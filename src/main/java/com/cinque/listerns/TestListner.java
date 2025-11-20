package com.cinque.listerns;

import com.cinque.Reports.ExtentLogger;
import com.cinque.Reports.ExtentReport;
import com.cinque.annotations.FrameworkAnnotation;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListner implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getDescription());
        ExtentReport.assignAuthor(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotation.class).author());
        ExtentReport.assignCategory(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotation.class).category());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getName() + " is passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getName() + " is failed");
        ExtentLogger.fail(result.getThrowable().getMessage());
        //ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
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
        ExtentLogger.info(result.getName() + " is skipped");
    }
}
