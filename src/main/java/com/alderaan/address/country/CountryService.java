package com.alderaan.address.country;

import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @since 2024-11-25
 * @see CountryServiceImpl
 * @author Jeffrey Spaan
 * @version 1.0
 */
public interface CountryService {
    ResponseEntity<List<CountryResponse>> findAllCountries();
    ResponseEntity<CountryResponse> findCountryById(Integer id);
    Country findOrCreateCountryByName(String countryName);
    ResponseEntity<CountryResponse> saveCountry(CountryRequest request);
    ResponseEntity<CountryResponse> updateCountryById(Integer id, CountryRequest request);
    ResponseEntity<Void> deleteCountryById(Integer id);
}
