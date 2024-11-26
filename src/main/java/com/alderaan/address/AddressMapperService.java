package com.alderaan.address;

import com.alderaan.address.city.City;
import com.alderaan.address.city.CityService;
import com.alderaan.address.country.Country;
import com.alderaan.address.country.CountryService;
import com.alderaan.address.postcode.Postcode;
import com.alderaan.address.postcode.PostcodeService;
import com.alderaan.address.street.Street;
import com.alderaan.address.street.StreetService;
import com.alderaan.address.subdivision.Subdivision;
import com.alderaan.address.subdivision.SubdivisionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
record AddressMapperService(
        ModelMapper modelMapper,
        CountryService countryService,
        SubdivisionService subdivisionService,
        CityService cityService,
        PostcodeService postcodeService,
        StreetService streetService) {

    AddressResponse mapEntityToDto(Address address) {
        return modelMapper.map(address, AddressResponse.class);
    }

    Address mapRequestToEntity(AddressRequest request) {
        Country country = countryService.findOrCreateCountryByName(request.getCountryName());
        Subdivision subdivision = subdivisionService.findOrCreateSubdivisionByName(request.getSubdivisionName(), country);
        City city = cityService.findOrCreateCityByName(request.getCityName(), subdivision, country);
        Postcode postcode = postcodeService.findOrCreatePostcodeByCode(request.getPostcodeCode(), city);
        Street street = streetService.findOrCreateStreetByName(request.getStreetName(), postcode);

        Address address = modelMapper.map(request, Address.class);
        address.setStreet(street);
        return address;
    }
}