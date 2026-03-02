package com.SeleniumWebDriverClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class D02LaunchingEdge 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.edge.driver", "C:\\Users\\reena\\OneDrive\\Documents\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		//driver.close();
	}

}
