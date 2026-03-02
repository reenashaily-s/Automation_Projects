package com.blazedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
    WebDriver driver;

    By successHeader = By.tagName("h1");

    public ConfirmationPage(WebDriver driver) { 
        this.driver = driver; 
    }

    public String getConfirmationText() {
        String text = driver.findElement(successHeader).getText();
        System.out.println("Booking Confirmation Text: " + text);
        return text;
    }
}