package pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPageResults extends BasePage{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
    private By productTitles = By.cssSelector(".product-thumb .caption h4 a");
    private By sortDropdown = By.id("input-sort");

    public SearchPageResults(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductTitles() {
    	
        return driver.findElements(productTitles).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    
    }

    public void selectSortOption(String option) {
    
    	WebElement dropdown = driver.findElement(sortDropdown);
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
       
    
    }

    public boolean isSortedCorrectly(String sortOption) {
    
    	List<String> titles = getProductTitles();
        List<String> sortedTitles;
        

        switch (sortOption) {
            case "Name (A - Z)":
            	sortedTitles = new ArrayList<>(titles);
                Collections.sort(sortedTitles,String.CASE_INSENSITIVE_ORDER);
                break;
            
            case "Name (Z - A)":
            	sortedTitles = new ArrayList<>(titles);
                Collections.sort(sortedTitles, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
                break;
           
            case "Price (Low > High)":
           
                List<Double> prices = getProductPrices();
                List<Double> sortedPrices = new ArrayList<>(prices);
                Collections.sort(sortedPrices);
                return prices.equals(sortedPrices);
                
            case "Price (High > Low)":
            	
                List<Double> highToLowPrices = getProductPrices();
                List<Double> sortedHighToLowPrices = new ArrayList<>(highToLowPrices);
                Collections.sort(sortedHighToLowPrices, Collections.reverseOrder());
                return highToLowPrices.equals(sortedHighToLowPrices);
            
            default:
                return false;
        }
        
        return titles.equals(sortedTitles);
    }

    private List<Double> getProductPrices() {
        
    	return driver.findElements(By.cssSelector(".price-tag"))
                .stream()
                .map(WebElement::getText)
                .map(price -> Double.parseDouble(price.replace("$", "").trim()))
                .collect(Collectors.toList());
    
    }
}
