package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	private WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		
		this.driver = driver;
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	protected void waitForElementToBeVisible(org.openqa.selenium.By locator) {
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    
	}

    protected void waitForElementToBeClickable(org.openqa.selenium.By locator) {
    	
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    
    }
}
