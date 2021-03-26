package com.eugeniojava.covid19vaccination.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
public class CityRequest {

    @NotBlank
    private final String name;

    @NotBlank
    private final String state;
}
