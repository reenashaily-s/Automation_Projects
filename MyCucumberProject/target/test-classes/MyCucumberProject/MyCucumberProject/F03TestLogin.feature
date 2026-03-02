Feature: Test Login

  Background: 
    Given Launch Test Login Page

  Scenario: To validate login functionality on Test Login Page with valid data
    When Enter valid user name
    When Enter valid password
    And Click on Login button
    Then Home page should display

  Scenario: To validate login functionality on Test Login Page with invalid data
    When Enter invalid user name and invalid password
    And I Click on Loging button
    Then Should get error message