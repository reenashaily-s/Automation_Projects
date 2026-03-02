package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D05AmazonAssignment {
	WebDriver driver;
	
	@Test(priority = 1, groups = "AmazonPrime")
	public void clickOnMXPlayer() {
		driver.findElement(By.partialLinkText("MX")).click();
	}
	@Test(priority = 2, groups = "Offers")
	public void clickOnSell() {
		driver.findElement(By.partialLinkText("Sell")).click();
	}
	@Test(priority = 3, groups = "AmazonPrime")
	public void clickOnAmazonPay() {
		driver.findElement(By.partialLinkText("Pay")).click();
	}
	@Test(priority = 4, groups = "Offers")
	public void clickOnTodaysDeals() {
		driver.findElement(By.partialLinkText("Today")).click();
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		driver.get("https://www.amazon.in/");
		System.out.println("Title: " + driver.getTitle());
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Title: " + driver.getTitle());
	}

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.close();
	}

}
