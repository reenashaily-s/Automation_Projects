package com.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    // Global variables to share data across TC1 to TC10
    public static String token;
    public static String contactId;
    public static String userEmail;
    
    // Reporting variables
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void setup() {
        // Core Logic: Set the URL for all tests
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
        
        // Reporting Logic: Initialize the HTML report
        ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        
        System.out.println(">>> Framework Initialized: Base URL set and Report started.");
    }

    @AfterSuite
    public void tearDown() {
        // Finalize the report file
        extent.flush(); 
        System.out.println(">>> Execution Finished: Report generated at target/ExtentReport.html");
    }
}