package testCases;

import java.io.FileWriter;
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

import objectRepository.CreateTeamRepo;
import objectRepository.LogOutRepository;
import objectRepository.LoginRepository;
import objectRepository.createTeamObject;

public class JoinLeague {

	int leagueCount = 2;
	int Matchcount = 3;
	int LeagueAmountposition = 0;
	int Leagueamnt = 0;
	WebDriver driver;
	WebDriverWait Wait;
	CreateTeamRepo crtTeam;
	JavascriptExecutor js;
	boolean getDoneTutorial = true;

	createTeamObject createTeam;
	LogOutRepository logoutRepo;
	LoginRepository loginRepo;
	Login login;
	Actions actions;
	boolean skip = true;
	boolean done = true;
	int temp = 0;
	int temp1 = 0;
	int count = 0;
	int alreadyCreateTeam = 0;
	List<WebElement> matchList = null;

	// global declared
	java.util.List<WebElement> LeagueSize;
	java.util.List<WebElement> LeagueAmount;

	public JoinLeague(WebDriver _driver, WebDriverWait _Wait) {
		driver = _driver;
		Wait = _Wait;
		crtTeam = PageFactory.initElements(driver, CreateTeamRepo.class);
		js = (JavascriptExecutor) driver;

	
		//js = (JavascriptExecutor) driver;
		loginRepo = PageFactory.initElements(driver, LoginRepository.class);
		createTeam = PageFactory.initElements(driver, createTeamObject.class);
		logoutRepo = PageFactory.initElements(driver, LogOutRepository.class);
	}

	public void Select_The_Match() throws Exception {

		Thread.sleep(2000);
		List<WebElement> matchlist = null;

		Wait.until(ExpectedConditions.visibilityOf(crtTeam.getMatchList()));
		Thread.sleep(2000);

		try {
			js.executeScript("$( \".scroling_div\" ).scrollTop(9999999);");
			matchlist = driver.findElements(By.xpath("//div[@class='match_listing']/div"));
			Thread.sleep(1000);
			js.executeScript("$( \".scroling_div\" ).scrollTop(9999999);");
		} catch (Exception e) {

			e.printStackTrace();
		}

		matchlist = driver.findElements(By.xpath("//*[@class='match_listing']/div/div"));

		// get the match list and print
		System.out.println("Number of matches:" + matchlist.size());
		Thread.sleep(2000);
		matchlist.get(Matchcount).click();

		
		if (getDoneTutorial)

		{

			Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getDoneTutorial())).click();
		}

		getDoneTutorial = false;

	}

	public void JoinContests() throws Exception {

		
		int i;
		java.util.List<WebElement> Teamlist = null;


		if (getDoneTutorial)

		{

			Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getDoneTutorial())).click();

			Thread.sleep(2000);

			java.util.List<WebElement> LeagueList = driver
					.findElements(By.xpath("//div[@class = 'contest_data_list contests']/div"));
			LeagueList.get(leagueCount).click();

			Thread.sleep(2000);

			//
			crtTeam.getLeagueJoinNowbtn().click();

			Thread.sleep(4000);

			Teamlist = driver.findElements(By.xpath("//ul[@class='teams_list']/li"));

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

					Teamlist = driver.findElements(By.xpath("//ul[@class='teams_list']/li"));
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

			java.util.List<WebElement> LeagueList = driver
					.findElements(By.xpath("//div[@class = 'contest_data_list contests']/div"));
			LeagueList.get(leagueCount).click();

			Thread.sleep(2000);

			//
			crtTeam.getLeagueJoinNowbtn().click();

			Thread.sleep(4000);

			Teamlist = driver.findElements(By.xpath("//ul[@class='teams_list']/li"));

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

					Teamlist = driver.findElements(By.xpath("//ul[@class='teams_list']/li"));
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

			try {
				Thread.sleep(4000);
			} catch (Exception e) {
				e.printStackTrace();

			}

			Teamlist = driver.findElements(By.xpath("//ul[@class='teams_list']/li"));

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

	// join league more than 100 members and league amount less than 100
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

	// join league Less than 100 members and league amount less than 100
	public void joinleagueLessThan100Member() throws InterruptedException {

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

			for (int j = 0; j < LeagueSize.size(); j++) {
				String arSplit = LeagueSize.get(j).getText();
				String teamcount[] = arSplit.split(" ");
				System.out.println(teamcount[0]);

				String arrSplit = LeagueAmount.get(j).getText();
				String Leagueamnt[] = arrSplit.split("₹");
				System.out.println(Leagueamnt[1]);

				System.out.println(Integer.parseInt(Leagueamnt[1]) < 100 && Integer.parseInt(teamcount[0]) < 100);

				if (Integer.parseInt(Leagueamnt[1]) < 100 && Integer.parseInt(teamcount[0]) < 100) {

					System.out.println(LeagueAmount.get(LeagueAmountposition).getText());

					WebElement element = LeagueAmount.get(LeagueAmountposition);

					((JavascriptExecutor) driver).executeScript("$('.scroling_div').scrollTop(0);", element);

					LeagueAmount.get(LeagueAmountposition).click();

					break;

				}

			}

		}

	}

	// join league 2 members and league amount less than 100
	public void joinleague2Members() throws InterruptedException {

		if (getDoneTutorial)

		{

			Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getDoneTutorial())).click();
			Thread.sleep(5000);

			crtTeam.getAllContests().click();

			Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getDoneTutorial())).click();
			Thread.sleep(2000);

			crtTeam.getTeamDcrementsort().click();

			try {

				// WebElement element = LeagueAmount.get(LeagueAmountposition);

				((JavascriptExecutor) driver)
						.executeScript("$('.scroling_div').scrollTop(9999999999999999999999999999);");

			} catch (Exception e) {

				e.printStackTrace();
			}

			LeagueSize = driver
					.findElements(By.xpath("//div[@class='contest_data_list contests']/div/div/div/div[3]/div[3]"));

			LeagueAmount = driver.findElements(By.xpath("//div[@class='bottom_strip']/p/span/a/span"));

			for (int j = 0; j < LeagueSize.size(); j++) {
				String arSplit = LeagueSize.get(j).getText();
				String teamcount[] = arSplit.split(" ");
				System.out.println(teamcount[0]);

				String arrSplit = LeagueAmount.get(j).getText();
				String Leagueamnt[] = arrSplit.split("₹");
				System.out.println(Leagueamnt[1]);

				System.out.println(Integer.parseInt(Leagueamnt[1]) < 100 && Integer.parseInt(teamcount[0]) < 2);

				if (Integer.parseInt(Leagueamnt[1]) < 100 && Integer.parseInt(teamcount[0]) < 3) {

					System.out.println(LeagueAmount.get(LeagueAmountposition).getText());

					WebElement element = LeagueAmount.get(LeagueAmountposition);

					((JavascriptExecutor) driver).executeScript("$('.scroling_div').scrollTop(0);", element);

					LeagueAmount.get(LeagueAmountposition).click();

					break;

				}

			}

		}

	}

	public void SelectPlayerInList(String size, List<WebElement> PlayerList, WebElement first, WebElement second)
			throws Exception {
		if (first.isEnabled()) {
			int actualSize = Integer.parseInt(size);
			String playing11 = createTeam.getselectedplaying11members().getText();
			// System.out.println("Playing 11 : " + playing11);
			Thread.sleep(2000);
			String[] temp = playing11.split("(?=/)");
			// System.out.println(temp[0]);

			int memberSelected = Integer.parseInt(temp[0].trim());

			for (int i = 0; i < actualSize; i++) {

				if (memberSelected <= 11) {

					if (createTeam.getfirstTeamPlayerSelected().getText().equals("7")
							|| createTeam.getsecoundTeamPlayerSelected().getText().equals("7")) {
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
					WebElement element = createTeam.getPlayerlist();
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					PlayerList.get(index).click();
					PlayerList = driver.findElements(By.xpath("//div[@class='row']/a"));
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			second.click();

		} // FOR LOOP CLOSE
	}// fUNCTION close

	@SuppressWarnings("null")
	public void TeamSelection(String WK, String Bat, String AR, String Bowl) throws Exception {

		Thread.sleep(2000);

		String st = createTeam.getfooterButton().getText();
		if (st.contains("MY")) {
			st = "MY TEAMS";
		}
		System.out.println(st);

		List<WebElement> teamCount = null;
		Thread.sleep(3000);
		switch (st) {

		case "CREATE NEW TEAM": {

			if (temp == 1) {
				teamCount = driver.findElements(By.xpath("//div[@class='team_data']"));
				if (teamCount.size() >= 10) {
					createTeam.gethomeButton().click();
					Thread.sleep(2000);
					Matchcount++;
					Select_The_Match();
				}

			}

			Wait.until(ExpectedConditions.elementToBeClickable(createTeam.getcreateNewButton())).click();

			if (skip) {
				Thread.sleep(2000);
				Wait.until(ExpectedConditions.elementToBeClickable(createTeam.getTutorialSkipButton())).click();
				skip = false;
			}

			// System.out.println("Team count : "+teamCount.size());
			count++;
			temp1 = alreadyCreateTeam + count;
			System.out.println("Already Created team :" + alreadyCreateTeam + "Newly Created Team :" + count
					+ " Total team Created : " + temp1);
			if (temp1 >= 10) {
				Thread.sleep(2000);
				Wait.until(ExpectedConditions.elementToBeClickable(createTeam.gethomeButton())).click();

				Matchcount++;
				count = 0;
				System.out.println("10 Team created in previous Match, Now switching to Next match : " + Matchcount);
				Select_The_Match();
			}
			break;

		}

		case "MY TEAMS": {

			String footerButton = createTeam.getfooterButton().getText();
			String[] arr = footerButton.split("\n");
			if (arr[0].equalsIgnoreCase("MY TEAMS")) {

				alreadyCreateTeam = Integer.parseInt(arr[1]);
				if (arr[1].equals("10")) {
					Thread.sleep(3000);
					createTeam.getbackButton().click();
					Matchcount++;
					Select_The_Match();
				}
			}

			Wait.until(ExpectedConditions.elementToBeClickable(createTeam.getmyTeamButton())).click();

			teamCount = driver.findElements(By.xpath("//div[@class='team_data']"));

			if (teamCount.size() >= 10) {
				createTeam.gethomeButton().click();
				Thread.sleep(2000);
				Matchcount++;
				Select_The_Match();

			}

			Thread.sleep(2000);
			createTeam.getcreateNewButton().click();
			if (skip) {
				Thread.sleep(3000);
				Wait.until(ExpectedConditions.elementToBeClickable(createTeam.getTutorialSkipButton())).click();
				skip = false;
			}
			count++;
			temp = 1;
			break;
		}

		default:
			
			teamCount = driver.findElements(By.xpath("//div[@class='team_data']"));
			if (teamCount.size() >= 10) {

				if (createTeam.getfooterButton().isDisplayed() != true) {
					createTeam.gethomeButton().click();
					++Matchcount;
					Select_The_Match();

				}
			}


			Thread.sleep(1000);
			createTeam.getSBYButton().click();

			List<WebElement> list1 = driver.findElements(By.xpath("//a[@class='select_player']"));
			SelectPlayerInList(WK, list1, createTeam.getWicketKeeperPlayerType(), createTeam.getBetterPlayerType());

			list1 = driver.findElements(By.xpath("//a[@class='select_player']"));
			SelectPlayerInList(Bat, list1, createTeam.getBetterPlayerType(), createTeam.getAllRounderPlayerType());

			list1 = driver.findElements(By.xpath("//a[@class='select_player']"));
			SelectPlayerInList(AR, list1, createTeam.getAllRounderPlayerType(), createTeam.getBowlerPlayerType());

			list1 = driver.findElements(By.xpath("//a[@class='select_player']"));
			SelectPlayerInList(Bowl, list1, createTeam.getBowlerPlayerType(), createTeam.getNextbtn());

			try {

				js.executeScript("$( \".scroling_div\" ).scrollTop(9999999);");
				List<WebElement> selectCaptain = driver.findElements(By.xpath("//a[@class='c_sect']/span"));
				List<WebElement> selectViceCaptain = driver.findElements(By.xpath("//a[@class='vc_sect']/span"));
				Random randomGenerator = new Random();
				int c = randomGenerator.nextInt(selectCaptain.size());
				int VC = randomGenerator.nextInt(selectViceCaptain.size());
				System.out.println("    " + c + "   " + VC);

				selectCaptain.get(selectCaptain.size() - 2).click();

				selectViceCaptain.get(selectViceCaptain.size() - 3).click();

				Thread.sleep(3500);
				createTeam.getSAVEbtn().click();

			}

			catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}