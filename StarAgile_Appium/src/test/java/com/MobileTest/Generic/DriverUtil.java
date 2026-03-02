package com.MobileTest.Generic;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverUtil 
{
	public static AppiumDriver driver;
	public static AppiumDriver initAndroidDriverSession()
	{
		//set required capabilities
		  UiAutomator2Options options = new UiAutomator2Options();
		  options.setCapability("appium:adbExecTimeout",30000);
		  String path = System.getProperty("user.dir")+"//src//test//resources//ApiDemos-debug.apk";
		  options.setCapability("appium:app", path);
		  
		  //send address for connection
		  URL serverUrl;
		  try 
		  {
			  serverUrl = new URI("http://127.0.0.1:4723/").toURL();
			  driver = new AndroidDriver(serverUrl, options);
			  System.out.println("Session id: "+driver.getSessionId());
		  } 
		  catch (MalformedURLException | URISyntaxException e) 
		  {
			  e.printStackTrace();
		  }
		  
		  return driver;		  
	}
	
}
