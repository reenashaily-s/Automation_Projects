package com.SeleniumWebDriverClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D20Synchronization_Implicit 
{

    public static void main(String[] args) 
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.redbus.in/");

        // ======== FROM ==========
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[1]/div[1]/div/div/div[1]")).click();
        // 🔧 old line: driver.findElement(By.id("srcDest")).sendKeys("Kolh");
        driver.findElement(By.id("srcDest")).sendKeys("Kolh");
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div/div/div")).click();

        // ======== TO ==========
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[2]")).click();
        // 🔧 old line: driver.findElement(By.id("srcDest")).sendKeys("Gurg");
        driver.findElement(By.id("srcDest")).sendKeys("Gurg");
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div/div/div")).click();

        // ======== CALENDAR ==========
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[3]/div[1]")).click();

        // ======== DATE ==========
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/div/div[1]/div[3]/div[3]/div[2]/div/ul/li[33]/div/div")).click();

        // ======== SEARCH BUSES ==========
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/search/div/div/button")).click();

        // ======== DISPLAY RESULT ==========

        System.out.println(driver.findElement(By.xpath("//*[@id=\"37844746\"]/div[1]/div[3]/div/div[1]/div[1]")).getText());

        driver.close();
    }
}


