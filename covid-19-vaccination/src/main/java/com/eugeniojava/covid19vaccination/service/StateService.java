package com.eugeniojava.covid19vaccination.service;

import com.eugeniojava.covid19vaccination.controller.request.StateRequest;
import com.eugeniojava.covid19vaccination.controller.response.StateResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StateService {

    ResponseEntity<List<StateResponse>> getAll();

    ResponseEntity<StateResponse> getById(Long id);

    ResponseEntity<StateResponse> create(StateRequest stateRequest);

    ResponseEntity<StateResponse> update(Long id, StateRequest stateRequest);

    ResponseEntity<?> delete(Long id);
}
