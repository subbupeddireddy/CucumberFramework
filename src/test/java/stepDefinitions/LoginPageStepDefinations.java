package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webPages.LoginPage;

public class LoginPageStepDefinations {

	WebDriver driver;
	String url = "http://10.10.10.206/BPCL/central/site/login";
	String  pass = "Admin@123";
	LoginPage lp;

	SubbuSharing share;

	public LoginPageStepDefinations(SubbuSharing share) throws Exception {
		this.share = share;
		lp = share.pages.getLoginPage();
	}

	@Given("the user is on the Login page")
	public void user_is_on_the_login_page() {

		share.driver.get(url);

	}

	@When("^the (.+) sigin with valid credentials$")
	public void siginWithValidCredentials(String user) throws InterruptedException {

		lp.signIn(user, pass);
		Thread.sleep(2000);
	}

	@Then("the user signin to application")
	public void verifyUrl() {
		Assert.assertFalse(share.driver.getCurrentUrl().contains("site/login"));
	}

}
