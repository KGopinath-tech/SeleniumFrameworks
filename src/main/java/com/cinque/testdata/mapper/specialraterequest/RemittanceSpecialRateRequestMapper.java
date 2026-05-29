package com.cinque.testdata.mapper.specialraterequest;


import com.cinque.testdata.DTO.specialraterequest.SpecialRateRequestData;
import com.cinque.testdata.SpecialRateRequestTestData;

public class RemittanceSpecialRateRequestMapper {

    public static SpecialRateRequestData map(SpecialRateRequestTestData data){
        return SpecialRateRequestData.builder()
                .remid(data.getRemid())
                .valuedate(data.getValuedate())
                .rmcurrency(data.getRmcurrency())
                .correspondent(data.getCorrespondent())
                .rmpaymode(data.getRmpaymode())
                .rmfcamount(data.getRmfcamount())
                .rmlcamount(data.getRmlcamount())
                .rmremark(data.getRmremark())
                .build();
    }
}
