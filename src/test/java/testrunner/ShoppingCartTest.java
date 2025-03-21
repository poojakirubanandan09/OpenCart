package testrunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "src\\test\\resources\\Feature\\shoppingcart.feature",
		glue = "stepDef",
		plugin = {"pretty", "html:target/cucumber-reports/shoppingcart.html", "json:target/cucumber-reports/shoppingcart.json"}
				
	)
public class ShoppingCartTest extends AbstractTestNGCucumberTests{
	

}
