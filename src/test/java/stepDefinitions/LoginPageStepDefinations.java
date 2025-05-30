package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webPages.LoginPage;

public class LoginPageStepDefinations {

	WebDriver driver;
	String pass = "Admin@123";
	LoginPage lp;

	SubbuSharing share;

	public LoginPageStepDefinations(SubbuSharing share) throws Exception {
		this.share = share;
		lp = share.pages.getLoginPage();
	}

	@Given("the user is on the Login page")
	public void user_is_on_the_login_page() throws Exception {

		share.driver.get(share.utils.getProperty("maindevurl"));

	}

	@When("^the (.+) sigin with valid credentials$")
	public void siginWithValidCredentials(String user) throws Exception {

		lp.signIn(user, share.utils.getProperty("pass"));

	}

	@Then("the user signin to application")
	public void verifyUrl() {

		Assert.assertFalse(share.driver.getCurrentUrl().contains("site/login"));
	}

}
