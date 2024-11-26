package com.alderaan.address;

import com.alderaan.address.street.StreetResponse;
import lombok.Data;

@Data
public class AddressResponse {
    private int id;
    private int number;
    private String addition;
    private StreetResponse street;
}