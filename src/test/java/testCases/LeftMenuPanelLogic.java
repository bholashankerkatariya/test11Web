package testCases;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import objectRepository.LogOutRepository;
import objectRepository.LoginRepository;
import objectRepository.ProfileRepository;
import testclass.SocialMediaLoginTest;
import utils.CSVDataReader;

public class LeftMenuPanelLogic {

    WebDriver driver;
    WebDriverWait Wait;
    LoginRepository loginRepo;
    LogOutRepository logoutRepo;
    ProfileRepository prflRepo;
    JavascriptExecutor js;
    Actions actions;

    String validation1 = "Old Password is required";
    String validation2 = "Password is required.";
    String validation3 = "Confirm password is required.";
    String validation4 = "Password does not match";

    public LeftMenuPanelLogic(WebDriver _driver, WebDriverWait _Wait) {
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
        Thread.sleep(2000);
        logoutRepo.getMyProfile().click();
        Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getTutorialSkipButton())).click();
    }

    public void ReferAndEarn() throws InterruptedException {
        logoutRepo.getLeftPanelprfl().click();
        Thread.sleep(3000);
        String earn = prflRepo.getEarntext().getText();
        System.out.println(earn);

        prflRepo.getReferAndEarn().click();
        Thread.sleep(2000);
        driver.navigate().back();
    }

    public void Fill_Profile_Details() throws InterruptedException {
        Go_To_profile();
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

        if (prflRepo.getMale().isEnabled()) {
            Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.getFemale())).click();
            //System.out.println("Famale Gender selected");
        }
        else {
                Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.getMale())).click();
                //System.out.println("Male Gender selected");
            }

        if (prflRepo.getFemale().isEnabled()) {
            Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.getMale())).click();
            //System.out.println("Male Gender selected");
        }
        else {
                prflRepo.getFemale().click();
                //System.out.println("FeMale Gender selected");
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
        Thread.sleep(2000);
        driver.navigate().back();

    }

    public void Change_Password() throws Exception {

        Go_To_profile();
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
        prflRepo.getEnterOldpassword().clear();
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
        Thread.sleep(2000);

        // Case 3:Check New and Confirm password not matching
        prflRepo.getEnterOldpassword().clear();
        prflRepo.getEnterOldpassword().sendKeys("Arjun@123");
        prflRepo.getEnterNewpassword().clear();
        prflRepo.getEnterNewpassword().sendKeys("Arjun@123");
        prflRepo.getReEnterNewpassword().clear();
        prflRepo.getReEnterNewpassword().sendKeys("jun@12");
        Thread.sleep(1000);

        String BodyText4 = prflRepo.getPasswrdDoesntMatch().getText();

        if (validation4.equals(BodyText4)) {

            System.out.println(BodyText4 + ":" + validation4);
        }

        System.out.println("Case3 Passed");

        // Case 4:Change password
        Thread.sleep(2000);
        prflRepo.getEnterOldpassword().clear();
        prflRepo.getEnterOldpassword().sendKeys("Arjun@123");
        prflRepo.getEnterNewpassword().clear();
        prflRepo.getEnterNewpassword().sendKeys("Arjun@123");
        prflRepo.getReEnterNewpassword().clear();
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

        if (prflRepo.getFirstTheme().isEnabled()) {
            prflRepo.getScndTheme().click();
            System.out.println("Second Theme got selected");
        }

        if (prflRepo.getScndTheme().isEnabled()) {
            prflRepo.getThirdTheme().click();
            System.out.println("Third Theme got selected");
        }

        if (prflRepo.getThirdTheme().isEnabled()) {
            prflRepo.getFourthTheme().click();
            System.out.println("Fourth Theme got selected");
        }

        if (prflRepo.getFourthTheme().isEnabled()) {
            prflRepo.getFifthTheme().click();
            System.out.println("Fifth Theme got selected");
        }

        if (prflRepo.getFifthTheme().isEnabled()) {
            prflRepo.getFirstTheme().click();
            System.out.println("First Theme got selected");
        }

        Thread.sleep(3000);
        driver.navigate().back();
    }

    public void Select_Time_format() throws InterruptedException {

        Goto_settings();
        Thread.sleep(2000);
        prflRepo.getOpenMatchTimeSection().click();

        prflRepo.getDHMSformate().click();
        prflRepo.getHoursformat().click();
        prflRepo.getDateTimeFormat().click();
        //boolean Hoursformate = prflRepo.getHoursformat() != true;
        if (prflRepo.getDHMSformate().isEnabled()) {
            System.out.println(prflRepo.getDHMSformate().isSelected());
            prflRepo.getHoursformat().click();
            //System.out.println(prflRepo.getDHMSformate().isEnabled());
        } else {
            prflRepo.getDHMSformate().click();
        }

        if (prflRepo.getHoursformat().isEnabled()) {
            System.out.println(prflRepo.getHoursformat().isSelected());
            prflRepo.getDateTimeFormat().click();
        } else {
            prflRepo.getHoursformat().click();
        }

        if (prflRepo.getDateTimeFormat().isEnabled()) {
            System.out.println(prflRepo.getDateTimeFormat().isSelected());
            prflRepo.getDHMSformate().click();
        }else{
            prflRepo.getDateTimeFormat().click();
        }

        Thread.sleep(3000);
        driver.navigate().back();
    }


    public void Change_Language() throws InterruptedException {
        Goto_settings();
        prflRepo.getOpenLanguageSection().click();
        boolean Hindi = prflRepo.getChooseHindi() != null;
        if (Hindi) {
            System.out.println(Hindi);
            prflRepo.getChooseEnglish().click();
        } else {
            prflRepo.getChooseHindi().click();
        }

        boolean English = prflRepo.getChooseEnglish() != null;
        if (English) {
            System.out.println(English);
            prflRepo.getChooseHindi().click();
        } else{
            prflRepo.getChooseEnglish().click();
        }

        driver.navigate().back();
    }


    public void Support() throws InterruptedException {

        Wait.until(ExpectedConditions.elementToBeClickable(logoutRepo.getLeftPanelprfl())).click();
        Thread.sleep(2000);
        prflRepo.getSupport().click();
        Thread.sleep(2000);
        actions = new Actions(driver);
        actions.moveToElement(prflRepo.getVerifyEmailsUs()).perform();
        Thread.sleep(200);
       String call = prflRepo.getCallUs().getText();
        System.out.println(call);

       String livechat = prflRepo.getLiveChat().getText();
        System.out.println(livechat);

        String email = prflRepo.getVerifyEmailsUs().getText();
        System.out.println(email);

        String faqs = prflRepo.getFaqs().getText();
        System.out.println(faqs);
        prflRepo.getFaqs().click();
        Thread.sleep(1000);

      /*  try {
            for (int j = 0; j <10; j++) {
                js.executeScript("$(\".scroling_div\").scrollTop(99999999999999999999999999999);");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } */
        driver.navigate().back();
        driver.navigate().back();
    }


    public void polls() throws InterruptedException {

        Wait.until(ExpectedConditions.elementToBeClickable(logoutRepo.getLeftPanelprfl())).click();
        Thread.sleep(2000);
        prflRepo.getPolls().click();
        if(prflRepo.getVerifyNodatafoundtext().isDisplayed()){
          String message =  prflRepo.getVerifyNodatafoundtext().getText();
          System.out.println(message);
        }
         driver.navigate().back();
    }

}

