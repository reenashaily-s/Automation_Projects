package com.MobileTest.DriverSessions;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class DriverSessionWithDesireCapabilitiesClass 
{
  @Test
  public void testDriverSesion() throws MalformedURLException, URISyntaxException 
  {
	  //set required capabilities
	  DesiredCapabilities de_cap = new DesiredCapabilities();
	  de_cap.setCapability("platformName", "Android");  
	  de_cap.setCapability("appium:automationName", "uiautomator2");
	  de_cap.setCapability("appium:deviceName", "pixel_3a");
	  de_cap.setCapability("appium:udid", "emulator-5554");
	  de_cap.setCapability("appium:adbExecTimeout",30000);
	  String path = System.getProperty("user.dir")+"//src//test//resources//ApiDemos-debug.apk";
	  de_cap.setCapability("appium:app", path); 
	  
	  //send request to server (server address)
	  URL serverUrl = new URI("http://127.0.0.1:4723/").toURL();
	  
	  //create appium driver session 
	  AppiumDriver driver = new AndroidDriver(serverUrl,de_cap);
	  System.out.println("Session id: "+driver.getSessionId());
	  
  }
}
 