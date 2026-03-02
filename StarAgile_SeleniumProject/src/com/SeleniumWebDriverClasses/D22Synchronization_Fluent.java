package com.SeleniumWebDriverClasses;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class D22Synchronization_Fluent 
{

    public static void main(String[] args) 
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.redbus.in/");
		
		FluentWait<WebDriver>wait = new FluentWait<WebDriver>(driver);
		
		//From
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[1]/div[1]/div/div/div[1]")).click();
		driver.findElement(By.id("srcDest")).sendKeys("Kolh");
		wait.withTimeout(Duration.ofSeconds(10))
			.ignoring(NoSuchElementException.class)
			.pollingEvery(Duration.ofMillis(1))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div/div/div"))).click();
				
		//To
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[2]")).click();
		driver.findElement(By.id("srcDest")).sendKeys("Gurg");
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div/div/div")).click();
				
		//Calender
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[3]/div[1]")).click();
		
		//Date
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[3]/div[3]/div[2]/div/ul/li[33]/div/div")).click();
		
		//Search Buses
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/button")).click();
		
		//Display Result
		System.out.println(driver.findElement(By.xpath("//*[@id=\"37844746\"]/div[1]/div[3]/div/div[1]/div[1]")).getText());
		
		driver.close();
    }
}
