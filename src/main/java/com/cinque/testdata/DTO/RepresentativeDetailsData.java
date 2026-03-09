package com.cinque.testdata.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class RepresentativeDetailsData {

    private String representativeType;
    private String representativeFirstName;
    private String representativeMiddleName;
    private String representativeLastName;
    private String representativeGender;
    private String representativeDOB;
    private String representativeNationality;
    private String representativeDualNationality;
    private String representativePhoneCode;
    private String representativePhoneNumber;
    private String representativeIdType;
    private String representativeIdNumber;
    private String placeOfIssue;
    private String idIssueDate;
    private String idExpiryDate;
    private String idIssueCountry;
    private String visaNumber;
    private String visaIdExpiryDate;
    private String relation;
    private String repIdImagePath;

}
