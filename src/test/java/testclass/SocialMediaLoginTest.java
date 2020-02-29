package testclass;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testCases.LoginLogic;
import utils.Browser;

public class SocialMediaLoginTest {
	LoginLogic lgn;
	Browser browser;

	@Parameters({"browsers"})
	@BeforeTest()
	public void callbrowser(String name)
	{	
		browser = new Browser(name);
		lgn = new LoginLogic(browser.driver, browser.Wait);
	}

	@Test(priority = 1, enabled = true)
	public void LoginFB() throws Exception {
		lgn.Login_With_FB();
	}
	
	
	/*
	 * @Test(priority =2, enabled = true) public void LoginWithGoogle() throws
	 * Exception { lgn.Login_With_Google(); //issue from pankaj side, Click event
	 * not working in automation }
	 */
	 
	
	  @Test(priority = 2, enabled = false) public void GoToProfile() throws
	  InterruptedException { lgn.Go_To_profile(); }
	 
	 
	
	/*
	 * @AfterTest(enabled = true) public void Logout() throws InterruptedException {
	 * lgn.logout(); }
	 */
		

}
