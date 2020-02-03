package action;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

import objectRepository.LoginRepository;

public class Action {
	
	JavascriptExecutor js = null;
	
	public void ScrollDown(){
		int i; 
		  
		for (i = 0; i < 15; i++)  
		{ 
			js.executeScript("$(\".scroling_div\").scrollTop(99999999999999999999999999999);");
		} 
	}
<<<<<<< HEAD
	
	public void PopClose(LoginRepository loginRepo) throws InterruptedException {
		try {
			//System.out.println(loginRepo.getAddCloseButtonList());
			while (loginRepo.getAddCloseButtonList() != null) {

				if (loginRepo.getAddCloseButtonList().isDisplayed()) {
					loginRepo.getAddCloseButtonList().click();
					System.out.println("Clicks on close button");
					Thread.sleep(1000);
				}
					
				break;			
			}
		} catch (NoSuchElementException e1) {
			e1.printStackTrace();
		}
	}
	
	public void SkipTutorial() {
		
	}
	
=======
	public void PopClose(LoginRepository loginRepo) throws InterruptedException {
		try {
			System.out.println(loginRepo.getAddCloseButtonList());
			while (loginRepo.getAddCloseButtonList() != null) {

				if (loginRepo.getAddCloseButtonList().isDisplayed()) {
					loginRepo.getAddCloseButtonList().click();
					System.out.println("Clicks on close button");
					Thread.sleep(1000);
				}
					
				break;
				
			}
		} catch (NoSuchElementException e1) {

			e1.printStackTrace();
		}
	}
>>>>>>> b50934f5d3cf8f3789407fc5348892633edd78c8
}

