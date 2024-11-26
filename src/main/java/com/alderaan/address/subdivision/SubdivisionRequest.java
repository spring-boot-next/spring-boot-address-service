package com.alderaan.address.subdivision;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubdivisionRequest {

    private String iso;
    private String name;
    private String type;
    private String countryName;
}