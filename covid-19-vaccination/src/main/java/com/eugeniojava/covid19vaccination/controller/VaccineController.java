package com.eugeniojava.covid19vaccination.controller;

import com.eugeniojava.covid19vaccination.controller.request.CityRequest;
import com.eugeniojava.covid19vaccination.controller.response.CityResponse;
import com.eugeniojava.covid19vaccination.model.Vaccine;
import com.eugeniojava.covid19vaccination.service.VaccineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("${api.prefix}/vaccines")
public class VaccineController {

    private final VaccineService vaccineService;

    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @GetMapping
    public ResponseEntity<List<Vaccine>> getAll() {
        return vaccineService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaccine> getById(@PathVariable Long id) {
        return vaccineService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Vaccine> create(@Valid @RequestBody Vaccine vaccine) {
        return vaccineService.create(vaccine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vaccine> update(@PathVariable Long id,
                                          @Valid @RequestBody Vaccine Vaccine) {
        return vaccineService.update(id, Vaccine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return vaccineService.delete(id);
    }
}
