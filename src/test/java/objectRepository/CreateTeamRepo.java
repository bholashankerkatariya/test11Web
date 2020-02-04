package objectRepository;

import java.util.List;

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
	private WebElement PlayerInfo;

	@FindBy(xpath = "//span[contains(text(),'Add To My Team')]")
	private WebElement AddtoMyteambtn;

	@FindBy(xpath = "//a[contains(@class,'close_line')]")
	private WebElement closePlayerinfoPopup;

	@FindBy(xpath = "//span[contains(text(),'Reset')]")
	private WebElement ResetBtn;

	@FindBy(xpath = "//*[contains(text(),'PICK 1-4 WICKET-KEEPER')]")
	private WebElement WicketTextVerify;

	@FindBy(xpath = "//*[contains(text(),'PICK 2-6 BATTERS')]")
	private WebElement batterstextverify;

	@FindBy(xpath = "//*[contains(text(),'PICK 1-6 ALL-ROUNDERS')]")
	private WebElement Allroundertextverify;

	@FindBy(xpath = "//*[contains(text(),'PICK 2-6 BOWLERS')]")
	private WebElement BowlerstextVerify;

	@FindBy(xpath = "//a[@class='btn']")
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

	@FindBy(xpath = "//div[@class='match_listing']/div/div")
	public List<WebElement> MatchList;

	@FindBy(xpath = "//div[@class='right']//a//img")
	private WebElement GotoHome;

	@FindBy(xpath = "//div[@class='contest_data_list contests']/div/div/div/div[3]/div[3]")
	private List<WebElement> LeagueSize;

	@FindBy(xpath = "//div[@class='bottom_strip']/p/span/a/span")
	private List<WebElement> LeagueAmount;

	@FindBy(xpath = "//div[@class = 'contest_data_list contests']/div")
	private List<WebElement> LeagueList;

	@FindBy(xpath = "//div[@class='first_team']")
	private WebElement firstTeamPlayerSelected;

	public WebElement getfirstTeamPlayerSelected() {
		return firstTeamPlayerSelected;
	}

	@FindBy(xpath = "//div[@class='second_team']")
	private WebElement secoundTeamPlayerSelected;

	public WebElement getsecoundTeamPlayerSelected() {
		return secoundTeamPlayerSelected;
	}

	public List<WebElement> getLeagueList() {
		return LeagueList;
	}

	public List<WebElement> getLeagueAmount() {
		return LeagueAmount;
	}

	public List<WebElement> getLeagueSize() {
		return LeagueSize;
	}

	public WebElement getGotoHome() {
		return GotoHome;
	}

	public List<WebElement> getMatchList() {
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
	@FindBy(xpath = "//body/app-root/div[@class='full_view hight_full']/div[@class='left_view']/div[@class='blur_showing']/app-count-down/app-contest-category/div/div[@class='app_center hight_full']/div[@class='scroling_div']/div[@class='contest_listing']/div[1]/a[1]")
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

	@FindBy(xpath = "//div[@class='contest_listing']/div/div/div")
	private List<WebElement> TotalContests;

	@FindBy(xpath = "//div[@class='team_data']")
	private List<WebElement> TeamCount;

	public List<WebElement> getTeamCount() {
		return TeamCount;
	}

	public List<WebElement> getTotalContests() {
		return TotalContests;
	}

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

	@FindBy(xpath = "//div[@class='scroling_div']//div[1]//div[1]//div[1]//div[1]//div[4]//a[1]//span[1]")
	private List<WebElement> CaptainTextBox;

	public List<WebElement> getCaptainTextBox() {
		return CaptainTextBox;
	}

	@FindBy(xpath = "//div[@class='table_own cap_vc_tab']//div[2]//div[1]//div[1]//div[1]//div[4]//a[2]//span[1]")
	private List<WebElement> ViceCaptainBox;

	public List<WebElement> getViceCaptainBox() {
		return ViceCaptainBox;
	}

	// Private contest
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

	@FindBy(xpath = "//div[@class='col-2 text-right short up']//a[contains(text(),'CR')]")
	private WebElement CR_sort;

	@FindBy(xpath = "//div[contains(text(),'No more than 6 teams allowed in a league with less than 100 members. ')]")
	private WebElement NoMoreThan6TeamsValidation;

	@FindBy(xpath = "//div[@class='bottom_strip']/ul/li/span[contains(text(),'M')]")
	private WebElement M;

	@FindBy(xpath = "//div[@class='bottom_strip']/ul/li/span[contains(text(),'C')]")
	private WebElement C;

	@FindBy(xpath = "//div[@class='bottom_strip']/ul/li/span[contains(text(),'S')]")
	private WebElement S;

	@FindBy(xpath = "//ul[@class='teams_list']/li")
	private List<WebElement> Teamlist;

	@FindBy(xpath = "//div[@class='tab_view']/ul/li")
	private List<WebElement> playerType;

	@FindBy(xpath = "//a[@class='select_player']")
	private List<WebElement> MemberSelectionList;

	@FindBy(xpath = "//footer[@class='add_width_left']//div[3]//div[1]/p")
	private WebElement selectedplaying11members;

	public WebElement getselectedplaying11members() {
		return selectedplaying11members;
	}

	public List<WebElement> getMemberSelectionList() {
		return MemberSelectionList;
	}

	public List<WebElement> getplayerType() {
		return playerType;
	}

	public List<WebElement> getTeamlist() {
		return Teamlist;
	}

	public WebElement getS() {
		return S;
	}

	public WebElement getC() {
		return C;
	}

	public WebElement getM() {
		return M;
	}

	public WebElement getNoMoreThan6TeamsValidation() {
		return NoMoreThan6TeamsValidation;
	}

	public WebElement getCR_sort() {
		return CR_sort;
	}

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

	@FindBy(xpath = "//a[@class='foot_btn']")
	private WebElement footerButton;

	public WebElement getfooterButton() {
		return footerButton;
	}

	@FindBy(xpath = "//a[@class='introjs-button introjs-skipbutton']")
	private WebElement tutorialSkipButton;

	public WebElement getTutorialSkipButton() {
		return tutorialSkipButton;
	}

	@FindBy(xpath = "//ul[@class='nav_icon_list']//li//a//img")
	private WebElement backButton;

	public WebElement getbackButton() {
		return backButton;
	}

	@FindBy(xpath = "//*[contains(text(),'MY TEAMS')]")
	private WebElement myTeamButton;

	public WebElement getmyTeamButton() {
		return myTeamButton;
	}

	@FindBy(xpath = "//a[contains(text(),'WK')]")
	private WebElement WicketKeeperPlayerType;

	public WebElement getWicketKeeperPlayerType() {
		return WicketKeeperPlayerType;
	}

	@FindBy(xpath = "//a[contains(text(),'BAT')]")
	private WebElement BetterPlayerType;

	public WebElement getBetterPlayerType() {
		return BetterPlayerType;
	}

	@FindBy(xpath = "//a[contains(text(),'AR')]")
	private WebElement AllRounderPlayerType;

	public WebElement getAllRounderPlayerType() {
		return AllRounderPlayerType;
	}

	@FindBy(xpath = "//a[contains(text(),'BOWL')]")
	private WebElement BowlerPlayerType;

	public WebElement getBowlerPlayerType() {
		return BowlerPlayerType;
	}

	@FindBy(xpath = "//*[contains(text(),'SAVE')]")
	private WebElement SAVEbtn;

	public WebElement getSAVEbtn() {
		return SAVEbtn;
	}

	@FindBy(xpath = "//span[@class='right_text num_text']")
	private WebElement myTeamCount;

	public WebElement getmyTeamCount() {
		return myTeamCount;
	}

	@FindBy(xpath = "//*[@class='row' and @data-position]/div[4]")
	private WebElement singlePlayerCredit;

	public WebElement getsiglePlayerCredit() {
		return singlePlayerCredit;
	}

	@FindBy(xpath = "//footer/div/div[2]/div[1]/p")
	private WebElement remainingCredit;

	public WebElement getremainingCredit() {
		return remainingCredit;
	}

	@FindBy(xpath = "//footer/div/div[2]/div[1]/p")
	private WebElement PlayerList;

	public WebElement getPlayerList() {
		return PlayerList;
	}

	@FindBy(xpath = "//*[@class='match_listing']")
	private WebElement matchList;

	public WebElement getmatchList() {
		return matchList;
	}

	@FindBy(xpath = "//div[@class='introjs-tooltip introjs-bottom-left-aligned']")
	private WebElement toutorialScreen;

	public WebElement gettoutorialScreen() {
		return toutorialScreen;
	}
	
	@FindBy(xpath = "//a[contains(text(),'ENTRY FEE')]")
	private WebElement SortByEntryFee;

	public WebElement getSortByEntryFee() {
		return SortByEntryFee;
	}
	

}
