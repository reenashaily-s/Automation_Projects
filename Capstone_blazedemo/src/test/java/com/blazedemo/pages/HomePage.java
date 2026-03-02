package com.blazedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class HomePage 
{
    WebDriver driver;
    private By departureDropdown = By.name("fromPort");
    private By destinationDropdown = By.name("toPort");
    private By findFlightsBtn = By.cssSelector("input[type='submit']");

    public HomePage(WebDriver driver) 
    {
        this.driver = driver;
    }

    public void selectCities(String departure, String destination)
    {
        new Select(driver.findElement(departureDropdown)).selectByVisibleText(departure);
        new Select(driver.findElement(destinationDropdown)).selectByVisibleText(destination);
    }

    public void selectDepartureCity(String city) 
    {
        System.out.println("HOMEPAGE: Selecting Departure: " + city);
        new Select(driver.findElement(departureDropdown)).selectByVisibleText(city);
    }

    public boolean isCityInDestinationList(String cityName) 
    {
        Select destSelect = new Select(driver.findElement(destinationDropdown));
        List<WebElement> options = destSelect.getOptions();
        for (WebElement option : options) 
        {
            if (option.getText().equals(cityName)) 
            {
                return true; 
            }
        }
        return false;
    }

    public void clickFindFlights() 
    {
        driver.findElement(findFlightsBtn).click();
    }
}