Feature: Order Placement

  Scenario Outline: Complete an order from search to checkout
    Given I search for a product "MacBook"
    And I open the product details page for "MacBook"
    And I have add the product to the cart
    When I proceed to checkout 
    And I choose guest checkout
    And I enter billing details "John" "Doe" "john@example.com" "1234567890" "123 Street" "chennai" "600001" "India" "Goa"
    And I continue with the shipping method
    And I agree to the terms and conditions
    And I continue with the payment method
    And I confirm the order
    Then I should see a confirmation message for order placement
