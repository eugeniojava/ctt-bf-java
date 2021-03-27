package com.eugeniojava.covid19vaccination.controller.response;

import java.time.LocalDate;

public class VaccinatedByCityResponse {

    private final Long totalVaccinated;
    private final String city;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public VaccinatedByCityResponse(Long totalVaccinated, String city,
                                    LocalDate startDate, LocalDate endDate) {
        this.totalVaccinated = totalVaccinated;
        this.city = city;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getTotalVaccinated() {
        return totalVaccinated;
    }

    public String getCity() {
        return city;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
