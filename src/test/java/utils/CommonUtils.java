package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class CommonUtils {

	
	WebDriver driver;
	
	public CommonUtils (WebDriver driver){
		this.driver=driver;
	}
	
	

	public String switchToChildWindow() {
		Set<String> allWindowHandels = driver.getWindowHandles();

		Iterator<String> iterator = allWindowHandels.iterator();
		String parentwindow = iterator.next();
		String childwindow = iterator.next();

		return childwindow;

	}
	
	public String switchToParentWindow() {
		Set<String> allWindowHandels =driver.getWindowHandles();

		Iterator<String> iterator = allWindowHandels.iterator();
		String parentwindow = iterator.next();
		String childwindow = iterator.next();

		return parentwindow;

	}
	
}
