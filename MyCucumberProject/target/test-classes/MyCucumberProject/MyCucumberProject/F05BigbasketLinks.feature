@AmazonLinks
Feature: BigBasket Links

  Background: 
    Given Launch Bigbasket site

	@SellLink
  Scenario: To validate Exotic Link
    When Click on Exotic Fruits Link
    Then Exotic Fruits page should open

	@AmazonPayLink
  Scenario: To validate Tea Link
    When Click on Tea link
    Then Tea page should open

	@TodaysDealLink
  Scenario: To validate Ghee Link
    When Click on Ghee Link
    Then Ghee page should open

	@MXPlayerLink
  Scenario: To validate Nandhini Link
    When Click on Nadhini Link
    Then Nandhini page should open