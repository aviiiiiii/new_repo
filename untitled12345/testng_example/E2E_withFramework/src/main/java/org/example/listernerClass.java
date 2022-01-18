package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class listernerClass extends base implements ITestListener {

    private static Logger log= LogManager.getLogger(listernerClass.class.getName());
    ExtentReports extent=extentReport.getExtentReports();
    ExtentTest test;
    ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        log.info("onTestStart");
        test=extent.createTest("Test");
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        WebDriver driver = null;
        try {
            driver= (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("onTestSuccess");
        try {
            String path=getScreenShot(driver);
            extentTest.get().addScreenCaptureFromPath(path,result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        extentTest.get().log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        WebDriver driver = null;
        try {
            driver= (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("onTestFailure");
        try {
            String path=getScreenShot(driver);
            extentTest.get().addScreenCaptureFromPath(path,result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        extentTest.get().log(Status.FAIL,"Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        log.info("onTestSKipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        log.info("onStart");

    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        log.info("onFinish");
        extent.flush();
    }
}
