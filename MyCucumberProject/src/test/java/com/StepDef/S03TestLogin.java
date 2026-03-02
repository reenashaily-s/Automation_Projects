package com.StepDef;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S03TestLogin 
{
	WebDriver driver;
	@Given("Launch Test Login Page")
	public void launch_test_login_page() 
	{
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	    
	    driver.get("https://practice.expandtesting.com/login");
	}

	@When("Enter valid user name")
	public void enter_valid_user_name() 
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("practice");
	}

	@When("Enter valid password")
	public void enter_valid_password() 
	{
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
	}

	@When("Click on Login button")
	public void click_on_login_button() 
	{
		driver.findElement(By.xpath("//button[@id='submit-login']")).submit();
	}

	@Then("Home page should display")
	public void home_page_should_display() 
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("secure"));
	}

	@When("Enter invalid user name and invalid password")
	public void enter_invalid_user_name_and_invalid_password() 
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("trapti");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("trapti");
	}

	@When("I Click on Loging button")
	public void i_click_on_loging_button() 
	{
		driver.findElement(By.xpath("//button[@id='submit-login']")).submit();
	}

	@Then("Should get error message")
	public void should_get_error_message() 
	{
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText().contains("invalid"));
	}

}
