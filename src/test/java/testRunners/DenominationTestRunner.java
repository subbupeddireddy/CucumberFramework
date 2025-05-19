package testRunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features="src/test/java/featureFiles/Denomination.feature",
		glue={"stepDefinitions","hooks"},
		monochrome=true,
		dryRun=false,
		plugin= {"pretty","html:target/subbu/denomination.report","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter" },
		tags="@smokes"

				
		)


public class DenominationTestRunner extends AbstractTestNGCucumberTests {
	
	
	@Override
	@DataProvider(parallel=false)
	public Object[][] scenarios(){
		return super.scenarios();
		
	}

}
