package com.eugeniojava.covid19vaccination.service;

import com.eugeniojava.covid19vaccination.model.Vaccine;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VaccineService {

    ResponseEntity<List<Vaccine>> getAll();

    ResponseEntity<Vaccine> getById(Long id);

    ResponseEntity<Vaccine> create(Vaccine Vaccine);

    ResponseEntity<Vaccine> update(Long id, Vaccine Vaccine);

    ResponseEntity<?> delete(Long id);
}
