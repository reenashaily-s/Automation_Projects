package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D09Rediff_02_POM_Client
{
	WebDriver driver;
	D09Rediff_01_Utility r1;
	
	@Test
	public void registration1() 
	{
		r1.enterFullName("Reena Shaily");
		r1.enterRediffId("srsshaily");
		r1.setPassword("reena@123");
		r1.setBirthDate("09", "MAR", "2000");
	}
	
	@Test
	public void registration2() {
		r1.enterFullName("Dipika Brahmankar");
		r1.enterRediffId("dipika");
		r1.setPassword("dipika@123");
		r1.setBirthDate("05", "APR", "2001");
	}
	
	@BeforeMethod
	public void refreshPage() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.navigate().refresh();
	}
	
	@BeforeTest
	public void beforeTest() 
	{
		driver = new EdgeDriver(); //initialsed
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");	
		
		r1 = new D09Rediff_01_Utility(driver);
	}
	
	
	

	@AfterTest
	public void afterTest() 
	{
	}

}
