package com.ClassAssignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A01_GetPageSource 
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		String page = driver.getPageSource();
		System.out.println("PageSource : " +page);
	}

}
