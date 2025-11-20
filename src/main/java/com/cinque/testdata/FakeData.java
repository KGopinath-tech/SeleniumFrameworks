package com.cinque.testdata;

import com.github.javafaker.Faker;

public class FakeData {

    private FakeData(){}

    private static final Faker faker = new Faker();

    public static String getFirstname(){
        return faker.name().firstName();
    }
    public static String getLastname(){
        return faker.name().lastName();
    }
    public static String getFullname(){
        return faker.name().fullName();
    }
    public static String getMail(){
        return faker.internet().emailAddress();
    }
    public static String getPhonenumber(){
        return faker.phoneNumber().phoneNumber();
    }
    public static String getMobilenumber(){
        return faker.phoneNumber().cellPhone();
    }
}
