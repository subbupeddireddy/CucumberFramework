package webPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinancialYearBudgetPage {

	WebDriver driver;

	public FinancialYearBudgetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
		Thread.sleep(2000);

		try {
			if (financialYearNewBtn.isDisplayed()) {

				System.out.println("Budget already added");

			}
		} catch (Exception e) {
			System.out.println("Not found any New Budget , So i was adding");
			System.out.println("In block");
			clickonFinancialYearBudget();
			Thread.sleep(2000);
			selectFinYearBtn.click();
			Thread.sleep(1000);
			currentFinYearSelection.click();
			budgetValueTxt.sendKeys(budget);
			selectdatePickerBtnt.click();
			Thread.sleep(1000);
			currentDateSlection.click();
			remarksTxt.sendKeys("SampleText");
			uploadFile.sendKeys(
					"C:\\Users\\qq\\eclipse-workspace\\InTheFormCucum\\src\\test\\resources\\files\\subbu.pdf");
			allocateBtn.click();
		}

	}
	
	
	public void clickOnPrint() {
		printBtn.click();
	}
	public void excelDownload() {
		excelDownload.click();
	}

	public void clickonFinancialYearBudget() {
		addFinYearBtn.click();
		System.out.println("Clicked ");
	}

	public void clickOnNew() {
		financialYearNewBtn.click();
	}

	public void approveFinYearBudget() {
		remarksTxt.sendKeys("approved");
		approveBtn.click();

	}

}
