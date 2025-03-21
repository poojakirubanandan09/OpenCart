Feature: Search Functionality

  Scenario Outline: Search for a product
    Given I am on the OpenCart homepage
    When I search for a product from Excel row <row>
    Then I should see search results displayed
  Examples:
    | row |
    | 1   |
    | 2   |
    | 3   |
    | 4   |
  

