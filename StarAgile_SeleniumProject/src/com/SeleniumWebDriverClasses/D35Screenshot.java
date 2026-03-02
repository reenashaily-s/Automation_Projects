package com.SeleniumWebDriverClasses;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By; 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class D35Screenshot 
{
	public static void main(String[] args) throws IOException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/");
		
		Actions act = new Actions(driver);
		driver.findElement(By.linkText("Droppable")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/iframe")));
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		act.dragAndDrop(source, target).perform();
		
		// Screenshot
		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // ---> takes screenshot
		FileHandler.copy(screenShot, new File("Screenshots\\JQuerySS.jpeg"));		  // ---> creats a jpeg file
		System.out.println("Screenshot Captured !!!");
		driver.close();
		
		
	}
}
