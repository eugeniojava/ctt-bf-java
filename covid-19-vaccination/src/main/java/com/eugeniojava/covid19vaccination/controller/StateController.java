package com.eugeniojava.covid19vaccination.controller;

import com.eugeniojava.covid19vaccination.controller.request.StateRequest;
import com.eugeniojava.covid19vaccination.controller.response.StateResponse;
import com.eugeniojava.covid19vaccination.service.StateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("${api.prefix}/states")
public class StateController {

    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping
    public ResponseEntity<List<StateResponse>> getAll() {
        return stateService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StateResponse> getById(@PathVariable Long id) {
        return stateService.getById(id);
    }

    @PostMapping
    public ResponseEntity<StateResponse> create(
            @Valid @RequestBody StateRequest stateRequest) {
        return stateService.create(stateRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StateResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody StateRequest stateRequest) {
        return stateService.update(id, stateRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return stateService.delete(id);
    }
}
