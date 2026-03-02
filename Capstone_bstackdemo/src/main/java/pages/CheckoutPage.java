package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage 
{
    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) 
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private void highlight(WebElement element, String color) 
    {
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].style.border='3px solid " + color + "';", element);
    }

    // Checkout
    public void proceedToCheckout() throws InterruptedException 
    {
        // Wait for SUBTOTAL text
        By subtotalLabelLoc = By.xpath("//div[@class='sub' and text()='SUBTOTAL']");
        WebElement subtotalLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(subtotalLabelLoc));
        highlight(subtotalLabel, "blue");
        By checkoutBtnLoc = By.className("buy-btn");
        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(checkoutBtnLoc));
        highlight(checkoutBtn, "green");        
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkoutBtn);
    }

    // Shipping
    public void enterShippingDetails(String first, String last, String address, String state, String zip) throws InterruptedException {
        WebElement fName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstNameInput")));
        fName.sendKeys(first);
        driver.findElement(By.id("lastNameInput")).sendKeys(last);
        driver.findElement(By.id("addressLine1Input")).sendKeys(address);
        driver.findElement(By.id("provinceInput")).sendKeys(state);
        driver.findElement(By.id("postCodeInput")).sendKeys(zip);        
        Thread.sleep(1000);
        driver.findElement(By.id("checkout-shipping-continue")).click();
        System.out.println("Step: Detailed entered, Clicked on Submit");
    }

    // 
    public String getEmptyCartMessage() 
    {
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shelf-empty")));
        highlight(msg, "orange");
        return msg.getText();
    }

    public boolean isCheckoutButtonPresent() 
    {
        return driver.findElements(By.className("buy-btn")).size() > 0;
    }

    public String getConfirmationMessage() 
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation-message"))).getText();
    }
}