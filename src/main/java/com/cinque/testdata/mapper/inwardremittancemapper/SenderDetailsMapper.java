package com.cinque.testdata.mapper.inwardremittancemapper;

import com.cinque.testdata.DTO.inwardremittancedata.SenderDetailsData;
import com.cinque.testdata.InwardRemittanceTestData;

public class SenderDetailsMapper {

    public static SenderDetailsData map(InwardRemittanceTestData data){
        return SenderDetailsData.builder()
                .sendertype(data.getSendertype()).
                firstname(data.getFirstname()).
                middlename(data.getMiddlename()).
                lastname(data.getLastname()).
                mobilecode(data.getMobilecode()).
                mobile(data.getMobile()).
                address(data.getAddress()).
                city(data.getCity()).
                country(data.getCountry()).
                nationality(data.getNationality()).
                idtype(data.getIdtype()).
                idnumber(data.getIdnumber()).
                idissueplace(data.getIdissueplace()).
                idissuedate(data.getIdissuedate()).
                idexpirydate(data.getIdexpirydate()).
                emirate(data.getEmirate()).
                nearbyairport(data.getNearbyairport()).
                build();
    }
}
