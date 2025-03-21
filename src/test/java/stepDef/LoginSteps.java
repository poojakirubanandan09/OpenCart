package stepDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.LoginPage;

public class LoginSteps {
	
	 WebDriver driver  = new ChromeDriver();;
	 LoginPage loginPage;

	@Given("I am on the login page")
    public void i_am_on_the_login_page() {
		
        driver.get("https://demo.opencart.com.gr/");
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
    }

    @When("I enter login credentials {string} {string}")
    public void i_enter_login_credentials(String email, String password) {
        loginPage.enterLoginCredentials(email, password);
    }

    @And("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed!");
        
        loginPage.clickLogout();
        
        driver.quit();
    }
    
    
}
