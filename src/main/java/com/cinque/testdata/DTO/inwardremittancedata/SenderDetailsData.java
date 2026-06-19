package com.cinque.testdata.DTO.inwardremittancedata;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class SenderDetailsData {

    private String sendertype;
    private String firstname;
    private String middlename;
    private String lastname;
    private String mobilecode;
    private String mobile;
    private String address;
    private String city;
    private String country;
    private String nationality;
    private String idtype;
    private String idnumber;
    private String idissueplace;
    private String idissuedate;
    private String idexpirydate;
    private String nearbyairport;

}
