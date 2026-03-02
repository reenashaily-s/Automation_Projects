package com.MobileAppTest.Scenarios;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.MobileTest.Generic.DriverUtil;
import com.MobileTest.Generic.MobileUtil;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.KeyEventMetaModifier;

public class TC10_KeyboardAutomation 
{
	@Test
	public void testSession() throws MalformedURLException, URISyntaxException
	{
		//create driver session
		AppiumDriver driver = DriverUtil.initAndroidDriverSession();
		
		//view
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//pagearea
		WebElement area = driver.findElement(AppiumBy.id("android:id/list"));
		
		//scroll down to textField
		MobileUtil.scrollUptoCount(driver, area, 3, "down");
		
		//textField
		driver.findElement(AppiumBy.accessibilityId("TextFields")).click();
		//driver.findElement(AppiumBy.id("io.appium.android.apis:id/edit")).sendKeys("Hello All");
		
		//presskeyMethod
		((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.H).withMetaModifier(KeyEventMetaModifier.SHIFT_ON));
		((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.E));
		((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.L));
		((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.L));
		((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.O));
	}
}
