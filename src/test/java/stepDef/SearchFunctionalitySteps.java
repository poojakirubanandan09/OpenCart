package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import pom.SearchPage;
import pom.SearchPageResults;


public class SearchFunctionalitySteps {

	WebDriver driver;
	SearchPageResults searchPageResults ;
	SearchPage searchPage;


	@Given("I am on the homepage")
	public void i_am_on_the_homepage() {
	   
		driver = new ChromeDriver();
    	driver.get("https://demo.opencart.com.gr/");
    	
        searchPageResults = new SearchPageResults(driver);
        searchPage = new SearchPage(driver);
        
	}

    @When("I search for {string} in the search bar")
    public void iSearchForProduct(String product) {
    	
    	searchPage.enterSearchQuery(product);
    	searchPage.clickSearchButton();
    	
    }

    @And("I sort the results by {string}")
    public void iSortTheResultsBy(String sortOption) {
    	
    	searchPageResults.selectSortOption(sortOption);
    }

    @Then("I should see the products sorted correctly by {string}")
    public void iShouldSeeTheProductsSortedCorrectly(String sortOption) {
    	
        Assert.assertTrue(searchPageResults.isSortedCorrectly(sortOption),"The products are not sorted correctly for: " + sortOption);
        
    driver.quit();
        
    }
}
