package com.cinque.Reports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.cinque.config.Configfactory;
import com.cinque.utils.ScreenshotUtils;

public final class ExtentLogger {

    private ExtentLogger(){}

    public static void pass(String message){
        ExtentTest test = Extentmanager.getExtentTest();
        if(test==null) return;
        if(Configfactory.getConfig().screenshotForPassedSteps().equalsIgnoreCase("Yes")) {
            test.pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshot()).build());
        }else{
            test.pass(message);
        }
    }
    public static void fail(String message){
        ExtentTest test = Extentmanager.getExtentTest();
        if(test==null) return;
                test.fail(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshot()).build());
    }
    public static void info(String message){
        ExtentTest test = Extentmanager.getExtentTest();
        if(test==null) return;
        if(Configfactory.getConfig().screenshotForInfoSteps().equalsIgnoreCase("Yes")) {
            test.info(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshot()).build());
        }
    }
}
