/*
 * 10.	Launch https://register.rediff.com/register/register.php?FormName=user_details
		a.	Enter full Name
		b.	Enter Rediff Id
		c.	Enter Password
		d.	Enter Confirm Password
		e.	Enter Email ID
		f.	Enter Phone No
		Use xpath  
 */

package com.ClassAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Validate_RegistrationForm 
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
				
		driver.findElement(By.xpath("//form[@method=\"post\"]/div/div[2]/input")).sendKeys("Reena Shaily");
		driver.findElement(By.xpath("//div[@class=\"emailCnt\"]/input")).sendKeys("something");
		driver.findElement(By.xpath("//div[@class=\"password-container\"]/input[@placeholder=\"Enter password\"]")).sendKeys("2131");
		driver.findElement(By.xpath("//div[@class=\"password-container\"]/input[@placeholder=\"Retype password\"]")).sendKeys("2131");
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("mailid@gmail.com");
		driver.findElement(By.xpath("//input[@id=\"mobno\"]")).sendKeys("8799797971");

	}

}
