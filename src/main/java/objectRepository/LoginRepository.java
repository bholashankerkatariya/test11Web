package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created By: Bhola Shanker Katariya QA @Myteam11
 */

public class LoginRepository {

	@FindBy(xpath = "//input[@type='text']")
	private WebElement refercodetxt;
	
	@FindBy(xpath = "//*[@name='emailmob']")
	private WebElement Usernametxt;

	@FindBy(xpath = "//input[@type='password']")
	public WebElement Passwordtxt;

	@FindBy(xpath = "//img[@alt='eye']")
	private WebElement ViewPassword;

	@FindBy(xpath = "//a[@href='https://www.myteam11.com/android-app-download.html']  ")
	private WebElement AndroidApp;

	@FindBy(xpath = "//a[@href='https://itunes.apple.com/us/app/myteam11/id1221862854?ls=1']")
	private WebElement iosApp;

	@FindBy(xpath = "//a[@class='forgot_pass']")
	private WebElement forgotpasswrd;

	@FindBy(xpath = "//a[@id='signin_fb']")
	private WebElement FacebookLoginButton;

	@FindBy(xpath = "//a[@id='signin_gm']")
	private WebElement GoogleLoginButton;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement Signinbtn;

	@FindBy(xpath = "//a[@routerlink='login' or contains(text(),'Sign In')]")
	private WebElement signinlnk;

	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	private WebElement Signupbtn;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement Submitbtn;

	@FindBy(xpath = "//*[@class='alert_box_wraper']")
	private WebElement NotificationMessage;

	@FindBy(xpath = "//*[@class='introjs-button introjs-skipbutton']")
	private WebElement tutorialSkipButton;

	@FindBy(xpath = "//*[@class='avtar menu_toggle']//img")
	private WebElement UserProfileImage;

	@FindBy(xpath = "//*[@class='main_menu']/child::li[1]")
	private WebElement MainMenuProfiletab;

	@FindBy(xpath = "//*[@class='btn logout']")
	private WebElement Logout_btn;

	@FindBy(xpath = "//*[@id='identifierId' and @type= 'email']")
	private WebElement PopUp_emailbox;

	@FindBy(xpath = "//*[@class='whsOnd zHQkBf' and @type= 'password']")
	private WebElement PopUp_Passwordbox;

	@FindBy(xpath = "//*[@id ='identifierNext' and @tabindex='0']")
	private WebElement PopUp_NextBtn;

	@FindBy(xpath = "//*[@id='passwordNext' and @tabindex='0']")
	private WebElement Popup_PasswordNextbtn;

	@FindBy(xpath = "//input[@id='email']") 
	private WebElement FacebookEmailTextBox;

	@FindBy(xpath = "//*[@id='pass']")
	private WebElement FacebookPasswordTextBox;
	
	@FindBy(xpath = "//*[@id='identifierId' and @type='email']")
	private WebElement GoogleEmailTextBox;
	
	public WebElement getGoogleEmailTextBox() {
		return GoogleEmailTextBox;
	}

	public WebElement getGooglePopUpNextButton() {
		return GooglePopUpNextButton;
	}

	public WebElement getGooglePasswordTextBox() {
		return GooglePasswordTextBox;
	}

	public WebElement getGooglePopUpPasswordNextButton() {
		return GooglePopUpPasswordNextButton;
	}

	@FindBy(xpath = "//*[@id=\"identifierNext\"]")
	private WebElement GooglePopUpNextButton;
	
	@FindBy(xpath = "//*[@type=\"password\"]")
	private WebElement GooglePasswordTextBox;
	
	@FindBy(xpath = "//*[@id=\"passwordNext\"]")
	private WebElement GooglePopUpPasswordNextButton;

	/**
	 * @return the facebookPasswordTextBox
	 */
	public WebElement getFacebookPasswordTextBox() {
		return FacebookPasswordTextBox;
	}

	@FindBy(xpath = "//label[@id='loginbutton']")
	private WebElement FacebookLoginsubmit;

	/**
	 * @return the facebookEmailTextBox
	 */
	public WebElement getFacebookEmailTextBox() {
		return FacebookEmailTextBox;
	}

	/**
	 * @return the facebookLoginbtn
	 */
	public WebElement getFacebookLoginsubmit() {
		return FacebookLoginsubmit;
	}

	/**
	 * @return the popup_PasswordNextbtn
	 */
	public WebElement getPopup_PasswordNextbtn() {
		return Popup_PasswordNextbtn;
	}

	/**
	 * @return the popUp_NextBtn
	 */
	public WebElement getPopUp_NextBtn() {
		return PopUp_NextBtn;
	}

	/**
	 * @return the popUp_Passwordbox
	 */
	public WebElement getPopUp_Passwordbox() {
		return PopUp_Passwordbox;
	}

	/**
	 * @return the popUp_emailbox
	 */
	public WebElement getPopUp_emailbox() {
		return PopUp_emailbox;
	}

	/**
	 * @return the logout_btn
	 */
	public WebElement getLogout_btn() {
		return Logout_btn;
	}

	/**
	 * @return the mainMenuProfiletab
	 */
	public WebElement getMainMenuProfiletab() {
		return MainMenuProfiletab;
	}

	/**
	 * @return the userProfileImage
	 */
	public WebElement getUserProfileImage() {
		return UserProfileImage;
	}

	/**
	 * @return the tutorialSkipButton
	 */
	public WebElement getTutorialSkipButton() {
		return tutorialSkipButton;
	}

	/**
	 * @return the usernametxt
	 */
	public WebElement getUsernametxt() {
		return Usernametxt;
	}

	/**
	 * @return the notificationMessage
	 */
	public WebElement getNotificationMessage() {
		return NotificationMessage;
	}

	/**
	 * @param notificationMessage the notificationMessage to set
	 */

	/**
	 * @return the passwordtxt
	 */
	public WebElement getPasswordtxt() {
		return Passwordtxt;
	}

	/**
	 * @return the viewPassword
	 */
	public WebElement getViewPassword() {
		return ViewPassword;
	}

	/**
	 * @return the androidApp
	 */
	public WebElement getAndroidApp() {
		return AndroidApp;
	}

	/**
	 * @return the iosApp
	 */
	public WebElement getIosApp() {
		return iosApp;
	}

	/**
	 * @return the forgotpasswrd
	 */
	public WebElement getForgotpasswrd() {
		return forgotpasswrd;
	}

	/**
	 * @return the loginFB
	 */
	public WebElement getFacebookLoginButton() {
		return FacebookLoginButton;
	}

	/**
	 * @return the loginGgl
	 */
	public WebElement getGoogleLoginButton() {
		return GoogleLoginButton;
	}

	/**
	 * @return the signinbtn
	 */
	public WebElement getSigninbtn() {
		return Signinbtn;
	}

	/**
	 * @return the refercodetxt
	 */
	public WebElement getRefercodetxt() {
		return refercodetxt;
	}

	/**
	 * @return the signinlnk
	 */
	public WebElement getSigninlnk() {
		return signinlnk;
	}

	/**
	 * @return the signupbtn
	 */
	public WebElement getSignupbtn() {
		return Signupbtn;
	}

	/**
	 * @return the submitbtn
	 */
	public WebElement getSubmitbtn() {
		return Submitbtn;
	}

}
