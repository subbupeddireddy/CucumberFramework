package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features="src/test/java/featureFiles",
glue= {"stepDefinitions" , "hooks"},
monochrome=true,
plugin= {"pretty" , "html:target/subbu/subbuHTML.report"},
tags="@smoke"
		)


public class SmokeTestCaseRunner extends AbstractTestNGCucumberTests {

	
	
	
	
}
