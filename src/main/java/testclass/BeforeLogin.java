package testclass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testCases.WithoutLogin;
import utils.CSVDataReader;

public class BeforeLogin {
	WithoutLogin wl;
	WebDriver driver;
	
	BeforeLogin(){
	
	wl = new WithoutLogin();
	}
	
	@DataProvider(name = "Login")
	public  Object[][] Login() throws Exception {
		 return CSVDataReader.DDTReader("ddt/LoginPage.csv");
	}
	
	@Test(priority = 1, enabled = true )
	public void PlayNowbtn(String UserName, String Password, String Status) throws InterruptedException {
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
