package com.Assignments;

import java.net.URI;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Assignment_4
{
	@Test
	 public void installAPIDemosApp() throws Exception 
	{

	    UiAutomator2Options opt = new UiAutomator2Options();
	    opt.setPlatformName("Android");
	    URL serverUrl = new URI("http://127.0.0.1:4723/").toURL();
	    AndroidDriver driver = new AndroidDriver(serverUrl, opt);
	    String APIDemosPackage = "io.appium.android.apis";

	    // Install API Demos
	    String apkPath = System.getProperty("user.dir") + "/src/test/resources/ApiDemos-debug.apk";
	    driver.installApp(apkPath);
        System.out.println("API Demos APK installed successfully");
	    
        Assert.assertTrue(driver.isAppInstalled(APIDemosPackage),
                "Assertion Failed: API Demos app is not installed");

        System.out.println("Assertion Passed: API Demos app is installed on the device");

	    driver.quit();
	}

}
