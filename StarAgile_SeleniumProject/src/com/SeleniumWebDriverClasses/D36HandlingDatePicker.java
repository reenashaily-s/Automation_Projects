package com.SeleniumWebDriverClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D36HandlingDatePicker 
{

    public static void main(String[] args) 
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.redbus.in/");

        // From
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[1]/div[1]/div/div/div[1]")).click();
        // 🔧 old line: driver.findElement(By.id("srcDest")).sendKeys("Kolh");
        driver.findElement(By.id("srcDest")).sendKeys("Kolh");
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div/div/div")).click();

        // To
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[2]")).click();
        // 🔧 old line: driver.findElement(By.id("srcDest")).sendKeys("Gurg");
        driver.findElement(By.id("srcDest")).sendKeys("Kara");
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div/div/div")).click();

        // Calender Icon
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[3]/div[1]")).click();       
        
        // selecting month
        WebElement month = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[3]/div[3]/div[2]/div/div/div/p[1]"));
        
        // clicking on arrow
        WebElement arrow = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[3]/div[3]/div[2]/div/div/i[2]"));
        arrow.click();
        
        // date of journey
        String  doj_month = "Jun", doj_date = "9";
        
        // selecting doj in calender
        while(!month.getText().contains(doj_month))
			arrow.click();
		driver.findElement(By.xpath("//span[contains(text(), \"" + doj_date + "\")]")).click();
        
    } 
}

