package com.eugeniojava.covid19vaccination.service;

import com.eugeniojava.covid19vaccination.controller.request.VaccineRequest;
import com.eugeniojava.covid19vaccination.controller.response.VaccineResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VaccineService {

    ResponseEntity<List<VaccineResponse>> getAll();

    ResponseEntity<VaccineResponse> getById(Long id);

    ResponseEntity<VaccineResponse> create(VaccineRequest vaccineRequest);

    ResponseEntity<VaccineResponse> update(Long id,
                                           VaccineRequest vaccineRequest);

    ResponseEntity<?> delete(Long id);
}
