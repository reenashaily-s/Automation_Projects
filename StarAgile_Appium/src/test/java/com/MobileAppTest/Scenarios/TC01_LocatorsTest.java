package com.MobileAppTest.Scenarios;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.MobileTest.Generic.DriverUtil;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class TC01_LocatorsTest 
{
  @Test
  public void testMobileLocators() 
  {
	 //create driver session
	 AppiumDriver driver = DriverUtil.initAndroidDriverSession();
	 
	 //Locator1: accessibilityId Locator
	 WebElement e1 = driver.findElement(AppiumBy.accessibilityId("Access'ibility"));
	 System.out.println("Element1 Text is: "+e1.getText());
	 e1.click();
	 
	 //navigate to back
	 driver.navigate().back();
	 
	 //Locator2: xpath
	 driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Animation\"]")).click();
	 driver.navigate().back();
		 
	 //Locator3: androidUIAutomator
	 driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"App\")")).click();	 
	 driver.navigate().back();
	 
	 //Locator4: className
	 driver.findElements(AppiumBy.className("android.widget.TextView")).get(5).click();
	 driver.navigate().back();
	 
	 //Locator5: resource-id
	 driver.findElements(AppiumBy.id("android:id/text1")).get(11).click();
	 
  }
}
