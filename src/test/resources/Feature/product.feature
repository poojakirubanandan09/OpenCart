Feature: Product Details Page

  Scenario: Validate product details
    Given I navigate to a product page
    Then I should see the product title
    And I should see the product description
    And I should see the product price
    And I should see the product image
    And I should see product availability status

  Scenario: Add product to wishlist
  	Given I navigate to a product page
    When I add the product to the wishlist
    Then I should see a confirmation message for wishlist

  Scenario: Add product to cart
 	  Given I navigate to a product page
    When I add the product to the cart
    Then I should see a confirmation message for cart
