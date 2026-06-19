package com.cinque.Reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Extentmanager {


    private static final Map<String, ExtentTest> EXTENT_TEST_MAP = new ConcurrentHashMap<>();

    public static ExtentTest getExtentTest(String testName ) {
        return EXTENT_TEST_MAP.get(testName);
    }
    public static void setExtentTest(String testName, ExtentTest test) {
        EXTENT_TEST_MAP.put(testName, test);
    }

    public static void removeExtentTest(String testName) {
        EXTENT_TEST_MAP.remove(testName);
    }

}
