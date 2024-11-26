package com.alderaan.address.country;

import com.alderaan.address.common.constant.HttpConstant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(HttpConstant.Request.Path.COUNTRY)
record CountryController(CountryService countryService) {

    @GetMapping
    ResponseEntity<List<CountryResponse>> getAllCountries() {
        return countryService.findAllCountries();
    }

    @GetMapping("/{id}")
    ResponseEntity<CountryResponse> getCountryById(@PathVariable Integer id) {
        return countryService.findCountryById(id);
    }

    @PostMapping
    ResponseEntity<CountryResponse> createCountry(@RequestBody CountryRequest request) {
        return countryService.saveCountry(request);
    }

    @PutMapping("/{id}")
    ResponseEntity<CountryResponse> updateCountryById(@PathVariable Integer id, @RequestBody CountryRequest request) {
        return countryService.updateCountryById(id, request);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCountryById(@PathVariable Integer id) {
        return countryService.deleteCountryById(id);
    }
}