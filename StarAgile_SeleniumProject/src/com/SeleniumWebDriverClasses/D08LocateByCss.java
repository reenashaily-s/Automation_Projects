package com.SeleniumWebDriverClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D08LocateByCss 
{

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement userName = driver.findElement(By.cssSelector("input[autofocus=\"1\"]"));
		userName.sendKeys("something@gmail.com");
		WebElement password = driver.findElement(By.cssSelector("input[data-testid=\"royal-pass\"][type=\"password\"]"));
		password.sendKeys("pass123");
		WebElement LoginButton = driver.findElement(By.cssSelector("button[value=\"1\"]"));
		LoginButton.click();
		
		//driver.close();
	}

}
