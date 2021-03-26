package com.eugeniojava.covid19vaccination.controller.request;

import com.eugeniojava.covid19vaccination.model.City;
import com.eugeniojava.covid19vaccination.model.Report;
import com.eugeniojava.covid19vaccination.model.Vaccine;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class ReportRequest {

    @NotBlank
    private final String city;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDate date;

    @Positive
    private final Integer total;

    @NotBlank
    private final String vaccine;

    public Report toEntity(City city, Vaccine vaccine) {
        Report report = new Report();

        report.setCity(city);
        report.setDate(date);
        report.setTotal(total);
        report.setVaccine(vaccine);

        return report;
    }
}
