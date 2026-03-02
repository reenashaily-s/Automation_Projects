/*
 * 15.	Open https://echoecho.com/htmlforms09.htm
		a.	Display the status of all 3 checkboxes (Milk, butter and Cheese)
		b.	Only select those checkboxes those are not selected
		c.	Display the status.
  
 */

package com.ClassAssignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A15_echoecho_checkbox 
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://echoecho.com/htmlforms09.htm");
		
		List<WebElement>products = driver.findElements(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td/input"));

		for (WebElement p : products) 
		{
			System.out.println("Before...");
			System.out.println(p.getAttribute("value") + ": Selected: " + p.isSelected());
			System.out.println(p.getAttribute("value") + ": Enabled : " + p.isEnabled());
			System.out.println(p.getAttribute("value") + ": Visible : " + p.isDisplayed());

			//if (p.isSelected() == false)
				//p.click();
			if(!p.isSelected())
				p.click();

			System.out.println("\nAfter...");
			System.out.println(p.getAttribute("value") + ": Selected: " + p.isSelected());
			System.out.println(p.getAttribute("value") + ": Enabled : " + p.isEnabled());
			System.out.println(p.getAttribute("value") + ": Visible : " + p.isDisplayed());
		
		}
	}

}
