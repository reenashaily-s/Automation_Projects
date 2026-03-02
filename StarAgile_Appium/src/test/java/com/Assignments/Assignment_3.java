package com.Assignments;

import java.net.URI;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Assignment_3
{
	@Test
	public void uninstallAPIDemos() throws Exception 
	{

	    UiAutomator2Options opt = new UiAutomator2Options();
	    opt.setPlatformName("Android");

	    URL serverUrl = new URI("http://127.0.0.1:4723/").toURL();
	    AndroidDriver driver = new AndroidDriver(serverUrl, opt);

	    String APIDemosPackage = "io.appium.android.apis";

	    // Uninstall API Demos
	    driver.removeApp(APIDemosPackage);
	    System.out.println("APIDemos app uninstalled");
	    
	    Assert.assertFalse(
	            driver.isAppInstalled("io.appium.android.apis"),
	            "Assertion Failed: APIDemos app is present on the device"
	    );

	    System.out.println("Assertion Passed: APIDemos app is not present on the device");

	    driver.quit();
	}

}
