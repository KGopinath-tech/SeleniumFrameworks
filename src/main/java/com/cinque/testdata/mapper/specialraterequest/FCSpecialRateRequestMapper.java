package com.cinque.testdata.mapper.specialraterequest;

import com.cinque.testdata.DTO.specialraterequest.SpecialRateRequestData;
import com.cinque.testdata.SpecialRateRequestTestData;

public class FCSpecialRateRequestMapper {

    public static SpecialRateRequestData map(SpecialRateRequestTestData data){
        return SpecialRateRequestData.builder().fctype(data.getFctype()).
                fctransactiontype(data.getFctransactiontype())
                .fccurrency(data.getFccurrency())
                .fcamount(data.getFcamount())
                .lcamount(data.getLcamount())
                .fcremark(data.getFcremark())
                .valuedate(data.getValuedate())
                .build();
    }
}
