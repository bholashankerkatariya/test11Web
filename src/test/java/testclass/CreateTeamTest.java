package testclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testCases.CreateTeam;
import testCases.JoinLeagueLogic;
import testCases.LoginLogic;
import utils.Browser;
import utils.CSVDataReader;


public class CreateTeamTest {
    LoginLogic lgn;
    Browser browser;
    JoinLeagueLogic joinleague;
    WebDriver driver;
    CreateTeam createTeam;

    int count = 1;

    @DataProvider( name = "Login" )
    public Object[][] CSVReader( ) throws Exception{
        return CSVDataReader.DDTReader("ddt/LoginPage.csv");
    }

    @DataProvider( name = "teamCombination" )
    public Object[][] TeamSelection( ) throws Exception{
        return CSVDataReader.DDTReader("ddt/TeamSelection.csv");
    }

    @Parameters( {"browsers"} )
    @BeforeTest
    public void CallBrowser(String name) {
        browser = new Browser(name);

        lgn = new LoginLogic(browser.driver, browser.Wait);
        joinleague = new JoinLeagueLogic(browser.driver, browser.Wait);
        createTeam = new CreateTeam(browser.driver, browser.Wait);
    }

    @Test( priority = 1, dataProvider = "Login" )
    public void loginToPortal(String Username, String Password) throws InterruptedException{
        lgn.Login_with_Valid_Credentials(Username, Password);
    }

    @Test( priority = 2, enabled = true )
    public void select_A_Match( ) throws Exception{
        joinleague.Select_The_Match();
    }

    @Test( priority = 3, enabled = true, dataProvider = "teamCombination" )
    public void CreateTeam(String WK, String Bat, String AR, String Bowl) throws Exception{
        createTeam.TeamSelection(WK, Bat, AR, Bowl);
    }

    @Test( priority = 4, enabled = false )
    public void Join_Mega_Contest( ) throws Exception{
        joinleague.JoinMegaContests();
    }

    @Test( priority = 5, enabled = false )
    public void TearDown( ){
        driver.quit();
    }

}
