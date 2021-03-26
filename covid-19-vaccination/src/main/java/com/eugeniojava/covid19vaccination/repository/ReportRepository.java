package com.eugeniojava.covid19vaccination.repository;

import com.eugeniojava.covid19vaccination.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findAllByCity_NameAndDateBetween(String cityName,
                                                  LocalDate startDate,
                                                  LocalDate endDate);
}
