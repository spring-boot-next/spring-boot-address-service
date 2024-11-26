package com.alderaan.address.subdivision;

import com.alderaan.address.country.Country;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @since 2024-11-25
 * @see SubdivisionServiceImpl
 * @author Jeffrey Spaan
 * @version 1.0
 */
public interface SubdivisionService {
    ResponseEntity<List<SubdivisionResponse>> findAllSubdivisions();
    ResponseEntity<SubdivisionResponse> findSubdivisionById(Integer id);
    Subdivision findOrCreateSubdivisionByName(String subdivisionName, Country country);
    ResponseEntity<SubdivisionResponse> saveSubdivision(SubdivisionRequest request);
    ResponseEntity<SubdivisionResponse> updateSubdivisionById(Integer id, SubdivisionRequest request);
    ResponseEntity<Void> deleteSubdivisionById(Integer id);
}