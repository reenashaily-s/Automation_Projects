/*
 * 2.	Launch https://www.echotrak.com/Login.aspx?ReturnUrl=%2f
		a.	Enter user name as your name
		b.	Enter password as yourname123
		c.	Click on Login button
		Use the locator Name  
 */

package com.ClassAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A02_echotrack_NameLocator 
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
		driver.findElement(By.name("txtCustomerID")).sendKeys("reenashaily");
		driver.findElement(By.name("txtPassword")).sendKeys("reena123");	
		driver.findElement(By.name("Butsub")).click();
	}
	

}
