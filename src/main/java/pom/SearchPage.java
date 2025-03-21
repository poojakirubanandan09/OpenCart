package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    WebDriver driver;

    // Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By searchBox = By.name("search");
    By searchButton = By.xpath("//*[@id=\"search\"]/span/button");
    By searchResults = By.cssSelector(".product-thumb");
  

    // Actions
    public void enterSearchQuery(String product) {
    	driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(product);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public boolean isProductDisplayed() {
        return driver.findElements(searchResults).size() > 0;
    }

  
}

