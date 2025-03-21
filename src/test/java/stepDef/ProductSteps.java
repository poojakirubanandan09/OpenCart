package stepDef;

import pom.ProductPage;
import pom.SearchPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {
	
	WebDriver driver ;
    ProductPage productPage;
    SearchPage searchPage ;

    @Given("I navigate to a product page")
    public void i_navigate_to_a_product_page() {
        
   
    	driver = new ChromeDriver();
    	productPage = new ProductPage(driver);
        searchPage = new SearchPage(driver);
            
      	driver.get("https://demo.opencart.com.gr/");
        searchPage.enterSearchQuery("MacBook");
        searchPage.clickSearchButton();
        productPage.openProductPage("MacBook");
    	
    }
    
    @Then("I should see the product title")
    public void i_should_see_the_product_title() {
        Assert.assertFalse(productPage.getProductTitle().isEmpty(), "Product title is missing!");
    }

    @Then("I should see the product description")
    public void i_should_see_the_product_description() {
        Assert.assertFalse(productPage.getProductDescription().isEmpty(), "Product description is missing!");
    }

    @Then("I should see the product price")
    public void i_should_see_the_product_price() {
        Assert.assertFalse(productPage.getProductPrice().isEmpty(), "Product price is missing!");
    }

    @Then("I should see the product image")
    public void i_should_see_the_product_image() {
        Assert.assertTrue(productPage.isProductImageDisplayed(), "Product image is missing!");
    }

    @Then("I should see product availability status")
    public void i_should_see_product_availability_status() {
        Assert.assertTrue(productPage.isProductAvailable(), "Product is out of stock!");
        driver.quit();
    }

    @When("I add the product to the wishlist")
    public void i_add_the_product_to_the_wishlist() {
        productPage.addToWishlist();
    }

    @Then("I should see a confirmation message for wishlist")
    public void i_should_see_a_confirmation_message_for_wishlist() {
        Assert.assertTrue(productPage.isAddedToWishlist(), "Product was not added to wishlist!");
        driver.quit();
    }

    @When("I add the product to the cart")
    public void i_add_the_product_to_the_cart() {
        productPage.addToCart();
    }

    @Then("I should see a confirmation message for cart")
    public void i_should_see_a_confirmation_message_for_cart() {
        Assert.assertTrue(productPage.isAddedToCart(), "Product was not added to cart!");
        driver.quit();
    }
    
    
    
       
}
/*
 * Feature: Shopping Cart Functionality
 * 
 * Scenario Outline: Add products to cart and remove one before checkout Given I
 * am on the OpenCart page When I searches for "mac" in the search bar And I add
 * "MacBook" to cart And I add "MacBook Pro" to cart And I navigate to shopping
 * cart Then I should see 2 products in the cart And I proceed to checkout page
 * Then I shoul see checkout page
 */
