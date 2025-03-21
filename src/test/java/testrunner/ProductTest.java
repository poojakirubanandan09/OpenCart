package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		
		features = "src\\test\\resources\\Feature\\product.feature",
		glue = "stepDef",
		plugin = {"pretty", "html:target/cucumber-reports/product.html", "json:target/cucumber-reports/product.json"}
				
	)
public class ProductTest extends AbstractTestNGCucumberTests {

}
