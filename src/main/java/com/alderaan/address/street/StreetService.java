package com.alderaan.address.street;

import com.alderaan.address.postcode.Postcode;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @since 2024-11-26
 * @see StreetServiceImpl
 * @author Jeffrey Spaan
 * @version 1.0
 */
public interface StreetService {
    ResponseEntity<List<StreetResponse>> findAllStreets();
    ResponseEntity<StreetResponse> findStreetById(Integer id);
    Street findOrCreateStreetByName(String streetName, Postcode postcode);
    ResponseEntity<StreetResponse> saveStreet(StreetRequest request);
    ResponseEntity<StreetResponse> updateStreetById(Integer id, StreetRequest request);
    ResponseEntity<Void> deleteStreetById(Integer id);
}