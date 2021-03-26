package com.eugeniojava.covid19vaccination.service.impl;

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
    public ResponseEntity<List<Vaccine>> getAll() {
        List<Vaccine> vaccines = vaccineRepository.findAll();

        if (!vaccines.isEmpty()) {
            return new ResponseEntity<>(vaccines, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Vaccine> getById(Long id) {
        Vaccine vaccine = vaccineRepository.findById(id).orElse(null);

        if (vaccine != null) {
            return new ResponseEntity<>(vaccine, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Vaccine> create(Vaccine vaccine) {
        return new ResponseEntity<>(vaccineRepository.save(vaccine),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Vaccine> update(Long id, Vaccine vaccine) {
        Vaccine existingVaccine =
                vaccineRepository.findById(id).orElse(null);

        if (existingVaccine != null) {
            existingVaccine.setName(vaccine.getName());
            existingVaccine.setOrigin(vaccine.getOrigin());

            return new ResponseEntity<>(vaccineRepository.save(existingVaccine),
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
