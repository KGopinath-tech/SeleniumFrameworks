package com.cinque.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.cinque.constants.FrameworkConstants;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class ExtentReport {

    private ExtentReport(){}

    public static ExtentReports extent;
    public static String reportPath;

    public static void initReports(){

        String reportName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + "_ExtentReport.html";
        reportPath = FrameworkConstants.getReportPath() + reportName;

        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        extent.attachReporter(spark);
    }

    public static void flushReports(){
        if(extent != null)
            extent.flush();
    }

    public static synchronized void createTest(String testName){
        ExtentTest test = extent.createTest(testName);
        Extentmanager.setExtentTest(testName, test);
    }
    public static void assignAuthor(String testName, String author){
        ExtentTest test = Extentmanager.getExtentTest(testName);
        if (test != null)
            test.assignAuthor(author);
    }
    public static void assignCategory(String testName, String[] category) {
        ExtentTest test = Extentmanager.getExtentTest(testName);
        if (test != null)
            test.assignCategory(category);
    }
}
