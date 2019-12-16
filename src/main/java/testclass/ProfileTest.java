package testclass;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testCases.LeftMenuPanel;
import testCases.Login;
import utils.Browser;
import utils.CSVDataReader;

public class ProfileTest {
	static Login lgn;
	Browser browser;
	LeftMenuPanel leftmenupanel;

	public ProfileTest() {	
		this.browser = new Browser();	
		leftmenupanel = new LeftMenuPanel(null, null);	
		lgn = new Login(browser.driver, browser.Wait);
		
	}
	
	@DataProvider(name = "Login")
	public Object[][] CSVReader() throws Exception {
		return CSVDataReader.DDTReader("ddt/LoginPage.csv");
	}
	
	@BeforeTest()
	public void callbrowser()
	{	
		browser.chrome();
		
	}
	
	@Test(priority = 1, enabled = true, dataProvider = "Login")
	public static void loginToPortal(String Username, String Password) throws InterruptedException {
		lgn.Login_with_Valid_Credentials(Username, Password);		
	}
	
	@Test(priority = 2, enabled = true)
	public void Go_To_profile() throws InterruptedException {
		leftmenupanel.Go_To_profile();
		
	}
	
}
