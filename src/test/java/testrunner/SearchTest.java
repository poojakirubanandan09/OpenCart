package testrunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/feature/search.feature",
	    glue = "stepDef",
	  //  tags = "@SearchTest",
	    plugin = {"pretty", "html:target/cucumber-reports/search.html", "json:target/cucumber-reports/search.json"}
	)

public class SearchTest extends AbstractTestNGCucumberTests{
   
	
}
