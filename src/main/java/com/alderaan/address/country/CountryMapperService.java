package com.alderaan.address.country;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
record CountryMapperService(ModelMapper modelMapper) {

    CountryResponse mapEntityToDto(Country country) {
        return modelMapper.map(country, CountryResponse.class);
    }

    Country mapRequestToEntity(CountryRequest request) {
        return modelMapper.map(request, Country.class);
    }
}