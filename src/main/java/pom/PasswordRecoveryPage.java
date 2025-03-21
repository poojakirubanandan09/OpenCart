package pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage extends BasePage {
   


    // Constructor
    public PasswordRecoveryPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    By myAccountLink = By.linkText("My Account");
    By loginLink = By.linkText("Login");
    By forgottenPasswordLink = By.linkText("Forgotten Password");
    By emailField = By.id("input-email");
    By continueButton = By.cssSelector("input[type='submit'][value='Continue']");
    By successMessage = By.cssSelector(".alert-success ");

    // Actions
    public void openPasswordRecoveryPage() {
        driver.findElement(myAccountLink).click();
        driver.findElement(loginLink).click();
        driver.findElement(forgottenPasswordLink).click();
    }

    public void enterEmailForRecovery(String email) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(continueButton).click();
    }

    public boolean isRecoveryRequestSuccessful() {
    	
    	waitForElementToBeVisible(successMessage);
    	return driver.findElements(successMessage).size()>0;
         
    }
}
