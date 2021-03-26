package com.eugeniojava.covid19vaccination.controller.request;

import com.eugeniojava.covid19vaccination.model.Vaccine;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
public class VaccineRequest {

    @NotBlank
    private final String name;

    @NotBlank
    private final String origin;

    public Vaccine toEntity() {
        Vaccine vaccine = new Vaccine();

        vaccine.setName(name);
        vaccine.setOrigin(origin);

        return vaccine;
    }
}
