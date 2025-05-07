package hooks;

import io.cucumber.java.After;
import stepDefinitions.SubbuSharing;

public class Hooks {

	SubbuSharing sharing;

	public Hooks(SubbuSharing sharing) {
		this.sharing = sharing;

	}

	//@After("@smoke")
	public void tearDownAfterSmokeScenario() {
		sharing.driver.quit();
		System.out.println("I was closing the scenarios of Smoke");
	}

	//@After("@sanity")
	public void tearDownAfterSanityScenario() {
		sharing.driver.close();
		System.out.println("I was closing the scenarios of Sanity");
	}
	
		@After
	public void tearDownAfterScenario() {
	//	sharing.driver.close();
		sharing.driver.quit();

		System.out.println("I was closing the scenarios of All");
	}
}
