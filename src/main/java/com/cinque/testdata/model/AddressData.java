package com.cinque.testdata.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressData {
    private String AddressInUAE;
    private String POBox;
    private String City;
    private String NearestAirport;
    private String Emirate;
    private String District;
    private String Country;
    private String HomeAddressInCountry;
    private String TemporaryAddress;

}
