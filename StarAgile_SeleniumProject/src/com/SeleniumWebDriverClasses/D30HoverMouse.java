package com.SeleniumWebDriverClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class D30HoverMouse 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://istqb.in/");
		
		Actions act = new Actions(driver);
		WebElement spLink = driver.findElement(By.linkText("SPECIALIST"));
		act.moveToElement(spLink).perform();
		
		//.perform() will perform the said action.
		List<WebElement> subMenus = driver.findElements(By.xpath("//*[@id=\"sp-menu\"]/div/nav/ul/li[6]/div/div/ul/li/a"));
		Thread.sleep(2000);
		
		for(WebElement sm : subMenus)
			System.out.println(sm.getText());
		
		driver.close();
	}	
}
