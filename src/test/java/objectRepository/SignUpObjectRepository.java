package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpObjectRepository {

	public WebElement getSignUpLink() {
		return SignUpLink;
	}

	public WebElement getEnterEmail() {
		return EnterEmail;
	}

	public WebElement getEnterPassword() {
		return EnterPassword;
	}

	public WebElement getOpenReferralfields() {
		return OpenReferralfields;
	}

	public WebElement getEnterReferralCode() {
		return EnterReferralCode;
	}

	public WebElement getViewPassword() {
		return ViewPassword;
	}

	public WebElement getSignUpSubmtbtn() {
		return SignUpSubmtbtn;
	}

	public WebElement getPickTeamName() {
		return PickTeamName;
	}

	public WebElement getUsername() {
		return Username;
	}

	public WebElement getState() {
		return State;
	}

	public WebElement getLetsPlaybtn() {
		return LetsPlaybtn;
	}

	public WebElement getEnterMobileNumber() {
		return EnterMobileNumber;
	}

	public WebElement getSendOTPbtn() {
		return SendOTPbtn;
	}

	public WebElement getOTPBoxes() {
		return OTPBoxes;
	}

	public WebElement getVerifyOTP() {
		return VerifyOTP;
	}

	@FindBy(xpath = "//a[contains(text(),'Sign up')]")
	private WebElement SignUpLink;

	@FindBy(xpath = "//input[@placeholder='Enter Email *']")
	private WebElement EnterEmail;

	@FindBy(xpath = "//input[@placeholder='Enter Your Password *']")
	private WebElement EnterPassword;

	@FindBy(xpath = "//a[@id='singnup_i_have_referral_code']")
	private WebElement OpenReferralfields;

	@FindBy(xpath = "//input[@placeholder='Referral Code (Optional)']")
	private WebElement EnterReferralCode;

	@FindBy(xpath = "//a[@class='field-icon toggle-password']//img")
	private WebElement ViewPassword;

	@FindBy(xpath = "//button[@id='singnup_register']")
	private WebElement SignUpSubmtbtn;

	@FindBy(xpath = "//*[@class='suggestion_div']/a[1]")
	private WebElement PickTeamName;

	@FindBy(xpath = "//input[@placeholder='Your Full Name']")
	private WebElement Username;

	@FindBy(xpath = "//select[@name='state']")
	private WebElement State;

	@FindBy(xpath = "//button[@class='btn blue_btn']")
	private WebElement LetsPlaybtn;

	@FindBy(xpath = "//input[@placeholder='Mobile Number']")
	private WebElement EnterMobileNumber;

	@FindBy(xpath = "//button[@class='btn blue_btn']")
	private WebElement SendOTPbtn;

	@FindBy(xpath = "//div[@class='otpBox']")
	private WebElement OTPBoxes;

	@FindBy(xpath = "//button[contains(text(),'Verify')]")
	private WebElement VerifyOTP;

	/*
	 * @FindBy(xpath = "//input[@name='a']") private WebElement OTPBoxe1;
	 * 
	 * @FindBy(xpath = "//input[@name='b']") private WebElement OTPBoxe2;
	 * 
	 * @FindBy(xpath = "//input[@name='c']") private WebElement OTPBoxe3;
	 * 
	 * @FindBy(xpath = "//input[@name='d']") private WebElement OTPBoxe4;
	 * 
	 * @FindBy(xpath = "//input[@name='e']") private WebElement OTPBoxe5;
	 * 
	 * @FindBy(xpath = "//input[@name='f']") private WebElement OTPBoxe6;
	 */

	@FindBy(xpath = "//*[@class='otp ng-untouched ng-pristine ng-valid']")
	private WebElement OtpBoxes;

	public WebElement getOtpBoxes() {
		return OtpBoxes;
	}

	@FindBy(xpath = "//input[@placeholder='Enter Password']")
	private WebElement EnterNewPassword;

	public WebElement getEnterNewPassword() {
		return EnterNewPassword;
	}

	@FindBy(xpath = "//input[@placeholder='Re-enter Password']")
	private WebElement Re_EnterNewPassword;

	public WebElement getRe_EnterNewPassword() {
		return Re_EnterNewPassword;
	}
	
	@FindBy(xpath = "//button[@class='btn blue_btn']")
	private WebElement CreatePassword;

	public WebElement getCreatePassword() {
		return CreatePassword;
	}
}
