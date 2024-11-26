package com.alderaan.address.city;

import com.alderaan.address.country.Country;
import com.alderaan.address.country.CountryService;
import com.alderaan.address.subdivision.Subdivision;
import com.alderaan.address.subdivision.SubdivisionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
record CityMapperService(
        ModelMapper modelMapper,
        SubdivisionService subdivisionService,
        CountryService countryService) {

    CityResponse mapEntityToDto(City city) {
        return modelMapper.map(city, CityResponse.class);
    }

    City mapRequestToEntity(CityRequest request) {
        Country country = countryService.findOrCreateCountryByName(request.getCountryName());
        Subdivision subdivision = subdivisionService.findOrCreateSubdivisionByName(request.getSubdivisionName(), country);

        City city = modelMapper.map(request, City.class);
        city.setSubdivision(subdivision);
        city.setCountry(country);
        return city;
    }
}