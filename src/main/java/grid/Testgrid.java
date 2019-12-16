/*
 * package grid;
 * 
 * import java.net.MalformedURLException; import java.net.URL; import
 * java.util.concurrent.TimeUnit;
 * 
 * import org.openqa.selenium.Platform; import org.openqa.selenium.WebDriver;
 * import org.openqa.selenium.remote.DesiredCapabilities; import
 * org.openqa.selenium.remote.RemoteWebDriver;
 * 
 * import com.beust.jcommander.Strings;
 * 
 * public class Testgrid { static WebDriver driver; static String nodeUrl;
 * 
 * public static void main(Strings[] args ) throws MalformedURLException { try {
 * nodeUrl = "http://192.168.20.22:21123/wd/hub";
 * 
 * DesiredCapabilities capabilities = DesiredCapabilities.chrome();
 * capabilities.setBrowserName("Chrome");
 * capabilities.setPlatform(Platform.WINDOWS); driver = new RemoteWebDriver(new
 * URL(nodeUrl), capabilities); driver.manage().deleteAllCookies();
 * driver.manage().window().maximize();
 * driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 * driver.get("www.myteam11.com/fantasy-sports");
 * System.out.println("the title is " + driver.getTitle());
 * 
 * } catch (Exception e) {
 * 
 * e.printStackTrace(); }
 * 
 * }
 * 
 * }
 */