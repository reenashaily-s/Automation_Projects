Feature: Registration on DemoQA

  Background: 
    Given Launch DemoQA site

  Scenario: Validate registration process on DemoQA site with valid data
    When I Enter valid first name as "Reena"
    When I Enter valid last name as "Shaily"
    When I Enter valid email id as "s@gmail.com"
    Then Registration should successful

  Scenario: Validate registration process on DemoQA site with invalid data
    When I Enter invalid first name as "Tanu"
    When I Enter invalid last name as "ja"
    When I Enter invalid email id as "tan@gmail.com"
    Then Registration should not successful