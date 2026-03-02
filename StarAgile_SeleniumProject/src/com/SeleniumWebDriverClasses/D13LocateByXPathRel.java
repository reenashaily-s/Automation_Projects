package com.SeleniumWebDriverClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D13LocateByXPathRel 
{

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//form[@method=\"post\"]/div/div/input")).sendKeys("fndfn@gmail.com");
		driver.findElement(By.xpath("//form[@method=\"post\"]/div/div[2]/div/input")).sendKeys("1234"); 
	
	}

}
