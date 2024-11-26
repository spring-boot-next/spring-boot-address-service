package com.alderaan.address.subdivision;

import com.alderaan.address.common.constant.HttpConstant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(HttpConstant.Request.Path.SUBDIVISION)
record SubdivisionController(SubdivisionService subdivisionService) {

    @GetMapping
    public ResponseEntity<List<SubdivisionResponse>> getAllSubdivisions() {
        return subdivisionService.findAllSubdivisions();
    }

    @GetMapping("/{id}")
    ResponseEntity<SubdivisionResponse> getStreetById(@PathVariable Integer id) {
        return subdivisionService.findSubdivisionById(id);
    }

    @PostMapping
    ResponseEntity<SubdivisionResponse> createSubdivision(@RequestBody SubdivisionRequest request) {
        return subdivisionService.saveSubdivision(request);
    }

    @PutMapping("/{id}")
    ResponseEntity<SubdivisionResponse> updateSubdivisionById(@PathVariable Integer id, @RequestBody SubdivisionRequest request) {
        return subdivisionService.updateSubdivisionById(id, request);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteSubdivisionById(@PathVariable Integer id) {
        return subdivisionService.deleteSubdivisionById(id);
    }
}