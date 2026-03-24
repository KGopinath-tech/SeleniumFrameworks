package com.cinque.testdata.mapper;

import com.cinque.testdata.DTO.IdentityDetailsData;
import com.cinque.testdata.TestData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IdentityDetailsMapper {

    public static IdentityDetailsData map (TestData data){

        List<String> images = null;

        if (data.getImagePath() != null && !data.getImagePath().isEmpty()) {
            images = Arrays.stream(data.getImagePath().split(","))
                    .map(String::trim)
                    .filter(path -> !path.isEmpty())
                    .collect(Collectors.toList());
        }

        return IdentityDetailsData.builder().idType(data.getIdType())
                .idNumber(data.getIdNumber())
                .issueCountry(data.getIssueCountry())
                .issuePlace(data.getIssuePlace())
                .issueDate(data.getIssueDate())
                .idExpiryDate(data.getIdExpiryDate())
                .visaNumber(data.getVisaNumber())
                .visaExpiryDate(data.getVisaExpiryDate())
                .imagePaths(images).build();
    }
}
