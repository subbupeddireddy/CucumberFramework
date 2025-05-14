package utils;

import org.openqa.selenium.WebDriver;

import webPages.DenominationPage;
import webPages.FinancialYearBudgetPage;
import webPages.LoginPage;

public class PageFactory {

	WebDriver driver;
	LoginPage lp;
	FinancialYearBudgetPage fp;
	DenominationPage dp ;
	
	

	public PageFactory(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLoginPage() throws Exception {

		lp = new LoginPage(this.driver);
		return lp;
	}

	public FinancialYearBudgetPage getFinancialYearBudgetPage() throws Exception {
		 fp = new FinancialYearBudgetPage(this.driver);
		return fp;
	}
	
		
	public DenominationPage getDenominationPage() {
		 dp = new DenominationPage(this.driver);
		return dp;
	}

}
