package com.StepDef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S04DemoQARegistraion 
{
	WebDriver driver;
	@Given("Launch DemoQA site")
	public void launch_demo_qa_site() 
	{
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	    
	    driver.get("https://demoqa.com/automation-practice-form");
	}

	@When("I Enter valid first name as {string}")
	public void i_enter_valid_first_name_as(String fn) 
	{
		 driver.findElement(By.id("firstName")).sendKeys(fn);
	}

	@When("I Enter valid last name as {string}")
	public void i_enter_valid_last_name_as(String ln) 
	{
		driver.findElement(By.id("lastName")).sendKeys(ln);
	}

	@When("I Enter valid email id as {string}")
	public void i_enter_valid_email_id_as(String em) 
	{
		driver.findElement(By.id("userEmail")).sendKeys(em);
	}

	@Then("Registration should successful")
	public void registration_should_successful() 
	{
		System.out.println("Registration Successful\nThank you!!!");
	}

	@When("I Enter invalid first name as {string}")
	public void i_enter_invalid_first_name_as(String fn) 
	{
		driver.findElement(By.id("firstName")).sendKeys(fn);
	}

	@When("I Enter invalid last name as {string}")
	public void i_enter_invalid_last_name_as(String ln) 
	{
		driver.findElement(By.id("lastName")).sendKeys(ln);
	}

	@When("I Enter invalid email id as {string}")
	public void i_enter_invalid_email_id_as(String em) 
	{
		driver.findElement(By.id("userEmail")).sendKeys(em);
	}

	@Then("Registration should not successful")
	public void registration_should_not_successful() 
	{
		System.out.println("Registration fail\nPlease try again!!!");
	}
}
