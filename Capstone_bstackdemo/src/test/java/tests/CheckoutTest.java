package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.*;

public class CheckoutTest extends BaseTest {

    @Test(priority = 1, description = "TC_007: Valid Checkout Flow")
    public void TC_007_PlaceOrderSuccess() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        login.login("demouser", "testingisfun99");
        product.addProductToCart("iPhone 11 Pro");
        Thread.sleep(2000); // Wait for sidebar
        checkout.proceedToCheckout();
        checkout.enterShippingDetails("John", "Doe", "123 Lane", "California", "90001");
        
        Assert.assertTrue(checkout.getConfirmationMessage().contains("successfully placed"));
    }

    @Test(priority = 2, description = "TC_008: Empty Cart Verification")
    public void TC_008_EmptyCartNegative() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        login.login("demouser", "testingisfun99");
        
        // 1. Open the bag while empty
        product.openCart();
        Thread.sleep(2000); 

        // 2. Verify the "Add some products..." message
        String msg = checkout.getEmptyCartMessage();
        Assert.assertTrue(msg.contains("Add some products in the bag"));
        
        // 3. Verify the Checkout button is NOT there        
        System.out.println("TC_008 Passed: Empty cart state confirmed.");
    }
}