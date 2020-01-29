package testCases;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import action.Action;
import objectRepository.CreateTeamRepo;
import objectRepository.LogOutRepository;
import objectRepository.LoginRepository;

public class JoinLeagueLogic {

	int leagueCount = 0;
	int Matchcount = 1;
	int LeagueAmountposition = 0;
	int Leagueamnt = 0;
	WebDriver driver;
	static WebDriverWait Wait;
	static CreateTeamRepo crtTeam;
	JavascriptExecutor js;
	boolean getDoneTutorial = true;

	Action action;
	LogOutRepository logoutRepo;
	LoginRepository loginRepo;
	LoginLogic loginLogic;
	Actions actions;
	boolean skip = true;
	boolean done = true;
	int temp = 0;
	int temp1 = 0;
	int count = 0;
	int alreadyCreateTeam = 0;
	List<WebElement> matchList = null;
	static List<WebElement> PlayerList = null;

	java.util.List<WebElement> LeagueSize;
	java.util.List<WebElement> LeagueAmount;
	List<WebElement> TotalContests;

	public JoinLeagueLogic(WebDriver _driver, WebDriverWait _Wait) {
		driver = _driver;
		Wait = _Wait;

		js = (JavascriptExecutor) driver;

		crtTeam = PageFactory.initElements(driver, CreateTeamRepo.class);
		loginRepo = PageFactory.initElements(driver, LoginRepository.class);

		logoutRepo = PageFactory.initElements(driver, LogOutRepository.class);
	}

	public void Select_The_Match() throws Exception {

		Thread.sleep(2000);
		List<WebElement> matchlist = null;

		try {
			for (int i = 0; i < 15; i++) {
				js.executeScript("$(\".scroling_div\").scrollTop(99999999999999999999999999999);");
			}

			// Scroll up
			js.executeScript("$(\".scroling_div\").scrollTop(0);");
		} catch (Exception e) {
			e.printStackTrace();
		}

		matchlist = crtTeam.getMatchList();

		System.out.println("Number of matches:" + matchlist.size());

		Thread.sleep(1000);
		matchlist.get(Matchcount).click();

		/*
		 * if (getDoneTutorial) {
		 * 
		 * Thread.sleep(4000); crtTeam.getDoneTutorial().click();
		 * 
		 * }
		 */

		// getDoneTutorial = false;

	}

	// Join first contest of match
	public void JoinMegaContests() throws Exception {

		int i;
		java.util.List<WebElement> Teamlist = null;

		if (getDoneTutorial)

		{

			Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getDoneTutorial())).click();

			Thread.sleep(2000);

			java.util.List<WebElement> LeagueList = crtTeam.getLeagueList();
			LeagueList.get(leagueCount).click();

			Thread.sleep(2000);

			//
			crtTeam.getLeagueJoinNowbtn().click();

			Thread.sleep(4000);

			Teamlist = crtTeam.getTeamlist(); // driver.findElements(By.xpath("//ul[@class='teams_list']/li"));

			for (i = 0; i < Teamlist.size();) {

				// System.out.println("Teamlist: " + Teamlist.get(i).getAttribute("class"));
				// System.out.println("Teamlist: " +
				// Teamlist.get(i).getAttribute("class").equals("disable_5"));

				try {

					boolean disableTeams = Teamlist.get(i).getAttribute("class").equals("disable_5");

					if (disableTeams) {
						i++;
						continue;

					}

					Teamlist.get(i).click();

					boolean joinTeam;

					try {
						joinTeam = crtTeam.getJoinContest().isDisplayed();
						if (joinTeam) {

							Thread.sleep(30000);
							crtTeam.getJoinContest().click();
						}

					} catch (Exception e1) {
						boolean joinTeam2 = crtTeam.getJoinContestofTeamlistbtn().isDisplayed();
						if (joinTeam2) {

							crtTeam.getJoinContestofTeamlistbtn().click();
						}
						e1.printStackTrace();
					}

					Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getLeagueJoinNowbtnPopup())).click();

					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.getStackTrace();
					}

					Teamlist = crtTeam.getTeamlist();
					i++;

					// System.out.println("Teamlist: " + Teamlist.get(i).getAttribute("class"));

				} catch (Exception e) {

					e.printStackTrace();
				}

				if (i == Teamlist.size()) {
					break;

				}

			}

			getDoneTutorial = false;
		}

		else {

			Thread.sleep(2000);

			java.util.List<WebElement> LeagueList = crtTeam.getLeagueList();
			LeagueList.get(leagueCount).click();

			Thread.sleep(2000);

			//
			crtTeam.getLeagueJoinNowbtn().click();

			Thread.sleep(4000);

			Teamlist = crtTeam.getTeamlist();

			for (i = 0; i < Teamlist.size();) {

				// System.out.println("Teamlist: " + Teamlist.get(i).getAttribute("class"));
				// System.out.println("Teamlist: " +
				// Teamlist.get(i).getAttribute("class").equals("disable_5"));

				try {

					boolean disableTeams = Teamlist.get(i).getAttribute("class").equals("disable_5");

					if (disableTeams) {
						i++;
						continue;

					}

					Teamlist.get(i).click();

					boolean joinTeam;

					try {
						joinTeam = crtTeam.getJoinContest().isDisplayed();
						if (joinTeam) {

							Thread.sleep(3000);
							crtTeam.getJoinContest().click();
						}

					} catch (Exception e1) {
						boolean joinTeam2 = crtTeam.getJoinContestofTeamlistbtn().isDisplayed();
						if (joinTeam2) {

							crtTeam.getJoinContestofTeamlistbtn().click();
						}
						e1.printStackTrace();
					}

					Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getLeagueJoinNowbtnPopup())).click();

					Thread.sleep(1000);

					Teamlist = crtTeam.getTeamlist();
					i++;

					// System.out.println("Teamlist: " + Teamlist.get(i).getAttribute("class"));

				} catch (Exception e) {

					e.printStackTrace();
				}

				if (i == Teamlist.size()) {
					break;
				}

			}
			Thread.sleep(2000);
			crtTeam.getGotoHome().click();
		}
	}

	// Create and Join Private Contest
	public void JoinPrivateContest() throws InterruptedException {

		int i;
		java.util.List<WebElement> Teamlist = null;

		if (getDoneTutorial)

		{

			Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getDoneTutorial())).click();

			Thread.sleep(2000);

			Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getCreatePrivateContestbtn())).click();

			Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getEnterYourcontestName()))
					.sendKeys("Testing purpose");
			crtTeam.getEnterWinningAmount().sendKeys("20");
			crtTeam.getenterContestSize().sendKeys("3");
			crtTeam.getAllowMultipleteamJointoggle().click();
			crtTeam.getJoin_Now_buttonpvtContest().click();

			Thread.sleep(4000);

			Teamlist = crtTeam.getTeamlist();

			for (i = 0; i < Teamlist.size();) {

				try {

					boolean disableTeams = Teamlist.get(i).getAttribute("class").equals("disable_5");

					if (disableTeams) {
						i++;
						continue;

					}

					Teamlist.get(i).click();

					boolean joinTeam;

					try {

						joinTeam = crtTeam.getJoinContest().isDisplayed();
						if (joinTeam) {

							crtTeam.getJoinContest().click();
						}

					} catch (Exception e1) {
						boolean joinTeam2 = crtTeam.getJoinContestofTeamlistbtn().isDisplayed();

						if (joinTeam2) {

							crtTeam.getJoinContestofTeamlistbtn().click();
						}

						e1.printStackTrace();
					}

					Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getLeagueJoinNowbtnPopup())).click();

					Thread.sleep(3000);

					FileWriter Csvwriter;

					try {

						String PvtContestCode = crtTeam.getGetCodeofPvtContest().getText();

						Thread.sleep(2000);
						String path = "ddt/privateContestcode.csv";

						Csvwriter = new FileWriter(path);

						Csvwriter.write(PvtContestCode);
						Csvwriter.append("\n");

						Csvwriter.close();

					} catch (Exception e) {

						e.printStackTrace();
					}

					crtTeam.getClosepvtcontestPopup().click();

					Teamlist = driver.findElements(By.xpath("//ul[@class='teams_list']/li"));
					i++;

				} catch (Exception e) {

					e.printStackTrace();
				}

				if (i == Teamlist.size()) {

					break;

				}

			}

		}
	}

	// join league more than 100 members league and amount less than 100
	public void joinleagueMoreThan100Member() throws Exception {

		if (getDoneTutorial)

		{

			Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getDoneTutorial())).click();
			Thread.sleep(5000);

			crtTeam.getAllContests().click();
			Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getDoneTutorial())).click();
			Thread.sleep(2000);

			LeagueSize = driver
					.findElements(By.xpath("//div[@class='contest_data_list contests']/div/div/div/div[3]/div[3]"));

			LeagueAmount = driver.findElements(By.xpath("//div[@class='bottom_strip']/p/span/a/span"));

			try {

				js.executeScript("$( \".scroling_div\" ).scrollTop(9999999999999999999999);");
				js.executeScript("$( \".scroling_div\" ).scrollTop(9999999999999999999999);");
				js.executeScript("$( \".scroling_div\" ).scrollTop(9999999999999999999999);");
				js.executeScript("$( \".scroling_div\" ).scrollTop(9999999999999999999999);");

			} catch (Exception e) {

				e.printStackTrace();
			}

			for (int j = 0; j < LeagueSize.size();) {
				String arSplit = LeagueSize.get(j).getText();
				String teamcount[] = arSplit.split(" ");
				System.out.println(teamcount[0]);

				String arrSplit = LeagueAmount.get(j).getText();
				String Leagueamnt[] = arrSplit.split("₹");
				System.out.println(Leagueamnt[1]);

				System.out.println(Integer.parseInt(Leagueamnt[1]) < 100 && Integer.parseInt(teamcount[0]) > 100);

				if (Integer.parseInt(Leagueamnt[1]) < 100 && Integer.parseInt(teamcount[0]) > 100) {

					System.out.println(LeagueAmount.get(LeagueAmountposition).getText());

					WebElement element = LeagueAmount.get(LeagueAmountposition);

					((JavascriptExecutor) driver).executeScript("$('.scroling_div').scrollTop(0);", element);

					LeagueAmount.get(LeagueAmountposition).click();

				}

				break;
			}

		}
	}

	// join league Less than 100 members league and amount less than 100
	public void joinleagueLessThan100Member() throws InterruptedException {

		int i;
		java.util.List<WebElement> Teamlist = null;

		if (getDoneTutorial) {

			try {
				Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getDoneTutorial())).click();
				Thread.sleep(2000);

				crtTeam.getAllContests().click();
				Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getDoneTutorial())).click();
				Thread.sleep(2000);
			} catch (Exception e2) {

				e2.printStackTrace();
			}

			LeagueSize = crtTeam.getLeagueSize();
			LeagueAmount = crtTeam.getLeagueAmount();

			try {

				for (int j = 0; j < 30; j++) {
					js.executeScript("$(\".scroling_div\").scrollTop(99999999999999999999999999999);");
				}

				// Scroll up
				js.executeScript("$(\".scroling_div\").scrollTop(0);");

			} catch (Exception e) {

				e.printStackTrace();
			}

			for (int j = 0; j < LeagueSize.size(); j++) {
				String arSplit = LeagueSize.get(j).getText();
				String teamcount[] = arSplit.split(" ");

				String arrSplit = LeagueAmount.get(j).getText();
				String Leagueamnt[] = arrSplit.split("₹");

				// league size and league amount
				System.out.println("Team Count: " + teamcount[0] + ", League amount: " + Leagueamnt[1]);
				// logic to find exact result
				System.out.println(Integer.parseInt(Leagueamnt[1]) < 100 && Integer.parseInt(teamcount[0]) < 100);

				if (Integer.parseInt(Leagueamnt[1]) < 100 && Integer.parseInt(teamcount[0]) < 100) {

					System.out.println(LeagueAmount.get(LeagueAmountposition).getText());

					WebElement element = LeagueAmount.get(LeagueAmountposition);

					((JavascriptExecutor) driver).executeScript("$('.scroling_div').scrollTop(0);", element);

					LeagueAmount.get(LeagueAmountposition).click();

					break;

				}

			}

			Thread.sleep(4000);

			Teamlist = crtTeam.getTeamlist();

			for (i = 0; i < Teamlist.size();) {

				// System.out.println("Teamlist: " + Teamlist.get(i).getAttribute("class"));
				// System.out.println("Teamlist: " +
				// Teamlist.get(i).getAttribute("class").equals("disable_5"));

				try {

					boolean disableTeams = Teamlist.get(i).getAttribute("class").equals("disable_5");

					if (disableTeams) {
						i++;
						continue;

					}

					Teamlist.get(i).click();

					boolean joinTeam;

					try {
						joinTeam = crtTeam.getJoinContest().isDisplayed();
						if (joinTeam) {

							Thread.sleep(3000);
							crtTeam.getJoinContest().click();
						}

					} catch (Exception e1) {
						boolean joinTeam2 = crtTeam.getJoinContestofTeamlistbtn().isDisplayed();
						if (joinTeam2) {

							crtTeam.getJoinContestofTeamlistbtn().click();
						}
						e1.printStackTrace();
					}

					Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getLeagueJoinNowbtnPopup())).click();

					Thread.sleep(1000);

					Teamlist = crtTeam.getTeamlist();
					i++;

					// System.out.println("Teamlist: " + Teamlist.get(i).getAttribute("class"));

				} catch (Exception e) {

					e.printStackTrace();
				}

				if (i == Teamlist.size()) {
					break;
				}

			}
			Thread.sleep(2000);
			crtTeam.getGotoHome().click();
		}

	}

	// join league 2 members league and amount less than 100 (Head2Head)
	public void joinleague2Members() throws InterruptedException {

		int i;
		java.util.List<WebElement> Teamlist = null;

		if (getDoneTutorial)

		{

			Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getDoneTutorial())).click();
			Thread.sleep(3000);

			crtTeam.getAllContests().click();

			Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getDoneTutorial())).click();
			Thread.sleep(2000);

			// crtTeam.getTeamDcrementsort().click();

			try {

				// WebElement element = LeagueAmount.get(LeagueAmountposition);

				((JavascriptExecutor) driver)
						.executeScript("$('.scroling_div').scrollTop(9999999999999999999999999999);");

			} catch (Exception e) {

				e.printStackTrace();
			}

			LeagueSize = crtTeam.getLeagueSize();
			LeagueAmount = crtTeam.getLeagueAmount();

			for (int j = 0; j < LeagueSize.size(); j++) {
				String arSplit = LeagueSize.get(j).getText();
				String teamcount[] = arSplit.split(" ");

				String arrSplit = LeagueAmount.get(j).getText();
				String Leagueamnt[] = arrSplit.split("₹");

				System.out.println("Team Count: " + teamcount[0] + ", League amount: " + Leagueamnt[1]);
				System.out.println(Integer.parseInt(Leagueamnt[1]) < 100 && Integer.parseInt(teamcount[0]) < 2);

				if (Integer.parseInt(Leagueamnt[1]) < 100 && Integer.parseInt(teamcount[0]) < 3
						&& crtTeam.getS().isDisplayed()) {

					System.out.println(LeagueAmount.get(LeagueAmountposition).getText());

					WebElement element = LeagueAmount.get(LeagueAmountposition);

					((JavascriptExecutor) driver).executeScript("$('.scroling_div').scrollTop(0);", element);

					LeagueAmount.get(LeagueAmountposition).click();

					break;

				}

			}

			Thread.sleep(4000);

			Teamlist = crtTeam.getTeamlist();

			for (i = 0; i < Teamlist.size();) {

				// System.out.println("Teamlist: " + Teamlist.get(i).getAttribute("class"));
				// System.out.println("Teamlist: " +
				// Teamlist.get(i).getAttribute("class").equals("disable_5"));

				try {

					boolean disableTeams = Teamlist.get(i).getAttribute("class").equals("disable_5");

					if (disableTeams) {
						i++;
						continue;
					}

					Teamlist.get(i).click();

					boolean joinTeam;

					try {
						joinTeam = crtTeam.getJoinContest().isDisplayed();
						if (joinTeam) {

							Thread.sleep(3000);
							crtTeam.getJoinContest().click();
						}

					} catch (Exception e1) {
						boolean joinTeam2 = crtTeam.getJoinContestofTeamlistbtn().isDisplayed();
						if (joinTeam2) {

							crtTeam.getJoinContestofTeamlistbtn().click();
						}
						e1.printStackTrace();
					}

					Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getLeagueJoinNowbtnPopup())).click();

					Thread.sleep(1000);

					Teamlist = crtTeam.getTeamlist();
					i++;

					// System.out.println("Teamlist: " + Teamlist.get(i).getAttribute("class"));

				} catch (Exception e) {

					e.printStackTrace();
				}

				if (i == Teamlist.size()) {
					break;
				}

			}
			Thread.sleep(2000);
			crtTeam.getGotoHome().click();
		}

	}

	// Create team logic
	public void SelectPlayerInList(String size, List<WebElement> PlayerList, WebElement first, WebElement second)
			throws Exception {
		if (first.isEnabled()) {
			int actualSize = Integer.parseInt(size);
			String playing11 = crtTeam.getselectedplaying11members().getText();
			// System.out.println("Playing 11 : " + playing11);
			Thread.sleep(2000);
			String[] temp = playing11.split("(?=/)");
			// System.out.println(temp[0]);

			int memberSelected = Integer.parseInt(temp[0].trim());

			for (int i = 0; i < actualSize; i++) {

				if (memberSelected <= 11) {

					if (crtTeam.getfirstTeamPlayerSelected().getText().equals("7")
							|| crtTeam.getsecoundTeamPlayerSelected().getText().equals("7")) {
						Thread.sleep(5000);

						String script = "$( \".table_desin  .row\" ).each(function() {\r\n"
								+ "  if($(this).hasClass(\"disabled\")){\r\n" + "console.log(\"Disebled Row\");\r\n"
								+ "	}else{\r\n" + "console.log(\"Row\");\r\n" + "$('.scroling_div').animate({\r\n"
								+ "    scrollTop: ($(this).offset().top)\r\n" + "},500); return false; // breaks\r\n"
								+ "}\r\n" + "});";

						js.executeScript(script);
						Thread.sleep(2000);

						// for unable player list after 7 player selected from one team
						PlayerList = driver.findElements(By.xpath("//div[@class='row']/a"));
						// System.out.println("unable Player list count = " + enablePlayerList.size());
					}
				}

				try {
					Random randomGenerator = new Random();
					int index = randomGenerator.nextInt(PlayerList.size());
					System.out.print(" " + index);
					WebElement element = crtTeam.getPlayerlist();
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					PlayerList.get(index).click();
					PlayerList = driver.findElements(By.xpath("//div[@class='row']/a"));
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			second.click();

		} // FOR LOOP CLOSE
	} // fUNCTION close

	// Select the Teams
	public void TeamSelection(String WK, String Bat, String AR, String Bowl) throws Exception {

		/*
		 * if (getDoneTutorial) {
		 * Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getDoneTutorial())
		 * ).click();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * String st = crtTeam.getfooterButton().getText(); if (st.contains("MY")) { st
		 * = "MY TEAMS"; }
		 * 
		 * System.out.println(st);
		 * 
		 * List<WebElement> teamCount = null; Thread.sleep(3000); switch (st) {
		 * 
		 * case "CREATE NEW TEAM": {
		 * 
		 * if (temp == 1) { teamCount =
		 * driver.findElements(By.xpath("//div[@class='team_data']")); if
		 * (teamCount.size() >= 10) { crtTeam.getGotoHome().click(); Thread.sleep(2000);
		 * Matchcount++; Select_The_Match(); }
		 * 
		 * }
		 * 
		 * Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.
		 * getCreateNewTeamBtn())).click();
		 * 
		 * if (skip) {
		 * 
		 * Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.
		 * getTutorialSkipButton())).click(); skip = false; }
		 * 
		 * // System.out.println("Team count : "+teamCount.size()); count++; temp1 =
		 * alreadyCreateTeam + count; System.out.println("Already Created team :" +
		 * alreadyCreateTeam + " Newly Created Team :" + count +
		 * " Total team Created : " + temp1); if (temp1 >= 10) { Thread.sleep(2000);
		 * Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getGotoHome())).
		 * click();
		 * 
		 * Matchcount++; count = 0; System.out
		 * .println("10 Team created in previous Match, Now switching to Next match : "
		 * + Matchcount); Select_The_Match(); } break;
		 * 
		 * }
		 * 
		 * case "MY TEAMS": {
		 * 
		 * String footerButton = crtTeam.getfooterButton().getText(); String[] arr =
		 * footerButton.split("\n"); if (arr[0].equalsIgnoreCase("MY TEAMS")) {
		 * 
		 * alreadyCreateTeam = Integer.parseInt(arr[1]); if (arr[1].equals("10")) {
		 * Thread.sleep(3000); crtTeam.getbackButton().click(); Matchcount++;
		 * Select_The_Match(); } }
		 * 
		 * Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getmyTeamButton())
		 * ).click();
		 * 
		 * teamCount = crtTeam.getTeamCount(); if (teamCount.size() >= 10) {
		 * crtTeam.getGotoHome().click(); Thread.sleep(2000); Matchcount++;
		 * Select_The_Match();
		 * 
		 * }
		 * 
		 * Thread.sleep(2000); crtTeam.getCreateNewTeamBtn().click(); if (skip) {
		 * Thread.sleep(3000);
		 * Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.
		 * getTutorialSkipButton())).click(); skip = false; } count++; temp = 1; break;
		 * }
		 * 
		 * default:
		 * 
		 * teamCount = driver.findElements(By.xpath("//div[@class='team_data']")); if
		 * (teamCount.size() >= 10) {
		 * 
		 * if (crtTeam.getfooterButton().isDisplayed() != true) {
		 * crtTeam.getGotoHome().click(); ++Matchcount; Select_The_Match();
		 * 
		 * } }
		 * 
		 * Thread.sleep(1000); crtTeam.getCR_sort().click();
		 * 
		 * List<WebElement> list1 =
		 * driver.findElements(By.xpath("//a[@class='select_player']"));
		 * SelectPlayerInList(WK, list1, crtTeam.getWicketKeeperPlayerType(),
		 * crtTeam.getBetterPlayerType());
		 * 
		 * list1 = driver.findElements(By.xpath("//a[@class='select_player']"));
		 * SelectPlayerInList(Bat, list1, crtTeam.getBetterPlayerType(),
		 * crtTeam.getAllRounderPlayerType());
		 * 
		 * list1 = driver.findElements(By.xpath("//a[@class='select_player']"));
		 * SelectPlayerInList(AR, list1, crtTeam.getAllRounderPlayerType(),
		 * crtTeam.getBowlerPlayerType());
		 * 
		 * list1 = driver.findElements(By.xpath("//a[@class='select_player']"));
		 * SelectPlayerInList(Bowl, list1, crtTeam.getBowlerPlayerType(),
		 * crtTeam.getNextbtn());
		 * 
		 * try {
		 * 
		 * js.executeScript("$( \".scroling_div\" ).scrollTop(9999999);");
		 * List<WebElement> selectCaptain =
		 * driver.findElements(By.xpath("//a[@class='c_sect']/span")); List<WebElement>
		 * selectViceCaptain =
		 * driver.findElements(By.xpath("//a[@class='vc_sect']/span")); Random
		 * randomGenerator = new Random(); int c =
		 * randomGenerator.nextInt(selectCaptain.size()); int VC =
		 * randomGenerator.nextInt(selectViceCaptain.size()); System.out.println("    "
		 * + c + "   " + VC);
		 * 
		 * selectCaptain.get(selectCaptain.size() - 2).click();
		 * 
		 * selectViceCaptain.get(selectViceCaptain.size() - 3).click();
		 * 
		 * Thread.sleep(3500); crtTeam.getSAVEbtn().click();
		 * 
		 * }
		 * 
		 * catch (Exception e) { e.printStackTrace(); }
		 * 
		 * } }
		 */}

	// Joine the league of 6 teams only
	public void JoineLeague_Of_6_Teams() throws Exception {

		Thread.sleep(2000);
		if (getDoneTutorial) {
			Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getDoneTutorial())).click();
			Thread.sleep(3000);

			crtTeam.getAllContests().click();

			Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getDoneTutorial())).click();
			Thread.sleep(2000);

			try {

				for (int i = 0; i < 30; i++) {
					js.executeScript("$(\".scroling_div\").scrollTop(99999999999999999999999999999);");
				}

				// Scroll up
				// js.executeScript("$(\".scroling_div\").scrollTop(0);");

			} catch (Exception e) {

				e.printStackTrace();
			}

			// TotalContests = crtTeam.getTotalContests();
			LeagueSize = crtTeam.getLeagueSize();
			LeagueAmount = crtTeam.getLeagueAmount();

			for (int j = 0; j < LeagueSize.size(); j++) {
				String arSplit = LeagueSize.get(j).getText();
				String teamcount[] = arSplit.split(" ");

				String arrSplit = LeagueAmount.get(j).getText();
				String Leagueamnt[] = arrSplit.split("₹");

				System.out.println("Team Count: " + teamcount[0] + ", League amount: " + Leagueamnt[1]);

				if (Integer.parseInt(Leagueamnt[1]) <= 100 && Integer.parseInt(teamcount[0]) > 6
						&& crtTeam.getM().isDisplayed() && !crtTeam.getC().isDisplayed()) {

					// System.out.println(LeagueAmount.get(LeagueAmountposition).getText());
					System.out.println(Integer.parseInt(Leagueamnt[1]) <= 100 && Integer.parseInt(teamcount[0]) > 6
							&& crtTeam.getM().isDisplayed() && !crtTeam.getC().isDisplayed());

					WebElement element = LeagueAmount.get(LeagueAmountposition);

					((JavascriptExecutor) driver).executeScript("$('.scroling_div').scrollTop(0);", element);

					LeagueAmount.get(LeagueAmountposition).click();

					break;

				}

			}

		}

		else {

			Thread.sleep(3000);

			crtTeam.getAllContests().click();

			Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getDoneTutorial())).click();
			Thread.sleep(2000);

			try {

				for (int i = 0; i < 15; i++) {
					js.executeScript("$(\".scroling_div\").scrollTop(99999999999999999999999999999);");
				}

				// Scroll up
				js.executeScript("$(\".scroling_div\").scrollTop(0);");

			} catch (Exception e) {

				e.printStackTrace();
			}

			// TotalContests = crtTeam.getTotalContests();
			LeagueSize = crtTeam.getLeagueSize();
			LeagueAmount = crtTeam.getLeagueAmount();

			for (int j = 0; j < LeagueSize.size(); j++) {
				String arSplit = LeagueSize.get(j).getText();
				String teamcount[] = arSplit.split(" ");

				String arrSplit = LeagueAmount.get(j).getText();
				String Leagueamnt[] = arrSplit.split("₹");

				System.out.println("Team Count: " + teamcount[0] + ", League amount: " + Leagueamnt[1]);

				if (Integer.parseInt(Leagueamnt[1]) < 100 && Integer.parseInt(teamcount[0]) > 6
						&& crtTeam.getM().isDisplayed() && !crtTeam.getC().isDisplayed()) {

					// System.out.println(LeagueAmount.get(LeagueAmountposition).getText());
					System.out.println(Integer.parseInt(Leagueamnt[1]) < 100 && Integer.parseInt(teamcount[0]) > 6
							&& crtTeam.getM().isDisplayed() && !crtTeam.getC().isDisplayed());

					WebElement element = LeagueAmount.get(LeagueAmountposition);

					((JavascriptExecutor) driver).executeScript("$('.scroling_div').scrollTop(0);", element);

					LeagueAmount.get(LeagueAmountposition).click();

					break;

				}

			}

		}

	}

	@SuppressWarnings("null")
	public void TeamSelection2(String WK, String Bat, String AR, String Bowl) throws Exception {
		
		String st;
		boolean getDoneTutorial = true;
		
		if (getDoneTutorial) {

			Thread.sleep(2000);
			crtTeam.getDoneTutorial().click();
		
			st = crtTeam.getCreateNewTeamBtn().getText();
			System.out.println(st);

			List<WebElement> teamCount = null;
			switch (st) {
			// when 0 teams
			case "Create Team": {
				teamCount = crtTeam.getTeamCount();
				if (teamCount.size() >= 10) {
					driver.navigate().back();
					Thread.sleep(2000);
					Matchcount++;
					Select_The_Match();
				}

				Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getCreateNewTeamBtn())).click();

				count++;
				temp1 = alreadyCreateTeam + count;
				System.out.println("Already Created team :" + alreadyCreateTeam + "Newly Created Team :" + count
						+ "Total team Created : " + temp1);
				if (temp1 >= 10) {
					Thread.sleep(2000);
					driver.navigate().back();

					Matchcount++;
					count = 0;
					System.out.println("10 Team created in previous Match, Now switch to another match: " + Matchcount);
					Select_The_Match();
				}
				break;
			}

			// when team > 0
			case "My Teams": {
				System.out.println("Already Created Team = " + crtTeam.getTeamCount());
				alreadyCreateTeam = crtTeam.getTeamCount().size();
				if (alreadyCreateTeam == 10) {
					Thread.sleep(3000);
					driver.navigate().back();
					Matchcount++;
					alreadyCreateTeam = 0;
					Select_The_Match();
				} else {
					Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getCreateNewTeamBtn())).click();
					teamCount = crtTeam.getTeamCount();
					if (teamCount.size() >= 10) {
						driver.navigate().back();
						Thread.sleep(2000);
						Matchcount++;
						Select_The_Match();
					}

					Thread.sleep(2000);
					crtTeam.getCreateNewTeamBtn().click();

					count++;
				}

				break;
			}

			// allready 10 teams.
			default:
				if (teamCount.size() >= 10) {
					System.out.println("Default team count : " + teamCount.size());
					if (crtTeam.getCreateNewTeamBtn().isDisplayed() != true) {
						driver.navigate().back();
						Matchcount++;
						Select_The_Match();
					}
				}
			}

			Thread.sleep(1000);
			crtTeam.getS_Bysort().click();

			List<WebElement> playerType = crtTeam.getplayerType();

			List<WebElement> list1 = new ArrayList<WebElement>();

			Thread.sleep(1000);
			list1 = crtTeam.getMemberSelectionList();
			SelectPlayerInList(0, WK, list1, playerType.get(0), playerType.get(1));

			Thread.sleep(1000);
			list1 = crtTeam.getMemberSelectionList();
			SelectPlayerInList(1, Bat, list1, playerType.get(1), playerType.get(2));

			Thread.sleep(1000);
			list1 = crtTeam.getMemberSelectionList();
			SelectPlayerInList(2, AR, list1, playerType.get(2), playerType.get(3));

			Thread.sleep(1000);
			if (playerType.get(3).isSelected()) {
				crtTeam.getCR_sort().click();
				
			}

			list1 = crtTeam.getMemberSelectionList();
			SelectPlayerInList(3, Bowl, list1, playerType.get(3), null);
			playing11 = Integer.parseInt(crtTeam.getselectedplaying11members().getText());

			if (playing11 == 11) {
				Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getNextbtn())).click();
				captainSelection();
			} else
				System.out.println("wrong selection");
		}
		getDoneTutorial = false;
	}
	
	static int playing11 = 0;
	static int actualSize = 0;
	static int i = 0;

	static void SelectPlayerInList(int pos, String size, List<WebElement> PlayerListdemo, WebElement first,
			WebElement second) throws Exception {

		PlayerList = PlayerListdemo;
		if (first.isEnabled()) {
			actualSize = Integer.parseInt(size);
			playing11 = Integer.parseInt(crtTeam.getselectedplaying11members().getText());
			for (i = 0; i < actualSize;) {
				System.out.println(" selection start ");
				selectPlayerRandomIndex(pos);
			}
			playing11 = Integer.parseInt(crtTeam.getselectedplaying11members().getText());
			System.out.println("selected ocuont " + playing11);

			if (second != null)
				second.click();
			hs.clear();
		}
	}

	static void randomSelection() {
		generateRandomIndex();
	}

	static HashSet<Integer> hs = new HashSet<Integer>();
	static ArrayList<Integer> list = new ArrayList<Integer>();

	static void selectPlayerRandomIndex(int pos) {
		genrateList(pos);
		for (int cPos = 0; cPos < list.size(); cPos++) {
			int index = list.get(cPos);
			System.out.print("index " + index);

			WebElement element = PlayerList.get(index);
			int tempPos = -1;
			try {
				WebElement e = element.findElement(By.xpath("//div[@class='row disabled']"));
				if (!e.isDisplayed()) {
					System.out.println(" not displayed ");
					Wait.until(ExpectedConditions.elementToBeClickable(element)).click();
					i++;
					actualSize--;
				} else {
					System.out.println("fade displayed at " + index);

					for (int a = 0; a < list.size(); a++)
						System.out.print(" " + list.get(a));
					int no = -1;
					boolean flag = true;
					while (flag) {
						no = (int) (Math.random() * PlayerList.size());
						if (!list.contains(no)) {
							list.add(no);
							list.remove(cPos);
							tempPos = no;
							System.out.println("break value " + tempPos);
							flag = false;
							break;
						}
					}
					for (int a = 0; a < list.size(); a++)
						System.out.print(" " + list.get(a));
					System.out.println("new pos  " + tempPos);
					cPos--;
				}
			} catch (Exception e) {
				System.out.println("error no fade ");
				Wait.until(ExpectedConditions.elementToBeClickable(element)).click();
				i++;
				actualSize--;
			}
		}
	}

	static void genrateList(int pos) {
		list.clear();
		/*
		 * switch(pos) { case 0:{ list.add(0); list.add(2); break; } case 1:{
		 * 
		 * list.add(1); list.add(2); list.add(3); break; } case 2:{ list.add(5);
		 * list.add(1); list.add(3); list.add(4);
		 * 
		 * break; } case 3:{ list.add(0); list.add(1); break; } }
		 */

		while (list.size() < actualSize) {
			int num = (int) (Math.random() * PlayerList.size());
			if (!list.contains(num))
				list.add(num);
		}

	}

	static void generateRandomIndex() {
		int size = PlayerList.size();
		while (hs.size() < actualSize) {
			int num = (int) (Math.random() * size);
			hs.add(num);
		}
	}

	public void captainSelection() throws Exception {
		System.out.print("start captain selection ");
		int c = 0, vc = 1;
		try {
			List<WebElement> selectCaptainlist = crtTeam.getCaptainTextBox();
			List<WebElement> selectViceCaptainlist = crtTeam.getViceCaptainBox();

			/*
			 * if (selectCaptainlist.size() >= 0 && selectViceCaptainlist.size() >= 0) {
			 * 
			 * Random randomGenerator = new Random(); c =
			 * randomGenerator.nextInt(selectCaptainlist.size()); vc =
			 * randomGenerator.nextInt(selectViceCaptainlist.size() / 2);
			 * 
			 * System.out.println("Captain List Size = " + selectCaptainlist.size() +
			 * "Vice Captain List size = " + selectViceCaptainlist.size());
			 * 
			 * System.out.println("captain = " + c + "ViceCaptain :" + vc); }
			 * 
			 * 
			 * 
			 * if (c == vc) { captainSelection(); }
			 */

			Thread.sleep(1000);
			Wait.until(ExpectedConditions.elementToBeClickable(selectCaptainlist.get(c))).click();
			Thread.sleep(1000);
			Wait.until(ExpectedConditions.elementToBeClickable(selectViceCaptainlist.get(vc))).click();
		} catch (Exception e) {
			e.printStackTrace();
			captainSelection();
		}

		Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getSaveteambtn())).click();
	} // function close

}