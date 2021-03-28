package com.eugeniojava.covid19vaccination.service;

import com.eugeniojava.covid19vaccination.controller.request.ReportRequest;
import com.eugeniojava.covid19vaccination.controller.response.ReportResponse;
import com.eugeniojava.covid19vaccination.controller.response.VaccinatedByCityResponse;
import com.eugeniojava.covid19vaccination.controller.response.VaccinatedByStateResponse;
import com.eugeniojava.covid19vaccination.controller.response.VaccinatedByVaccineResponse;
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

    ResponseEntity<VaccinatedByCityResponse>
    getTotalVaccinatedByCityBetween(String cityName, LocalDate startDate,
                                    LocalDate endDate);

    ResponseEntity<VaccinatedByStateResponse>
    getTotalVaccinatedByStateBetween(String stateName, LocalDate startDate,
                                     LocalDate endDate);

    ResponseEntity<List<VaccinatedByVaccineResponse>>
    getTotalVaccinatedByVaccineBetween(LocalDate startDate, LocalDate endDate);
}
