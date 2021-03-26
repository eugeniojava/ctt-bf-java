package com.eugeniojava.covid19vaccination.controller.request;

import com.eugeniojava.covid19vaccination.model.State;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
public class StateRequest {

    @NotBlank
    private final String name;

    @NotBlank
    @Size(min = 2, max = 2)
    private final String abbreviation;

    public State convert() {
        State state = new State();

        state.setName(name);
        state.setAbbreviation(abbreviation);

        return state;
    }
}
