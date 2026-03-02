package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest 
{

    @Test(priority = 1, groups = {"login_func"})
    public void TC_001_validLogin() 
    {
        System.out.println("Starting TC_001: Valid Login Test");
        LoginPage lp = new LoginPage(driver);        
        lp.login("demouser", "testingisfun99");        
        Assert.assertTrue(driver.getCurrentUrl().contains("bstackdemo.com"), "Login failed!");
        System.out.println("Success: TC_001 Passed. Logged in successfully.");
    }

    @Test(priority = 2, groups = {"login_func"})
    public void TC_002_lockedUserLogin() 
    {
        System.out.println("Starting TC_002: Locked User Login Test");
        LoginPage lp = new LoginPage(driver);
        lp.login("locked_user", "testingisfun99");
        System.out.println("Step: Submitted credentials for locked_user");       
        String error = lp.getErrorMessage();
        System.out.println("Step: Error message captured: " + error);        
        Assert.assertEquals(error, "Your account has been locked.", "Error mismatch for locked user!");
        System.out.println("Success: TC_002 Passed. error message displayed.");
    }

    @Test(priority = 3, groups = {"login_func"})
    public void TC_003_emptyLogin() 
    {
        System.out.println("Starting TC_003: Empty Login Test");
        LoginPage lp = new LoginPage(driver);
        lp.login("", "");        
        String error = lp.getErrorMessage();
        System.out.println("Step: Error message captured: " + error);
        Assert.assertFalse(error.isEmpty(), "No error message displayed for empty login!");
        System.out.println("Success: TC_003 Passed. Empty login blocked.");
    }
}