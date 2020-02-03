package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {

	public WebDriver driver;
	public WebDriverWait Wait;

	public void chrome() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Bhola Shankar\\eclipse-workspace\\Myteam11Web\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
			
		//String baseUrl = "https://goteam11.com/fantasy-sports/landing";
	
		String baseUrl = "https://www.myteam11.com/fantasy-sports/landing";
		driver.get(baseUrl);
		Wait = new WebDriverWait(driver, 30);

	}

	/*
	 * public void Firefoxe() {
	 * 
	 * // declaration and instantiation of objects/variables
	 * 
	 * System.setProperty("webdriver.gecko.driver",
	 * "C:\\Users\\Bhola Shankar\\eclipse-workspace\\Myteam11Web\\Drivers\\geckodriver.exe"
	 * );
	 * 
	 * driver = new FirefoxDriver();
	 * 
	 * String baseUrl = "https://myteam11.com/fantasy-sports/landing";
	 * driver.get(baseUrl); driver.manage().window().maximize(); try {
	 * Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
	 * String alertMessage = driver.switchTo().alert().getText();
	 * System.out.println(alertMessage);
	 * 
	 * }
	 */
	public WebDriver getDriver() {
		if (driver == null) {
			driver = new ChromeDriver();
			return driver;
		} else {
			return driver;
		}
	}

	public void quitDriver() {
		try {

			driver.quit();
		} catch (Exception e) {

		}
		driver = null;
	}

}
