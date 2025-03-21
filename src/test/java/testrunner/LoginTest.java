package testrunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "src\\test\\resources\\Feature\\login.feature",
		glue = "stepDef",
		plugin = {"pretty", "html:target/cucumber-reports/login.html", "json:target/cucumber-reports/login.json"}
				
	)
public class LoginTest extends AbstractTestNGCucumberTests{

	
}
