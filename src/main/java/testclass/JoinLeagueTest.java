package testclass;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testCases.JoinLeague;
import testCases.Login;
import utils.Browser;
import utils.CSVDataReader;

public class JoinLeagueTest { 
	static Login lgn;
	Browser browser;
	JoinLeague joinleague;
	

	public JoinLeagueTest() {	
		this.browser = new Browser();	
		
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
		lgn = new Login(browser.driver, browser.Wait);
		joinleague = new JoinLeague(browser.driver, browser.Wait);
	}
	
	@Test(priority = 1, enabled = true, dataProvider = "Login")
	public static void loginToPortal(String Username, String Password) throws InterruptedException {
		lgn.Login_with_Valid_Credentials(Username, Password);		
	}
	
	@Test(priority = 2, enabled = true)
	public void select_A_Match() throws Exception {
		joinleague.Select_The_Match();	
	}
	
	@Test(priority =3, enabled = false)
	public void join_A_Contest() throws Exception {	
		
		joinleague.JoinContests();	
		
	}	
	
	@Test(priority = 4, enabled = true)
	public void Join_Private_contest() {
		joinleague.JoinPrivateContest();
	}
}
