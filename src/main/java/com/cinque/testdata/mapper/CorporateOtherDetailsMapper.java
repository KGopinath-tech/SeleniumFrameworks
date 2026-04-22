package com.cinque.testdata.mapper;

import com.cinque.testdata.DTO.OtherDetailsData;
import com.cinque.testdata.TestData;

public class CorporateOtherDetailsMapper {

    public static OtherDetailsData map (TestData data){
        return OtherDetailsData.builder().CBBusinessActivity(data.getCBBusinessActivity())
                .remarks(data.getRemarks())
                .companyLegalStatus(data.getCompanyLegalStatus())
                .location(data.getLocation())
                .watchlistRemarks(data.getWatchlistRemarks())
                .highRiskRemarks(data.getHighRiskRemarks())
                .VATRegistrationNumber(data.getVATRegistrationNumber())
                .CBLicence(data.getCBLicence())
                .CBExpiryDate(data.getCBExpiryDate())
                .natureOfBusiness(data.getNatureOfBusiness())
                .natureOfBusinessSubtype(data.getNatureOfBusinessSubtype())
                .companySubtype(data.getCompanySubtype())
                .CADIban(data.getCADIban())
                .registeredBy(data.getRegisteredBy())
                .referredBy(data.getReferredBy())
                .employee(data.getEmployee())
                .UID(data.getUID())
                .others(data.getOthers())
                .build();
    }
}
