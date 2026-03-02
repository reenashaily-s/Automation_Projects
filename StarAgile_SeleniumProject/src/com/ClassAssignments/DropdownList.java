package com.ClassAssignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownList 
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
		
		//By default selected :India, Now selecting Netherlands from the DropDown List	
		countries.selectByVisibleText("Netherlands");			
	}

}
