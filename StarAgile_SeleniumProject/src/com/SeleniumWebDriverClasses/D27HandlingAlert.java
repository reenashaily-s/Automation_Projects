package com.SeleniumWebDriverClasses;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D27HandlingAlert 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demoqa.com/alerts");
		
		Alert alt;		//Reference of Alert interface
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)", "");
		
		driver.findElement(By.id("alertButton")).click();
		alt = driver.switchTo().alert();	//Now alt holding the alert
		System.out.println(alt.getText());
		Thread.sleep(2000);
		alt.accept();						//Will click on Ok button
		
		driver.findElement(By.id("timerAlertButton")).click();
		Thread.sleep(5000);
		alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
		
		WebElement but3 = driver.findElement(By.id("confirmButton"));
		js.executeScript("arguments[0].click()", but3);
		alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.dismiss();					//Click on cancel button
		System.out.println(driver.findElement(By.id("confirmResult")).getText());
		
		//driver.findElement(By.id("promtButton")).click();
		js.executeScript("arguments[0].click()", driver.findElement(By.id("promtButton")));
		alt = driver.switchTo().alert();
		alt.sendKeys("Dipika");
		alt.accept();
		System.out.println(driver.findElement(By.id("promptResult")).getText());
	}
	
}
