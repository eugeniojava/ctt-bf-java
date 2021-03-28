package com.eugeniojava.covid19vaccination.controller.response;

import java.time.LocalDate;

public class VaccinatedByVaccineResponse {

    private final Long vaccineId;
    private final String vaccineName;
    private final Long totalVaccinated;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public VaccinatedByVaccineResponse(Long vaccineId, String vaccineName,
                                       Long totalVaccinated,
                                       LocalDate startDate, LocalDate endDate) {
        this.vaccineId = vaccineId;
        this.vaccineName = vaccineName;
        this.totalVaccinated = totalVaccinated;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getVaccineId() {
        return vaccineId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public Long getTotalVaccinated() {
        return totalVaccinated;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
