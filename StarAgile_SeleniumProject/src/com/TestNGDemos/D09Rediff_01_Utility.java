package com.TestNGDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class D09Rediff_01_Utility 
{
	WebDriver driver;
	
	public D09Rediff_01_Utility(WebDriver driver) 
	{
		this.driver = driver;
	}
		
	public void enterFullName(String fn) 
	{
		driver.findElement(By.xpath("//input[@placeholder='Enter your full name']")).sendKeys(fn);
	}
	
	public void enterRediffId(String rid) 
	{
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Rediffmail ID\"]")).sendKeys(rid);
		
	}
	
	public void setPassword(String ps) 
	{
		driver.findElement(By.xpath("//input[@id='newpasswd']")).sendKeys(ps);
		driver.findElement(By.xpath("//input[@id='newpasswd1']")).sendKeys(ps);
	}
	
	public void setBirthDate(String day, String month, String year) 
	{
		new Select(driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[8]/select[1]"))).selectByVisibleText(day);
		new Select(driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[8]/select[2]"))).selectByVisibleText(month);
		new Select(driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[8]/select[3]"))).selectByVisibleText(year);
	}
	

}
