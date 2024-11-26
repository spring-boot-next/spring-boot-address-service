package com.alderaan.address.postcode;

import com.alderaan.address.city.City;
import com.alderaan.address.city.CityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
record PostcodeMapperService(ModelMapper modelMapper, CityService cityService) {

    PostcodeResponse mapEntityToDto(Postcode postcode) {
        return modelMapper.map(postcode, PostcodeResponse.class);
    }

    Postcode mapRequestToEntity(PostcodeRequest request) {
        City city = cityService.findCityByName(request.getCityName());

        Postcode postcode = modelMapper.map(request, Postcode.class);
        postcode.setCity(city);
        return postcode;
    }
}