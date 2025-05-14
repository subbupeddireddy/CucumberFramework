	package stepDefinitions;
	
	import org.openqa.selenium.WebDriver;

import utils.CommonUtils;
import utils.PageFactory;
	
	public class SubbuSharing {
	
		
		public WebDriver driver;
		
		public PageFactory pages;
		
		public CommonUtils utils;
	
		public SubbuSharing() throws Exception{
			WebDriverManager manager=new WebDriverManager();
			this.driver =manager.getDriver();
			pages =new PageFactory(this.driver);
			utils=new CommonUtils(this.driver);
		}
		
		
		
	}
