package com.alderaan.address.subdivision;

import com.alderaan.address.country.Country;
import com.alderaan.address.country.CountryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
record SubdivisionServiceImpl(
        SubdivisionMapperService subdivisionMapperService,
        SubdivisionRepository subdivisionRepository,
        CountryService countryService) implements SubdivisionService {

    @Override
    public ResponseEntity<List<SubdivisionResponse>> findAllSubdivisions() {
        List<SubdivisionResponse> subdivisionResponseList = subdivisionRepository.findAllSubdivisionsWithDetails().stream()
                .map(subdivisionMapperService::mapEntityToDto)
                .toList();

        return ResponseEntity.ok(subdivisionResponseList);
    }

    @Override
    public ResponseEntity<SubdivisionResponse> findSubdivisionById(Integer id) {
        Subdivision subdivision = subdivisionRepository.findSubdivisionWithDetailsById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subdivision not found"));

        return ResponseEntity.ok(subdivisionMapperService.mapEntityToDto(subdivision));
    }

    @Override
    public Subdivision findOrCreateSubdivisionByName(String subdivisionName, Country country) {
        return subdivisionRepository.findByName(subdivisionName)
                .orElseGet(() -> subdivisionRepository.save(
                        Subdivision.builder()
                                .name(subdivisionName)
                                .country(country)
                                .build())
                );
    }

    @Override
    public ResponseEntity<SubdivisionResponse> saveSubdivision(SubdivisionRequest request) {
        Subdivision subdivision = subdivisionRepository.findByName(request.getName())
                .orElseGet(() -> {
                    Subdivision newSubdivision = subdivisionMapperService.mapRequestToEntity(request);
                    return subdivisionRepository.save(newSubdivision);
                });

        return ResponseEntity.ok(subdivisionMapperService.mapEntityToDto(subdivision));
    }

    @Override
    public ResponseEntity<SubdivisionResponse> updateSubdivisionById(Integer id, SubdivisionRequest request) {
        Subdivision subdivision = subdivisionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subdivision not found"));

        Subdivision updatedSubdivision = subdivisionMapperService.mapRequestToEntity(request);
        updatedSubdivision.setId(subdivision.getId());
        subdivisionRepository.save(updatedSubdivision);

        return ResponseEntity.ok(subdivisionMapperService.mapEntityToDto(updatedSubdivision));
    }

    @Override
    public ResponseEntity<Void> deleteSubdivisionById(Integer id) {
        Subdivision subdivision = subdivisionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subdivision not found"));

        subdivisionRepository.delete(subdivision);

        return ResponseEntity.noContent().build();
    }
}