package com.eugeniojava.covid19vaccination.controller.response;

import com.eugeniojava.covid19vaccination.model.Vaccine;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class VaccineResponse {

    private final Long id;
    private final String name;
    private final String origin;

    public VaccineResponse(Vaccine vaccine) {
        id = vaccine.getId();
        name = vaccine.getName();
        origin = vaccine.getOrigin();
    }

    public static List<VaccineResponse> convert(List<Vaccine> vaccines) {
        return vaccines
                .stream()
                .map(VaccineResponse::new)
                .collect(Collectors.toList());
    }
}
