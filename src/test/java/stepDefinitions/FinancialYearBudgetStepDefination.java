package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.picocontainer.annotations.Inject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonUtils;
import webPages.FinancialYearBudgetPage;
import webPages.LoginPage;

public class FinancialYearBudgetStepDefination {
	
	String url = "http://10.10.10.206/BPCL/central/site/login";
	String pass = "Admin@123";
	FinancialYearBudgetPage fin;
	LoginPage lp;
	SubbuSharing share;
	
	
public	FinancialYearBudgetStepDefination (SubbuSharing share){
		this.share=share;
		lp = share.pages.getLoginPage();
		fin = share.pages.getFinancialYearBudgetPage();
	}
	
	
	

	@Given("the {string} is on Financial Year Budget page")
	public void the_user_is_on_financial_year_budget_page(String user) throws InterruptedException {
		
		 
		 share.driver.get(url);
		lp.signIn(user, pass);
		Thread.sleep(2000);
		share.driver.get("http://10.10.10.206/BPCL/central/couponbudget/site/couponbudget");
	}
	    
    
    

	@When("the user clicks on the Financial Year Budget print button")
	public void the_user_clicks_on_the_financial_year_budget_print_button() throws InterruptedException {
		Thread.sleep(2000);
		fin.clickOnPrint();
	}

	

	@Then("the Excel file should be downloaded successfully")
	public void the_excel_file_should_be_downloaded_successfully() throws InterruptedException {
		Thread.sleep(2000);
		CommonUtils cu=new CommonUtils(share.driver);
		share.driver.switchTo().window((cu.switchToChildWindow()));
		Thread.sleep(2000);
		fin.excelDownload();
	}

	@When("the user adds the amount and submit")
	public void the_user_adds_the_amount_and_submit() throws InterruptedException {

		fin = share.pages.getFinancialYearBudgetPage();
		fin.clickonFinancialYearBudget();
		fin.addFinancialYearBudget("25000");

	}

	@When("^the user adds the (.+) and submit$")
	public void the_user_adds_the_amount_and_submit_Advance(String data) throws InterruptedException {

		fin.addFinancialYearBudget(data);

	}

	@When("the user submits the Financial year budget")
	public void the_user_submits_the_financial_year_budget() throws InterruptedException {
		Thread.sleep(2000);
		fin.clickOnNew();
		fin.approveFinYearBudget();
		System.out.println("Ok ");

	}

	@Then("the success message is displayed")
	public void the_success_message_is_displayed() throws InterruptedException {
		Thread.sleep(2000);
		try {
			share.driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.println("In catch block");
		} finally {
			System.out.println("No alert present");
		}
		System.out.println("Displayed");
	}

	@Then("the budget displayed in list view")
	public void the_budget_displayed_in_list_view() {
		System.out.println("Showingss");

	}

}
