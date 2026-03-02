/*
 * 9.	Launch https://www.echotrak.com/Login.aspx?ReturnUrl=%2f
		a.	Enter user name as your name
		b.	Enter password as yourname123
		c.	Click on Login button
		Use the xpath Locator
  
 */

package com.ClassAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A09_echotrack_Xpath 
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
				
		driver.findElement(By.xpath("//input[@name=\"txtCustomerID\"]")).sendKeys("something@gmail.com");
		driver.findElement(By.xpath("//input[@name=\"txtPassword\"]")).sendKeys("reena123");
		driver.findElement(By.xpath("//input[@id=\"Butsub\"]")).click();
	}

}
