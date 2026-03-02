/*
 *11.	Launch https://www.facebook.com/
		a.	Enter username as test@gmail.com
		b.	Enter password as test@123
		c.	Click on Login Button
		d.	Display the error message.
		Use XPath locator

  
 */

package com.ClassAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A11_Facebook_XpathLocator 
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
				
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("test@123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		
		String errorMessage = driver.findElement(By.xpath("//div[@class=\"_9ay7\"]")).getText();
		System.out.println("Display login error : "+ errorMessage);
		
		
	}

}
