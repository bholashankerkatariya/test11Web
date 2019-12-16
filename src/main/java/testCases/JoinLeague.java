package testCases;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.csvreader.CsvReader;

import objectRepository.CreateTeamRepo;

public class JoinLeague {

	int leagueCount = 1;
	int Matchcount = 9;
	WebDriver driver;
	WebDriverWait Wait;
	CreateTeamRepo crtTeam;
	JavascriptExecutor js;

	public JoinLeague(WebDriver _driver, WebDriverWait _Wait) {
		driver = _driver;
		Wait = _Wait;
		crtTeam = PageFactory.initElements(driver, CreateTeamRepo.class);
		js = (JavascriptExecutor) driver;
	}

	public void Select_The_Match() throws Exception {

		Thread.sleep(5000);
		List<WebElement> matchlist = null;

		try {
			
			js.executeScript("$( \".scroling_div\" ).scrollTop(9999999999999999999999);");
			js.executeScript("$( \".scroling_div\" ).scrollTop(999999999999999999999);");
			js.executeScript("$( \".scroling_div\" ).scrollTop(99999999999999999999);");
			js.executeScript("$( \".scroling_div\" ).scrollTop(99999999999999999999);");
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		matchlist = driver.findElements(By.xpath("//*[@class='match_listing']/div/div"));

		// get the match list and print
		System.out.println("Number of matches:" + matchlist.size());
		Thread.sleep(2000);
		matchlist.get(Matchcount).click();

		/*
		 * if (crtTeam.getMyteamsBtn().isDisplayed()) {
		 * Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getMyteamsBtn())).
		 * click(); System.out.println("Clicked on Myteam" + "button"); }
		 * 
		 * else {
		 * 
		 * crtTeam.getCreateNewTeamBtn().click();
		 * 
		 * }
		 */

		/*
		 * public void SelectPlayers(int WK, int BAT, int AR, int Bowl) {
		 * 
		 * List <WebElement> WicketKeeper = (List<WebElement>)
		 * driver.findElements(By.xpath("//a[@class='select_player']"));
		 * System.out.println("Wicket Keeper in list:"+ WicketKeeper.size());
		 * WicketKeeper.get(WK);
		 * 
		 * crtTeam.getWicketKipper(); }
		 */
	}

	int temp = 0;

	public void JoinContests() throws Exception {

		boolean getDoneTutorial = true;
		int i;
		java.util.List<WebElement> Teamlist = null;

		if (getDoneTutorial)

		{

			Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getDoneTutorial())).click();

			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}

			java.util.List<WebElement> LeagueList = driver
					.findElements(By.xpath("//div[@class = 'contest_data_list contests']/div"));
			LeagueList.get(leagueCount).click();

			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}

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

			// go back to home screen
			Thread.sleep(4000);
			crtTeam.getGotoHome().click();
		}

		else {

			java.util.List<WebElement> LeagueList = driver
					.findElements(By.xpath("//div[@class = 'contest_data_list contests']/div"));

			LeagueList.get(leagueCount).click();

			Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getLeagueJoinNowbtn())).click();

			Teamlist = driver.findElements(By.xpath("//ul[@class='teams_list']/li"));

			for (i = 0; i < Teamlist.size(); i++) {

				System.out.println("Teamlist: " + Teamlist.get(i).getAttribute("class"));

				if (Teamlist.get(i).getAttribute("class").equals("disable_5")) {

					continue;

				}

				try {

					Teamlist.get(i).click();

					crtTeam.getJoinContest().click();
					crtTeam.getLeagueJoinNowbtnPopup().click();

				} catch (Exception e) {

					e.printStackTrace();
				}

			}

		}

	}

	public void JoinPrivateContest() {

		boolean getDoneTutorial = true;
		int i;
		java.util.List<WebElement> Teamlist = null;

		if (getDoneTutorial)

		{

			Wait.until(ExpectedConditions.elementToBeClickable(crtTeam.getDoneTutorial())).click();

			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}

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
					List<String> test;
					
					try {
						
						String PvtContestCode = crtTeam.getGetCodeofPvtContest().getText();
						
						Thread.sleep(2000);
						String path = "ddt/privateContestcode.csv";
						
						Csvwriter = new FileWriter(path);
						test = new ArrayList<>();
						test.add(PvtContestCode);
						
						for (int j = 0; j < test.size(); j++) {
							Csvwriter.append(String.valueOf(j));
							Csvwriter.append("\n");
						}
						
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

}