package stepDef;

import pom.SearchPage;
import pom.ProductPage;
import pom.CheckoutPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class OrderSteps {
    WebDriver driver = new ChromeDriver();
    SearchPage searchPage = new SearchPage(driver);
    ProductPage productPage  = new ProductPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
  //  boolean isInitialized = false;

	/*
	 * @Before(order = 0) public void setUp() { 
		 * if (!isInitialized) { 
		 		 * driver = new ChromeDriver(); 
				 * driver.get("https://demo.opencart.com.gr/"); 
				 * searchPage = new SearchPage(driver);
				 * productPage = new ProductPage(driver); 
				 * checkoutPage = new CheckoutPage(driver); 
				 * isInitialized = true;
		 *  }
     * } 
     */

    @Given("I search for a product {string}")
    public void i_search_for_a_product(String productName) {
    	
    	
        driver.get("https://demo.opencart.com.gr/");
        searchPage.enterSearchQuery(productName);
        searchPage.clickSearchButton();
    }

    @Given("I open the product details page for {string}")
    public void i_open_the_product_details_page(String productName) {
        productPage.openProductPage(productName);
    }

    @Given("I have add the product to the cart")
    public void i_add_the_product_to_the_cart() {
        productPage.addToCart();
    }

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
       // checkoutPage.proceedToCheckout();
    	productPage.moveToCheckout();
    }

	
	@When("I choose guest checkout")
	public void i_choose_guest_checkout() {
	
		checkoutPage.selectGuestCheckout();
	  
	  }
	 

    @When("I enter billing details {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void i_enter_billing_details(String firstName, String lastName, String email, String phone, String address, String city, String postcode, String country, String region)  {
        checkoutPage.enterBillingDetails(firstName, lastName, email, phone, address, city, postcode, country, region);
    }

    @When("I continue with the shipping method")
    public void i_continue_with_the_shipping_method() {
        checkoutPage.continueShippingMethod();
    }

    @When("I agree to the terms and conditions")
    public void i_agree_to_the_terms_and_conditions() {
        checkoutPage.agreeToTerms();
    }

    @When("I continue with the payment method")
    public void i_continue_with_the_payment_method() {
        checkoutPage.continuePaymentMethod();
    }

    @When("I confirm the order")
    public void i_confirm_the_order() {
        checkoutPage.confirmOrder();
    }

    @Then("I should see a confirmation message for order placement")
    public void i_should_see_a_confirmation_message_for_order_placement() {
        Assert.assertTrue(checkoutPage.isOrderPlaced(), "Order placement failed!");
        driver.quit();
    }

	
	 
	 
}

