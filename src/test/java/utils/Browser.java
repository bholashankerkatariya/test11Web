package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;

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

            options.setPageLoadStrategy(PageLoadStrategy.NONE);

            options.addArguments(
                    "start-maximized",
                    "enable-automation",
                    "--disable-infobars",
                    "--no-sandbox",
                    "--disable-gpu",
                    "--disable-dev-shm-usage",
                    "--disable-browser-side-navigation",
                    "--disable-notifications"
            );

            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver(options);
            

            driver.get(live);
            Wait = new WebDriverWait(driver, 30);
            Wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
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
