package com.eugeniojava.covid19vaccination.controller.response;

import com.eugeniojava.covid19vaccination.model.City;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CityResponse {

    private final Long id;
    private final String name;
    private final String state;

    public CityResponse(City city) {
        id = city.getId();
        name = city.getName();
        state = city.getState().getName();
    }

    public static List<CityResponse> convert(List<City> cities) {
        return cities
                .stream()
                .map(CityResponse::new)
                .collect(Collectors.toList());
    }
}
