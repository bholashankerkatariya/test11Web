package testCases;

import objectRepository.LoginRepository;
import objectRepository.SignUpObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import utils.ApiCallForOtp;
import utils.Browser;
import utils.CSVDataReader;

public class SignUpLogic {

	public WebDriver driver;
	public WebDriverWait Wait;
	Browser browser;
	LoginRepository loginRepo;
	SignUpObjectRepository signupRepo;
	Actions actions;

	public SignUpLogic(WebDriver _driver, WebDriverWait _Wait) {
		driver = _driver;
		Wait = _Wait;

		loginRepo = PageFactory.initElements(driver, LoginRepository.class);
		signupRepo = PageFactory.initElements(driver, SignUpObjectRepository.class);
	}


	@DataProvider(name = "Signup")
	public Object[][] CSVReader() throws Exception {
		return CSVDataReader.DDTReader("ddt/Signup.csv");
	}

	public void Register_New_User(String Email, String Password, String ReferralCode, String MobileNumber,
			String UserName, String Status) {
		actions = new Actions(driver);
		actions.moveToElement(signupRepo.getSignUpLink()).perform();

		Wait.until(ExpectedConditions.elementToBeClickable(signupRepo.getSignUpLink())).click();
		Wait.until(ExpectedConditions.elementToBeClickable(signupRepo.getEnterEmail())).clear();
		signupRepo.getEnterEmail().sendKeys(Email);
		signupRepo.getEnterPassword().clear();
		signupRepo.getEnterPassword().sendKeys(Password);
		Wait.until(ExpectedConditions.elementToBeClickable(signupRepo.getOpenReferralfields())).click();
		Wait.until(ExpectedConditions.elementToBeClickable(signupRepo.getEnterReferralCode())).clear();
		signupRepo.getEnterReferralCode().sendKeys(ReferralCode);

		actions.moveToElement(signupRepo.getSignUpSubmtbtn()).perform();

		Wait.until(ExpectedConditions.elementToBeClickable(signupRepo.getSignUpSubmtbtn())).click();

	}

	public void OTP_Process(String Email, String Password, String ReferralCode, String MobileNumber, String UserName,
			String Status) {

		Wait.until(ExpectedConditions.elementToBeClickable(signupRepo.getEnterMobileNumber())).clear();
		signupRepo.getEnterMobileNumber().sendKeys(MobileNumber);
		signupRepo.getSendOTPbtn().click();

		ApiCallForOtp obj = new ApiCallForOtp();
		String otp = obj.GetOtp(MobileNumber);

		Wait.until(ExpectedConditions.elementToBeClickable(signupRepo.getOtpBoxes())).sendKeys(otp);

		Wait.until(ExpectedConditions.elementToBeClickable(signupRepo.getVerifyOTP())).click();

	}

	public void Almost_done(String Email, String Password, String ReferralCode, String MobileNumber, String UserName,
			String Status) {
		Wait.until(ExpectedConditions.elementToBeClickable(signupRepo.getPickTeamName())).click();
		Wait.until(ExpectedConditions.elementToBeClickable(signupRepo.getUsername())).sendKeys(UserName);
		Wait.until(ExpectedConditions.elementToBeClickable(signupRepo.getState())).sendKeys("Rajasthan");

		actions.moveToElement(signupRepo.getLetsPlaybtn()).perform();

		Wait.until(ExpectedConditions.elementToBeClickable(signupRepo.getLetsPlaybtn())).click();
		Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getTutorialSkipButton())).click();
	}

	public void ForgotPassword(String Email, String Password, String ReferralCode, String MobileNumber, String UserName,
			String Status) {
		Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getSigninlnk())).click();
		Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getForgotpasswrd())).click();
		Wait.until(ExpectedConditions.elementToBeClickable(signupRepo.getEnterMobileNumber())).clear();
		Wait.until(ExpectedConditions.elementToBeClickable(signupRepo.getEnterMobileNumber())).sendKeys(MobileNumber);
		signupRepo.getSendOTPbtn().click();

		ApiCallForOtp obj = new ApiCallForOtp();
		String otp = obj.GetOtp(MobileNumber);

		Wait.until(ExpectedConditions.elementToBeClickable(signupRepo.getOtpBoxes())).sendKeys(otp);

		Wait.until(ExpectedConditions.elementToBeClickable(signupRepo.getVerifyOTP())).click();

		Wait.until(ExpectedConditions.elementToBeClickable(signupRepo.getEnterNewPassword())).clear();

		Wait.until(ExpectedConditions.elementToBeClickable(signupRepo.getEnterNewPassword())).sendKeys("Arjun@1234");

		Wait.until(ExpectedConditions.elementToBeClickable(signupRepo.getRe_EnterNewPassword())).clear();

		Wait.until(ExpectedConditions.elementToBeClickable(signupRepo.getRe_EnterNewPassword())).sendKeys("Arjun@1234");

		Wait.until(ExpectedConditions.elementToBeClickable(signupRepo.getCreatePassword())).click();

	}

}
