package com.TestNGDemos;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class D06DataProviderDemo {
	WebDriver driver;
	String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", actUrl;
	
	@Test(dataProvider = "getData")
	public void loginToOHRM(String un, String ps) {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ps);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		actUrl = driver.getCurrentUrl();
		
		//Assert.assertEquals(actUrl, expUrl, "Invalid User name / Password!!!");
		//Assert.assertTrue(actUrl.contains("dashboard"), "Invalid User name / Password!!!");
		//Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}
	@AfterMethod
	public void afterMethod() {
		if (driver.getCurrentUrl().contains("dashboard")) {
			driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
			driver.findElement(By.linkText("Logout")).click();
			System.out.println("Test Case Pass");
		}
		else {
			System.out.println("Test Case Fail");
		}
	}


	@DataProvider
	public Object[][] getData() {
		return new Object[][] {
			new Object[] { "admin", "admin123" },
			new Object[] { "trapti", "trapti123" },
			new Object[] { "admin", "admin123" },
			new Object[] { "aparna", "aparna123" },
		};
		
		//Object[][] data = new Object[][] {{1 ,"A"}, {2, "B"}};
		
		//return data;
	}
	@BeforeTest
	public void beforeTest() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
