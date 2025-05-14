package webPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class FinancialYearBudgetPage {

	WebDriver driver;
	CommonUtils utils;

	public FinancialYearBudgetPage(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		utils =new CommonUtils(driver);
		
	}

	@FindBy(css = "button[title='Add Financial Year Budget']")
	private WebElement addFinYearBtn;
	@FindBy(css = "span#select2-finYr-container")
	private WebElement selectFinYearBtn;
	@FindBy(css = "input#amt")
	private WebElement budgetValueTxt;
	@FindBy(css = "input#datepicker")
	private WebElement selectdatePickerBtnt;
	@FindBy(css = "textarea#remark")
	private WebElement remarksTxt;
	@FindBy(css = "input[type='file']")
	private WebElement uploadFile;
	@FindBy(css = "button#save")
	private WebElement allocateBtn;
	@FindBy(css = "button#approve")
	private WebElement approveBtn;

	@FindBy(css = "")
	private List<WebElement> finYearOptions;
	@FindBy(css = "td.today.day")
	private WebElement currentDateSlection;
	@FindBy(xpath = "//button[text()='New']")
	private WebElement financialYearNewBtn;
	@FindBy(xpath = "//ul[@id='select2-finYr-results']/li[text()='2025-2026']")
	private WebElement currentFinYearSelection;
	
	
	@FindBy (css="body h3#export") private WebElement excelDownload;
	@FindBy (css="a[title='print']") private WebElement printBtn;

	public void addFinancialYearBudget(String budget) throws InterruptedException {
		

		try {
			utils.waitForVisibleWebElement(financialYearNewBtn);
			if (financialYearNewBtn.isDisplayed()) {

				System.out.println("Budget already added");

			}
		} catch (Exception e) {
			System.out.println("Not found any New Budget , So i was adding");
			System.out.println("In block");
			clickonFinancialYearBudget();
			clickOnSelectFinYear();
			selectCurrentFinYear();
			enterBudget(budget);
			clickOnDatePicker();
			selectCurrentDate();
			enterRemarks("SampleText");
			uploadFile();
			clickOnAllocateBtn();
		}

	}
	
public void clickOnSelectFinYear() {
		
		utils.waitForClickWebElement(selectFinYearBtn);
		selectFinYearBtn.click();
	}
	
	public void selectCurrentFinYear() {
		utils.waitForClickWebElement(currentFinYearSelection);
		currentFinYearSelection.click();
	
	}
	public void enterBudget(String budget) {
		utils.waitForVisibleWebElement(budgetValueTxt);
		budgetValueTxt.sendKeys(budget);
	}
public void clickOnDatePicker() {
		
		utils.waitForClickWebElement(selectdatePickerBtnt);
		selectdatePickerBtnt.click();
	}
	
	public void selectCurrentDate() {
		utils.waitForClickWebElement(currentDateSlection);
		currentDateSlection.click();
	
	}
	public void uploadFile() {
		utils.waitForVisibleWebElement(uploadFile);

		uploadFile.sendKeys(
				System.getProperty("user.dir")+"\\src\\test\\resources\\files\\subbu.pdf");
	
	}
	
public void clickOnAllocateBtn() {
		
		utils.waitForClickWebElement(allocateBtn);
		allocateBtn.click();
	}
	
	
	
	
	
	
	
	
	public void clickOnPrint() {
		
		utils.waitForClickWebElement(printBtn);
				printBtn.click();
	}
	public void excelDownload() {
		utils.waitForClickWebElement(excelDownload);
		excelDownload.click();
	}

	public void clickonFinancialYearBudget() {
		utils.waitForClickWebElement(addFinYearBtn);
		addFinYearBtn.click();
	}

	
	
	public void clickOnNew() {
		utils.waitForClickWebElement(financialYearNewBtn);
		financialYearNewBtn.click();
	}
	
	
	
	

	public void approveFinYearBudget() {
		enterRemarks("approved");
		clickOnApproveButton();
		

	}
	
	public void clickOnApproveButton() {
		utils.waitForClickWebElement(approveBtn);
		approveBtn.click();
	}
	
	
	public void enterRemarks(String remarks) {
		utils.waitForVisibleWebElement(remarksTxt);
		remarksTxt.sendKeys(remarks);
		
	}

}
