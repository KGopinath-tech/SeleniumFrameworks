package com.cinque.testdata.mapper.customerregistermapper;

import com.cinque.testdata.DTO.customerregisterdata.OtherDetailsData;
import com.cinque.testdata.CustomerRegisterTestData;

public class IndividualOtherDetailsMapper {

    public static OtherDetailsData map (CustomerRegisterTestData data){
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
                .registeredBy(data.getRegisteredBy())
                .referredBy(data.getReferredBy())
                .employee(data.getEmployee())
                .UID(data.getUID())
                .others(data.getOthers())
                .build();
    }
}
