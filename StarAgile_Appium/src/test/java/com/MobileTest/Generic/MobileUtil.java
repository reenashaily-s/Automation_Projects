
package com.MobileTest.Generic;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;

public class MobileUtil 
{
	public static void getScreenschot(AppiumDriver driver, String ScreenshotName)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		  File f= ts.getScreenshotAs(OutputType.FILE);
		  File destination = new File(System.getProperty("user.dir")+"//Screenshots//"+ScreenshotName+System.currentTimeMillis()+".png");
		  try {
			  	FileHandler.copy(f, destination);
		  	  } 
		  catch (IOException e) 
		  {
			e.printStackTrace();
		  }
	}
	
	public static void scrollDown(AppiumDriver driver, WebElement pageArea)
	{
		driver.executeScript("mobile: scrollGesture", 
				ImmutableMap.of(
								"elementId", ((RemoteWebElement)pageArea).getId(), 
								"direction", "down",
								"percent", 1.0));
	}
	
	public static void scrollUp(AppiumDriver driver, WebElement pageArea)
	{
		driver.executeScript("mobile: scrollGesture", 
				ImmutableMap.of(
								"elementId", ((RemoteWebElement)pageArea).getId(), 
								"direction", "up",
								"percent", 1.0));
	}
	
	public static void scrollLeft(AppiumDriver driver, WebElement pageArea)
	{
		driver.executeScript("mobile: scrollGesture", 
				ImmutableMap.of(
								"elementId", ((RemoteWebElement)pageArea).getId(), 
								"direction", "left",
								"percent", 1.0));
	}
	
	public static void scrollRight(AppiumDriver driver, WebElement pageArea)
	{
		driver.executeScript("mobile: scrollGesture", 
				ImmutableMap.of(
								"elementId", ((RemoteWebElement)pageArea).getId(), 
								"direction", "right",
								"percent", 1.0));
	}
	
	public static void scrollUptoCount(AppiumDriver driver,WebElement pageArea,int count,String direction)
	{
		for(int i=1;i<=count;i++)
		{
		driver.executeScript("mobile:scrollGesture",
				ImmutableMap.of(				  
								"elementId",((RemoteWebElement)pageArea).getId(),
								"direction",direction,
								"percent",1.0));
		
		}
	}
	
	
	
	
	
	
	
	

}
