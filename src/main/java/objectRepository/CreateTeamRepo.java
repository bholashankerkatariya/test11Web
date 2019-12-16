package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateTeamRepo {
	
	
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
	
	@FindBy(xpath = "//a[contains(text(),'WK (1)')]")
	private WebElement WicketKipper;
	
	@FindBy(xpath = "//a[contains(text(),'BAT (0)')]")
	private WebElement batsman;
	
	@FindBy(xpath = "//a[contains(text(),'AR (0)')]")
	private WebElement allrounder;
	
	@FindBy(xpath = "//a[contains(text(),'BOWL (0)')]")
	private WebElement bowler;
	
	@FindBy(xpath = "//span[contains(text(),'CREATE NEW TEAM')]")
	private WebElement CreateNewTeamBtn;
	
	@FindBy(xpath = "//div[@class='match_listing']/div")
	public WebElement MatchList;
	
	@FindBy(xpath = "//div[@class='right']//a//img")
	private WebElement GotoHome;
	
	public WebElement getGotoHome() {
		return GotoHome;
	}
	
	public WebElement getMatchList() {
		return MatchList;
	}
	
	public WebElement getCreateNewTeamBtn() {
		return CreateNewTeamBtn;
	}

	public WebElement getMyteamsBtn() {
		return MyteamsBtn;
	}

	public WebElement getCloneTeambtn() {
		return CloneTeambtn;
	}

	public WebElement getEditTeambtn() {
		return EditTeambtn;
	}

	public WebElement getTeamPreviewIcon() {
		return TeamPreviewIcon;
	}
	
	

	@FindBy(xpath = "//span[contains(text(),'MY TEAMS')]") 
	private WebElement MyteamsBtn;
	
	@FindBy(xpath = "	//a[contains(text(),'CLONE')]")
	private WebElement CloneTeambtn;
	
	@FindBy(xpath = "//a[contains(text(),'Edit')]")
	private WebElement EditTeambtn;
	
	@FindBy(xpath = "//a[contains(text(),'PREVIEW')]")
	private WebElement TeamPreviewIcon;
	
// Join Team
	@FindBy(xpath = "//div[16]//a[1]")
	private WebElement AllContests;
	
	@FindBy(xpath = "//div[@class = 'contest_data_list contests']/div")
	private WebElement ContestList;
	
	@FindBy(xpath = "//div[contains(@class,'contest_data_list contests')]/div[1]/div[1]/div[1]")
	private WebElement FirstContestFromAllcontest;
	
	@FindBy(xpath = "//a[@class='mini_wallet_btn']")
	private WebElement MiniWallet;
	
	@FindBy(xpath = "//span[@class='left_text']")
	private WebElement LeagueJoinNowbtn;
	
	@FindBy(xpath = "//div[@class='app_footer']//a[@class='foot_btn']")
	private WebElement LeagueJoinNowbtnPopup;
	
	@FindBy(xpath = "//ul[@class='teams_list']/li[1]")
	private WebElement SelectFirstTeam;
	
	@FindBy(xpath = "//div[@class='left_view']//a[2]")
	private WebElement JoinContest;
	
	@FindBy(xpath = "//body/app-root/div[@class='full_view hight_full']/div[@class='left_view']/div[@class='blur_showing']/app-count-down/app-contest-category/div/div[@class='app_center hight_full']/div[@class='scroling_div']/div[@class='contest_listing']/div[1]/a[1]")
	private WebElement ViewAllContest;
	
	@FindBy(xpath = "//footer[@class='add_width_left app_footer']//a[@class='foot_btn']")
	private WebElement JoinContestofTeamlistbtn;
	
	@FindBy(xpath = "//a[contains(text(),'COPY CODE')]")
	private WebElement CopypvtContestCode;
	
	@FindBy(xpath = "//div[@id='contest_invite_code']//a[@class='close_line']")
	private WebElement ClosepvtcontestPopup;
	
	@FindBy(xpath = "//h3[@class='blue']")
	private WebElement CodeofPvtContest;
	
	@FindBy(xpath = "//div[@class='alert_type alert_red']")
	private WebElement VerifyMesageOfThirdPvtContest;
	
	public WebElement getVerifyMesageOfThirdPvtContest() {
		return VerifyMesageOfThirdPvtContest;
	}
	
	public WebElement getGetCodeofPvtContest() {
		return CodeofPvtContest;
	}
	
	public WebElement getClosepvtcontestPopup() {
		return ClosepvtcontestPopup;
	}
	
	public WebElement getCopypvtContestCode() {
		return CopypvtContestCode;
	}
	
	public WebElement getJoinContestofTeamlistbtn() {
		return JoinContestofTeamlistbtn;
	}
	
	
	public WebElement getViewAllContest() {
		return ViewAllContest;
	}
	
	public WebElement getSelectFirstTeam() {
		return SelectFirstTeam;
	}
	
	public WebElement getJoinContest() {
		return JoinContest;
	}
	
	public WebElement getLeagueJoinNowbtnPopup() {
		return LeagueJoinNowbtnPopup;
	}
	
	public WebElement getLeagueJoinNowbtn() {
		return LeagueJoinNowbtn;
	}
		
	public WebElement getAllContests() {
		return AllContests;
	}
	
	public WebElement getContestList() {
		return ContestList;
	}
	
	public WebElement getFirstContestFromAllcontest() {
		return FirstContestFromAllcontest;
	}
	
	public WebElement getMiniWallet() {
		return MiniWallet;
	}
	
	
	//Private contest		
	@FindBy(xpath = "//button[@class='btn white']")
	private WebElement CreatePrivateContestbtn;
	
	@FindBy(xpath = "//input[@placeholder='Give your contest a name']")
	private WebElement EnterYourcontestName;
	
	@FindBy(xpath = "//input[@placeholder='Total Winning Amount *']")
	private WebElement EnterWinningAmount;
	
	@FindBy(xpath = "//input[@placeholder='Contest Size *']")
	private WebElement enterContestSize;
	
	@FindBy(xpath = "//span[@class='slider round']")
	private WebElement AllowMultipleteamJointoggle;
	
	@FindBy(xpath = "//button[@class='foot_btn']")
	private WebElement Join_Now_buttonpvtContest;
	
	@FindBy(xpath = "//*[@class='introjs-button introjs-skipbutton introjs-donebutton']")
	private WebElement DoneTutorial;

	
	public WebElement getDoneTutorial() {
		return DoneTutorial;
	}
	
	public WebElement getCreatePrivateContestbtn() {
		return CreatePrivateContestbtn;
	}
	
	public WebElement getEnterWinningAmount() {
		return EnterWinningAmount;
	}
	
	public WebElement getenterContestSize() {
		return enterContestSize;
	}
	
	public WebElement getAllowMultipleteamJointoggle() {
		return AllowMultipleteamJointoggle;
	}
	
	public WebElement getJoin_Now_buttonpvtContest() {
		return Join_Now_buttonpvtContest;
	}
	
	public WebElement getEnterYourcontestName() {
		return EnterYourcontestName;
	}
		
}
