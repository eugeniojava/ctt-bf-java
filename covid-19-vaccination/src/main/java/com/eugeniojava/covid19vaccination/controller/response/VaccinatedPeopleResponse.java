package com.eugeniojava.covid19vaccination.controller.response;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class VaccinatedPeopleResponse {

    private final String city;
    private final Integer vaccinatedPeople;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public VaccinatedPeopleResponse(String city, Integer vaccinatedPeople,
                                    LocalDate startDate, LocalDate endDate) {
        this.city = city;
        this.vaccinatedPeople = vaccinatedPeople;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
