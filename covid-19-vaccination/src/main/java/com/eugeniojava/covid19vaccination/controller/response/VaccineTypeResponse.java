package com.eugeniojava.covid19vaccination.controller.response;

import java.time.LocalDate;

public class VaccineTypeResponse {

    private final Long vaccineId;
    private final String vaccineName;
    private final Long total;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public VaccineTypeResponse(Long vaccineId, String vaccineName, Long total,
                               LocalDate startDate, LocalDate endDate) {
        this.vaccineId = vaccineId;
        this.vaccineName = vaccineName;
        this.total = total;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getVaccineId() {
        return vaccineId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public Long getTotal() {
        return total;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
