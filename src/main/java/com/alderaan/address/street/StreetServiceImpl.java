package com.alderaan.address.street;

import com.alderaan.address.postcode.Postcode;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class StreetServiceImpl implements StreetService {

    private final StreetMapperService streetMapperService;
    private final StreetRepository streetRepository;

    @Override
    public ResponseEntity<List<StreetResponse>> findAllStreets() {
        List<StreetResponse> streetResponseList = streetRepository.findAllStreetsWithDetails().stream()
                .map(streetMapperService::mapEntityToDto)
                .toList();

        return ResponseEntity.ok(streetResponseList);
    }

    @Override
    public ResponseEntity<StreetResponse> findStreetById(Integer id) {
        Street street = streetRepository.findStreetWithDetailsById(id)
                .orElseThrow(() -> new EntityNotFoundException("Street not found"));

        return ResponseEntity.ok(streetMapperService.mapEntityToDto(street));
    }

    @Override
    public Street findOrCreateStreetByName(String streetName, Postcode postcode) {
        return streetRepository.findByName(streetName)
                .orElseGet(() -> streetRepository.save(
                        Street.builder()
                                .name(streetName)
                                .postcode(postcode)
                                .build())
                );
    }

    @Override
    @Transactional
    public ResponseEntity<StreetResponse> saveStreet(StreetRequest request) {
        Street street = streetRepository.findByName(request.getName())
                .orElseGet(() -> {
                    Street newStreet = streetMapperService.mapRequestToEntity(request);
                    return streetRepository.save(newStreet);
                });

        return ResponseEntity.ok(streetMapperService.mapEntityToDto(street));
    }

    @Override
    @Transactional
    public ResponseEntity<StreetResponse> updateStreetById(Integer id, StreetRequest request) {
        Street street = streetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Street not found"));

        Street updatedStreet = streetMapperService.mapRequestToEntity(request);
        updatedStreet.setId(street.getId());
        streetRepository.save(updatedStreet);

        return ResponseEntity.ok(streetMapperService.mapEntityToDto(updatedStreet));
    }

    @Override
    public ResponseEntity<Void> deleteStreetById(Integer id) {
        Street street = streetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Street not found"));

        streetRepository.delete(street);

        return ResponseEntity.noContent().build();
    }
}