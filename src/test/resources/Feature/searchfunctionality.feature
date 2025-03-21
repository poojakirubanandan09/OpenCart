Feature: Search and Sort Products

  Scenario Outline: Search for a product and sort results
    Given I am on the homepage
    When I search for "<product>" in the search bar
    And I sort the results by "<sort_option>"
    Then I should see the products sorted correctly by "<sort_option>"

  Examples:
    | product  | sort_option        |
    | Mac      | Name (A - Z)       |
    | Mac      | Name (Z - A)       |
    | Mac      | Price (Low > High) |
    | Mac      | Price (High > Low) |
				 
				
				