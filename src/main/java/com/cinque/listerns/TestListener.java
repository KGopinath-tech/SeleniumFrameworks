package com.cinque.listerns;

import com.cinque.Reports.ExtentLogger;
import com.cinque.Reports.ExtentReport;
import com.cinque.Reports.Extentmanager;
import com.cinque.annotations.FrameworkAnnotation;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {

        String testName = result.getName();
        ExtentReport.createTest(testName);

        FrameworkAnnotation annotation = result.getMethod().getConstructorOrMethod()
                .getMethod().getAnnotation(FrameworkAnnotation.class);
        if (annotation != null) {
            ExtentReport.assignAuthor(annotation.author());
            ExtentReport.assignCategory(annotation.category());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass( result.getName() + " is passed");
        Extentmanager.removeExtentTest(result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getName() + " is failed");
        if(result.getThrowable() != null) {
            ExtentLogger.fail(result.getThrowable().getMessage());
            //ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        }
        Extentmanager.removeExtentTest(result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReport.flushReports();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getName();
        ExtentLogger.info(testName + " is skipped");
        Extentmanager.removeExtentTest(testName);
    }
}
