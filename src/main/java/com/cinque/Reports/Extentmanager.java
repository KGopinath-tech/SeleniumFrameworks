package com.cinque.Reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Extentmanager {


    private static final Map<String, ExtentTest> EXTENT_TEST_MAP
            = new ConcurrentHashMap<>();

    private static final ThreadLocal<String> CURRENT_TEST_NAME
            = new ThreadLocal<>();

    public static ExtentTest getExtentTest() {
        return EXTENT_TEST_MAP.get(CURRENT_TEST_NAME.get());
    }
    public static void setExtentTest(String testName, ExtentTest test) {
        EXTENT_TEST_MAP.put(testName, test);
        CURRENT_TEST_NAME.set(testName);
    }

    public static void removeExtentTest(String testName) {
        EXTENT_TEST_MAP.remove(testName);
        CURRENT_TEST_NAME.remove();
    }

//    private Extentmanager(){}
//
//    private static final ThreadLocal<ExtentTest> THREAD_LOCAL = new ThreadLocal<>();
//
//    static ExtentTest getExtentTest(){
//        return THREAD_LOCAL.get();
//    }
//    static void setExtentTest(ExtentTest test){
//        THREAD_LOCAL.set(test);
//    }
}
