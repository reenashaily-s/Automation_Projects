package com.SeleniumWebDriverClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class D31HandlingRight_DoubleClick 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
		Actions act = new Actions(driver);
		
		//contextClick() ---> Right click on the control
		WebElement rightClick = driver.findElement(By.xpath("//*[@id=\"authentication\"]/span"));
		act.contextClick(rightClick).perform();		
		
		List<WebElement>menus = driver.findElements(By.xpath("//*[@id=\"authentication\"]/ul/li/span"));
		for(WebElement m : menus)
			System.out.println(m.getText());		
		driver.findElement(By.id("authentication")).click();
				
		//doubleClick() ---> double click on the control		
		WebElement dblClick = driver.findElement(By.xpath("//*[@id=\"authentication\"]/button"));
		act.moveToElement(dblClick).doubleClick().perform();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		//driver.close();	
	}
}
