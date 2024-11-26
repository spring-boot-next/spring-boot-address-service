package com.alderaan.address;

import com.alderaan.address.common.constant.HttpConstant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(HttpConstant.Request.Path.ADDRESS)
record AddressController(AddressService addressService) {

    @GetMapping
    public ResponseEntity<List<AddressResponse>> getAllAddresses() {
        return addressService.findAllAddresses();
    }

    @GetMapping("/{id}")
    ResponseEntity<AddressResponse> getAddressById(@PathVariable Integer id) {
        return addressService.findAddressById(id);
    }

    @PostMapping
    public ResponseEntity<AddressResponse> createAddress(@RequestBody AddressRequest request) {
        return addressService.saveAddress(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddressById(@PathVariable Integer id) {
        return addressService.deleteAddressById(id);
    }
}