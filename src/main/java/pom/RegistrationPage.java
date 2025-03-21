package pom;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage {
    
	
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    
    // Locators
    By myAccountLink = By.linkText("My Account");
    By registerLink = By.linkText("Register");
    By firstNameField = By.id("input-firstname");
    By lastNameField = By.id("input-lastname");
    By emailField = By.id("input-email");
    By telephoneField = By.id("input-telephone");
    By passwordField = By.id("input-password");
    By confirmPasswordField = By.id("input-confirm");
    By privacyPolicyCheckbox = By.name("agree");
    By continueButton = By.cssSelector("input[type='submit'][value='Continue']");
    By successMessage = By.cssSelector(".alert-success");
    By accountExistsMessage = By.cssSelector(".alert-danger");

    // Actions
    public void openRegistrationPage() {
    	waitForElementToBeClickable(myAccountLink);
        driver.findElement(myAccountLink).click();
        waitForElementToBeClickable(registerLink);
        driver.findElement(registerLink).click();
    }

    public void enterUserDetails(String firstName, String lastName, String email, String telephone, String password) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(telephoneField).sendKeys(telephone);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
    }

    public void acceptPrivacyPolicy() {
        driver.findElement(privacyPolicyCheckbox).click();
    }

    public void submitRegistration() {
        driver.findElement(continueButton).click();
    }

    public boolean isRegistrationSuccessful() {
        return driver.findElements(successMessage).size() > 0;
    }

	public boolean isAccountAlreadyExists() {
		try {
            WebElement errorMessage = driver.findElement(accountExistsMessage);
            return errorMessage.getText().contains("already registered") || errorMessage.getText().contains("already exists");
        } catch (NoSuchElementException e) {
            return false;
        }
	}
}
