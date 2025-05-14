package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\featureFiles\\FinancialYearBudget.feature",
glue = {"stepDefinitions","hooks" },dryRun=false, monochrome = true, plugin = {"pretty","json:target/cucumber_subbu_json_report","html:target/cucumber_subbu_html_report"})
public class FinancialYearBudgetTestRunner2 extends AbstractTestNGCucumberTests {

}
