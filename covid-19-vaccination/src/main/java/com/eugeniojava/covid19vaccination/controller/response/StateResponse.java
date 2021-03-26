package com.eugeniojava.covid19vaccination.controller.response;

import com.eugeniojava.covid19vaccination.model.State;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class StateResponse {

    private final Long id;
    private final String name;
    private final String abbreviation;

    public StateResponse(State state) {
        id = state.getId();
        name = state.getName();
        abbreviation = state.getAbbreviation();
    }

    public static List<StateResponse> convert(List<State> states) {
        return states
                .stream()
                .map(StateResponse::new)
                .collect(Collectors.toList());
    }
}
