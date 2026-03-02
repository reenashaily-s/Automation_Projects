package com.StepDef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S05BigbasketLinks 
{
	WebDriver driver;
	@Given("Launch Bigbasket site")
	public void launch_bigbasket_site() 
	{
		
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.get("https://www.amazon.in/");
	}

	@When("Click on Exotic Fruits Link")
	public void click_on_exotic_fruits_link() 
	{
		driver.findElement(By.partialLinkText("Sell")).click();
	}

	@Then("Exotic Fruits page should open")
	public void exotic_fruits_page_should_open() 
	{
		System.out.println("Title: " + driver.getTitle());
	}

	@When("Click on Tea link")
	public void click_on_tea_link() 
	{
		driver.findElement(By.partialLinkText("Pay")).click();
	}

	@Then("Tea page should open")
	public void tea_page_should_open() 
	{
		System.out.println("Title: " + driver.getTitle());
	}

	@When("Click on Ghee Link")
	public void click_on_ghee_link() 
	{
		driver.findElement(By.partialLinkText("Deals")).click();
	}

	@Then("Ghee page should open")
	public void ghee_page_should_open() 
	{
		System.out.println("Title: " + driver.getTitle());
	}

	@When("Click on Nadhini Link")
	public void click_on_nadhini_link() 
	{
		driver.findElement(By.partialLinkText("MX")).click();
	}

	@Then("Nandhini page should open")
	public void nandhini_page_should_open() 
	{
		System.out.println("Title: " + driver.getTitle());
	}
}
