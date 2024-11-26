package com.alderaan.address.city;

import com.alderaan.address.country.Country;
import com.alderaan.address.subdivision.Subdivision;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @since 2024-11-26
 * @see CityServiceImpl
 * @author Jeffrey Spaan
 * @version 1.0
 */
public interface CityService {
    ResponseEntity<List<CityResponse>> findAllCities();
    ResponseEntity<CityResponse> findCityById(Integer id);
    City findCityByName(String name);
    City findOrCreateCityByName(String cityName, Subdivision subdivision, Country country);
    ResponseEntity<CityResponse> saveCity(CityRequest request);
    ResponseEntity<CityResponse> updateCityById(Integer id, CityRequest request);
    ResponseEntity<Void> deleteCityById(Integer id);
}