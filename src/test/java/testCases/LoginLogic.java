package testCases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import action.Action;
import objectRepository.LogOutRepository;
import objectRepository.LoginRepository;
import utils.CSVDataReader;

public class LoginLogic {

	WebDriver driver;
	WebDriverWait Wait;
	LoginRepository loginRepo;
	LogOutRepository logoutRepo;
	Actions actions;
	
	Action act;
	
	JavascriptExecutor js;
	WebElement closeButtonList;

	public LoginLogic(WebDriver _driver, WebDriverWait _Wait) {
		driver = _driver;
		Wait = _Wait;
		logoutRepo = PageFactory.initElements(driver, LogOutRepository.class);
		loginRepo = PageFactory.initElements(driver, LoginRepository.class);
		js = (JavascriptExecutor) driver;
		act = new Action();
	}

	@DataProvider(name = "Login")
	public Object[][] CSVReader() throws Exception {
		return CSVDataReader.DDTReader("ddt/LoginPage.csv");
	}

	public void BlankSubmitLogin() {
		// System.out.println("in loop: "+ lg.getSigninlnk().getText());
		Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getSigninlnk())).click();
		Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getSigninbtn())).click();
		System.out.println("Enter Email / Mobile" + " Password is required");
	}

	public void Login_Invalid_Password(String Username, String Password) throws InterruptedException {
		actions = new Actions(driver);
		actions.moveToElement(loginRepo.getSigninbtn()).perform();

		loginRepo.getUsernametxt().clear();
		loginRepo.getUsernametxt().sendKeys(Username);
		loginRepo.getPasswordtxt().clear();
		Thread.sleep(4000);
		loginRepo.getPasswordtxt().sendKeys("test@123");
		Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getSubmitbtn())).click();
		System.out.println("Password is Incorrect");
	}

	public void Login_with_wrong_Email(String Username, String Password) {
		actions = new Actions(driver);
		actions.moveToElement(loginRepo.getSigninbtn()).perform();

		loginRepo.getUsernametxt().clear();
		loginRepo.getUsernametxt().sendKeys("myteam11@gm");
		loginRepo.getPasswordtxt().clear();
		loginRepo.getPasswordtxt().sendKeys(Password);

		Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getSubmitbtn())).click();
		System.out.println("User Doesn't Exists");
	}

	public void Login_with_Valid_Credentials(String Username, String Password) throws InterruptedException {

		Thread.sleep(2000);
		String URL = driver.getCurrentUrl();

		if (URL.contains("landing")) {

			Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getSigninlnk())).click();
			Thread.sleep(2000);
			js.executeScript("$(\".scroling_div\").scrollTop(99999999999999999999999);");

			loginRepo.getUsernametxt().clear();
			loginRepo.getUsernametxt().sendKeys(Username);
			loginRepo.getPasswordtxt().clear();
			loginRepo.getPasswordtxt().sendKeys(Password);

			Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getSubmitbtn())).click();
			Thread.sleep(4000);
			loginRepo.getTutorialSkipButton().click();

			Thread.sleep(2000);
			
			//close add popup 
			act.PopClose(loginRepo);

		}

		else {

			actions = new Actions(driver);
			Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getSigninlnk())).click();
			// actions.moveToElement(loginRepo.getSigninbtn()).perform();

			loginRepo.getUsernametxt().clear();
			loginRepo.getUsernametxt().sendKeys(Username);
			loginRepo.getPasswordtxt().clear();
			loginRepo.getPasswordtxt().sendKeys(Password);

			Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getSubmitbtn())).click();
			Thread.sleep(2000);
			Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getTutorialSkipButton())).click();
			System.out.println("User LoggedIn Successfully");

		}
	}

	public void Go_To_profile() throws InterruptedException {

		Thread.sleep(2000);
		logoutRepo.getLeftPanelprfl().click();
		Wait.until(ExpectedConditions.elementToBeClickable(logoutRepo.getMyProfile())).click();
		Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getTutorialSkipButton())).click();
	}

	public void Login_With_FB() throws Exception {

		String parentWindowHandler = driver.getWindowHandle();
		String childWindowHandler = null;

		driver.switchTo().window(parentWindowHandler);

		System.out.print("Regirected to from :" + loginRepo.getFacebookEmailTextBox());

		Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getSigninlnk())).click();

		Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getFacebookLoginButton())).click();

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			childWindowHandler = iterator.next();
		}

		driver.switchTo().window(childWindowHandler); // switch to popup window

		loginRepo.getFacebookEmailTextBox().sendKeys("testqa.auth@gmail.com");
		loginRepo.getFacebookPasswordTextBox().clear();
		loginRepo.getFacebookPasswordTextBox().sendKeys("bhola@786");
		loginRepo.getFacebookLoginsubmit().click();
		driver.switchTo().window(parentWindowHandler);
	}

	public void Login_With_Google() throws Exception {

		Thread.sleep(4000);
		String parentWindowHandler = driver.getWindowHandle();
		String childWindowHandler = null;

		driver.switchTo().window(parentWindowHandler);

		System.out.print("Regirected to from :" + loginRepo.getGoogleLoginButton());

		Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getSigninlnk())).click();

		Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getGoogleLoginButton())).click();

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			childWindowHandler = iterator.next();
		}

		driver.switchTo().window(childWindowHandler); // switch to popup window

		loginRepo.getGoogleEmailTextBox().clear();
		Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getGoogleEmailTextBox()))
				.sendKeys("testqa.auth@gmail.com");

		Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getGooglePopUpNextButton())).click();

		loginRepo.getGooglePasswordTextBox().clear();

		Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getGooglePasswordTextBox())).sendKeys("bhola@123");

		Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getGooglePopUpPasswordNextButton())).click();

		driver.switchTo().window(parentWindowHandler);
	}

	public void logout() throws InterruptedException {
		Thread.sleep(2000);
		actions = new Actions(driver);
		actions.moveToElement(logoutRepo.getLogoutbtn()).perform();

		Wait.until(ExpectedConditions.elementToBeClickable(logoutRepo.getLogoutbtn())).click();
		System.out.println("User LoggedOut Successfully");
		Thread.sleep(4000);
		driver.quit();
	}

}