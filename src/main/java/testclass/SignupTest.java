package testclass;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testCases.Login;
import testCases.SignUp;
import utils.Browser;
import utils.CSVDataReader;

public class SignupTest {
	Login lgn;
	Browser browser;
	SignUp signup;

	
	  public SignupTest() {
		  this.browser = new Browser(); 
		  signup = new SignUp(this.browser.driver, this.browser.Wait); }
	 
	
	@DataProvider(name = "Signup")
	public Object[][] CSVReader() throws Exception {
		return CSVDataReader.DDTReader("ddt/Signup.csv");
	}
	
	@BeforeTest()
	public void callbrowser()
	{	
		browser.chrome();
		signup = new SignUp(browser.driver, browser.Wait);
	}
	
	@Test(priority = 1, enabled = true, dataProvider = "Signup")
	public void Registration(String Email, String Password, String ReferralCode, String MobileNumber,
			String UserName, String Status) {
		signup.Register_New_User(Email,Password, ReferralCode, MobileNumber,UserName, Status);		
	}
	
	@Test(priority = 2, enabled = true, dataProvider = "Signup")
	public void Enter_OTP(String Email, String Password, String ReferralCode, String MobileNumber,
			String UserName, String Status) {
		signup.OTP_Process(Email, Password, ReferralCode, MobileNumber,UserName, Status);
	}
	
	@Test(priority = 3, enabled = true, dataProvider = "Signup")
	public void Almostdonescreen(String Email, String Password, String ReferralCode, String MobileNumber,
			String UserName, String Status) {
		signup.Almost_done(Email,Password, ReferralCode, MobileNumber, UserName, Status);
	}
	
	@Test(priority = 4, enabled = false, dataProvider = "Signup")
	public void forgotpassword(String Email, String Password, String ReferralCode, String MobileNumber,
			String UserName, String Status) {
		signup.ForgotPassword(Email, Password, ReferralCode, MobileNumber, UserName, Status);
	}
	
	@Test(priority = 5, enabled = true) 
	public void GoToProfile() throws InterruptedException { 
		//lgn = new Login(browser.driver, browser.Wait);
		lgn.Go_To_profile(); 
	}
		
	@AfterTest(enabled = true)
	public void Logout() throws InterruptedException {
	lgn.logout();
	}
		
}
