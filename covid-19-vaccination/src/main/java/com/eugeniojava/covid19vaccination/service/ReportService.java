package com.eugeniojava.covid19vaccination.service;

import com.eugeniojava.covid19vaccination.controller.request.ReportRequest;
import com.eugeniojava.covid19vaccination.controller.response.ReportResponse;
import com.eugeniojava.covid19vaccination.controller.response.VaccinatedPeopleResponse;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {

    ResponseEntity<List<ReportResponse>> getAll();

    ResponseEntity<ReportResponse> getById(Long id);

    ResponseEntity<ReportResponse> create(ReportRequest reportRequest);

    ResponseEntity<ReportResponse> update(
            Long id, ReportRequest reportRequest);

    ResponseEntity<?> delete(Long id);

    ResponseEntity<VaccinatedPeopleResponse> getVaccinatedPeopleByCityAndDateBetween(
            String cityName, LocalDate startDate, LocalDate endDate);
}
