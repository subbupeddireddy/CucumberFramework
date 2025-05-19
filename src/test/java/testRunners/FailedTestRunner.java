package testRunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@target/failedScenarios.txt",
glue = {"stepDefinitions", "hooks"},dryRun=false, monochrome = true,
plugin = {"pretty","json:target/cucumber_subbu_json.report","html:target/cucumber_subbu_html.report",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }


		)
public class FailedTestRunner extends AbstractTestNGCucumberTests {
	
	
	@DataProvider(parallel=true)
	@Override
	public Object[][] scenarios(){
		return super.scenarios();
		
	}

}
