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

	public LeftMenuPanel(WebDriver _driver, WebDriverWait _Wait) {
		driver = _driver;
		Wait = _Wait;
		logoutRepo = PageFactory.initElements(driver, LogOutRepository.class);
		loginRepo = PageFactory.initElements(driver, LoginRepository.class);
		prflRepo = PageFactory.initElements(driver, ProfileRepository.class);
	}

	@DataProvider(name = "Login")
	public Object[][] CSVReader() throws Exception {
		return CSVDataReader.DDTReader("ddt/LoginPage.csv");
	}

	public void Go_To_profile() throws InterruptedException {
		Thread.sleep(4000);
		logoutRepo.getLeftPanelprfl().click();
		Wait.until(ExpectedConditions.elementToBeClickable(logoutRepo.getMyProfile())).click();
		Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getTutorialSkipButton())).click();
	}

	public void Fill_Profile_Details() {

		Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.getEditProfileicon())).click();
		Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.getEnterUserName())).sendKeys("Automation User");	
		Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.getEnterDOB())).sendKeys("01022001");
		Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.getFemale())).click();
		prflRepo.getEnterAddress().sendKeys("Gate No. 8, 275, Gandhi Path W, Guru Jhambeshwar Nagar A, "
				+ "Vaishali Nagar, Jaipur, Rajasthan 302021");
		prflRepo.getEnterPincode().sendKeys("302021");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		prflRepo.getUpdateProfileBtn().click();

	}

	public void Change_Password() {
		Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.getEditProfileicon())).click();
		prflRepo.getChangePassword().click();
		Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.getEnterOldpassword())).sendKeys("Arjun@123");
		prflRepo.getEnterNewpassword().sendKeys("Arjun@123");
		prflRepo.getReEnterNewpassword().sendKeys("Arjun@123");
		Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.getUpdatePasswordsubmitBtn())).click();
		driver.navigate().to("https://www.myteam11.com/fantasy-sports/menu/home");
	}

	public void Change_Theme() {
		logoutRepo.getLeftPanelprfl().click();
		Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.getSettings())).click();
		prflRepo.getOpenThemeSection().click();
		prflRepo.getFifthTheme().click();
		driver.navigate().back();
	}

	public void Select_Time_format() {
		Wait.until(ExpectedConditions.elementToBeClickable(logoutRepo.getLeftPanelprfl())).click();
		Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.getSettings())).click();
		prflRepo.getOpenMatchTimeSection().click();
		prflRepo.getOne_hour_left().click();
		prflRepo.getOpenMatchTimeSection().click();
		driver.navigate().back();
	}

	public void Change_Language() {
		Wait.until(ExpectedConditions.elementToBeClickable(logoutRepo.getLeftPanelprfl())).click();
		Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.getSettings())).click();
		prflRepo.getOpenLanguageSection().click();

		if (prflRepo.getChooseHindi().isSelected()) {

			prflRepo.getChooseEnglish().click();
		}

		if (prflRepo.getChooseEnglish().isSelected()) {

			prflRepo.getChooseHindi().click();
		}

		driver.navigate().back();

	}

	public void Refer_And_Earn() throws Exception {
		Wait.until(ExpectedConditions.elementToBeClickable(logoutRepo.getLeftPanelprfl())).click();
		Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.getReferAndEarn())).click();
		Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.getInviteFriendbtn())).click();
		Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.getCopyCode())).click();
		Thread.sleep(5000);
		driver.navigate().back();
	}

	public void Help_desk() {
		Wait.until(ExpectedConditions.elementToBeClickable(logoutRepo.getLeftPanelprfl())).click();
		Wait.until(ExpectedConditions.elementToBeClickable(prflRepo.getSupport())).click();
		actions = new Actions(driver);
		actions.moveToElement(prflRepo.getVerifyEmailsUs()).perform();
		System.out.println("Support features verified");
		driver.navigate().back();
	}
	
	

}