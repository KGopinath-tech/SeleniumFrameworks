package com.cinque.testdata.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class IdentityDetailsData {

    private String idType;
    private String idNumber;
    private String issueCountry;
    private String issuePlace;
    private String issueDate;
    private String idExpiryDate;
    private String visaNumber;
    private String visaExpiryDate;
    private String imagePath;
}
