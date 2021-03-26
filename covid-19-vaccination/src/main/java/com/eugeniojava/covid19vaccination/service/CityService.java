package com.eugeniojava.covid19vaccination.service;

import com.eugeniojava.covid19vaccination.controller.request.CityRequest;
import com.eugeniojava.covid19vaccination.controller.response.CityResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CityService {

    ResponseEntity<List<CityResponse>> getAll();

    ResponseEntity<CityResponse> getById(Long id);

    ResponseEntity<CityResponse> create(CityRequest cityRequest);

    ResponseEntity<CityResponse> update(Long id,
                                        CityRequest cityRequest);

    ResponseEntity<?> delete(Long id);
}
