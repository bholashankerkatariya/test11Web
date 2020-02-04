package testclass;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testCases.JoinLeagueLogic;
import testCases.LoginLogic;
import utils.Browser;
import utils.CSVDataReader;

public class JoinLeagueTest {
	static LoginLogic lgn;
	Browser browser;
	JoinLeagueLogic joinleague;
	int count = 1;

	public JoinLeagueTest() {
		this.browser = new Browser();

		lgn = new LoginLogic(browser.driver, browser.Wait);
		joinleague = new JoinLeagueLogic(browser.driver, browser.Wait);

	}

	@DataProvider(name = "Login")
	public Object[][] CSVReader() throws Exception {
		return CSVDataReader.DDTReader("ddt/LoginPage.csv");
	}

	@DataProvider(name = "teamCombination")
	public Object[][] TeamSelection() throws Exception {
		return CSVDataReader.DDTReader("ddt/TeamSelection.csv");
	}

	@BeforeTest
	public void callbrowser() {
		browser.chrome();
		lgn = new LoginLogic(browser.driver, browser.Wait);
		joinleague = new JoinLeagueLogic(browser.driver, browser.Wait);
	}

	@Test(priority = 1, enabled = true, dataProvider = "Login")
	public static void loginToPortal(String Username, String Password) throws InterruptedException {
		lgn.Login_with_Valid_Credentials(Username, Password);
	}

	@Test(priority = 2, enabled = true)
	public void select_A_Match() throws Exception {
		joinleague.Select_The_Match();
	}


	@Test(priority = 3, enabled = false, dataProvider = "teamCombination")
	public void CreatetTeam(String WK, String Bat, String AR, String Bowl) throws Exception {

		/*
		 * Thread.sleep(2000); System.out.println("Team " + count + " : " + WK + " " +
		 * Bat + " " + AR + " " + Bowl); joinleague.TeamSelection2(WK, Bat, AR, Bowl);
		 * count++;
		 */

	}

	@Test(priority = 4, enabled = false)
	public void Join_Mega_Contest() throws Exception {
		joinleague.JoinMegaContests();
	}

	@Test(priority = 5, enabled = false)
	public void Join_Private_contest() throws InterruptedException {

		joinleague.JoinPrivateContest();
	}

	@Test(priority = 6, enabled = false)
	public void join_league_More_Than_100_Member() throws Exception {

		joinleague.joinleagueMoreThan100Member();

	}

	@Test(priority = 7, enabled = true)
	public void join_league_Less_Than_100Member() throws Exception {
		joinleague.joinleagueLessThan100Members();
	}

	@Test(priority = 8, enabled = false)
	public void join_league_2_Members() throws Exception {

		joinleague.joinleague2Members();

	}

	@Test(priority = 9, enabled = false)
	public void JoineLeague_Of_6_Teams() throws Exception {
		joinleague.JoineLeague_Of_6_Teams();
	}
	
	/*
	 * @AfterTest 
	 * public void teardownbrowser()
	 *  { 
	 *  browser.quitDriver();
	 *  }
	 */
	 
}
