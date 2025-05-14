package webPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonUtils;

public class DenominationPage {

	WebDriver driver;
	WebDriverWait wait;

	public DenominationPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));


	}

	private @FindBy(css = "button[value$='create-denomination']") WebElement addDenominationBtn;
	private @FindBy(css = "input#amt") WebElement denominationAmtTxt;
	private @FindBy(css = "textarea#remark") WebElement remarksTxt;
	private @FindBy(css = "input[type='search']") WebElement searchTxt;
	private @FindBy(css = "button#save") WebElement saveBtn;
	private @FindBy(css = "button#update") WebElement updateBtn;
	private @FindBy(css = "button#approve") WebElement approveBtn;
	private @FindBy(xpath = "//button[text()='New']") WebElement newBtn;
	private @FindBy(css = "a[title='print']") WebElement printBtn;
	private @FindBy(css = "h3#export") WebElement excelDownloadBtn;
	
	
	
	public void clickOnPrintBtn() {
		try {
			wait.until(ExpectedConditions.visibilityOf(printBtn));
			}
			catch (Exception e) {
				System.out.println("Exception");
				
				}
		printBtn.click();
	}
	
	public boolean excelDownloadIsDisplayed() {
		
		
		
		try {
		wait.until(ExpectedConditions.visibilityOf(excelDownloadBtn));
		}
		catch (Exception e) {
			System.out.println("Exception");
			
			}
		return excelDownloadBtn.isDisplayed();
	}

	public void clickOnAddDenomination() {
		addDenominationBtn.click();
	}

	public void clickOnNewDenomination() {
		newBtn.click();
	}

	public void addDenomination(int value) throws InterruptedException {
		denominationAmtTxt.sendKeys(String.valueOf(value));
		remarksTxt.sendKeys("add Denomination");
		saveBtn.click();
		Thread.sleep(2000);
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.println("Not found any Alert");
		}

	}

	public void enterDenomination(int denom) {
		denominationAmtTxt.sendKeys(String.valueOf(denom));
	}

	public void enterRemarks(String remarks) {
		remarksTxt.sendKeys(remarks);
	}

	public void clickonSubmit() throws Exception {
		saveBtn.click();
		Thread.sleep(2000);
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.println("Not found any Alert");
		}
	}

	public void approveDenomination() {

		remarksTxt.sendKeys("Approve Denomination");
		updateBtn.click();
	}

	public String validateMessage() {
		try {
			WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[contains(@class, 'swal-modal')]//div[contains(@class, 'swal-text')]"))); 
			String actual = successMsg.getText();
			System.out.println(actual);
			return actual;

		} catch (Exception e) {
			System.out.println("Not found success message");
			return "Not found success message";
		}

	}

}
