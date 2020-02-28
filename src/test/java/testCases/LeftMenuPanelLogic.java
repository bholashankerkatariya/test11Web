/*
package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import objectRepository.LogOutRepository;
import objectRepository.LoginRepository;
import objectRepository.ProfileRepository;
import utils.CSVDataReader;

public class LeftMenuPanel {

    WebDriver driver;
    WebDriverWait Wait;
    LoginRepository loginRepo;
    LogOutRepository logoutRepo;
    ProfileRepository prflRepo;
    Actions actions;

    String validation1 = "Old Password is required";
    String validation2 ="Password is required.";
    String validation3 ="Confirm password is required.";
    String validation4 ="Password doesn't match";

    public LeftMenuPanel(WebDriver _driver, WebDriverWait _Wait) {
        driver =
                _driver;
        Wait = _Wait;
        logoutRepo = PageFactory.initElements(driver,
                LogOutRepository.class);
        loginRepo = PageFactory.initElements(driver,
                LoginRepository.class);
        prflRepo = PageFactory.initElements(driver,
                ProfileRepository.class);
    }

    @DataProvider(name = "Login")
    public Object[][] CSVReader() throws Exception {
        return CSVDataReader.DDTReader("ddt/LoginPage.csv");
    }

    public void Go_To_profile() throws InterruptedException {
        Thread.sleep(4000);
        logoutRepo.getLeftPanelprfl().click();
        Wait.until(ExpectedConditions.elementToBeClickable(logoutRepo.getMyProfile())
        ).click();
        Thread.sleep(3000);
        Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.
                getTutorialSkipButton())).click();
    }

    public void Fill_Profile_Details() throws InterruptedException {
        Thread.sleep(3000);
        prflRepo.getEditProfileicon().click();
        Thread.sleep(3000);
        prflRepo.getEnterUserName().click();
        prflRepo.getEnterUserName().clear();
        Thread.sleep(1000);
        prflRepo.getEnterUserName().sendKeys("Automation User");
        Thread.sleep(3000);
        prflRepo.getEnterDOB().click();
        prflRepo.getEnterDOB().clear();
        Thread.sleep(1000);
        prflRepo.getEnterDOB().sendKeys("01022001");

        if (prflRepo.getMale().isSelected()) {
            Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.getFemale())).
                    click();
            System.out.println("Famale selected");
        }

        if (prflRepo.getFemale().isSelected()) {
            Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.getMale())).click
                    ();
            System.out.println("Male selected");
        }

        Thread.sleep(1000);
        prflRepo.getMale().click();
        System.out.println(2000);
        prflRepo.getEnterAddress().
                sendKeys("Gate No. 8, 275, Gandhi Path W, Guru Jhambeshwar Nagar A, " +
                        "Vaishali Nagar, Jaipur, Rajasthan");
        prflRepo.getEnterPincode().clear();
        prflRepo.getEnterPincode().sendKeys("302021");

        Thread.sleep(2000);
        prflRepo.getUpdateProfileBtn().click();
        Thread.sleep(5000);
        driver.navigate().back();

    }

    public void Change_Password() throws Exception {

        Thread.sleep(2000);
        prflRepo.getEditProfileicon().click();
        Thread.sleep(1000);
        prflRepo.getChangePassword().click();
        Thread.sleep(2000);

        //Blank submit case 1
        prflRepo.getEnterOldpassword().click();
        prflRepo.getEnterNewpassword().click();
        prflRepo.getReEnterNewpassword().click();
        prflRepo.getEnterOldpassword().click();
        Thread.sleep(1000);

        String BodyText1 = prflRepo.getOldPasswrdIsRequired().getText();

        if (validation1.equals(BodyText1)) {
            System.out.println(BodyText1 + ": " +
                    validation1);
        }

        Thread.sleep(1000);

        String BodyText2 = prflRepo.getPasswrdIsRequired().getText();
        if (validation2.equals(BodyText2)) {
            System.out.println(BodyText2 + ": " +
                    validation2);
        }


        Thread.sleep(1000);

        String BodyText3 = prflRepo.getCnfrmPasswrdIsRequired().getText();

        if (validation3.equals(BodyText3)) {

            System.out.println(BodyText3 + ": " + validation3);
        }

        System.out.println("Case1 Passed");


       // Case 2:Check Validation for New and confirm password
        prflRepo.getEnterOldpassword().sendKeys("Arjun@123");
        prflRepo.getEnterNewpassword().click();
        prflRepo.getReEnterNewpassword().click();
        prflRepo.getEnterOldpassword().click();
        Thread.sleep(1000);

        String BodyText21 = prflRepo.getPasswrdIsRequired().getText();

        if (validation2.equals(BodyText21)) {

            System.out.println(BodyText21 + ": " + validation2);
        }


        String BodyText31 = prflRepo.getCnfrmPasswrdIsRequired().getText();

        if (validation3.equals(BodyText31)) {
            System.out.println(BodyText31 + ": " +
                    validation3);
        }

        System.out.println("Case2 Passed");

       // Case 3:Check New and Confirm password not matching
        prflRepo.getEnterOldpassword().clear();
        prflRepo.getEnterOldpassword().sendKeys("Arjun@123");
        prflRepo.getEnterNewpassword().sendKeys("Arjun@123");
        prflRepo.getReEnterNewpassword().sendKeys("rjun@12");
        Thread.sleep(1000);


        String BodyText4 = prflRepo.getPasswrdDoesntMatch().getText();

        if (validation4.equals(BodyText4)) {

            System.out.println(BodyText4 + ":" + validation4);
        }

        System.out.println("Case3 Passed");

        Thread.sleep(2000);

       // Case 4:Change password driver.navigate().refresh();
        Thread.sleep(5000);
        prflRepo.getEnterOldpassword().sendKeys("Arjun@123");
        prflRepo.getEnterNewpassword().sendKeys("Arjun@123");
        prflRepo.getReEnterNewpassword().sendKeys("Arjun@123");
        Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.
                getUpdatePasswordsubmitBtn())).click();

    }

    public void Goto_settings() throws InterruptedException {
        Thread.sleep(3000);
        logoutRepo.getLeftPanelprfl().click();
        Thread.sleep(3000);
        prflRepo.getSettings().click();
    }

    public void Change_Theme() throws InterruptedException {
        Goto_settings();
        Thread.sleep(1000);
        prflRepo.getOpenThemeSection().click();
        Thread.sleep(1000);
        prflRepo.getFifthTheme().click();
        System.out.println("Fifth Theme got selected");
        Thread.sleep(3000);
        driver.navigate().back();
    }

    public void Select_Time_format() throws InterruptedException {

        Goto_settings();
        Thread.sleep(2000);
        prflRepo.getOpenMatchTimeSection().click();

        prflRepo.getHoursformat().click();
        prflRepo.getDateTimeFormat().click();
        prflRepo.getDHMSformate().click();

        if (prflRepo.getDHMSformate().isSelected()) {
            System.out.println(prflRepo.getDHMSformate().isSelected());
            prflRepo.getHoursformat().click();
            //System.out.println(prflRepo.getDHMSformate().isEnabled()); }

            if (prflRepo.getHoursformat().isSelected()) {
                System.out.println(prflRepo.getHoursformat().isSelected());
                prflRepo.getDateTimeFormat().click();
            }

            if (prflRepo.getDateTimeFormat().isSelected()) {
                System.out.println(prflRepo.getDateTimeFormat().isSelected());
                prflRepo.getDHMSformate().click();
            }

            Thread.sleep(3000);

        }

        public void Change_Language() {
            Goto_settings();
            prflRepo.getOpenLanguageSection().click();

            if (prflRepo.getChooseHindi().isSelected()) {
                System.out.println(prflRepo.getChooseHindi().isSelected());

                prflRepo.getChooseEnglish().click();
            }

            if (prflRepo.getChooseEnglish().isSelected()) {

                System.out.println(prflRepo.getChooseEnglish().isSelected());
                prflRepo.getChooseHindi().click();
            }

            driver.navigate().back();
        }

        public void Refer_And_Earn() {
            Wait.until(ExpectedConditions.elementToBeClickable(logoutRepo.getLeftPanelprfl())).click();
            Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.getReferAndEarn())).click();
            Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.
                    getInviteFriendbtn())).click();
            Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.getCopyCode())).
                    click();
            Thread.sleep(5000);
            driver.navigate().back();
        }

        public void Help_desk() {
            Wait.until(ExpectedConditions.elementToBeClickable(logoutRepo.
                    getLeftPanelprfl())).click();
            Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.getSupport())).
                    click();
            actions = new Actions(driver);
            actions.moveToElement(prflRepo.getVerifyEmailsUs()).perform();
            System.out.println("Support features verified");
            driver.navigate().back();
        }
    }
}

*/
