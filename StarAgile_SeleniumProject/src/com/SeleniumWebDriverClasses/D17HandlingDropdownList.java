package com.SeleniumWebDriverClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class D17HandlingDropdownList 
{

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		WebElement DropList = driver.findElement(By.id("country"));
		
		// Select class
		Select countries = new Select(DropList);
		System.out.println("Selected County : " + countries.getFirstSelectedOption().getText());
		
		// All countries count
		List <WebElement> allCountries = countries.getOptions();
		System.out.println("Total num of countries in the DropList : " + allCountries.size());
		
//		// all countries list with index number
//		int i=0;
//		for(WebElement l:allCountries)
//		{
//			System.out.println(i+ ". " +l.getText());
//			i++;
//		}
//		
		countries.selectByVisibleText("Netherlands");
//		//countries.selectByContainsVisibleText("Neth");
//		//countries.selectByValue("150"); 
//		
//		countries.selectByIndex(147);
//		System.out.println("Selected Country: " + countries.getFirstSelectedOption().getText());
//		
				
		
		
		
		
	}

}
