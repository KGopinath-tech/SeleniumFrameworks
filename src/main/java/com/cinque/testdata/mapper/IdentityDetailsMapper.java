package com.cinque.testdata.mapper;

import com.cinque.testdata.DTO.IdentityDetailsData;
import com.cinque.testdata.TestData;

public class IdentityDetailsMapper {

    public static IdentityDetailsData map (TestData data){
        return IdentityDetailsData.builder().idType(data.getIdType())
                .idNumber(data.getIdNumber())
                .issueCountry(data.getIssueCountry())
                .issuePlace(data.getIssuePlace())
                .issueDate(data.getIssueDate())
                .idType(data.getIdType())
                .visaNumber(data.getVisaNumber())
                .visaExpiryDate(data.getVisaExpiryDate())
                .imagePath(data.getImagePath()).build();
    }
}
