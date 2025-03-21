Feature: User Login

  Scenario Outline: User Login Process
    Given I am on the login page
    When I enter login credentials "testuser@example.com" "Test@123"
    And I click the login button
    Then I should be logged in successfully