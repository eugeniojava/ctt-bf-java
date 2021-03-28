package com.eugeniojava.covid19vaccination.service.impl;

import com.eugeniojava.covid19vaccination.controller.request.ReportRequest;
import com.eugeniojava.covid19vaccination.controller.response.ReportResponse;
import com.eugeniojava.covid19vaccination.controller.response.VaccinatedByCityResponse;
import com.eugeniojava.covid19vaccination.controller.response.VaccinatedByStateResponse;
import com.eugeniojava.covid19vaccination.controller.response.VaccinatedByVaccineResponse;
import com.eugeniojava.covid19vaccination.model.City;
import com.eugeniojava.covid19vaccination.model.Report;
import com.eugeniojava.covid19vaccination.model.Vaccine;
import com.eugeniojava.covid19vaccination.repository.CityRepository;
import com.eugeniojava.covid19vaccination.repository.ReportRepository;
import com.eugeniojava.covid19vaccination.repository.VaccineRepository;
import com.eugeniojava.covid19vaccination.repository.result.TotalVaccineTypeResult;
import com.eugeniojava.covid19vaccination.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    private final CityRepository cityRepository;

    private final VaccineRepository vaccineRepository;

    public ReportServiceImpl(ReportRepository reportRepository,
                             CityRepository cityRepository,
                             VaccineRepository vaccineRepository) {
        this.reportRepository = reportRepository;
        this.cityRepository = cityRepository;
        this.vaccineRepository = vaccineRepository;
    }

    @Override
    public ResponseEntity<List<ReportResponse>> getAll() {
        List<Report> reports = reportRepository.findAll();

        if (!reports.isEmpty()) {
            return new ResponseEntity<>(ReportResponse.convert(reports),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<ReportResponse> getById(Long id) {
        Report report = reportRepository.findById(id).orElse(null);

        if (report != null) {
            return new ResponseEntity<>(new ReportResponse(report),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<ReportResponse> create(ReportRequest reportRequest) {
        City city = cityRepository.findByName(reportRequest.getCity())
                .orElse(null);
        Vaccine vaccine = vaccineRepository
                .findByName(reportRequest.getVaccine())
                .orElse(null);

        if (city != null && vaccine != null) {
            Report report = reportRepository.save(
                    reportRequest.toEntity(city, vaccine));

            return new ResponseEntity<>(new ReportResponse(report),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<ReportResponse> update(Long id,
                                                 ReportRequest reportRequest) {
        Report report = reportRepository.findById(id).orElse(null);

        if (report != null) {
            City city = cityRepository.findByName(reportRequest.getCity())
                    .orElse(null);
            Vaccine vaccine = vaccineRepository
                    .findByName(reportRequest.getVaccine()).orElse(null);

            if (city != null && vaccine != null) {
                report.setCity(city);
                report.setDate(reportRequest.getDate());
                report.setTotal(reportRequest.getTotal());
                report.setVaccine(vaccine);

                return new ResponseEntity<>(
                        new ReportResponse(reportRepository.save(report)),
                        HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        if (reportRepository.findById(id).isPresent()) {
            reportRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<VaccinatedByCityResponse>
    getTotalVaccinatedByCityBetween(String cityName,
                                    LocalDate startDate,
                                    LocalDate endDate) {
        Long totalVaccinated =
                reportRepository
                        .getTotalVaccinatedByCityBetween(cityName,
                                startDate, endDate);

        if (totalVaccinated == null) {
            totalVaccinated = 0L;
        }
        VaccinatedByCityResponse vaccinatedByCityResponse =
                new VaccinatedByCityResponse(totalVaccinated,
                        cityName,
                        startDate,
                        endDate);

        return new ResponseEntity<>(vaccinatedByCityResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VaccinatedByStateResponse>
    getTotalVaccinatedByStateBetween(String stateName,
                                     LocalDate startDate,
                                     LocalDate endDate) {
        Long totalVaccinated =
                reportRepository
                        .getTotalVaccinatedByStateBetween(stateName,
                                startDate, endDate);

        if (totalVaccinated == null) {
            totalVaccinated = 0L;
        }
        VaccinatedByStateResponse vaccinatedByStateResponse =
                new VaccinatedByStateResponse(totalVaccinated, stateName,
                        startDate, endDate);

        return new ResponseEntity<>(vaccinatedByStateResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<VaccinatedByVaccineResponse>>
    getTotalVaccinatedByVaccineBetween(
            LocalDate startDate,
            LocalDate endDate) {
        List<TotalVaccineTypeResult> totalVaccineTypeResults =
                reportRepository.getTotalVaccinatedByVaccineBetween(startDate,
                        endDate);
        List<VaccinatedByVaccineResponse> vaccinatedByVaccineRespons =
                new ArrayList<>();

        totalVaccineTypeResults.forEach(result -> {
            VaccinatedByVaccineResponse vaccinatedByVaccineResponse =
                    new VaccinatedByVaccineResponse(
                            result.getId(),
                            result.getVaccine(),
                            result.getTotal(),
                            startDate,
                            endDate);

            vaccinatedByVaccineRespons.add(vaccinatedByVaccineResponse);
        });

        return new ResponseEntity<>(vaccinatedByVaccineRespons, HttpStatus.OK);
    }
}
