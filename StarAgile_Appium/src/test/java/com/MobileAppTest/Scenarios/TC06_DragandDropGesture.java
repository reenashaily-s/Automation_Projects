package com.MobileAppTest.Scenarios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import com.MobileTest.Generic.DriverUtil;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class TC06_DragandDropGesture 
{
  @Test
  public void testDragandDropGesture() 
  {
	  AppiumDriver driver = DriverUtil.initAndroidDriverSession();
	  driver.findElement(AppiumBy.accessibilityId("Views")).click();
	  driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
	  WebElement e = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
	  driver.executeScript("mobile: dragGesture", 
			  ImmutableMap.of(
					  			"elementId", ((RemoteWebElement) e).getId(),
					  			"endX", 721,
					  			"endY", 1260));
	  
	  String dropResult = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
	  System.out.println(dropResult);
	  
	  
	  
	  
	  
  }
}
