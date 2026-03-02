package com.StepDef;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

public class S01GoogleTitle 
{
	WebDriver driver;
	String title;
	
	@Given("Open Google")
	public void open_google() 
	{
	    System.out.println("Launching google");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	    
	    driver.get("https://www.google.com");
	}

	@When("Read the title of Google")
	public void read_the_title_of_google() 
	{
		title = driver.getTitle();
	}

	@Then("Title should be Google")
	public void title_should_be_google() 
	{
		System.out.println("Validating the title");
		System.out.println("Title: " + title);
		
		Assert.assertTrue(title.contains("Google"));
	}

}
