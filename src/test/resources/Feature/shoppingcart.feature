Feature: Shopping Cart Functionality
  
  Scenario Outline: Add products to cart and remove one before checkout 
		  Given I am on the OpenCart page 
		  When I searches for "mac" in the search bar 
		  And I add "MacBook" to cart 
		  And I searches for "mac" in the search bar
		  And I add "MacBook Pro" to cart 
		  And I navigate to shopping cart 
		  Then I should see 2 products in the cart 
		  And I proceed to checkout page
		  Then I shoul see checkout page