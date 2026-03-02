package com.MobileAppTest.Scenarios;

import java.io.IOException;
import org.testng.annotations.Test;
import com.MobileTest.Generic.DriverUtil;
import com.MobileTest.Generic.MobileUtil;
import io.appium.java_client.AppiumDriver;

public class TC07_Screenshot 
{
  @Test
  public void testScreenshot() throws IOException 
  {
	  AppiumDriver driver = DriverUtil.initAndroidDriverSession();
//	  TakesScreenshot ts = (TakesScreenshot)driver;
//	  File f= ts.getScreenshotAs(OutputType.FILE);
//	  File destination = new File(System.getProperty("user.dir")+"//Screenshots//demosApp"+System.currentTimeMillis()+".png");
//	  FileHandler.copy(f, destination);
	  
	  
	  MobileUtil.getScreenschot(driver, "homepage");
	  
  }
}

