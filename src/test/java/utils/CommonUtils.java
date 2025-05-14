package utils;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {

	WebDriver driver;
	WebDriverWait wait;
	FileInputStream fis;
	Properties prop;

	public CommonUtils(WebDriver driver) throws Exception {
		this.driver = driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));

	}

	public String switchToChildWindow() {
		Set<String> allWindowHandels = driver.getWindowHandles();

		Iterator<String> iterator = allWindowHandels.iterator();
		String parentwindow = iterator.next();
		String childwindow = iterator.next();

		return childwindow;

	}

	public String switchToParentWindow() {
		Set<String> allWindowHandels = driver.getWindowHandles();

		Iterator<String> iterator = allWindowHandels.iterator();
		String parentwindow = iterator.next();
		String childwindow = iterator.next();

		return parentwindow;

	}

	public String getProperty(String key) throws Exception {
		prop = new Properties();
		fis = new FileInputStream(
				new File("C:\\Users\\qq\\eclipse-workspace\\InTheFormCucum\\resources\\common.properties"));
		prop.load(fis);
		return prop.getProperty(key.toLowerCase());

	}
	
	public void waitForURLContains(String contains) {
		
		wait.until(ExpectedConditions.urlContains(contains));
		
	}
	public void waitForVisibleWebElement(WebElement element) {
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
public void waitForClickWebElement(WebElement element) {
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
public void waitForAlertPresent() {
	
	wait.until(ExpectedConditions.alertIsPresent());
	
}
	
public void waitForINVisibleWebElement(WebElement element) {
	
	wait.until(ExpectedConditions.invisibilityOf(element));
	
}

}
