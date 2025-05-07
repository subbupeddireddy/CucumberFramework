	package stepDefinitions;
	
	import org.openqa.selenium.WebDriver;
	
	import utils.PageFactory;
	
	public class SubbuSharing {
	
		
		public WebDriver driver;
		
		public PageFactory pages;
	
		public SubbuSharing(){
			WebDriverManager manager=new WebDriverManager();
			this.driver =manager.getDriver();
			pages =new PageFactory(this.driver);
		}
		
		
		
	}
