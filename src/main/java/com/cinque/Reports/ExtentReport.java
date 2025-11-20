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
    public static ExtentTest extentTest;

    public static void initReports(){

        String reportName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + "_ExtentReport.html";
        String reportPath = FrameworkConstants.getReportPath() + reportName;

        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        extent.attachReporter(spark);

    }
    public static void flushReports(){
        extent.flush();
    }
    public static synchronized void createTest(String testCaseName){
         extentTest = extent.createTest(testCaseName);
         Extentmanager.setExtentTest(extentTest);
    }
    public static void assignAuthor(String author){
        Extentmanager.getExtentTest().assignAuthor(author);
    }
    public static void assignCategory(String[] category) {
        Extentmanager.getExtentTest().assignCategory(category);
    }
}
