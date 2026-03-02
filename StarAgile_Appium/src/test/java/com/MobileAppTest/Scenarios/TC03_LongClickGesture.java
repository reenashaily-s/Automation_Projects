package com.MobileAppTest.Scenarios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.MobileTest.Generic.DriverUtil;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class TC03_LongClickGesture 
{
	@Test
	public void testLongClickGesture()
	{
		AppiumDriver driver = DriverUtil.initAndroidDriverSession();
		
		//views
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//drag and drop
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		//circle
		WebElement e = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
		
		//LongClick
		driver.executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) e).getId(), "duration", 3000));
	}
}
