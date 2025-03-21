Feature: Password Recovery

  Scenario Outline: Password Recovery Process
    Given I am on the password recovery page
    When I enter "testuser@example.com" for password recovery
    Then I should see a password reset success message