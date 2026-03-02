package com.Assignments;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.appmanagement.ApplicationState;

public class Assignment_2
{
	@Test
	public void launchMobileApp() throws MalformedURLException, URISyntaxException
	  {	  
		  //set required capabilities
		  UiAutomator2Options opt = new UiAutomator2Options();
		  opt.setCapability("platformName", "Android");
		  opt.setCapability("appium:adbExecTimeout",30000);
		  String path = System.getProperty("user.dir")+"//src//test//resources//ApiDemos-debug.apk";
		  opt.setCapability("appium:app", path);
		  
		  //send address for connection
		  URL serverUrl = new URI("http://127.0.0.1:4723/").toURL();
		  
		  //create appium driver session for android platform
		  AndroidDriver driver = new AndroidDriver(serverUrl, opt);
		  System.out.println("Mobile app launched successfully!");
		  System.out.println("Session id: "+driver.getSessionId());
		  
		  String appPackage = "io.appium.android.apis";
		  
		  ApplicationState currentState = driver.queryAppState(appPackage);
	      System.out.println("Current app state: " + currentState);	      
	  }
}
