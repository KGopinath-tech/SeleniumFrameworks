package com.cinque.testdata.mapper;

import com.cinque.testdata.DTO.OtherDetailsData;
import com.cinque.testdata.TestData;

public class IndividualOtherDetailsMapper {

    public static OtherDetailsData map (TestData data){
        return OtherDetailsData.builder().remarks(data.getRemarks())
                .location(data.getLocation())
                .watchlistRemarks(data.getWatchlistRemarks())
                .highRiskRemarks(data.getHighRiskRemarks())
                .CBLicence(data.getCBLicence())
                .CADIban(data.getCADIban())
                .CBBusinessActivity(data.getCBBusinessActivity())
                .companyLegalStatus(data.getCompanyLegalStatus())
                .VATRegistrationNumber(data.getVATRegistrationNumber())
                .CBExpiryDate(data.getCBExpiryDate())
                .natureOfBusiness(data.getNatureOfBusiness())
                .natureOfBusinessSubtype(data.getNatureOfBusinessSubtype())
                .companySubtype(data.getCompanySubtype())
                .referredBy(data.getReferredBy())
                .employee(data.getEmployee())
                .UID(data.getUID())
                .others(data.getOthers())
                .build();
    }
}
