package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.PasswordRecoveryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PasswordRecoverySteps {

	WebDriver driver = new ChromeDriver();
    PasswordRecoveryPage passwordRecoveryPage;
	
	@Given("I am on the password recovery page")
    public void i_am_on_the_password_recovery_page() {
        driver.get("https://demo.opencart.com.gr/");
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
        passwordRecoveryPage.openPasswordRecoveryPage();
    }

    @When("I enter {string} for password recovery")
    public void i_enter_for_password_recovery(String email) {
        passwordRecoveryPage.enterEmailForRecovery(email);
    }

    @Then("I should see a password reset success message")
    public void i_should_see_a_password_reset_success_message() {
        Assert.assertTrue(passwordRecoveryPage.isRecoveryRequestSuccessful(), "Password recovery failed!");
        driver.quit();
    }

}
