package testclass;

import org.testng.annotations.*;
import testCases.LoginLogic;
import utils.Browser;
import utils.CSVDataReader;

public class loginTest {
    LoginLogic lgn;
    Browser browser;

    @DataProvider(name = "Login")
    public Object[][] CSVReader() throws Exception {
        return CSVDataReader.DDTReader("ddt/LoginPage.csv");
    }

	@Parameters({ "browsers" })
    @BeforeTest
    public void callbrowser(String name) {
        browser = new Browser(name);
        lgn = new LoginLogic(browser.driver, browser.Wait);
    }

    @Test(priority = 1, enabled = true)
    public void Blank_Submit_Login() throws InterruptedException {
        lgn.BlankSubmitLogin();
    }

    @Test(priority = 2, enabled = true, dataProvider = "Login")
    public void Login_with_Invalid_Password(String Username, String Password) throws InterruptedException {
        lgn.Login_Invalid_Password(Username, Password);
    }

    @Test(priority = 3, enabled = true, dataProvider = "Login")
    public void Login_with_wrong_Email(String Username, String Password) throws InterruptedException {
        lgn.Login_with_wrong_Email(Username, Password);
    }

    @Test(priority = 4, enabled = true, dataProvider = "Login")
    public void Login_With_Valid_Credentials(String Username, String Password) throws InterruptedException {
        lgn.Login_with_Valid_Credentials(Username, Password);
    }

    @Test(priority = 5, enabled = false)
    public void GoToProfile() throws InterruptedException {
        lgn.Go_To_profile();
    }

/*	@AfterTest(enabled = true)
	public void teardown() throws InterruptedException {
		lgn.teardown();
	}*/
}
