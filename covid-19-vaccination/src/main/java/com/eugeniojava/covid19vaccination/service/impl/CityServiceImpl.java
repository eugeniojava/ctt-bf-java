package com.eugeniojava.covid19vaccination.service.impl;

import com.eugeniojava.covid19vaccination.controller.request.CityRequest;
import com.eugeniojava.covid19vaccination.controller.response.CityResponse;
import com.eugeniojava.covid19vaccination.model.City;
import com.eugeniojava.covid19vaccination.model.State;
import com.eugeniojava.covid19vaccination.repository.CityRepository;
import com.eugeniojava.covid19vaccination.repository.StateRepository;
import com.eugeniojava.covid19vaccination.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    private final StateRepository stateRepository;

    public CityServiceImpl(CityRepository cityRepository,
                           StateRepository stateRepository) {
        this.cityRepository = cityRepository;
        this.stateRepository = stateRepository;
    }

    @Override
    public ResponseEntity<List<CityResponse>> getAll() {
        List<City> cities = cityRepository.findAll();

        if (!cities.isEmpty()) {
            return new ResponseEntity<>(CityResponse.convert(cities),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<CityResponse> getById(Long id) {
        City city = cityRepository.findById(id).orElse(null);

        if (city != null) {
            return new ResponseEntity<>(new CityResponse(city),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<CityResponse> create(CityRequest cityRequest) {
        if (!cityRepository.findByNameAndStateName(cityRequest.getName(),
                cityRequest.getState())
                .isPresent()) {
            State state =
                    stateRepository.findByName(cityRequest.getState())
                            .orElse(null);

            if (state != null) {
                City city = cityRepository.save(new City(cityRequest.getName(),
                        state));

                return new ResponseEntity<>(new CityResponse(city),
                        HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<CityResponse> update(Long id,
                                               CityRequest cityRequest) {
        City city = cityRepository.findById(id).orElse(null);

        if (city != null) {
            State state =
                    stateRepository.findByName(cityRequest.getState())
                            .orElse(null);

            if (state != null) {
                city.setName(cityRequest.getName());
                city.setState(state);

                return new ResponseEntity<>(
                        new CityResponse(cityRepository.save(city)),
                        HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        if (cityRepository.findById(id).isPresent()) {
            cityRepository.deleteById(id);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
