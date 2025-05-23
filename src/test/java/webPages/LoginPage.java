package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class LoginPage {


	WebDriver driver;
	
	CommonUtils utils;
	public LoginPage(WebDriver driver) throws Exception {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		utils =new CommonUtils(driver);
	}
	
	
	
	@FindBy (css="input#loginform-username")  private WebElement userNameTxt;
	@FindBy (css="input#loginform-password") private WebElement passwordTxt;
	@FindBy (css="input#loginform-captcha") private WebElement verifcationTxt;
	@FindBy (name = "login-button") 		private WebElement signInBtn;
	@FindBy (xpath="//a[text()='Sign Up']") private WebElement signUpBtn;
	
	
	
	public void signIn(String user, String pass) {
		userNameTxt.sendKeys(user);
		passwordTxt.sendKeys(pass);
		verifcationTxt.sendKeys("subbu test");
		signInBtn.click();
		utils.waitForINVisibleWebElement(signInBtn);
		
		
	}
	
	
	
	
	

}
