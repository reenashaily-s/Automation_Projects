package com.ClassAssignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLoginTest 
{
    public static void main(String[] args) 
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        FacebookLoginPageDetails loginPage = new FacebookLoginPageDetails();
        loginPage.login(driver, "test@gmail.com", "test@123");
    }
}
