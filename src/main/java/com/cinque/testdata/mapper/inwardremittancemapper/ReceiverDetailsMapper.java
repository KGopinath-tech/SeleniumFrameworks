package com.cinque.testdata.mapper.inwardremittancemapper;

import com.cinque.testdata.DTO.inwardremittancedata.ReceiverDetailsData;
import com.cinque.testdata.InwardRemittanceTestData;

public class ReceiverDetailsMapper {

    public static ReceiverDetailsData map(InwardRemittanceTestData data){
        return ReceiverDetailsData.builder()
                .remid(data.getRemid())
                .relation(data.getRelation())
                .bank(data.getBank())
                .branch(data.getBranch())
                .accountno(data.getAccountno())
                .economicactivity(data.getEconomicactivity())
                .purposeoftransfer(data.getPurposeoftransfer())
                .build();
    }
}
