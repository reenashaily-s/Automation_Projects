package com.utils;

import com.base.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // Automatically creates a test in the report using the method name (e.g., tc1_addUser)
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Case Passed Successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail("Test Case Failed: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        
    }
}