package com.alderaan.address;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
record AddressServiceImpl(
        AddressMapperService addressMapperService,
        AddressRepository addressRepository) implements AddressService {

    public ResponseEntity<List<AddressResponse>> findAllAddresses() {
        List<AddressResponse> addressResponseList = addressRepository.findAllAddressesWithDetails().stream()
                .map(addressMapperService::mapEntityToDto)
                .toList();

        return ResponseEntity.ok(addressResponseList);
    }

    public ResponseEntity<AddressResponse> findAddressById(Integer id) {
        Address address = addressRepository.findAddressWithDetailsById(id)
                .orElseThrow(() -> new EntityNotFoundException("Address not found"));

        return ResponseEntity.ok(addressMapperService.mapEntityToDto(address));
    }

    public ResponseEntity<AddressResponse> saveAddress(AddressRequest request) {
        Address address = addressMapperService.mapRequestToEntity(request);
        addressRepository.save(address);

        return findAddressById(address.getId());
    }

    public ResponseEntity<Void> deleteAddressById(Integer id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Address not found"));

        addressRepository.delete(address);

        return ResponseEntity.noContent().build();
    }
}