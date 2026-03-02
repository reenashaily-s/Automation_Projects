package com.MobileAppTest.Scenarios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.MobileTest.Generic.DriverUtil;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class TC02_ClickGesture 
{
	@Test	
	public void testClickGesture()
	{
		AppiumDriver driver = DriverUtil.initAndroidDriverSession();
		
		//click action on view element
		//driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//click gesture
		WebElement e = driver.findElement(AppiumBy.accessibilityId("Views"));
		driver.executeScript("mobile: clickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) e).getId()));		
	}
}
 