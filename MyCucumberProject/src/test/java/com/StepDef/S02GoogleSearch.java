package com.StepDef;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S02GoogleSearch 
{
	WebDriver driver;
	@Given("Open Google in Chrome")
	public void open_google_in_chrome() 
	{
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	    
	    driver.get("https://www.google.com");
	}
 
	@When("Enter keyword for searching")
	public void enter_keyword_for_searching() 
	{
		driver.findElement(By.name("q")).sendKeys("Cucumber Feature");	
	}

	@When("Hit Enter")
	public void hit_enter() 
	{
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("A valid search result should display")
	public void a_valid_search_result_should_display() 
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("Cucumber"));
	}

}
