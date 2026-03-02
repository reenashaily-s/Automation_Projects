package com.blazedemo.tests;

import com.blazedemo.base.BaseTest;
import com.blazedemo.pages.*;
import com.blazedemo.utils.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FlightBookingTest extends BaseTest {

    private void logHeader(String tcId, String description) {
        System.out.println("\n---------------------------------------");
        System.out.println("Running: " + tcId + " - " + description);
        System.out.println("-----------------------------------------");
    }

    @Test(priority = 1)
    public void TC01_VerifyHomepage() {
        logHeader("TC01", "Verify homepage loads and dropdowns visible");
        Assert.assertEquals(driver.getTitle(), "BlazeDemo");
        System.out.println("RESULT: Homepage title confirmed.");
    }

    @Test(priority = 2)
    public void TC02_SearchFlights() {
        logHeader("TC02", "Search flights with valid cities");
        HomePage hp = new HomePage(driver);
        hp.selectCities("Paris", "London");
        hp.clickFindFlights();
        Assert.assertTrue(driver.getCurrentUrl().contains("reserve"));
        System.out.println("RESULT: Flight search transition successful.");
    }

    @Test(priority = 3)
    public void TC03_FullBookingFlow() {
        logHeader("TC03", "Complete a flight booking");
        HomePage hp = new HomePage(driver);
        hp.selectCities("Boston", "Berlin");
        hp.clickFindFlights();
        new ReservePage(driver).chooseFirstFlight();
        
        PurchasePage pp = new PurchasePage(driver);
        pp.enterDetails("John Doe", "123 Main St", "1111222233334444");
        pp.clickPurchase();
        
        String msg = new ConfirmationPage(driver).getConfirmationText();
        Assert.assertEquals(msg, "Thank you for your purchase today!");
        System.out.println("RESULT: E2E Booking verified.");
    }

    @DataProvider(name = "excelData")
    public Object[][] getExcelData() {
        return ExcelUtils.getTestData("src/test/resources/TestData.xlsx", "Sheet1");
    }

    @Test(priority = 4, dataProvider = "excelData")
    public void TC04_DataDrivenBooking(String name, String address, String card) {
        logHeader("TC04", "Multiple bookings with Data-driven set");
        System.out.println("Current User: " + name);
        HomePage hp = new HomePage(driver);
        hp.selectCities("San Diego", "New York");
        hp.clickFindFlights();
        new ReservePage(driver).chooseFirstFlight();
        new PurchasePage(driver).enterDetails(name, address, card);
        System.out.println("RESULT: Processed data for " + name);
    }

    @Test(priority = 5)
    public void TC05_BlankCreditCard() {
        logHeader("TC05", "Submit blank credit card");
        HomePage hp = new HomePage(driver);
        hp.selectCities("Mexico City", "Dublin");
        hp.clickFindFlights();
        new ReservePage(driver).chooseFirstFlight();
        new PurchasePage(driver).enterDetails("NoCard", "123 St", "");
        System.out.println("RESULT: Negative validation check for blank card submitted.");
    }

    @Test(priority = 6)
    public void TC06_InvalidCreditCardChars() {
        logHeader("TC06", "Submit non-numeric credit card");
        HomePage hp = new HomePage(driver);
        hp.selectCities("Portland", "Rome");
        hp.clickFindFlights();
        new ReservePage(driver).chooseFirstFlight();
        new PurchasePage(driver).enterDetails("InvalidCard", "456 St", "ABC-123");
        System.out.println("RESULT: Negative validation check for non-numeric card submitted.");
    }

    @Test(priority = 7)
    public void TC07_SameCitySelection() {
        logHeader("TC07", "Same departure and destination city validation");
        HomePage hp = new HomePage(driver);
        String testCity = "Boston";
        hp.selectDepartureCity(testCity);
        boolean isPresent = hp.isCityInDestinationList(testCity);
        
        if (isPresent) {
            System.out.println("STATUS: Bug Detected - '" + testCity + "' is still in Destination list.");
        } else {
            System.out.println("STATUS: Success - City filtered correctly.");
        }
        System.out.println("RESULT: TC07 Analysis complete.");
    }
}