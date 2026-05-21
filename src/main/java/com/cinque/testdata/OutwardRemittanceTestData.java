package com.cinque.testdata;


import io.github.sskorol.data.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OutwardRemittanceTestData {

    @Column(name ="testcasename")
    private String testcasename;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name= "toastType")
    private String toastType;
    @Column(name ="expectedMessages")
    private String expectedMessage;

    //Product Section
    @Column(name="country")
    private String country;
    @Column(name="currency")
    private String currency;
    @Column(name="producttype")
    private String producttype;
    @Column(name="product")
    private String product;
    @Column(name="deliverymode")
    private String deliverymode;

    //Amounts section
    @Column(name="fcamount")
    private String fcamount;
    @Column(name="lcamount")
    private String lcamount;
    @Column(name="commission")
    private String commission;
    @Column(name="othercharges")
    private String othercharges;
    @Column(name="discount")
    private String discount;
    @Column(name="paymode")
    private String paymode;

    //Sender Information
    @Column(name="remitterid")
    private String remitterid;
    @Column(name="representativename")
    private String representativename;
    @Column(name="purposeoftransfer")
    private String purposeoftransfer;
    @Column(name="sourceofincome")
    private String sourceofincome;

    //Receiver Information
    @Column(name="receivertype")
    private String receivertype;
    @Column(name="receivergender")
    private String receivergender;
    @Column(name="receiverfirstname")
    private String receiverfirstname;
    @Column(name="receivermiddlename")
    private String receivermiddlename;
    @Column(name="receiverlastname")
    private String receiverlastname;
    @Column(name="receiveraddress")
    private String receiveraddress;
    @Column(name="receivercity")
    private String receivercity;
    @Column(name="receivercountry")
    private String receivercountry;
    @Column(name="receivernationality")
    private String receivernationality;
    @Column(name="receivermobilecode")
    private String receivermobilecode;
    @Column(name="receivermobilenumber")
    private String receivermobilenumber;
    @Column(name="receiveridtype")
    private String receiveridtype;
    @Column(name="receiveridnumber")
    private String receiveridnumber;
    @Column(name="receiveridissuedate")
    private String receiveridissuedate;
    @Column(name="receiveridexpirydate")
    private String receiveridexpirydate;
    @Column(name="receiverrelationship")
    private String receiverrelationship;
    @Column(name="receivernearbyairport")
    private String receivernearbyairport;

    //Compliance Section
    @Column(name="suspiciousremarks")
    private String suspiciousremarks;
    @Column(name="ISTRremarks")
    private String ISTRremarks;
    @Column(name="SARremarks")
    private String SARremarks;

}
