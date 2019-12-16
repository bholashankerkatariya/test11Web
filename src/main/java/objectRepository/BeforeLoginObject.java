package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BeforeLoginObject {
	
	@FindBy(xpath = "//a[@class='btn blue_btn']")
	public WebElement PlayNowbtn;
	
	@FindBy(xpath = "//a[@id='landing_play_now']")
	public WebElement download_Android_app;
	
	@FindBy(xpath = "//a[@id='landing_login']")
	public WebElement Loginlink;

	@FindBy(xpath = "//a[@id='landing_register']")
	public WebElement Signuplink;

	@FindBy(xpath = "//div[@class='match_listing']")
	public WebElement Gameslist;

	@FindBy(partialLinkText = "Cricket")
	public WebElement Cricket;

	@FindBy(partialLinkText = "Kabaddi")
	public WebElement Kabaddi;

	@FindBy(partialLinkText = "Football")
	public WebElement Football;

	@FindBy(partialLinkText = "Volleyball")
	public WebElement Volleyball;
	
	@FindBy(partialLinkText = "Basketball")
	public WebElement Basketball;
	
	@FindBy(xpath = "//p//span[@class='regular'][contains(text(),'Regular')]")
	public WebElement RegularMode;
	
	@FindBy(xpath = "//p//span[@class='safe'][contains(text(),'Safe')]")
	public WebElement SafeMode;
	
	@FindBy(xpath = "//div[@class='match_listing']")
	public WebElement MatchList;
	
	@FindBy(xpath = "//div[@class='match_listing']//div[1]//div[1]//a[1]")
	public WebElement ThirdMatch;
	
	@FindBy(xpath = "//*[contains(text(),'My Contests')]")
	public WebElement MyContests;
	
	@FindBy(xpath = "//*[contains(text(),'Wallet')]")
	public WebElement Wallet;
	
	@FindBy(xpath = "//*[contains(text(),'More')]")
	public WebElement More;
	
	@FindBy(xpath = "//footer[@class='add_width_left']")
	public WebElement footer;
	
	@FindBy(xpath = "//a[@class='introjs-button introjs-skipbutton']")
	public WebElement SkipTutorial;
	
	
	@FindBy(xpath = "//figure[@class='logo']//img")
	public WebElement MyteamImgLogin;
	
	public WebElement getMyteamImg() {
		return MyteamImgLogin;
	}
	
	public WebElement getPlayNowbtn() {
		return PlayNowbtn;
	}
	
	public WebElement getDownload_Android_app() {
		return download_Android_app;
	}

	public WebElement getLoginlink() {
		return Loginlink;
	}

	public WebElement getSignuplink() {
		return Signuplink;
	}

	public WebElement getGameslist() {
		return Gameslist;
	}

	public WebElement getCricket() {
		return Cricket;
	}

	public WebElement getKabaddi() {
		return Kabaddi;
	}

	public WebElement getFootball() {
		return Football;
	}

	public WebElement getVolleyball() {
		return Volleyball;
	}

	public WebElement getBasketball() {
		return Basketball;
	}

	public WebElement getRegularMode() {
		return RegularMode;
	}

	public WebElement getSafeMode() {
		return SafeMode;
	}

	public WebElement getMatchList() {
		return MatchList;
	}

	public WebElement getThirdMatch() {
		return ThirdMatch;
	}

	public WebElement getMyContests() {
		return MyContests;
	}

	public WebElement getWallet() {
		return Wallet;
	}

	public WebElement getMore() {
		return More;
	}

	public WebElement getFooter() {
		return footer;
	}

	public WebElement getSkipTutorial() {
		return SkipTutorial;
	}

}
