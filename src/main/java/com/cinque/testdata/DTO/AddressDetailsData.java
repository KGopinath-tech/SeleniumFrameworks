package com.cinque.testdata.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class AddressDetailsData {

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
