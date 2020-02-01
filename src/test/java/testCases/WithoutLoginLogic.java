package testCases;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import action.Action;
import objectRepository.BeforeLogicRepository;
import objectRepository.CreateTeamRepo;
import utils.Browser;

public class WithoutLoginLogic extends Browser {
	BeforeLogicRepository beforelogin;
	WebDriverWait Wait;
	CreateTeamRepo ct;
	Action action;

	public WithoutLoginLogic() {

		ct = PageFactory.initElements(driver, CreateTeamRepo.class);
		beforelogin = PageFactory.initElements(driver, BeforeLogicRepository.class);
	}

	public void ClickOnPlayNow() throws InterruptedException {

		if (beforelogin.getMyteamImg().isDisplayed()) {
			System.out.println("Verified Myteam11 Logo on Play now screen");
			
			Actions actions = new Actions(driver);
			actions.moveToElement(beforelogin.getPlayNowbtn());
			actions.perform();
			
			beforelogin.getPlayNowbtn().click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			beforelogin.getSkipTutorial().click();
		}

	}

	public void Verifymatchlist() {

		if (beforelogin.getGameslist().isDisplayed()) {
			System.out.println("Match List appeared on screen");

		}

	}

	public void SelectMatch() throws Exception {

		beforelogin.getSkipTutorial().click();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		ArrayList<WebElement> list = (ArrayList<WebElement>) driver
				.findElements(By.xpath("//*[@class='match_listing']//a"));
		System.out.println("list - match list : " + list.size());
		Thread.sleep(3000);
		list.get(0).click();

	}

	public void ChangeInSafeMode() {

		if (beforelogin.getSafeMode().isSelected()) {

			System.out.println("You are playing in safe mode");
		}
	}

	public void ChangeInRegularMode() {

		if (beforelogin.getSafeMode().isSelected()) {
			beforelogin.getRegularMode().click();
			System.out.println("You are playing in safe mode");
		}

	}

	public void CreateTeame() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		beforelogin.getSkipTutorial().click();

		Wait.until(ExpectedConditions.visibilityOf(ct.getS_Bysort()));
		ct.getWicketKipper().click();
		ct.getWicketKipper().click();

		Wait.until(ExpectedConditions.visibilityOf(ct.getS_Bysort()));
		ct.getS_Bysort().click();
		WebElement list1 = ct.getPlayerRoles();

		SelectPlayerInList(1, list1, ct.getWicketKipper(), ct.getBatsman());

		list1 = ct.getWicketKipper();
		SelectPlayerInList(4, list1, ct.getPlayerRoles(), ct.getWicketKipper());

		list1 = ct.getPlayerRoles();
		SelectPlayerInList(2, list1, ct.getAllrounder(), ct.getBowler());

		list1 = ct.getPlayerRoles();
		SelectPlayerInList(4, list1, ct.getBowler(), ct.getNextbtn());

		Wait.until(ExpectedConditions.visibilityOf(ct.getSelectC()));
		ct.getSelectC().click();

		ct.getSelectVC().click();

		Wait.until(ExpectedConditions.visibilityOf(ct.getSaveteambtn())).click();
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
