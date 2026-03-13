package com.cinque.testdata.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PersonalDetailsData {
    private String customercategory;
    private String riskcategory;
    private String residenttype;
    private String gender;
    private String materialstatus;
    private String firstname;
    private String middlename;
    private String lastname;
    private String firstunicodename;
    private String middleunicodename;
    private String lastunicodename;
    private String dob;
    private String nationality;
    private String dualnationality;
    private String countryofbirth;
    private String placeofbirth;
    private String phonecode;
    private String mobilenumber;
    private String phonenumber;
    private String email;
    private String companytype;
    private String dateofestablishment;
    private String countryofincorporation;
    private String placeofincorporation;
}
