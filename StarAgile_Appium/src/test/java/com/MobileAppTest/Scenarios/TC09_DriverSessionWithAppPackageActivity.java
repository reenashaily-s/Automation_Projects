package com.MobileAppTest.Scenarios;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class TC09_DriverSessionWithAppPackageActivity 
{
	@Test
	public void testSession() throws MalformedURLException, URISyntaxException
	{
		UiAutomator2Options options = new UiAutomator2Options();
		options.setCapability("appium:appPackage","com.google.android.deskclock");
		options.setCapability("appium:appActivity", "com.android.deskclock.DeskClock");
		
		//server Address
		URL serverUrl = new URI("http://127.0.0.1:4723/").toURL();
		
		//create driver session
		AppiumDriver driver = new AndroidDriver(serverUrl, options);
		System.out.println("Session id is: "+driver.getSessionId());
	}
}
