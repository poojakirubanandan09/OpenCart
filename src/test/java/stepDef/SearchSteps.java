package stepDef;


import pom.SearchPage;
import utils.ExcelUtils;
import io.cucumber.java.en.*;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SearchSteps {
	
	WebDriver driver = new ChromeDriver(); 
	SearchPage searchPage;

	@Given("I am on the OpenCart homepage")
	public void i_am_on_the_open_cart_homepage() throws InterruptedException {
		
		driver.get("https://demo.opencart.com.gr/"); 
		Thread.sleep(2000);

		searchPage = new SearchPage(driver);
	    	   
	}
	
	@When("I search for a product from Excel row {int}")
	public void i_search_for_a_product_from_excel_row(Integer row) throws IOException {
		
		// Load Excel file and get data from row 0, column 0 (Product name)
        ExcelUtils.setExcelFile("src\\test\\resources\\Excel\\Books.xlsx", "ProductNameData");
        String product = ExcelUtils.getCellData(row, 0);

        
        searchPage.enterSearchQuery(product);
        searchPage.clickSearchButton();
	}


	@Then("I should see search results displayed")
	public void i_should_see_search_results_displayed() {
		
		Assert.assertTrue(searchPage.isProductDisplayed(),"Product not found in search results!");
		driver.quit();
	    
	} 


   
}

/*
 * WebDriver driver = new ChromeDriver(); SearchPage searchPage;
 * 
 * @Given("I am on the OpenCart homepage") public void i_am_on_the_homepage() {
 * driver.get("https://demo.opencart.com.gr/"); searchPage = new
 * SearchPage(driver); }
 * 
 * @When("I search for {string}") public void i_search_for(String product) {
 * searchPage.enterSearchQuery(product); searchPage.clickSearchButton(); }
 * 
 * @And("I select category {string}") public void i_select_category(String
 * category) { searchPage.selectCategory(category); }
 * 
 * @And("I set price range from {string} to {string}") public void
 * i_set_price_range(String min, String max) { searchPage.enterPriceRange(min,
 * max); searchPage.applyFilters(); }
 * 
 * @And("I apply rating filter") public void i_apply_rating_filter() {
 * searchPage.applyRatingsFilter(); }
 * 
 * @Then("I should see search results displayed") public void
 * i_should_see_results() { Assert.assertTrue(searchPage.isProductDisplayed(),
 * "Product not found in search results!"); driver.quit(); }
 */