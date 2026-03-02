package com.MobileAppTest.Scenarios;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.MobileTest.Generic.DriverUtil;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TC11_NotificationsTest 
{
	@Test
	public void testNotofocation() 
	{
		//create driver session
		AppiumDriver driver = DriverUtil.initAndroidDriverSession();
		
		((AndroidDriver) driver).openNotifications();
		
		//totalNotofication
		List<WebElement> headers = driver.findElements(AppiumBy.id("android:id/title"));
		System.out.println("Total Notifications Count: "+headers.size());
		
		for(WebElement i:headers)
		{
			System.out.println(i.getText());
		}		
	}
}
