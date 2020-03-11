package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created By: Bhola Shanker Katariya QA @Myteam11
 */

public class ProfileRepository {

	public WebElement getReferAndEarn() {
		return ReferAndEarn;
	}

	public WebElement getSupport() {
		return Support;
	}

	public WebElement getPolls() {
		return Polls;
	}

	public WebElement getFeedback() {
		return Feedback;
	}


	public WebElement getFollowUs() {
		return FollowUs;
	}

	public WebElement getSettings() {
		return Settings;
	}

	public WebElement getCopyCode() {
		return CopyCode;
	}

	public WebElement getGoogleContacts() {
		return GoogleContacts;
	}

	public WebElement getShareOnFBInvitation() {
		return ShareOnFBInvitation;
	}

	public WebElement getCloseInvitefriendPopup() {
		return CloseInvitefriendPopup;
	}

	public WebElement getVerifyNodatafoundtext() {
		return VerifyNodatafoundtext;
	}
	
	public WebElement getTitleFeedback() {
		return TitleFeedback;
	}
	
	public WebElement getSlctCategoryfeedback() {
		return SlctCategoryfeedback;
	}

	public WebElement getEnterMessageFeedback() {
		return EnterMessageFeedback;
	}

	public WebElement getSubmitFeedback() {
		return SubmitFeedback;
	}

	public WebElement getVerifySocialmediaAvailable() {
		return verifySocialmediaAvailable;
	}

	public WebElement getVerifyInstaGram() {
		return VerifyInstaGram;
	}

	public WebElement getVerifyFacebook() {
		return VerifyFacebook;
	}


	public WebElement getVerifyYoutube() {
		return VerifyYoutube;
	}

	public WebElement getVerifyTwitter() {
		return VerifyTwitter;
	}

	public WebElement getOpenLanguageSection() {
		return openLanguageSection;
	}

	public WebElement getChooseEnglish() {
		return ChooseEnglish;
	}

	public WebElement getChooseHindi() {
		return ChooseHindi;
	}


	public WebElement getOpenThemeSection() {
		return OpenThemeSection;
	}

	
	public WebElement getFirstTheme() {
		return FirstTheme;
	}

	public WebElement getScndTheme() {
		return ScndTheme;
	}

	public WebElement getThirdTheme() {
		return ThirdTheme;
	}

	public WebElement getFourthTheme() {
		return FourthTheme;
	}
	
	public WebElement getFifthTheme() {
		return FifthTheme;
	}

	public WebElement getSixthTheme() {
		return SixthTheme;
	}
	
	public WebElement getOpenMatchTimeSection() {
		return OpenMatchTimeSection;
	}

	
	public WebElement getDHMSformate() {
		return DHMSformate;
	}

	public WebElement getHoursformat() {
		return Hoursformat;
	}

	public WebElement getDateTimeFormat() {
		return DateTimeFormat;
	}
	
	public WebElement getUpdatePasswordsubmitBtn() {
		return UpdatePasswordsubmitBtn;
	}
	
	
	public WebElement getEditProfileicon() {
		return EditProfileicon;
	}

	
	public WebElement getEnterDOB() {
		return EnterDOB;
	}

	public WebElement getEnterAddress() {
		return EnterAddress;
	}
	
	public WebElement getUpdateProfileBtn() {
		return UpdateProfileBtn;
	}
	
	public WebElement getChangePassword() {
		return ChangePassword;
	}
	
	public WebElement getEnterPincode() {
		return EnterPincode;
	}
	
	public WebElement getEnterUserName() {
		return EnterUserName;
	}
	
	public WebElement getMale() {
		return Male;
	}
	
	public WebElement getFemale() {
		return Female;
	}
	
	public WebElement getOther() {
		return Other;
	}
	
	public WebElement getEnterOldpassword() {
		return EnterOldpassword;
	}
	
	public WebElement getEnterNewpassword() {
		return EnterNewpassword;
	}
	
	public WebElement getReEnterNewpassword() {
		return ReEnterNewpassword;
	}
	
	public WebElement getInviteFriendbtn() {
		return InviteFriendbtn;
	}
	
	public WebElement getVerifyEmailsUs() {
		return VerifyEmailsUs;
	}
	
	public WebElement getOldPasswrdIsRequired() {
		return OldPasswrdIsRequired;
	}
	
	public WebElement getPasswrdIsRequired() {
		return PasswrdIsRequired;
	}
	
	public WebElement getCnfrmPasswrdIsRequired() {
		return CnfrmPasswrdIsRequired;
	}
	
	public WebElement getPasswrdDoesntMatch() {
		return PasswrdDoesntMatch;
	}
	
	
	@FindBy(xpath = "//span[contains(text(),'Password does not match')]")
	private WebElement PasswrdDoesntMatch;
	
	@FindBy(xpath = "//Span[contains(text(),'Confirm password is required.')]")
	private WebElement CnfrmPasswrdIsRequired;
	
	@FindBy(xpath = "//Span[contains(text(),'Password is required.')]")
	private WebElement PasswrdIsRequired;
	
	@FindBy(xpath = "//Span[contains(text(),'Old Password is required')]")
	private WebElement OldPasswrdIsRequired;
	
	@FindBy(xpath = "//div[@class='support_services']//li[3]//a[1]")
	private WebElement VerifyEmailsUs;
	
	@FindBy(xpath = "//label[contains(text(),'Male')]") ////input[@id='gen1']
	private WebElement Male;
	
	@FindBy(xpath = "//label[contains(text(),'Female')]")
	private WebElement Female;
	
	@FindBy(xpath = "//label[contains(text(),'Other')]")
	private WebElement Other;
	
	@FindBy(xpath = "//a[contains(text(),'Refer & Earn')]")
	private WebElement ReferAndEarn;
	
	@FindBy(xpath = "//a[contains(text(),'Support')]")
	private WebElement Support;

	@FindBy(xpath = "//a[contains(text(),'Polls')]")
	public WebElement Polls;

	@FindBy(xpath = "//a[contains(text(),'Feedback')]")
	public WebElement Feedback;
	
	@FindBy(xpath = "//a[contains(text(),'Follow Us')]")
	public WebElement FollowUs;
	
	@FindBy(xpath = "//a[contains(text(),'Settings')]")
	public WebElement Settings;
	
	//Refer and Earn friends
	@FindBy(xpath = "//button[@class='btn white']")
	public WebElement InviteFriendbtn;
	
	@FindBy(xpath = "//a[contains(text(),'COPY CODE')]")
	public WebElement CopyCode;
	
	@FindBy(xpath = "//a[@class='foot_btn']")
	public WebElement GoogleContacts;
	
	@FindBy(xpath = "//app-refer-n-earn//a[1]//img[1]")
	public WebElement ShareOnFBInvitation;
	
	@FindBy(xpath = "//a[@class='close_line']")
	public WebElement CloseInvitefriendPopup;
	
	//Polls
	@FindBy(xpath = "//span[@class='text']")
	public WebElement VerifyNodatafoundtext;
	
	//Feedback
	@FindBy(xpath = "//input[@placeholder='Title *']")
	public WebElement TitleFeedback;
	
	@FindBy(xpath = "//select[@name='category']")
	public WebElement SlctCategoryfeedback;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter Your Message here *']")
	public WebElement EnterMessageFeedback;
	
	@FindBy(xpath = "//button[@class='foot_btn']")
	public WebElement SubmitFeedback;
	
	//Social media
	@FindBy(xpath = "//h2[contains(text(),'FOLLOW US ON SOCIAL MEDIA')]")
	public WebElement verifySocialmediaAvailable;
	
	@FindBy(xpath = "//span[contains(text(),'Instagram')]")
	public WebElement VerifyInstaGram;
	
	@FindBy(xpath = "//span[@class='text'][contains(text(),'Facebook')]")
	public WebElement VerifyFacebook;
	
	@FindBy(xpath = "//span[contains(text(),'Youtube')]")
	public WebElement VerifyYoutube;
	
	@FindBy(xpath = "//span[contains(text(),'Twitter')]")
	public WebElement VerifyTwitter;
	
	//Language Section elements
	@FindBy(xpath = "//p[contains(text(),'Language')]")
	public WebElement openLanguageSection;
	
	@FindBy(xpath = "//span[contains(text(),'ENGLISH')]")
	public WebElement ChooseEnglish;
	
	@FindBy(xpath = "//span[contains(text(),'हिंदी')]")
	public WebElement ChooseHindi;
	
	//theme section elements
	@FindBy(xpath = "//p[contains(text(),'Color Theme')]")
	public WebElement OpenThemeSection;
	
	@FindBy(xpath = "//div[@id='three']//li[1]")
	public WebElement FirstTheme;
	
	@FindBy(xpath = "//div[@id='three']//li[2]")
	public WebElement ScndTheme;
	
	@FindBy(xpath = "//div[@id='three']//li[3]")
	public WebElement ThirdTheme;
	
	@FindBy(xpath = "//div[@id='three']//li[4]")
	public WebElement FourthTheme;
	
	@FindBy(xpath = "//div[@id='three']//li[5]")
	public WebElement FifthTheme;
	
	@FindBy(xpath = "//div[@id='three']//li[6]")
	public WebElement SixthTheme;
	
	@FindBy(xpath = "//p[contains(text(),'Match Time')]")
	public WebElement OpenMatchTimeSection;
	
	@FindBy(xpath = "//ul[@class='time_list']/li[1]/label/span")
	public WebElement DHMSformate;
	
	@FindBy(xpath = "//ul[@class='time_list']/li[2]/label/span")
	public WebElement Hoursformat;
	
	@FindBy(xpath = "//ul[@class='time_list']/li[3]/label/span")
	public WebElement DateTimeFormat;
	
	@FindBy(xpath = "//a[@class='btn_edit']")
	public WebElement EditProfileicon;

	@FindBy(xpath = "//button[@class='btn rank']")
	public WebElement SeriesRank;
	
	@FindBy(xpath = "//input[@formcontrolname='Name']") 
	public WebElement EnterUserName;
	
	@FindBy(xpath = "//input[@formcontrolname='DOB']")
	public WebElement EnterDOB;
	
	@FindBy(xpath = "//div[7]//input[1]") //input[@formcontrolname='Address']
	public WebElement EnterAddress;
	
	@FindBy(xpath = "//button[@class='foot_btn']")
	public WebElement UpdateProfileBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Change Password')]")
	public WebElement ChangePassword;
	
	@FindBy(xpath = "//input[@formcontrolname='Zip']")
	public WebElement EnterPincode;
	
	@FindBy(xpath = "//input[@formcontrolname='oldPassowrd']")
	public WebElement EnterOldpassword;
	
	@FindBy(xpath = "//input[@formcontrolname='passowrd']")
	public WebElement EnterNewpassword;
	
	@FindBy(xpath = "//input[@formcontrolname='cPassowrd']")
	public WebElement ReEnterNewpassword;
	
	@FindBy(xpath = "//button[@class='foot_btn']")
	public WebElement UpdatePasswordsubmitBtn;

	@FindBy(xpath = "//span[@class='notification']")
	private WebElement earntext;

	public WebElement getEarntext() {
		return earntext;
	}

	@FindBy(xpath = "//div[@class='app_center hight_full']//li[1]//a[1]")
	private WebElement CallUs;

	public WebElement getCallUs() {
		return CallUs;
	}

	@FindBy(xpath = "//div[@class='app_center hight_full']//li[2]//a[1]")
	private WebElement LiveChat;

	public WebElement getLiveChat() {
		return LiveChat;
	}

	@FindBy(xpath = "//div[@class='app_center hight_full']//li[4]//a[1]")
	private WebElement Faqs;

	public WebElement getFaqs() {
		return Faqs;
	}
}
