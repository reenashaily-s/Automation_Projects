package com.Assignments;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import com.MobileTest.Generic.DriverUtil;

import io.appium.java_client.AppiumDriver;

public class Assignment_6
{
	@Test
	public void testScreenshot() throws IOException 
	  {
		  AppiumDriver driver = DriverUtil.initAndroidDriverSession();
		  TakesScreenshot ts = (TakesScreenshot)driver;
		  File f= ts.getScreenshotAs(OutputType.FILE);
		  String ScreenshotName = "AppHomePageView_Screenshot";
		  File destination = new File(System.getProperty("user.dir")+"//Screenshots//"+ScreenshotName+System.currentTimeMillis()+".png");
		  FileHandler.copy(f, destination);		  
	  }

}
