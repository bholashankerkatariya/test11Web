package grid;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class node1 {
	WebDriver driver;
	String nodeUrl;
	
  @Test
  public void f() {		
	try {
	nodeUrl = "http://192.168.20.22:21123/wd/hub";
	
	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	capabilities.setBrowserName("Chrome");
	capabilities.setPlatform(Platform.WINDOWS);
	driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("www.myteam11.com/fantasy-sports");
	System.out.println("The Result is" + driver.getTitle());
	
} catch (Exception e) {
	
	e.printStackTrace();
}

}
}  
 

