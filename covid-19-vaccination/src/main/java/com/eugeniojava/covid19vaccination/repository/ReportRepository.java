package com.eugeniojava.covid19vaccination.repository;

import com.eugeniojava.covid19vaccination.model.Report;
import com.eugeniojava.covid19vaccination.repository.result.TotalVaccineTypeResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    @Query("SELECT SUM(r.total) " +
            "FROM Report r " +
            "WHERE r.city.name = ?1" +
            " AND r.date BETWEEN ?2 AND ?3")
    Long getTotalVaccinatedByCityBetween(String cityName,
                                         LocalDate startDate,
                                         LocalDate endDate);

    @Query("SELECT SUM(r.total) " +
            "FROM Report r " +
            "JOIN City c ON r.city.id = c.id " +
            "JOIN State s ON c.state.id = s.id " +
            "WHERE s.name = ?1" +
            " AND r.date BETWEEN ?2 AND ?3")
    Long getTotalVaccinatedByStateBetween(String stateName,
                                          LocalDate startDate,
                                          LocalDate endDate);

    @Query("SELECT new com.eugeniojava.covid19vaccination.repository.result" +
            ".TotalVaccineTypeResult(v.id, v.name, SUM(r.total)) " +
            "FROM Report r " +
            "JOIN Vaccine v ON r.vaccine.id = v.id " +
            "WHERE r.date BETWEEN ?1 AND ?2 " +
            "GROUP BY v.name " +
            "ORDER BY v.id")
    List<TotalVaccineTypeResult> getTotalVaccinatedByVaccineBetween(
            LocalDate startDate,
            LocalDate endDate);
}
