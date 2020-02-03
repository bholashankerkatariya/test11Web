package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateTeam {
	
	
	public WebElement getPlayerRoles() {
		return PlayerRoles;
	}

	public WebElement getPlayerlist() {
		return Playerlist;
	}

	public WebElement getPlayerInfo() {
		return PlayerInfo;
	}

	public WebElement getAddtoMyteambtn() {
		return AddtoMyteambtn;
	}

	public WebElement getClosePlayerinfoPopup() {
		return closePlayerinfoPopup;
	}

	public WebElement getResetBtn() {
		return ResetBtn;
	}

	public WebElement getWicketTextVerify() {
		return WicketTextVerify;
	}

	public WebElement getBatterstextverify() {
		return batterstextverify;
	}

	public WebElement getAllroundertextverify() {
		return Allroundertextverify;
	}

	public WebElement getBowlerstextVerify() {
		return BowlerstextVerify;
	}

	public WebElement getNextbtn() {
		return Nextbtn;
	}

	public WebElement getSaveteambtn() {
		return Saveteambtn;
	}

	public WebElement getSelectVC() {
		return SelectVC;
	}

	public WebElement getSelectC() {
		return SelectC;
	}

	public WebElement getS_Bysort() {
		return S_Bysort;
	}

	
	@FindBy(xpath = "//*[@class='player_box']//img[1]")
	private WebElement PlayerRoles;
	
	@FindBy(xpath = "//div[contains(@class,'table_desin border_avl')]")
	private WebElement Playerlist;
	
	@FindBy(xpath = "//div[3]//div[1]//span[1]//span[1]//a[1]")
	private WebElement PlayerInfo ;
	
	@FindBy(xpath = "//span[contains(text(),'Add To My Team')]")
	private WebElement AddtoMyteambtn;
	
	@FindBy(xpath = "//a[contains(@class,'close_line')]")
	private WebElement closePlayerinfoPopup;
	
	@FindBy(xpath = "//span[contains(text(),'Reset')]")
	private WebElement ResetBtn;
	
	@FindBy(xpath = "//*[contains(text(),'PICK 1 WICKET-KEEPER')]")
	private WebElement WicketTextVerify;
	
	@FindBy(xpath = "//*[contains(text(),'PICK 3-5 BATTERS')]")
	private WebElement batterstextverify;
	
	@FindBy(xpath = "//*[contains(text(),'PICK 1-3 ALL-ROUNDERS')]")
	private WebElement Allroundertextverify;
	
	@FindBy(xpath = "//*[contains(text(),'PICK 3-5 BOWLERS')]")
	private WebElement BowlerstextVerify;
	
	@FindBy(xpath = "//span[contains(text(),'NEXT')]")
	private WebElement Nextbtn;
	
	@FindBy(xpath = "//*[contains(text(),'SAVE TEAM')]")
	private WebElement Saveteambtn;
	
	@FindBy(xpath = "//div[contains(@class,'table_desin border_avl')]//div[3]//div[3]//a[2]//span[1]")
	private WebElement SelectVC;
	
	@FindBy(xpath = "//div[contains(@class,'table_desin border_avl')]//div[2]//div[3]//a[1]//span[1]")
	private WebElement SelectC;
	
	@FindBy(xpath = "//a[contains(text(),'S.BY')]")
	private WebElement S_Bysort;
	
	public WebElement getWicketKipper() {
		return WicketKipper;
	}

	public WebElement getBatsman() {
		return batsman;
	}

	public WebElement getAllrounder() {
		return allrounder;
	}

	public WebElement getBowler() {
		return bowler;
	}

	

	@FindBy(xpath = "assets/images/cricket/wicket_kipper.svg")
	private WebElement WicketKipper;
	
	@FindBy(xpath = "assets/images/cricket/bats_man.svg")
	private WebElement batsman;
	
	@FindBy(xpath = "assets/images/cricket/all_rounder.svg")
	private WebElement allrounder;
	
	@FindBy(xpath = "assets/images/cricket/bowler.svg")
	private WebElement bowler;
	
	
	

}
