package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features="src/test/java/featureFiles",
glue= {"stepDefinitions","hooks"},
monochrome=true,
dryRun=false,
plugin= {"pretty","html:target/subbu/subbuAllTestHTML.report"}
		
		)
public class RunAllTestsTestRunner extends AbstractTestNGCucumberTests{
	
	
	
	

}
