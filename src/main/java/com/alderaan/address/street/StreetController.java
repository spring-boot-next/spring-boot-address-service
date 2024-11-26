package com.alderaan.address.street;

import com.alderaan.address.common.constant.HttpConstant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(HttpConstant.Request.Path.STREET)
record StreetController(StreetService streetService) {

    @GetMapping
    public ResponseEntity<List<StreetResponse>> getAllStreets() {
        return streetService.findAllStreets();
    }

    @GetMapping("/{id}")
    ResponseEntity<StreetResponse> getStreetById(@PathVariable Integer id) {
        return streetService.findStreetById(id);
    }

    @PostMapping
    ResponseEntity<StreetResponse> createStreet(@RequestBody StreetRequest request) {
        return streetService.saveStreet(request);
    }

    @PutMapping("/{id}")
    ResponseEntity<StreetResponse> updateStreetById(@PathVariable Integer id, @RequestBody StreetRequest request) {
        return streetService.updateStreetById(id, request);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteStreetById(@PathVariable Integer id) {
        return streetService.deleteStreetById(id);
    }
}