package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features ="src\\test\\resources\\Feature\\searchfunctionality.feature" ,
		glue = "stepDef",
		plugin = {"pretty","html:target/cucumber-reports/searchfunctionality.html", "json:target/cucumber-reports/searchfunctionality.json"}
		
		)
public class SearchFunctionalityTest extends AbstractTestNGCucumberTests {

}
