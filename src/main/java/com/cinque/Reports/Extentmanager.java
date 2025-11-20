package com.cinque.Reports;

import com.aventstack.extentreports.ExtentTest;

public class Extentmanager {

    private Extentmanager(){}

    private static final ThreadLocal<ExtentTest> THREAD_LOCAL = new ThreadLocal<>();

    static ExtentTest getExtentTest(){
        return THREAD_LOCAL.get();
    }
    static void setExtentTest(ExtentTest test){
        THREAD_LOCAL.set(test);
    }
}
