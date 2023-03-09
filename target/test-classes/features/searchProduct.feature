Feature: Validate search Product functionality

  Scenario: Search for product in both home and offer page validation
    Given User is on GreenCart Landing page
    When user search with short productName "Tom" and actual product is found on home page
    And user search with short productName "Tom" and actual product is found on Offer page
    Then Verify that productName from offer page is matching with the productName from offer page
