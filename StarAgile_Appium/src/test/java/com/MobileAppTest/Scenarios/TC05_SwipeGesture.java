package com.MobileAppTest.Scenarios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.MobileTest.Generic.DriverUtil;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class TC05_SwipeGesture 
{
  @Test
  public void testSwipeGesture() 
  {
	  AppiumDriver driver = DriverUtil.initAndroidDriverSession();
	  
	  //views
	  driver.findElement(AppiumBy.accessibilityId("Views")).click();
	  
	  //gallery
	  driver.findElement(AppiumBy.accessibilityId("Gallery")).click();

	  //photos - swipe
	  driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
	  
	  //swipe
	  WebElement pageArea = driver.findElement(AppiumBy.id("io.appium.android.apis:id/gallery"));
	  driver.executeScript("mobile: swipeGesture", 
			  ImmutableMap.of("elementId", ((RemoteWebElement) pageArea).getId(),
					  		  "direction", "left",
					  		  "percent", 1.0 ));
	  
	  
  }
}
