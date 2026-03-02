package com.SeleniumWebDriverClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class D21Synchronization_Explicit 
{

    public static void main(String[] args) 
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://omayo.blogspot.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		WebElement chkBox = driver.findElement(By.id("dte"));
		System.out.println("Before");
		System.out.println("Enabled: " + chkBox.isEnabled());
		System.out.println("Selected: " + chkBox.isSelected());
		
		driver.findElement(By.xpath("//*[@id=\"HTML47\"]/div[1]/button")).click();
		
		//wait.until(ExpectedConditions.elementToBeClickable(chkBox));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("dte")));
		//Will wait till the checkbox is getting enabled. Will wait for maximum 15 seconds
		chkBox.click();
		
		System.out.println("After");
		System.out.println("Enabled: " + chkBox.isEnabled());
		System.out.println("Selected: " + chkBox.isSelected());
    }
}
