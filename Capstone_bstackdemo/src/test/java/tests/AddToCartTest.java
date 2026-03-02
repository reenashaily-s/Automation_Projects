package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.*;

public class AddToCartTest extends BaseTest 
{

    @Test(priority = 1, groups = {"cart_func"}, description = "TC_004: Add single item to cart")
    public void TC_004_AddSingleItem() throws InterruptedException 
    {
        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);

        login.login("demouser", "testingisfun99");

        // Add 1 item
        product.addProductToCart("iPhone 11 Pro");
        
        // Verify count is 1
        String count = cart.getBagCount("1");
        Assert.assertEquals(count, "1", "TC_004 Failed: Count should be 1");
        System.out.println("TC_004 Passed: Single item added successfully.");
    }

    @Test(priority = 2, groups = {"cart_func"}, description = "TC_005: Add multiple items to cart and verify cart count")
    public void TC_005_AddMultipleItems() throws InterruptedException 
    {
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        new LoginPage(driver).login("demouser", "testingisfun99");        
        product.addProductToCart("iPhone 11");
        product.closeCart();
        product.addProductToCart("iPhone 12 Pro");
        String count = cart.getBagCount("2");
        Assert.assertEquals(count, "2", "TC_005 Failed: Count should be 2");
        System.out.println("TC_005 Passed: Multiple items added and verified.");
    }

    @Test(priority = 3, groups = {"cart_func"}, description = "TC_006: Remove item from cart")
    public void TC_006_RemoveItem() throws InterruptedException 
    {
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        new LoginPage(driver).login("demouser", "testingisfun99");
        product.addProductToCart("iPhone 11 Pro");
        product.closeCart();
        product.addProductToCart("iPhone 11");
        Assert.assertEquals(cart.getBagCount("2"), "2");
        product.removeFirstProduct();
        String finalCount = cart.getBagCount("1");
        Assert.assertEquals(finalCount, "1", "TC_006 Failed: Count did not decrease!");        
        System.out.println("TC_006 Passed: Successfully declared one product removed from cart.");
    }
}