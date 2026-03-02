/*
 * 5.	Launch https://www.echotrak.com/Login.aspx?ReturnUrl=%2f
		a.	Enter user name as your name
		b.	Enter password as yourname123
		c.	Click on Login button
		Use the className locator  
 */

package com.ClassAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A05_echotrack_ClassNameLocator 
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
				
		driver.findElements(By.className("form-control")).get(0).sendKeys("reenashaily");
		driver.findElements(By.className("form-control")).get(1).sendKeys("reena123");
		driver.findElement(By.className("btn-primary")).click();
	}

}
