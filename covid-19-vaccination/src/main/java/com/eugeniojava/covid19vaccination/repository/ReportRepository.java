package com.eugeniojava.covid19vaccination.repository;

import com.eugeniojava.covid19vaccination.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    @Query("SELECT SUM(r.total) FROM Report r" +
            " WHERE r.city.name = ?1" +
            " AND r.date BETWEEN ?2 AND ?3")
    Integer getVaccinatedPeopleByCityAndDateBetween(String cityName,
                                                    LocalDate startDate,
                                                    LocalDate endDate);
}
