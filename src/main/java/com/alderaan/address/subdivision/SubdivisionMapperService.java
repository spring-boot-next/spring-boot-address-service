package com.alderaan.address.subdivision;

import com.alderaan.address.country.Country;
import com.alderaan.address.country.CountryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
record SubdivisionMapperService(ModelMapper modelMapper, CountryService countryService) {

    SubdivisionResponse mapEntityToDto(Subdivision subdivision) {
        return modelMapper.map(subdivision, SubdivisionResponse.class);
    }

    Subdivision mapRequestToEntity(SubdivisionRequest request) {
        Country country = countryService.findOrCreateCountryByName(request.getCountryName());

        Subdivision subdivision = modelMapper.map(request, Subdivision.class);
        subdivision.setCountry(country);
        return subdivision;
    }
}