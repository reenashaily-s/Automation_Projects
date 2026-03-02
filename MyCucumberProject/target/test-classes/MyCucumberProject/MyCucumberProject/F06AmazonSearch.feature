Feature: Search on Amazon

  Scenario: To validate valid search on Amazon
    When Enter product as "IPhone under 50000"
    And Click on Search button
    Then A valid product should display

  Scenario: To validate invalid search on Amazon
    When Enter invalid product as "Nothing to Search"
    And Click on the search button
    Then Products should not display