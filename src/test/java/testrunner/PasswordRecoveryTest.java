package testrunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "src\\test\\resources\\Feature\\passwordrecovery.feature",
		glue = "stepDef",
		plugin = {"pretty", "html:target/cucumber-reports/passwordrecovery.html", "json:target/cucumber-reports/passwordrecovery.json"}
				
	)
public class PasswordRecoveryTest extends AbstractTestNGCucumberTests {


}
