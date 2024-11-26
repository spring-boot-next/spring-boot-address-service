package com.alderaan.address.street;

import com.alderaan.address.postcode.PostcodeResponse;
import lombok.Data;

@Data
public class StreetResponse {

    private int id;
    private String name;
    private PostcodeResponse postcode;
}