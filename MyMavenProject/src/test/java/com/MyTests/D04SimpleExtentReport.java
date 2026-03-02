package com.MyTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class D04SimpleExtentReport 
{

	public static void main(String[] args) 
	{
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("Reports\\SimpleReport.html");  // holds report
		ExtentReports report = new ExtentReports();												 // represents report
		ExtentTest test;																		 // represents tests in the report
		report.attachReporter(htmlReport);														 // please store report in specified html file
		
		
		// Environment Details
		report.setSystemInfo("User Name", "Mahima");
		report.setSystemInfo("Machine", "Lenovo");
		report.setSystemInfo("Operation System", "Windows 11");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Processor", "i5");
		
		//Configuration about look and feel of the report
		htmlReport.config().setDocumentTitle("My First Extent Report");
		htmlReport.config().setReportName("Google Tests");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setTimeStampFormat("dd-MMM-yyyy");
		
		//Create test
		test = report.createTest("Google Title");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com");
		System.out.println("Title: " + driver.getTitle());
		driver.close();
		
		// report --> 
		test.log(Status.PASS, MarkupHelper.createLabel("Google Title Test", ExtentColor.GREEN));
		
		//Create another test
		test = report.createTest("Google Search");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Maven", Keys.ENTER);
		driver.close();
		test.log(Status.FAIL, MarkupHelper.createLabel("Google Search Test", ExtentColor.RED));
		
		
		report.flush();	//Will generate the report file
		
		
	}

}
