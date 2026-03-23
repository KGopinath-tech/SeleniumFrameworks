package com.cinque.testdata.mapper;

import com.cinque.testdata.DTO.PersonalDetailsData;
import com.cinque.testdata.TestData;

public class CorporatePersonalDetailsMapper {

    public static PersonalDetailsData map (TestData data){

        return PersonalDetailsData.builder().companytype(data.getCompanytype())
                .riskcategory(data.getRiskcategory())
                .residenttype(data.getResidenttype())
                .firstname(data.getFirstname())
                .middlename(data.getMiddlename())
                .lastname(data.getLastname())
                .firstunicodename(data.getFirstunicodename())
                .middleunicodename(data.getMiddleunicodename())
                .lastunicodename(data.getLastunicodename())
                .dateofestablishment(data.getDateofestablishment())
                .countryofincorporation(data.getCountryofincorporation())
                .nationality(data.getNationality())
                .placeofincorporation(data.getPlaceofincorporation())
                .phonecode(data.getPhonecode())
                .mobilenumber(data.getMobilenumber())
                .phonenumber(data.getPhonenumber())
                .email(data.getEmail()).build();
    }
}
