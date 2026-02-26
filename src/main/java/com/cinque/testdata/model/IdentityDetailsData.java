package com.cinque.testdata.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
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

