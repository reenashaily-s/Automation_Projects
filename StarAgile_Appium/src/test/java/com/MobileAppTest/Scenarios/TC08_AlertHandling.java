package com.MobileAppTest.Scenarios;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.MobileTest.Generic.DriverUtil;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class TC08_AlertHandling 
{
  @Test
  public void testAlert() throws InterruptedException 
  {
	  AppiumDriver driver = DriverUtil.initAndroidDriverSession();
	  /*
	   * Alert Interface
	   * driver.switchTo().alert()
	   * OK = accept() :: cancel = dismiss() :: getText = getText() :: for prompt = sendKeys()
	   */
	  driver.findElement(AppiumBy.accessibilityId("App")).click();
	  driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
	  driver.findElement(AppiumBy.id("io.appium.android.apis:id/two_buttons")).click();
	  Thread.sleep(1500);
	  Alert alt1;
	  alt1 = driver.switchTo().alert();
	  System.out.println("===== Captured text from the alert==== "+ alt1.getText());
	  alt1.accept();
  }
}

