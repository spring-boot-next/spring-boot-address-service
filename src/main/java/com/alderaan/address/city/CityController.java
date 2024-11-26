package com.alderaan.address.city;

import com.alderaan.address.common.constant.HttpConstant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(HttpConstant.Request.Path.CITY)
record CityController(CityService cityService) {

    @GetMapping
    ResponseEntity<List<CityResponse>> getAllCities() {
        return cityService.findAllCities();
    }

    @GetMapping("/{id}")
    ResponseEntity<CityResponse> getCityById(@PathVariable Integer id) {
        return cityService.findCityById(id);
    }

    @PostMapping
    ResponseEntity<CityResponse> createCity(@RequestBody CityRequest request) {
        return cityService.saveCity(request);
    }

    @PutMapping("/{id}")
    ResponseEntity<CityResponse> updateCityById(@PathVariable Integer id, @RequestBody CityRequest request) {
        return cityService.updateCityById(id, request);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCityById(@PathVariable Integer id) {
        return cityService.deleteCityById(id);
    }
}