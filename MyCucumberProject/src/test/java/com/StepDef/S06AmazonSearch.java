package com.StepDef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S06AmazonSearch 
{
WebDriver driver;
	
	//@Before
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.amazon.in/");
	}
	//@After
	public void tearDown() 
	{
		driver.close();
	}
	
	@When("Enter product as {string}")
	public void enter_product_as(String prod) 
	{
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(prod);
	}

	@When("Click on Search button")
	public void click_on_search_button() 
	{
		driver.findElement(By.id("nav-search-submit-button")).click();
	}

	@Then("A valid product should display")
	public void a_valid_product_should_display() 
	{
	    System.out.println("Title: " + driver.getTitle());
	}

	@When("Enter invalid product as {string}")
	public void enter_invalid_product_as(String prod) 
	{
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(prod);
	}

	@When("Click on the search button")
	public void click_on_the_search_button() 
	{
		driver.findElement(By.id("nav-search-submit-button")).click();
	}

	@Then("Products should not display")
	public void products_should_not_display() 
	{
		System.out.println("Title: " + driver.getTitle());
	}
}
