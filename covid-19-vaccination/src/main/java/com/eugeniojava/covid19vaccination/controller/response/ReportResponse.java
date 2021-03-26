package com.eugeniojava.covid19vaccination.controller.response;

import com.eugeniojava.covid19vaccination.model.Report;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ReportResponse {

    private final Long id;
    private final String city;
    private final LocalDate date;
    private final Integer total;
    private final String vaccine;

    public ReportResponse(Report report) {
        id = report.getId();
        city = report.getCity().getName();
        date = report.getDate();
        total = report.getTotal();
        vaccine = report.getVaccine().getName();
    }

    public static List<ReportResponse> convert(List<Report> reports) {
        return reports
                .stream()
                .map(ReportResponse::new)
                .collect(Collectors.toList());
    }
}
