# BlazeDemo Selenium Automation Framework

This project is a Page Object Model (POM) based Selenium automation framework developed for the BlazeDemo flight booking application. It covers functional, data-driven, and negative test scenarios.

## 🛠 Tech Stack
* **Language:** Java
* **Build Tool:** Maven
* **Testing Framework:** TestNG
* **Automation Tool:** Selenium WebDriver
* **Data Handling:** Apache POI (Excel)
* **Design Pattern:** Page Object Model (POM)

## 📋 Test Scenarios Covered
The suite executes 7 core scenarios to ensure application stability:
* **TC01:** Homepage load and title verification.
* **TC02:** Basic flight search functionality.
* **TC03:** End-to-End (E2E) flight booking flow.
* **TC04:** Data-Driven testing using `TestData.xlsx` for multiple user records.
* **TC05:** Negative Scenario: Validation of blank credit card submission.
* **TC06:** Negative Scenario: Validation of non-numeric credit card characters.
* **TC07:** Negative Scenario: Verification of city filtering (Departure vs. Destination).

## 📂 Project Structure
* `src/test/java/com/blazedemo/base`: Contains `BaseTest.java` for driver setup and clean console logging.
* `src/test/java/com/blazedemo/pages`: Contains Page Objects (`HomePage`, `ReservePage`, etc.).
* `src/test/java/com/blazedemo/tests`: Contains `FlightBookingTest.java` with the TestNG logic.
* `src/test/resources`: Contains `TestData.xlsx` and configuration files.

## 🚀 How to Run
1. **Prerequisites:** Ensure Maven and JDK 11+ are installed.
2. **Execute via TestNG:** Right-click `testng.xml` and select **Run As > TestNG Suite**.
3. **Execute via Maven:** Run `mvn test` in the terminal.

## 📊 Reporting
After execution, a clean console log is generated with scenario headers. For detailed HTML reports, navigate to:
`target/surefire-reports/index.html` or `test-output/emailable-report.html`.