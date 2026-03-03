package com.cinque.testdata.model;


import lombok.Data;

@Data
    public class IdentityData {

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

