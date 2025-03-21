package testrunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "src\\test\\resources\\Feature\\register.feature",
		glue = "stepDef",
		plugin = {"pretty", "html:target/cucumber-reports/register.html", "json:target/cucumber-reports/register.json"}
				
	)
public class RegisterTest extends AbstractTestNGCucumberTests {


}
