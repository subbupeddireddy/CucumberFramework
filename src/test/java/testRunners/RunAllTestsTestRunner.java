package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features="src/test/java/featureFiles",
glue= {"stepDefinitions","hooks"},
monochrome=true,
dryRun=false,
plugin= {"pretty","html:target/subbu/subbuAllTestHTML.report","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		,"rerun:target/failedTests.txt"}
		
		)
public class RunAllTestsTestRunner extends AbstractTestNGCucumberTests{
	
	
	
	

}
