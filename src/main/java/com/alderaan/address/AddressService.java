package com.alderaan.address;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AddressService {
    ResponseEntity<List<AddressResponse>> findAllAddresses();
    ResponseEntity<AddressResponse> findAddressById(Integer id);
    ResponseEntity<AddressResponse> saveAddress(AddressRequest request);
    ResponseEntity<Void> deleteAddressById(Integer id);
}