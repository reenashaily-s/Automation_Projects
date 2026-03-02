package com.MobileTest.DriverSessions;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverSessionWithUIAutomator2OptionsClass 
{
  @Test
  public void testDriverSesion() throws MalformedURLException, URISyntaxException
  {	  
	  //set required capabilities
	  UiAutomator2Options options = new UiAutomator2Options();
	  options.setCapability("appium:adbExecTimeout",30000);
	  String path = System.getProperty("user.dir")+"//src//test//resources//ApiDemos-debug.apk";
	  options.setCapability("appium:app", path);
	  
	  //send address for connection
	  URL serverUrl = new URI("http://127.0.0.1:4723/").toURL();
	  
	  //create appium driver session for android platform
	  AppiumDriver driver = new AndroidDriver(serverUrl, options);
	  System.out.println("Session id: "+driver.getSessionId());
  }
}
