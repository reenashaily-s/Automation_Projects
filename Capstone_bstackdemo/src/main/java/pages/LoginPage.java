package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "signin") WebElement signInBtn;
    @FindBy(id = "username") WebElement usernameDropdown;
    @FindBy(id = "password") WebElement passwordDropdown;
    @FindBy(id = "login-btn") WebElement loginButton;
    @FindBy(className = "api-error") WebElement errorMessage; // To catch locked_user error

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String user, String pass) {
        WaitUtils.waitForElementClickable(driver, signInBtn, 10);
        signInBtn.click();

        // Only interact with dropdown if user is not empty
        if (user != null && !user.isEmpty()) {
            WaitUtils.waitForElementClickable(driver, usernameDropdown, 5);
            usernameDropdown.click();
            driver.findElement(By.xpath("//div[text()='" + user + "']")).click();
        }

        // Only interact with dropdown if pass is not empty
        if (pass != null && !pass.isEmpty()) {
            WaitUtils.waitForElementClickable(driver, passwordDropdown, 5);
            passwordDropdown.click();
            driver.findElement(By.xpath("//div[text()='" + pass + "']")).click();
        }

        WaitUtils.waitForElementClickable(driver, loginButton, 5);
        loginButton.click();
    }

    public String getErrorMessage() {
        WaitUtils.waitForElementVisible(driver, errorMessage, 5);
        return errorMessage.getText();
    }
}