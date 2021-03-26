package com.eugeniojava.covid19vaccination.repository;

import com.eugeniojava.covid19vaccination.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
}
