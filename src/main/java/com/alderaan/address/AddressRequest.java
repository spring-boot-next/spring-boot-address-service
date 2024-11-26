package com.alderaan.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {

    private int number;
    private String addition;
    private String streetName;
    private String postcodeCode;
    private String cityName;
    private String subdivisionName;
    private String countryName;
}