Feature: User Registration 

  Scenario Outline: User Registration Process
    Given I am on the registration page
    When I enter user details "John" "Doe" "testuser@example.com" "1234567890" "Test@123"
    And I accept the privacy policy
    And I submit the registration form
    Then I should see a success message