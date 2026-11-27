package com.cinque.testdata.mapper.specialraterequestmapper;

import com.cinque.testdata.DTO.specialraterequestdata.SpecialRateRequestData;
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
