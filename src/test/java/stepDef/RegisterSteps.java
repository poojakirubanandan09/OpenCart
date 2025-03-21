package stepDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.RegistrationPage;

public class RegisterSteps {

	    WebDriver driver = new ChromeDriver();
	    RegistrationPage registrationPage;
	    

	    @Given("I am on the registration page")
	    public void i_am_on_the_registration_page() {
	   

	        driver.get("https://demo.opencart.com.gr");
	        registrationPage = new RegistrationPage(driver);
	        registrationPage.openRegistrationPage();
	    }

	    @When("I enter user details {string} {string} {string} {string} {string}")
	    public void i_enter_user_details(String firstName, String lastName, String email, String phone, String password) {
	        registrationPage.enterUserDetails(firstName, lastName, email, phone, password);
	    }

	    @And("I accept the privacy policy")
	    public void i_accept_the_privacy_policy() {
	        registrationPage.acceptPrivacyPolicy();
	    }

	    @And("I submit the registration form")
	    public void i_submit_the_registration_form() {
	        registrationPage.submitRegistration();
	    }

	    @Then("I should see a success message")
	    public void i_should_see_a_success_message() {
	        if (registrationPage.isRegistrationSuccessful()) {
	            System.out.println("Registration successful!");
	            Assert.assertTrue(true);
	        } else if (registrationPage.isAccountAlreadyExists()) {
	            System.out.println("User already registered. Skipping registration.");
	        } else {
	            Assert.fail("User registration failed!");
	        }
	        
	        
	        driver.quit();

	    }
	    
	    

}
