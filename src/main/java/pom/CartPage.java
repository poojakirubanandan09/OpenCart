package pom;

import org.openqa.selenium.WebDriver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;


public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);
		
	}
		    
	    private By productRows = By.cssSelector(".table-responsive tbody tr");
	    private By checkoutButton = By.linkText("Checkout");
	//    private By updateButton = By.cssSelector(".btn-primary[data-original-title='Update']");
	//    private By cartSuccessMessage = By.cssSelector(".alert-success");
	    
	   
	   
        
	    public boolean isProductInCart(String productName) {
	        return driver.findElements(By.xpath("//td[contains(text(),'" + productName + "')]")).size() > 0;
	    }

	 

	    public int getProductCount() {
	        List<WebElement> rows = driver.findElements(productRows);
	        return rows.size();
	    }

	    public void proceedToCheckout() {
	        waitForElementToBeClickable(checkoutButton);
	        driver.findElement(checkoutButton).click();
	    }
	
	
	

}
