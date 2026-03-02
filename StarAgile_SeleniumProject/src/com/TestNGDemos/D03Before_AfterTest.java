package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D03Before_AfterTest {
	WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Before Test");
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		System.out.println("After Test");
	}

	@Test(priority = 3)
	public void testLittleBox() {
		driver.get("https://littleboxindia.com/");
		System.out.println("Title: " + driver.getTitle());
	}

	@Test(priority = 4)
	public void testLibas() {
		driver.get("https://www.libas.in/?srsltid=AfmBOoosC9EkK-Vnt6QlbuDLJhsvwUoqSdzBKZkN8sAfT7QoKd4yTL-R");
		System.out.println("Title: " + driver.getTitle());
	}

	@Test(priority = 2)
	public void testFirstCry() {
		driver.get("https://www.firstcry.com/?srsltid=AfmBOopCSYKI3yVo-xTL_NOHcOKjHQaL5qjAhjkKJHMMmRlaMlyXn0G2");
		System.out.println("Title: " + driver.getTitle());
	}

	@Test(priority = 1)
	public void testOnyc() {
		driver.get("https://onyc.in/");
		System.out.println("Title: " + driver.getTitle());
	}
}
