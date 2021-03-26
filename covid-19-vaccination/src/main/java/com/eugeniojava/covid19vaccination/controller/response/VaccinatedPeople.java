package com.eugeniojava.covid19vaccination.controller.response;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class VaccinatedPeople {

    private final String city;
    private final Integer vaccinatedPeople;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public VaccinatedPeople(String city, Integer vaccinatedPeople,
                            LocalDate startDate, LocalDate endDate) {
        this.city = city;
        this.vaccinatedPeople = vaccinatedPeople;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
