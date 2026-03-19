package com.cinque.testdata.mapper;

import com.cinque.testdata.DTO.OtherDetailsData;
import com.cinque.testdata.TestData;

public class OtherDetailsMapper {

    public static OtherDetailsData map (TestData data){
        return OtherDetailsData.builder().remarks(data.getRemarks())
                .location(data.getLocation())
                .watchlistRemarks(data.getWatchlistRemarks())
                .highRiskRemarks(data.getHighRiskRemarks())
                .CBLicence(data.getCBLicence())
                .CADIban(data.getCADIban())
                .referredBy(data.getReferredBy())
                .build();
    }
}
