package com.cinque.testdata.mapper.outwardremittancemapper;

import com.cinque.testdata.DTO.outwardremittancedata.ComplianceInformationData;
import com.cinque.testdata.OutwardRemittanceTestData;

public class ComplianceInformationMapper {

    public static ComplianceInformationData map (OutwardRemittanceTestData data){
        return ComplianceInformationData.builder().suspiciousremarks(data.getSuspiciousremarks()).
                ISTRremarks(data.getISTRremarks()).
                SARremarks(data.getSARremarks()).build();
    }
}
