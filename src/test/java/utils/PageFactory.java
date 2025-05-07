package utils;

import org.openqa.selenium.WebDriver;

import webPages.FinancialYearBudgetPage;
import webPages.LoginPage;

public class PageFactory {

	WebDriver driver;

	public PageFactory(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLoginPage() {

		LoginPage lp = new LoginPage(this.driver);
		return lp;
	}

	public FinancialYearBudgetPage getFinancialYearBudgetPage() {
		FinancialYearBudgetPage fp = new FinancialYearBudgetPage(this.driver);
		return fp;
	}

}
