/*

package testclass;

  import org.openqa.selenium.WebDriver;
  import org.testng.annotations.*;
  import testCases.LeftMenuPanel;
  import testCases.LoginLogic;
  import utils.Browser;
  import utils.CSVDataReader;

  public class LeftMenuPanelTest {
    static LoginLogic lgn;
    Browser browser;
  LeftMenuPanel leftmenupanel;
  WebDriver driver;

  @DataProvider(name = "Login")
  public Object[][] CSVReader() throws Exception
  {
    return CSVDataReader.DDTReader("ddt/LoginPage.csv");
  }

    @Parameters({ "browsers" })
    @BeforeTest
    public void callbrowser(String name) {
      browser = new Browser(name);
      lgn = new LoginLogic(browser.driver, browser.Wait);
      leftmenupanel = new LeftMenuPanel(browser.driver, browser.Wait);
    }

  @Test(priority = 1, enabled = true, dataProvider = "Login")
  public void loginToPortal(String Username, String Password) throws
  InterruptedException {
    lgn.Login_with_Valid_Credentials(Username, Password);
  }

  @Test(priority = 2, enabled = false) public void Go_To_profile() throws
  InterruptedException { leftmenupanel.Go_To_profile(); }

  @Test(priority = 3, enabled = false) public void Fill_Profile_Details()
  throws InterruptedException { leftmenupanel.Fill_Profile_Details(); }

  @Test(priority = 4, enabled = false) public void Change_Password() throws
  Exception { leftmenupanel.Change_Password(); }

  @Test(priority = 5, enabled = false) public void Change_Theme() throws
  InterruptedException { leftmenupanel.Change_Theme(); }

  @Test(priority = 6, enabled = false) public void Select_Time_formate() throws
  InterruptedException { leftmenupanel.Select_Time_format(); }

  @Test(priority = 7, enabled = true) public void Changelanguage() throws
  InterruptedException { leftmenupanel.Change_Language(); }

  @AfterTest() public void Logout() throws InterruptedException {
  //lgn.logout(); driver.quit(); }

  }

*/
