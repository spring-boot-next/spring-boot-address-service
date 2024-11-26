package com.alderaan.address.city;

import com.alderaan.address.country.CountryResponse;
import com.alderaan.address.subdivision.SubdivisionResponse;
import lombok.Data;

@Data
public class CityResponse {

    private int id;
    private String name;
    private SubdivisionResponse subdivision;
    private CountryResponse country;
}