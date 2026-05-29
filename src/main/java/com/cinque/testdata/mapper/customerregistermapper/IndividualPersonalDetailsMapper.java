package com.cinque.testdata.mapper.customerregistermapper;

import com.cinque.testdata.DTO.customerregisterdata.PersonalDetailsData;
import com.cinque.testdata.CustomerRegisterTestData;

public class IndividualPersonalDetailsMapper {

    public static PersonalDetailsData map(CustomerRegisterTestData data){

        return PersonalDetailsData.builder().customercategory(data.getCustomercategory())
                .riskcategory(data.getRiskcategory())
                .residenttype(data.getResidenttype())
                .gender(data.getGender())
                .materialstatus(data.getMaterialstatus())
                .firstname(data.getFirstname())
                .lastname(data.getLastname())
                .dob(data.getDob())
                .nationality(data.getNationality())
                .countryofbirth(data.getCountryofbirth())
                .placeofbirth(data.getPlaceofbirth())
                .phonecode(data.getPhonecode())
                .mobilenumber(data.getMobilenumber())
                .email(data.getEmail())
                .build();

    }

}
