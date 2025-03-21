package pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
   
	WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By myAccountLink = By.linkText("My Account");
    By loginLink = By.linkText("Login");
    By emailField = By.id("input-email");
    By passwordField = By.id("input-password");
    By loginButton = By.cssSelector("input[type='submit'][value='Login']");
    By logoutLink = By.linkText("Logout");

    // Actions
    public void openLoginPage() {
        driver.findElement(myAccountLink).click();
        driver.findElement(loginLink).click();
    }

    public void enterLoginCredentials(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginSuccessful() {
        return driver.findElements(logoutLink).size() > 0;
    }
    
    public void clickLogout() {
    	driver.findElement(logoutLink).click();
    }
}

