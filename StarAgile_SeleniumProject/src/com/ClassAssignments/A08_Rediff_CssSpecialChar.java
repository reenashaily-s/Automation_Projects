/*
 * 8.	Launch https://register.rediff.com/register/register.php?FormName=user_details
		a.	Enter full Name
		b.	Enter Rediff Id
		c.	Enter Password
		d.	Enter Confirm Password
		e.	Enter Email ID
		f.	Enter Phone No
		Use CssSelector Special Characters
  
 */

package com.ClassAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A08_Rediff_CssSpecialChar 
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
				
		driver.findElement(By.cssSelector("input[name^=\"name\"]")).sendKeys("Reena Shaily");
		driver.findElement(By.cssSelector("input[type=\"text\"][id^=\"login\"]")).sendKeys("something");
		driver.findElement(By.cssSelector("input[type=\"password\"][id=\"newpasswd\"]")).sendKeys("123456");
		driver.findElement(By.cssSelector("input[type=\"password\"][id=\"newpasswd1\"]")).sendKeys("123456");
		driver.findElement(By.cssSelector("input[type=\"email\"]")).sendKeys("mailid@gmail.com");
		driver.findElement(By.cssSelector("input[id=\"mobno\"]")).sendKeys("8799797971");

	}

}
