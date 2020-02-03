package testclass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import testCases.WithoutLoginLogic;

public class BeforeLogintest {
	WithoutLoginLogic wl;
	WebDriver driver;
	
	BeforeLogintest(){
	wl = new WithoutLoginLogic();
	}
	
		
	@Test(priority = 1, enabled = true )
	public void PlayNowbtn() throws InterruptedException {
		wl.ClickOnPlayNow();
	}
	
	@Test(priority = 2, enabled = true)
	public void GotoMatch() {
		wl.Verifymatchlist();
	}
	
	@Test(priority = 3, enabled = true)
	public void Selectmatch() throws Exception {
		wl.SelectMatch();
	}
	
	@Test(priority = 4, enabled = true)
	public void createTeame() {
		wl.CreateTeame();
	}
	
	
	/*
	 * @AfterTest public void closeBrowser() { driver.close(); }
	 */
	 
}
