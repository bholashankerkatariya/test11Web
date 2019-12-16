package testclass;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testCases.Login;
import utils.Browser;
import utils.CSVDataReader;

public class loginTest {
	Login lgn;
	Browser browser;


	public loginTest() {	
		this.browser = new Browser();	
		
	}
	
	@DataProvider(name = "Login")
	public Object[][] CSVReader() throws Exception {
		return CSVDataReader.DDTReader("ddt/LoginPage.csv");
	}
	
	@BeforeTest()
	public void callbrowser()
	{	
		browser.chrome();
		lgn = new Login(browser.driver, browser.Wait);
	}

	@Test(priority = 1, enabled = true)
	public void Blank_Submit_Login() {
		lgn.BlankSubmitLogin();
	}

	@Test(priority = 2, enabled = true, dataProvider = "Login")
	public void Login_with_wrong_Email(String Username, String Password) {
		lgn.Login_with_wrong_Email(Username, Password);
	}

	@Test(priority = 3, enabled = true, dataProvider = "Login")
	public void Login_with_wrong_Password(String Username, String Password) throws InterruptedException {
		lgn.Login_Invalid_Password(Username, Password);	
	}

	@Test(priority = 4, enabled = true, dataProvider = "Login")
	public void Login_With_Valid_Credentials(String Username, String Password) throws InterruptedException {
		lgn.Login_with_Valid_Credentials(Username, Password);
	}
	
	@Test(priority = 5, enabled = false) 
	public void GoToProfile() throws InterruptedException { 
		lgn.Go_To_profile(); 
	}
	
	/*
	 * @AfterTest(enabled = true) public void Logout() throws InterruptedException {
	 * lgn.logout(); }
	 */	

}