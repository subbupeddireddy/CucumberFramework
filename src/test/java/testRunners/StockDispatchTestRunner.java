package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\featureFiles\\StockDispatch.feature", glue = {
		"stepDefinitions","hooks" }, monochrome = true, dryRun = false,
				plugin = { "pretty", "html:traget/subbu/stepDefination.report" }

,tags="@smoke"

)

public class StockDispatchTestRunner extends AbstractTestNGCucumberTests{

}
