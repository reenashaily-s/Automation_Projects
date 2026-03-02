Feature: Search Functionality on Google

  Scenario: To validate search functionality on Google
    Given Open Google in Chrome
    When Enter keyword for searching
    And Hit Enter
    Then A valid search result should display
