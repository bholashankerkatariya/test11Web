package utils;

import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {

	public WebDriver driver = null;
	public WebDriverWait Wait;
	String live = "https://myteam11.com/fantasy-sports/landing";;
	String goteam = "https://goteam11.com/fantasy-sports/landing";
	String n2 = "http://m.myteam11.in/fantasy-sports/landing";

	
	public Browser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			//System.out.println("chrome browser is opening");
			String path = Paths.get("").toAbsolutePath().toString();

			//disable notification popup
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Bhola Shankar\\eclipse-workspace\\Myteam11Web\\Drivers\\chromedriver_79.exe");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();

			driver.get(live);
			Wait = new WebDriverWait(driver, 30);

		}

		/* if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("Firefox browser is opening"); 
			// String path =
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Bhola Shankar\\eclipse-workspace\\Myteam11Web\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(live);
			driver.manage().window().maximize();
			Wait = new WebDriverWait(driver, 30);
			String alertMessage = driver.switchTo().alert().getText();
			System.out.println(alertMessage);

		}

		if (browser.equalsIgnoreCase("Edge")) {
			System.out.println("Microsoft Edge browser"); // String path =
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\Bhola Shankar\\eclipse-workspace\\Myteam11Web\\Drivers\\msedgedriver80.361.50.exe");
			driver = new EdgeDriver();
			driver.get(live);
			driver.manage().window().maximize();
			Wait = new WebDriverWait(driver, 30);

		}*/
	}

	 /* public WebDriver getDriver() { if (driver == null) { driver = new
	  ChromeDriver(); return driver; } else return driver; }
	 */
}
