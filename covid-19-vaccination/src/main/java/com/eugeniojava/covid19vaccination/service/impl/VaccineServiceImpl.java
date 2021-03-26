package com.eugeniojava.covid19vaccination.service.impl;

import com.eugeniojava.covid19vaccination.controller.request.VaccineRequest;
import com.eugeniojava.covid19vaccination.controller.response.VaccineResponse;
import com.eugeniojava.covid19vaccination.model.Vaccine;
import com.eugeniojava.covid19vaccination.repository.VaccineRepository;
import com.eugeniojava.covid19vaccination.service.VaccineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineServiceImpl implements VaccineService {

    private final VaccineRepository vaccineRepository;

    public VaccineServiceImpl(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    @Override
    public ResponseEntity<List<VaccineResponse>> getAll() {
        List<Vaccine> vaccines = vaccineRepository.findAll();

        if (!vaccines.isEmpty()) {
            return new ResponseEntity<>(VaccineResponse.convert(vaccines),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<VaccineResponse> getById(Long id) {
        Vaccine vaccine = vaccineRepository.findById(id).orElse(null);

        if (vaccine != null) {
            return new ResponseEntity<>(new VaccineResponse(vaccine),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<VaccineResponse> create(
            VaccineRequest vaccineRequest) {
        return new ResponseEntity<>(
                new VaccineResponse(vaccineRepository.save(
                        vaccineRequest.toEntity())), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<VaccineResponse> update(
            Long id, VaccineRequest vaccineRequest) {
        Vaccine existingVaccine =
                vaccineRepository.findById(id).orElse(null);

        if (existingVaccine != null) {
            existingVaccine.setName(vaccineRequest.getName());
            existingVaccine.setOrigin(vaccineRequest.getOrigin());

            return new ResponseEntity<>(
                    new VaccineResponse(
                            vaccineRepository.save(existingVaccine)),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        if (vaccineRepository.findById(id).isPresent()) {
            vaccineRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
