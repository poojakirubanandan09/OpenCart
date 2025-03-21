package stepDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.CartPage;
import pom.CheckoutPage;
import pom.ProductPage;
import pom.SearchPage;

public class ShoppingCartSteps {
		
	WebDriver driver ;
	SearchPage searchPage ;
	ProductPage productPage ;
	CartPage cartPage ;
	CheckoutPage checkoutPage;

	@Given("I am on the OpenCart page")
	public void i_am_on_the_open_cart_page() {
	  
		driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
            
      	driver.get("https://demo.opencart.com.gr/");
	}
	
	@When("I searches for {string} in the search bar")
	public void i_searches_for_in_the_search_bar(String product) {
		
		searchPage.enterSearchQuery(product);
        searchPage.clickSearchButton();
	
	}
	
	@When("I add {string} to cart")
	public void i_add_to_cart(String string) {
	    productPage.openProductPage(string);
	    productPage.addToCart();
	}
	
	@When("I navigate to shopping cart")
	public void i_navigate_to_shopping_cart() {
	    productPage.moveToCart();
	}
	
	@Then("I should see {int} products in the cart")
	public void i_should_see_products_in_the_cart(Integer count) {
		Assert.assertEquals(cartPage.getProductCount(), count.intValue());
	}
	@Then("I proceed to checkout page")
	public void i_proceed_to_checkout_page() {
	    cartPage.proceedToCheckout();
	}
	@Then("I shoul see checkout page")
	public void i_shoul_see_checkout_page() {
		Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed());
		driver.quit();
	}


}
