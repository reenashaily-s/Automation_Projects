package com.MobileAppTest.Scenarios;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.MobileTest.Generic.DriverUtil;
import com.MobileTest.Generic.MobileUtil;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class TC04_ScrollGesture 
{
  @Test
  public void testScrollGesture() 
  {
	  AppiumDriver driver = DriverUtil.initAndroidDriverSession();
	  
	  //views
	  driver.findElement(AppiumBy.accessibilityId("Views")).click();
	  
//	  //scroll
	  WebElement pageArea = driver.findElement(AppiumBy.id("android:id/list"));
//	  driver.executeScript("mobile: scrollGesture", ImmutableMap.of("elementId", ((RemoteWebElement)pageArea).getId(), 
//			  				"direction", "down",
//			  				"percent", 1.0));
	  
	  MobileUtil.scrollDown(driver, pageArea);
	  MobileUtil.scrollUp(driver, pageArea);
	  MobileUtil.scrollUptoCount(driver, pageArea, 2, "down");
	  
	  
	  
  }
}
