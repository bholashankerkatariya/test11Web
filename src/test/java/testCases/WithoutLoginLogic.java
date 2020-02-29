/*

package testCases;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import objectRepository.BeforeLogicRepository;
import objectRepository.CreateTeamRepo;
import utils.Browser;

public class WithoutLoginLogic extends Browser {
	BeforeLogicRepository beforeloginRepo;
	WebDriverWait Wait;
	CreateTeamRepo crtRepo;
	Actions action;
	WebDriver driver;

	public WithoutLoginLogic(WebDriver _driver, WebDriverWait _Wait) {
		driver = _driver;
		Wait = _Wait;
		crtRepo = PageFactory.initElements(driver, CreateTeamRepo.class);
		beforeloginRepo = PageFactory.initElements(driver, BeforeLogicRepository.class);
	}

	public void ClickOnPlayNow() throws InterruptedException {

		if (beforeloginRepo.getMyteamImg().isDisplayed()) {
			System.out.println("Verified Myteam11 Logo on Play now screen");

			Actions actions = new Actions(driver);
			actions.moveToElement(beforeloginRepo.getPlayNowbtn());
			actions.perform();

			beforeloginRepo.getPlayNowbtn().click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			beforeloginRepo.getSkipTutorial().click();
		}

	}

	public void Verifymatchlist() {

		if (beforeloginRepo.getGameslist().isDisplayed()) {
			System.out.println("Match List appeared on screen");
		}

	}

	public void SelectMatch() throws Exception {

		beforeloginRepo.getSkipTutorial().click();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		ArrayList<WebElement> list = (ArrayList<WebElement>) driver
				.findElements(By.xpath("//*[@class='match_listing']//a"));
	System.out.println("list - match list : " + list.size());
		Thread.sleep(3000);
		list.get(0).click();

	}

	public void ChangeInSafeMode() {

		if (beforeloginRepo.getSafeMode().isSelected()) {

			System.out.println("You are playing in safe mode");
		}
	}

	public void ChangeInRegularMode() {

		if (beforeloginRepo.getSafeMode().isSelected()) {
			beforeloginRepo.getRegularMode().click();
			System.out.println("You are playing in safe mode");
		}
	}

	public void CreateTeame() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		beforeloginRepo.getSkipTutorial().click();
		Wait.until(ExpectedConditions.visibilityOf(crtRepo.getS_Bysort()));
		crtRepo.getWicketKipper().click();
		crtRepo.getWicketKipper().click();

		Wait.until(ExpectedConditions.visibilityOf(crtRepo.getS_Bysort()));
	crtRepo.getS_Bysort().click();
		WebElement list1 = crtRepo.getPlayerRoles();

		SelectPlayerInList(1, list1, crtRepo.getWicketKipper(), crtRepo.getBatsman());

		list1 = crtRepo.getWicketKipper();
		SelectPlayerInList(4, list1, crtRepo.getPlayerRoles(), crtRepo.getWicketKipper());

		list1 = crtRepo.getPlayerRoles();
		SelectPlayerInList(2, list1, crtRepo.getAllrounder(), crtRepo.getBowler());

		list1 = crtRepo.getPlayerRoles();
		SelectPlayerInList(4, list1, crtRepo.getBowler(), crtRepo.getNextbtn());

		Wait.until(ExpectedConditions.visibilityOf(crtRepo.getSelectC()));
		crtRepo.getSelectC().click();

		crtRepo.getSelectVC().click();

		Wait.until(ExpectedConditions.visibilityOf(crtRepo.getSaveteambtn())).click();
	}

	static void SelectPlayerInList(int size, WebElement list1, WebElement first, WebElement second) {
		if (first.isEnabled()) {

			for (int i = 0; i < size; i++) {
				System.out.println("get the list" + (list1));

				// list1.get(i).click();

			}
			second.click();
		}

	}

}

*/
