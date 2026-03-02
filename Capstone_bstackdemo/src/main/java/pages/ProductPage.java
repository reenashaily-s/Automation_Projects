package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private void highlight(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid red;');", element);
    }

    public void addProductToCart(String name) throws InterruptedException {
        By buyBtnLoc = By.xpath("//p[@class='shelf-item__title' and text()='" + name + "']/following-sibling::div[@class='shelf-item__buy-btn']");
        WebElement buyBtn = wait.until(ExpectedConditions.presenceOfElementLocated(buyBtnLoc));        
        highlight(buyBtn); // VISUAL: Highlight the button red
        Thread.sleep(1000); // PAUSE: Let you see the highlight        
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buyBtn);
        System.out.println("Forced Add: " + name);
        Thread.sleep(1500); // PAUSE: Watch the sidebar slide open
    }

    public void closeCart() throws InterruptedException {
        By xBtnLoc = By.cssSelector(".float-cart__close-btn");
        WebElement xBtn = wait.until(ExpectedConditions.elementToBeClickable(xBtnLoc));
        
        highlight(xBtn); // VISUAL: Highlight the X
        Thread.sleep(800);        
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", xBtn);        
        // Wait for it to vanish visually
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xBtnLoc));
        Thread.sleep(1000); // PAUSE: Watch the sidebar slide away
    }

    public void openCart() throws InterruptedException {
        WebElement bag = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bag--float-cart-closed")));
        highlight(bag);
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bag);
        Thread.sleep(1500); // PAUSE: Watch the final cart open
    }
    
    public void removeFirstProduct() throws InterruptedException {
        // Target the first 'remove' button (X) inside the cart list
        By removeBtnLoc = By.cssSelector(".shelf-item__del");
        WebElement removeBtn = wait.until(ExpectedConditions.elementToBeClickable(removeBtnLoc));       
        highlight(removeBtn);
        System.out.println("Step: Removing one product from cart...");
        Thread.sleep(1000);        
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", removeBtn);
        Thread.sleep(1500); // Wait for the UI to update the count
    }
}