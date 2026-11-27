package com.cinque.testdata.mapper.specialraterequestmapper;


import com.cinque.testdata.DTO.specialraterequestdata.SpecialRateRequestData;
import com.cinque.testdata.SpecialRateRequestTestData;

public class RemittanceSpecialRateRequestMapper {

    public static SpecialRateRequestData map(SpecialRateRequestTestData data){
        return SpecialRateRequestData.builder()
                .remid(data.getRemid())
                .valuedate(data.getValuedate())
                .rmcurrency(data.getRmcurrency())
                .correspondent(data.getCorrespondent())
                .product(data.getProduct())
                .rmpaymode(data.getRmpaymode())
                .rmfcamount(data.getRmfcamount())
                .rmlcamount(data.getRmlcamount())
                .rmremark(data.getRmremark())
                .build();
    }
}
