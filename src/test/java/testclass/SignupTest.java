package testclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import testCases.LoginLogic;
import testCases.SignUpLogic;
import utils.Browser;
import utils.CSVDataReader;

public class SignupTest {
    LoginLogic lgn;
    Browser browser;
    SignUpLogic signup;


    @DataProvider(name = "Signup")
    public Object[][] CSVReader() throws Exception {
        return CSVDataReader.DDTReader("ddt/Signup.csv");
    }

    @Parameters({"browsers"})
    @BeforeTest
    public void callbrowser(String name) {
        browser = new Browser(name);
        signup = new SignUpLogic(browser.driver, browser.Wait);
    }


    @Test(priority = 1, enabled = true, dataProvider = "Signup")
    public void Registration(String Email, String Password, String ReferralCode, String MobileNumber,
                             String UserName, String Status) {
        signup.Register_New_User(Email, Password, ReferralCode, MobileNumber, UserName, Status);
    }

    @Test(priority = 2, enabled = true, dataProvider = "Signup")
    public void Enter_OTP(String Email, String Password, String ReferralCode, String MobileNumber,
                          String UserName, String Status) {
        signup.OTP_Process(Email, Password, ReferralCode, MobileNumber, UserName, Status);
    }

    @Test(priority = 3, enabled = true, dataProvider = "Signup")
    public void Almostdonescreen(String Email, String Password, String ReferralCode, String MobileNumber,
                                 String UserName, String Status) {
        signup.Almost_done(Email, Password, ReferralCode, MobileNumber, UserName, Status);
    }

    @Test(priority = 4, enabled = false, dataProvider = "Signup")
    public void forgotpassword(String Email, String Password, String ReferralCode, String MobileNumber,
                               String UserName, String Status) {
        signup.ForgotPassword(Email, Password, ReferralCode, MobileNumber, UserName, Status);
    }

    @Test(priority = 5, enabled = true)
    public void GoToProfile() throws InterruptedException {
        lgn.Go_To_profile();
    }

    @AfterTest(enabled = true)
    public void Logout() throws InterruptedException {
        lgn.teardown();
    }

}
