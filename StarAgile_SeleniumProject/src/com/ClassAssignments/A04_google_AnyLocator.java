/*
 * 4.	Launch https://www.google.com/
		a.	Enter Pattankodoli Yatra
		b.	Hit Enter
		Use any locator id/name/className
 */

package com.ClassAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A04_google_AnyLocator 
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Pattankodoli Yatra" + Keys.ENTER);		
	}

}
