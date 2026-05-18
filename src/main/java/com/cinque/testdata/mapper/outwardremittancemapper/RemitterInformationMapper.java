package com.cinque.testdata.mapper.outwardremittancemapper;

import com.cinque.testdata.DTO.outwardremittancedata.RemitterInformationData;
import com.cinque.testdata.OutwardRemittanceTestData;

public class RemitterInformationMapper {

    public static RemitterInformationData map(OutwardRemittanceTestData data){
        return RemitterInformationData.builder().remitterid(data.getRemitterid()).
                representativename(data.getRepresentativename()).
                purposeoftransfer(data.getPurposeoftransfer()).
                sourceofincome(data.getSourceofincome()).
                build();
    }
}
