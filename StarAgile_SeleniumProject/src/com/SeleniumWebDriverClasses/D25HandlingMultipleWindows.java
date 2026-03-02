package com.SeleniumWebDriverClasses;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D25HandlingMultipleWindows 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.naukri.com/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 400)", "");
		
		driver.findElement(By.xpath("//span[contains(text(), \"Remote\")]")).click();
		
		System.out.println("Title: " + driver.getTitle());
		
		Set<String>windows = driver.getWindowHandles();
		//Object windows contains ids / name of both the windows
		Iterator<String>itr = windows.iterator();
		//Iterator is an interface which is used to itereate / fetch the elements from Set<>
		String win1 = itr.next();	//Will give the first element / id of 1st window
		String win2 = itr.next();	//Will give the 2nd element / id of 2nd window
		
		driver.switchTo().window(win2);		//Will switch to new window (2nd window)
		Thread.sleep(5000);
		System.out.println("Title: " + driver.getTitle());
		
		driver.findElement(By.xpath("//label[@for='chk-Work from office-wfhType-']//i[@class='ni-icon-unchecked']")).click();
		Thread.sleep(5000);
		driver.switchTo().window(win1);		//Will switch to home window (1st window)
		
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(5000);
		
		driver.quit();
	}
}
