package com.SeleniumWebDriverClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D05LocateByName 
{

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement userName = driver.findElement(By.name("email"));
		userName.sendKeys("test@gmail.com");
		WebElement password = driver.findElement(By.name("pass"));
		password.sendKeys("1234");
		WebElement LoginBtn = driver.findElement(By.name("login"));
		LoginBtn.click();
		
		//driver.close();
	}

}
