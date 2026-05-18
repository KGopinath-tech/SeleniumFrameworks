package com.cinque.testdata.DTO.outwardremittancedata;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class ReceiverInformationData {

    private String receivertype;
    private String receivergender;
    private String receiverfirstname;
    private String receivermiddlename;
    private String receiverlastname;
    private String receiveraddress;
    private String receivercity;
    private String receivercountry;
    private String receivernationality;
    private String receivermobilecode;
    private String receivermobilenumber;
    private String receiveridtype;
    private String receiveridnumber;
    private String receiveridissuedate;
    private String receiveridexpirydate;
    private String receiverrelationship;
    private String receivernearbyairport;
}
