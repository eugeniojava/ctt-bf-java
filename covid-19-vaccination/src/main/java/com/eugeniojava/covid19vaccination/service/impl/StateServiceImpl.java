package com.eugeniojava.covid19vaccination.service.impl;

import com.eugeniojava.covid19vaccination.controller.request.StateRequest;
import com.eugeniojava.covid19vaccination.controller.response.StateResponse;
import com.eugeniojava.covid19vaccination.model.State;
import com.eugeniojava.covid19vaccination.repository.StateRepository;
import com.eugeniojava.covid19vaccination.service.StateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService {

    private final StateRepository stateRepository;

    public StateServiceImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public ResponseEntity<List<StateResponse>> getAll() {
        List<State> states = stateRepository.findAll();

        if (!states.isEmpty()) {
            return new ResponseEntity<>(StateResponse.convert(states),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<StateResponse> getById(Long id) {
        State state = stateRepository.findById(id).orElse(null);

        if (state != null) {
            return new ResponseEntity<>(new StateResponse(state),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<StateResponse> create(StateRequest stateRequest) {
        if (!stateRepository
                .findByAbbreviation(stateRequest.getAbbreviation())
                .isPresent()) {
            State state = stateRepository.save(stateRequest.convert());

            return new ResponseEntity<>(new StateResponse(state),
                    HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<StateResponse> update(Long id,
                                                StateRequest stateRequest) {
        State state = stateRepository.findById(id).orElse(null);

        if (state != null) {
            state.setName(stateRequest.getName());
            state.setAbbreviation(stateRequest.getAbbreviation());

            return new ResponseEntity<>(
                    new StateResponse(stateRepository.save(state)),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        if (stateRepository.findById(id).isPresent()) {
            stateRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
