package com.TestNGDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Rediff_03_PageFactory 
{
	WebDriver driver;
	@FindBy (xpath = "//input[@placeholder='Enter your full name']") WebElement fullName;	
	@FindBy (xpath = "//input[@placeholder=\"Enter Rediffmail ID\"]") WebElement eMail;
	@FindBy (id="newpasswd") WebElement password;
	
	public Rediff_03_PageFactory(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	public void enterFullName(String fn) 
	{
		fullName.sendKeys(fn);		
	}
	
	public void enterRediffId(String rid) 
	{
		eMail.sendKeys(rid);
	}
	
	public void setPassword(String ps) 
	{
		password.sendKeys(ps);
		driver.findElement(By.xpath("//input[@id='newpasswd1']")).sendKeys(ps);
	}
	
	public void setBirthDate(String day, String month, String year) 
	{
		new Select(driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[8]/select[1]"))).selectByVisibleText(day);
		new Select(driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[8]/select[2]"))).selectByVisibleText(month);
		new Select(driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[8]/select[3]"))).selectByVisibleText(year);
	}
	

}
