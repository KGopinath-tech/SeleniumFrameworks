package com.cinque.testdata.mapper.outwardremittancemapper;

import com.cinque.testdata.DTO.outwardremittancedata.ReceiverInformationData;
import com.cinque.testdata.OutwardRemittanceTestData;

public class ReceiverInformationMapper {

    public static ReceiverInformationData map (OutwardRemittanceTestData data){
        return ReceiverInformationData.builder().receivertype(data.getReceivertype()).
                receivergender(data.getReceivergender()).
                receiverfirstname(data.getReceiverfirstname()).
                receivermiddlename(data.getReceivermiddlename()).
                receiverlastname(data.getReceiverlastname()).
                receiveraddress(data.getReceiveraddress()).
                receivercity(data.getReceivercity()).
                receivercountry(data.getReceivercountry()).
                receivernationality(data.getReceivernationality()).
                receivermobilecode(data.getReceivermobilecode()).
                receivermobilenumber(data.getReceivermobilenumber()).
                receiveridtype(data.getReceiveridtype()).
                receiveridnumber(data.getReceiveridnumber()).
                receiveridissuedate(data.getReceiveridissuedate()).
                receiveridexpirydate(data.getReceiveridexpirydate()).
                receiverrelationship(data.getReceiverrelationship()).
                receivernearbyairport(data.getReceivernearbyairport()).
                build();
    }
}
