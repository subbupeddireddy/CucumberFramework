package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;

public class DashboardStepDefination {

	SubbuSharing share;

	public DashboardStepDefination(SubbuSharing share) {
		this.share = share;
	}

	@Then("the Dashboard page is displayed")
	public void verifyDashboard() {
		Assert.assertTrue(share.driver.getCurrentUrl().contains("site/dashboard"));
	}

}
