package com.eugeniojava.covid19vaccination.controller;

import com.eugeniojava.covid19vaccination.controller.request.CityRequest;
import com.eugeniojava.covid19vaccination.controller.response.CityResponse;
import com.eugeniojava.covid19vaccination.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("${api.prefix}/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<List<CityResponse>> getAll() {
        return cityService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityResponse> getById(@PathVariable Long id) {
        return cityService.getById(id);
    }

    @PostMapping
    public ResponseEntity<CityResponse> create(
            @Valid @RequestBody CityRequest cityRequest) {
        return cityService.create(cityRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CityResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody CityRequest cityRequest) {
        return cityService.update(id, cityRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return cityService.delete(id);
    }
}
