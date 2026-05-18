package com.cinque.testdata.mapper.customerregistermapper;

import com.cinque.testdata.DTO.customerregisterdata.AddressDetailsData;
import com.cinque.testdata.TestData;

public class AddressDetailsMapper {


    public static AddressDetailsData map(TestData data){
        return AddressDetailsData.builder().AddressInUAE(data.getAddressInUAE())
                .POBox(data.getPOBox()).City(data.getCity())
                .NearestAirport(data.getNearestAirport())
                .Emirate(data.getEmirate())
                .District(data.getDistrict())
                .Country(data.getCountry())
                .HomeAddressInCountry(data.getHomeAddressInCountry())
                .TemporaryAddress(data.getTemporaryAddress())
                .build();
    }

}
