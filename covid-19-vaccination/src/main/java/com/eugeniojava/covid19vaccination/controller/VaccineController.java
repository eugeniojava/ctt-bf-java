package com.eugeniojava.covid19vaccination.controller;

import com.eugeniojava.covid19vaccination.controller.request.VaccineRequest;
import com.eugeniojava.covid19vaccination.controller.response.VaccineResponse;
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
    public ResponseEntity<List<VaccineResponse>> getAll() {
        return vaccineService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VaccineResponse> getById(@PathVariable Long id) {
        return vaccineService.getById(id);
    }

    @PostMapping
    public ResponseEntity<VaccineResponse> create(
            @Valid @RequestBody VaccineRequest vaccineRequest) {
        return vaccineService.create(vaccineRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VaccineResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody VaccineRequest vaccineRequest) {
        return vaccineService.update(id, vaccineRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return vaccineService.delete(id);
    }
}
