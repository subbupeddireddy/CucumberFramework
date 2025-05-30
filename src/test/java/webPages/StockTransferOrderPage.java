package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class StockTransferOrderPage {

	WebDriver driver;
	CommonUtils utils;

	public StockTransferOrderPage(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		utils = new CommonUtils(driver);

	}

	private @FindBy(css = "input[type='search']") WebElement searchTxt;
	private @FindBy(xpath = "//tbody/tr/td[2]") WebElement orderNumber;
	private @FindBy(xpath = "//tbody/tr/td[14]/button | //tbody/tr/td[14]/a") WebElement actionBtn;
	private @FindBy(xpath = "//tbody/tr/td[13]/button") WebElement vehicleEdit;
	private @FindBy(css = "input#vehicle_no") WebElement vehicleNoTxt;
	private @FindBy(css = "input#trans_name") WebElement truckNoTxt;
	private @FindBy(css = "input#seal_no") WebElement sealNoTxt;
	private @FindBy(css = "button[type='submit']") WebElement submitBtn;
	private @FindBy(css = ".btn.btn-danger") WebElement cancelBtn;

	public void searchOrder(String order) {
		utils.waitForClickWebElement(searchTxt);
		searchTxt.sendKeys(order);
	}

	public String getOrderNumberStatus() {
		return orderNumber.findElement(By.xpath("../td[14]")).getText();
	}

	public String getOrderNumber() {
		utils.waitForVisibleWebElement(orderNumber);
		return orderNumber.getText();
	}

	public String getStatus() {
		utils.waitForVisibleWebElement(actionBtn);
		return actionBtn.getText();
	}

	public void clickOnAction() throws Exception {
		utils.waitForVisibleWebElement(actionBtn);
		// Actions action=new Actions(driver);
		// action.scrollToElement(actionBtn).build().perform();

		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		//js.executeScript("window.scrollBy(0,500)");
		//Thread.sleep(2000);
		//System.out.println("By scroll height");
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		//Thread.sleep(2000);
		System.out.println("By scroll element");
		js.executeScript("arguments[0].scrollIntoView(true);", actionBtn);

		actionBtn.click();

	}

	public String fetchVehicleNumber() {
		utils.waitForVisibleWebElement(vehicleEdit);
		return vehicleEdit.getText();

	}

	public void enterVehicleNumber(String vehicleNo) {
		utils.waitForVisibleWebElement(this.vehicleNoTxt);

		this.vehicleNoTxt.sendKeys(vehicleNo);
	}

	public void enterTruckNumber(String truckNo) {
		this.truckNoTxt.sendKeys(truckNo);
	}

	public void enterSealNumber(String sealNo) {
		this.sealNoTxt.sendKeys(sealNo);

	}

	public void clickOnSaveBtn() {
		utils.waitForVisibleWebElement(this.submitBtn);
		submitBtn.click();
		utils.waitForINVisibleWebElement(this.submitBtn);

	}

	public void clickOnCancelBtn() {
		utils.waitForVisibleWebElement(this.cancelBtn);
		cancelBtn.click();

	}
}
