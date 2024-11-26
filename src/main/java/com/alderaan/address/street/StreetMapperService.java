package com.alderaan.address.street;

import com.alderaan.address.postcode.Postcode;
import com.alderaan.address.postcode.PostcodeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
record StreetMapperService(
        ModelMapper modelMapper,
        PostcodeService postcodeService) {

    StreetResponse mapEntityToDto(Street street) {
        return modelMapper.map(street, StreetResponse.class);
    }

    Street mapRequestToEntity(StreetRequest request) {
        Postcode postcode = postcodeService.findPostcodeByCode(request.getPostcodeCode());

        Street street = modelMapper.map(request, Street.class);
        street.setPostcode(postcode);
        return street;
    }
}