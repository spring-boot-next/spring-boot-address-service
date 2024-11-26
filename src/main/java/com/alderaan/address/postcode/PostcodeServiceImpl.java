package com.alderaan.address.postcode;

import com.alderaan.address.city.City;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class PostcodeServiceImpl implements PostcodeService {

    private final PostcodeMapperService postcodeMapperService;
    private final PostcodeRepository postcodeRepository;

    @Override
    public ResponseEntity<List<PostcodeResponse>> findAllPostcodes() {
        List<PostcodeResponse> postcodeResponseList = postcodeRepository.findAllPostcodesWithDetails().stream()
                .map(postcodeMapperService::mapEntityToDto)
                .toList();

        return ResponseEntity.ok(postcodeResponseList);
    }

    @Override
    public ResponseEntity<PostcodeResponse> findPostcodeById(Integer id) {
        Postcode postcode = postcodeRepository.findPostcodeWithDetailsById(id)
                .orElseThrow(() -> new EntityNotFoundException("Postcode not found"));

        return ResponseEntity.ok(postcodeMapperService.mapEntityToDto(postcode));
    }

    @Override
    public Postcode findPostcodeByCode(String postcodeCode) {
        return postcodeRepository.findByCode(postcodeCode)
                .orElseThrow(() -> new EntityNotFoundException("Postcode not found"));
    }

    @Override
    public Postcode findOrCreatePostcodeByCode(String postcodeCode, City city) {
        return postcodeRepository.findByCode(postcodeCode)
                .orElseGet(() -> postcodeRepository.save(
                        Postcode.builder()
                                .code(postcodeCode)
                                .city(city)
                                .build())
                );
    }

    @Override
    @Transactional
    public ResponseEntity<PostcodeResponse> savePostcode(PostcodeRequest request) {
        Postcode postcode = postcodeRepository.findByCode(request.getCode())
                .orElseGet(() -> {
                    Postcode newPostcode = postcodeMapperService.mapRequestToEntity(request);
                    return postcodeRepository.save(newPostcode);
                });

        return ResponseEntity.ok(postcodeMapperService.mapEntityToDto(postcode));
    }

    @Override
    public ResponseEntity<Void> deletePostcodeById(Integer id) {
        Postcode postcode = postcodeRepository.findPostcodeWithDetailsById(id)
                .orElseThrow(() -> new EntityNotFoundException("Postcode not found"));

        postcodeRepository.delete(postcode);

        return ResponseEntity.noContent().build();
    }
}