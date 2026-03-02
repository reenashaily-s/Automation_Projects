/*
 * 3.	Launch https://www.echotrak.com/Login.aspx?ReturnUrl=%2f
		a.	Enter user name as your name
		b.	Enter password as yourname123
		c.	Click on Login button
		Use the locator id  
 */

package com.ClassAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A03_echotrack_idLocator 
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
		driver.findElement(By.id("txtCustomerID")).sendKeys("reenashaily");
		driver.findElement(By.id("txtPassword")).sendKeys("reena123");	
		driver.findElement(By.id("Butsub")).click();
	}

}
