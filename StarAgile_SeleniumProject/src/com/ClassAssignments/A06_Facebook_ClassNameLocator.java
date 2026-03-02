/*
 * 6.	Launch https://www.facebook.com/
		a.	Enter username as test@gmail.com
		b.	Enter password as test@123
		c.	Click on Login Button
		Use className locator
  
 */

package com.ClassAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A06_Facebook_ClassNameLocator 
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
				
		driver.findElements(By.className("inputtext")).get(0).sendKeys("test@gmail.com");
		driver.findElements(By.className("inputtext")).get(1).sendKeys("test@123");
        driver.findElement(By.className("_42ft")).click();
	}

}
