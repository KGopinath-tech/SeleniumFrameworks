package com.cinque.testdata.mapper.specialraterequest;

import com.cinque.testdata.DTO.specialraterequest.SpecialRateRequestData;
import com.cinque.testdata.SpecialRateRequestTestData;

public class SpecialRateRequestSearchMapper {

    public static SpecialRateRequestData map(SpecialRateRequestTestData data){
        return SpecialRateRequestData.builder()
                .searchreferenceno(data.getSearchreferenceno())
                .searchfromdate(data.getSearchfromdate())
                .searchtodate(data.getSearchtodate())
                .searchstatus(data.getSearchstatus())
                .searchtransactiontype(data.getSearchtransactiontype())
                .build();
    }
}
