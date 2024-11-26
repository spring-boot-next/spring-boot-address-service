package com.alderaan.address.country;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
record CountryServiceImpl(
        CountryMapperService countryMapperService,
        CountryRepository countryRepository) implements CountryService {

    @Override
    public ResponseEntity<List<CountryResponse>> findAllCountries() {
        List<CountryResponse> countryResponseList = countryRepository.findAll().stream()
                .map(countryMapperService::mapEntityToDto)
                .toList();

        return ResponseEntity.ok(countryResponseList);
    }

    @Override
    public ResponseEntity<CountryResponse> findCountryById(Integer id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Country not found"));

        return ResponseEntity.ok(countryMapperService.mapEntityToDto(country));
    }

    @Override
    public Country findOrCreateCountryByName(String countryName) {
        return countryRepository.findByName(countryName)
                .orElseGet(() -> countryRepository.save(
                        Country.builder()
                                .name(countryName)
                                .build())
                );
    }

    @Override
    public ResponseEntity<CountryResponse> saveCountry(CountryRequest request) {
        Country country = countryRepository.findByName(request.getName())
                .orElseGet(() -> {
                    Country newCountry = countryMapperService.mapRequestToEntity(request);
                    return countryRepository.save(newCountry);
                });

        return ResponseEntity.ok(countryMapperService.mapEntityToDto(country));
    }

    @Override
    public ResponseEntity<CountryResponse> updateCountryById(Integer id, CountryRequest request) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Country not found"));

        Country updatedCountry = countryMapperService.mapRequestToEntity(request);
        updatedCountry.setId(country.getId());
        countryRepository.save(updatedCountry);
        return ResponseEntity.ok(countryMapperService.mapEntityToDto(updatedCountry));
    }

    @Override
    public ResponseEntity<Void> deleteCountryById(Integer id) {
        countryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}