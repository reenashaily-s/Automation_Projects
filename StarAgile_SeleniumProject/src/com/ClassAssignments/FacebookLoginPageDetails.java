/*
 * 6.	Launch https://www.facebook.com/
		a.	Enter username as test@gmail.com
		b.	Enter password as test@123
		c.	Click on Login Button
		Use className locator
  
 */

package com.ClassAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookLoginPageDetails
{
    public void enterEmail(WebDriver driver, String email) 
    {
        driver.findElements(By.className("inputtext")).get(0).sendKeys(email);
    }

    public void enterPassword(WebDriver driver, String password) 
    {
        driver.findElements(By.className("inputtext")).get(1).sendKeys(password);
    }

    public void clickLogin(WebDriver driver) 
    {
        driver.findElement(By.className("_42ft")).click();
    }

    public void login(WebDriver driver, String email, String password) 
    {
        enterEmail(driver, email);
        enterPassword(driver, password);
        clickLogin(driver);
    }
}
