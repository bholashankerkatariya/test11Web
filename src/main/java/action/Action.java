package action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import objectRepository.BeforeLoginObject;

public class Action {
	static BeforeLoginObject beforelogin;	
	public WebDriver driver;

	

	//constructor
	public Action() {
		
		beforelogin = PageFactory.initElements(driver, BeforeLoginObject.class);
				
	}

	//skip tutorial method
	public void skip() {
		beforelogin.getSkipTutorial();
		
	}
	

}
