package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public String getBagCount(String expectedValue) {
        By bagQty = By.cssSelector(".bag__quantity");
        // Polls the UI until the number changes to what we want
        wait.until(ExpectedConditions.textToBePresentInElementLocated(bagQty, expectedValue));
        return driver.findElement(bagQty).getText();
    }
}