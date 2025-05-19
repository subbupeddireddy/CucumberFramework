package hooks;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import stepDefinitions.SubbuSharing;

public class Hooks {

	SubbuSharing sharing;

	public Hooks(SubbuSharing sharing) {
		this.sharing = sharing;

	}

	@After("@smokes")
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
		
		
	//@AfterStep	
	public void takeScreenshot(Scenario scenario) throws Exception, IOException {
		
		if(scenario.isFailed()) {
	TakesScreenshot as=	(TakesScreenshot)sharing.driver;
	String screenshotName=scenario.getName().replaceAll(" ", "_")+".png";
	FileUtils.copyFile(as.getScreenshotAs(OutputType.FILE), new File("target/screenshots/"+screenshotName));
	
		}
		
	}
	
	
	@AfterStep	
		public void attachScreenShot(Scenario scenario) throws Exception, IOException {
			
			if(scenario.isFailed()) {
		TakesScreenshot as=	(TakesScreenshot)sharing.driver;
		
		File source=as.getScreenshotAs(OutputType.FILE);
		byte[] filecontent=FileUtils.readFileToByteArray(source);
		scenario.attach(filecontent, "image/png", "image");
		
			}
			
		}
}
