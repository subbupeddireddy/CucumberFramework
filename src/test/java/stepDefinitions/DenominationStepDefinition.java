package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonUtils;
import webPages.DenominationPage;
import webPages.LoginPage;

public class DenominationStepDefinition {

	SubbuSharing share;
	DenominationPage dp;
	LoginPage lp;

	public DenominationStepDefinition(SubbuSharing share) throws Exception {
		this.share = share;
		lp=share.pages.getLoginPage();
		dp = share.pages.getDenominationPage();
		
	}

	@Given("the {string} is on the Denomination page")
	public void the_user_is_on_the_denomination_page(String user) throws Exception {
		String url = share.utils.getProperty("maindevurl");
		String pass=share.utils.getProperty("pass");
		String denomUrl=share.utils.getProperty("denomUrl");
		
		share.driver.get(url);
		lp.signIn(user,pass );
		share.driver.get(denomUrl);

	}

	@When("the user enters denomination value of {int}")
	public void the_user_enters_denomination_value_of(Integer int1) throws Exception {
		dp.clickOnAddDenomination();
		dp.enterDenomination(int1);

	}

	@When("enters remarks as {string}")
	public void enters_remarks_as(String remarks) {
		dp.enterRemarks(remarks);
	}

	@When("clicks the Submit button")
	public void clicks_the_submit_button() throws Exception {
		dp.clickonSubmit();

	}

	@Then("a success message should be displayed")
	public void an_error_message_should_be_displayed() {
		String expectedMessage = "Denomination Added Successfully.";
		String actualMsg = dp.validateMessage();
		Assert.assertEquals(actualMsg, expectedMessage);

	}

	@Then("a success message {string} should be displayed")
	public void successMessage(String expectedMessage) {
		String actualMsg = dp.validateMessage();
		Assert.assertEquals(actualMsg, expectedMessage);
	}

	@Then("an error message {string} should be displayed")
	public void errorMessage(String expectedMessage) {
		String actualMsg = dp.validateMessage();
		Assert.assertEquals(actualMsg, expectedMessage);
	}

	@When("the user clicks on the Print button")
	public void the_user_clicks_on_the_print_button() {
		dp.clickOnPrintBtn();

	}

	@Then("the Excel Download button should be displayed")
	public void the_excel_download_button_should_be_displayed() {

		share.driver.switchTo().window(share.utils.switchToChildWindow());
		Assert.assertTrue(dp.excelDownloadIsDisplayed());

	}

}
