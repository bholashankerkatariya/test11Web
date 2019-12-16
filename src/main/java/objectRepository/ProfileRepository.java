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


	public WebElement getLiveChat() {
		return LiveChat;
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

	
	public WebElement getD_1H_30M_30S() {
		return D_1H_30M_30S;
	}

	public WebElement getOne_hour_left() {
		return One_hour_left;
	}

	public WebElement getSe_3_30() {
		return Se_3_30;
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
	
	@FindBy(xpath = "//li[3]//a[1]")
	private WebElement VerifyEmailsUs;
	
	@FindBy(xpath = "//label[contains(text(),'Male')]")
	private WebElement Male;
	
	@FindBy(xpath = "//label[contains(text(),'Female')]")
	private WebElement Female;
	
	@FindBy(xpath = "//label[contains(text(),'Other')]")
	private WebElement Other;
	
	@FindBy(xpath = "//a[contains(text(),'Refer & Earn')]")
	private WebElement ReferAndEarn;
	
	@FindBy(xpath = "//a[contains(text(),'Support')]")
	private WebElement Support;

	@FindBy(xpath = "//input[@type='password']//a[contains(text(),'Polls')]")
	public WebElement Polls;

	@FindBy(xpath = "//a[contains(text(),'Feedback')]")
	public WebElement Feedback;
	
	@FindBy(xpath = "//a[contains(text(),'Follow Us')]")
	public WebElement FollowUs;
	
	@FindBy(xpath = "//a[contains(text(),'Live Chat')]")
	public WebElement LiveChat;
	
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
	
	@FindBy(xpath = "//span[contains(text(),'1D : 1H : 30M : 30S')]")
	public WebElement D_1H_30M_30S;
	
	@FindBy(xpath = "//span[contains(text(),'1 hour left')]")
	public WebElement One_hour_left;
	
	@FindBy(xpath = "//ul[@class='time_list']//span[contains(text(),'12 Sep 3:30pm')]")
	public WebElement Se_3_30;
	
	@FindBy(xpath = "//a[@class='btn_edit']//img")
	public WebElement EditProfileicon;

	@FindBy(xpath = "//button[@class='btn rank']")
	public WebElement SeriesRank;
	
	@FindBy(xpath = "//input[@class='form-control ng-touched red ng-dirty ng-invalid']") 
	public WebElement EnterUserName;
	
	@FindBy(xpath = "//input[@class='form-control ng-dirty ng-touched red ng-invalid']")
	public WebElement EnterDOB;
	
	@FindBy(xpath = "//div[7]//input[1]")
	public WebElement EnterAddress;
	
	@FindBy(xpath = "//button[@class='foot_btn']")
	public WebElement UpdateProfileBtn;
	
	@FindBy(xpath = "//button[@class='btn white']")
	public WebElement ChangePassword;
	
	@FindBy(xpath = "//input[@class='form-control ng-touched red ng-dirty ng-invalid']")
	public WebElement EnterPincode;
	
	@FindBy(xpath = "//div[@class='profile_form']//div[1]//input[1]")
	public WebElement EnterOldpassword;
	
	@FindBy(xpath = "//div[2]//input[1]")
	public WebElement EnterNewpassword;
	
	@FindBy(xpath = "//div[3]//input[1]")
	public WebElement ReEnterNewpassword;
	
	@FindBy(xpath = "//button[@class='foot_btn']")
	public WebElement UpdatePasswordsubmitBtn;
	
	

}
