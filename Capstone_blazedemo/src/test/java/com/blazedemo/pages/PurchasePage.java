package com.blazedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchasePage {
    WebDriver driver;

    By nameField = By.id("inputName");
    By addressField = By.id("address"); 
    By creditCardField = By.id("creditCardNumber");
    By purchaseBtn = By.cssSelector("input[value='Purchase Flight']");

    public PurchasePage(WebDriver driver) { 
        this.driver = driver; 
    }

    public void enterDetails(String name, String address, String cardNum) {
        System.out.println("Entering details for: " + name);
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(creditCardField).sendKeys(cardNum);
    }

    public void clickPurchase() {
        System.out.println("Clicking Purchase Flight...");
        driver.findElement(purchaseBtn).click();
    }
}