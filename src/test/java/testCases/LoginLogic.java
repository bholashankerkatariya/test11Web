package testCases;

import action.Action;
import objectRepository.LogOutRepository;
import objectRepository.LoginRepository;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import utils.CSVDataReader;

import java.util.Iterator;
import java.util.Set;


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

	public void BlankSubmitLogin() throws InterruptedException {
		//actions = new Actions(driver);
		// System.out.println("in loop: "+ lg.getSigninlnk().getText());

		Thread.sleep(2000);
		loginRepo.getSigninlnk().click();
		Thread.sleep(2000);
		loginRepo.getSigninbtn().click();
		System.out.println("Enter Email / Mobile" + " Password is required");
		Thread.sleep(2000);
	}

	public void Login_Invalid_Password(String Username, String Password) throws InterruptedException {
		actions = new Actions(driver);
		actions.moveToElement(loginRepo.getSigninbtn()).perform();
		Thread.sleep(500);
		loginRepo.getUsernametxt().clear();
		loginRepo.getUsernametxt().sendKeys(Username);
		loginRepo.getPasswordtxt().clear();
		loginRepo.getPasswordtxt().sendKeys("test@123");
		Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getSubmitbtn())).click();
		System.out.println("Password is Incorrect");
		Thread.sleep(2000);
	}

	public void Login_with_wrong_Email(String Username, String Password) throws InterruptedException {
		actions = new Actions(driver);
		actions.moveToElement(loginRepo.getSigninbtn()).perform();
		Thread.sleep(500);
		loginRepo.getUsernametxt().clear();
		loginRepo.getUsernametxt().sendKeys("myteam11@gm");
		loginRepo.getPasswordtxt().clear();
		loginRepo.getPasswordtxt().sendKeys(Password);

		Thread.sleep(1000);
		loginRepo.getSubmitbtn().click();
		System.out.println("You are not registered with Entered email Id");
	}

	public void Login_with_Valid_Credentials(String Username, String Password) throws InterruptedException {
		actions = new Actions(driver);
		Thread.sleep(2000);
		String URL = driver.getCurrentUrl();

		if (URL.contains("landing")) {
			System.out.println("User going to login");

			Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getSigninlnk())).click();

			Thread.sleep(1000);
			js.executeScript("$(\".scroling_div\").scrollTop(9999999999999999999999);");

			loginRepo.getUsernametxt().clear();
			loginRepo.getUsernametxt().sendKeys(Username);
			loginRepo.getPasswordtxt().clear();
			loginRepo.getPasswordtxt().sendKeys(Password);

			Thread.sleep(2000);
			loginRepo.getSubmitbtn().click();
			Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getTutorialSkipButton())).click();
			System.out.println("User logged in successfully");

			//close addpopup 
			act.PopClose(loginRepo);
		}

		Thread.sleep(2000);
		String URL1 = driver.getCurrentUrl();

		if (URL1.contains("login")) {

			Thread.sleep(1000);
			loginRepo.getUsernametxt().clear();
			loginRepo.getUsernametxt().sendKeys(Username);
			loginRepo.getPasswordtxt().clear();
			loginRepo.getPasswordtxt().sendKeys(Password);
			Thread.sleep(2000);
			loginRepo.getSubmitbtn().click();
			Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getTutorialSkipButton())).click();
			System.out.println("User LoggedIn Successfully");

			//close add popup
			act.PopClose(loginRepo);
		}
	}


	public void Go_To_profile() throws InterruptedException {
		Thread.sleep(2000);
		logoutRepo.getLeftPanelprfl().click();
		Wait.until(ExpectedConditions.elementToBeClickable(logoutRepo.getMyProfile())).click();
		Wait.until(ExpectedConditions.elementToBeClickable(loginRepo.getTutorialSkipButton())).click();
		Thread.sleep(2000);
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

		Go_To_profile();
		Thread.sleep(2000);
		actions = new Actions(driver);
		actions.moveToElement(logoutRepo.getLogoutbtn()).perform();

		Wait.until(ExpectedConditions.elementToBeClickable(logoutRepo.getLogoutbtn())).click();
		System.out.println("User Logged Out Successfully");
		Thread.sleep(2000);
		driver.quit();
	}
}

