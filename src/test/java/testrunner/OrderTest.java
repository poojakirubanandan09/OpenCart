package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "src\\test\\resources\\Feature\\order.feature",
		glue = "stepDef",
		plugin = {"pretty", "html:target/cucumber-reports/order.html", "json:target/cucumber-reports/order.json"}
				
	)
public class OrderTest extends AbstractTestNGCucumberTests {

}
