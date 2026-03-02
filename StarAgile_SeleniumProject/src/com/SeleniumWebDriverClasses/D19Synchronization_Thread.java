package com.SeleniumWebDriverClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D19Synchronization_Thread 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.redbus.in/");

		//From
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[1]/div[1]/div/div/div[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("srcDest")).sendKeys("Kolh");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div/div/div")).click();
		
		//To
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[2]")).click();
		driver.findElement(By.id("srcDest")).sendKeys("Gurg");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div/div/div")).click();
		
		//Calender
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[3]/div[1]")).click();
		
		//Date
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[3]/div[3]/div[2]/div/ul/li[33]/div/div")).click();
		
		//Search Buses
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/button")).click();
		
		//Display Result
		System.out.println(driver.findElement(By.xpath("//*[@id=\"37844746\"]/div[1]/div[3]/div/div[1]/div[1]")).getText());
		
		driver.close();
	}

}