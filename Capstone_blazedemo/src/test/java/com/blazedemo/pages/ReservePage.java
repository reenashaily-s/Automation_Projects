package com.blazedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReservePage {
    WebDriver driver;

    // Locator for the first "Choose This Flight" button
    By chooseFlightBtn = By.cssSelector("table tbody tr:nth-child(1) input[type='submit']");

    public ReservePage(WebDriver driver) { 
        this.driver = driver; 
    }

    public void chooseFirstFlight() {
        System.out.println("TC: Selecting the first available flight...");
        driver.findElement(chooseFlightBtn).click();
    }
}