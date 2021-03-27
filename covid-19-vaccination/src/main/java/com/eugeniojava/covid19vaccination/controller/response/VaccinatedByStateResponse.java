package com.eugeniojava.covid19vaccination.controller.response;

import java.time.LocalDate;

public class VaccinatedByStateResponse {

    private final Long totalVaccinated;
    private final String state;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public VaccinatedByStateResponse(Long totalVaccinated, String state,
                                     LocalDate startDate, LocalDate endDate) {
        this.totalVaccinated = totalVaccinated;
        this.state = state;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getTotalVaccinated() {
        return totalVaccinated;
    }

    public String getState() {
        return state;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
