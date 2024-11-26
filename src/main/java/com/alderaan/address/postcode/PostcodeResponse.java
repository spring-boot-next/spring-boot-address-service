package com.alderaan.address.postcode;

import com.alderaan.address.city.CityResponse;
import lombok.Data;

@Data
public class PostcodeResponse {
    private int id;
    private String code;
    private CityResponse city;
}