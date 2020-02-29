/*

package testclass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testCases.LoginLogic;
import testCases.WithoutLoginLogic;
import utils.Browser;

public class BeforeLogintest {
	WithoutLoginLogic wl;
	WebDriver driver;
    Browser browser;

    @Parameters({ "browsers" })
    @BeforeTest
    public void callbrowser(String name) {
        browser = new Browser(name);
        wl = new WithoutLoginLogic(browser.driver, browser.Wait);
    }

	@Test(priority = 1, enabled = true )
	public void PlayNowbtn() throws InterruptedException {
		wl.ClickOnPlayNow();
	}

	@Test(priority = 2, enabled = true)
	public void GotoMatch() {
		wl.Verifymatchlist();
	}
	@Test(priority = 3, enabled = true)
	public void Selectmatch() throws Exception {
	wl.SelectMatch();
	}

	@Test(priority = 4, enabled = true)
	public void createTeame() {
		wl.CreateTeame();
	}


	@AfterTest public void closeBrowser() { driver.close(); }

}

*/
