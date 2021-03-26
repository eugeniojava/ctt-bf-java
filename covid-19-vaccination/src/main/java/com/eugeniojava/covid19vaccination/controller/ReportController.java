package com.eugeniojava.covid19vaccination.controller;

import com.eugeniojava.covid19vaccination.controller.request.ReportRequest;
import com.eugeniojava.covid19vaccination.controller.response.ReportResponse;
import com.eugeniojava.covid19vaccination.controller.response.VaccinatedPeople;
import com.eugeniojava.covid19vaccination.model.Report;
import com.eugeniojava.covid19vaccination.repository.ReportRepository;
import com.eugeniojava.covid19vaccination.service.ReportService;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/vaccinatedPeople")
    public ResponseEntity<VaccinatedPeople> getVaccinatedPeople(
            @RequestParam String cityName,
            @RequestParam String startDate,
            @RequestParam String endDate) {
        LocalDate startLocalDate = LocalDate.parse(startDate);
        LocalDate endLocalDate = LocalDate.parse(endDate);
        List<Report> reports = reportRepository
                .findAllByCity_NameAndDateBetween(
                        cityName,
                        startLocalDate,
                        endLocalDate);
        Integer numberOfPeople = 0;

        for (Report report : reports) {
            numberOfPeople += report.getTotal();
        }

        return new ResponseEntity<>(new VaccinatedPeople(cityName,
                numberOfPeople, startLocalDate, endLocalDate), HttpStatus.OK);
    }
}
