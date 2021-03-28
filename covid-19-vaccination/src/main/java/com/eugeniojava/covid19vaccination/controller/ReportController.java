package com.eugeniojava.covid19vaccination.controller;

import com.eugeniojava.covid19vaccination.controller.request.ReportRequest;
import com.eugeniojava.covid19vaccination.controller.response.ReportResponse;
import com.eugeniojava.covid19vaccination.controller.response.VaccinatedByCityResponse;
import com.eugeniojava.covid19vaccination.controller.response.VaccinatedByStateResponse;
import com.eugeniojava.covid19vaccination.controller.response.VaccinatedByVaccineResponse;
import com.eugeniojava.covid19vaccination.repository.ReportRepository;
import com.eugeniojava.covid19vaccination.service.ReportService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("${api.prefix}/reports")
public class ReportController {

    private final ReportService reportService;

    private final ReportRepository reportRepository;

    public ReportController(ReportService reportService,
                            ReportRepository reportRepository) {
        this.reportService = reportService;
        this.reportRepository = reportRepository;
    }

    @GetMapping
    public ResponseEntity<List<ReportResponse>> getAll() {
        return reportService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportResponse> getById(@PathVariable Long id) {
        return reportService.getById(id);
    }

    @PostMapping
    public ResponseEntity<ReportResponse> create(
            @Valid @RequestBody ReportRequest reportRequest) {
        return reportService.create(reportRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReportResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody ReportRequest reportRequest) {
        return reportService.update(id, reportRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return reportService.delete(id);
    }

    @GetMapping("/totalVaccinatedByCity")
    public ResponseEntity<VaccinatedByCityResponse>
    getTotalVaccinatedByCityBetween(
            @RequestParam String cityName,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")
                    LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")
                    LocalDate endDate) {
        return reportService.getTotalVaccinatedByCityBetween(
                cityName, startDate, endDate);
    }

    @GetMapping("/totalVaccinatedByState")
    public ResponseEntity<VaccinatedByStateResponse>
    getTotalVaccinatedByStateBetween(
            @RequestParam String stateName,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")
                    LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")
                    LocalDate endDate) {
        return reportService.getTotalVaccinatedByStateBetween(
                stateName, startDate, endDate);
    }

    @GetMapping("/totalVaccinatedByVaccine")
    public ResponseEntity<List<VaccinatedByVaccineResponse>>
    getTotalVaccinatedByVaccineBetween(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")
                    LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")
                    LocalDate endDate) {
        return reportService.getTotalVaccinatedByVaccineBetween(startDate,
                endDate);
    }
}
