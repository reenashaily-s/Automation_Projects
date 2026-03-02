/*
 * 20.	Open https://www.redbus.in/
		a.	Click on From 
		b.	Enter first 4 characters from your city (Kolhapur – kolh)
		c.	Click on the 1st option (City)
		d.	Click on To
		e.	Enter Bang (Bangalore)
		f.	Click on Bangalore from the list
		g.	Click on Calendar icon
		h.	Click on 31
		i.	Click on Search buses button
		j.	Display the 1st bus from list

  
 */

package com.ClassAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A20_RedBus 
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		
		// From
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[1]/div[1]/div/div/div[1]"));
		driver.findElement(By.id("srcDest")).sendKeys("Kolh");
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div/div/div")).click();
		
		// To
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[2]")).click();
		driver.findElement(By.id("srcDest")).sendKeys("Gurg");
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div/div/div")).click();
		
		// Calender
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[3]/div[3]/div[1]/div/i")).click();
		
		// Date
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[3]/div[3]/div[1]/div/div/div[2]")).click();
		
		// Search Buses
		
		// Display Result
		
		
	}

}
