package com.alderaan.address.subdivision;

import com.alderaan.address.country.CountryResponse;
import lombok.Data;

@Data
public class SubdivisionResponse {

    private int id;
    private String iso;
    private String name;
    private SubdivisionType type;
    private CountryResponse country;
}