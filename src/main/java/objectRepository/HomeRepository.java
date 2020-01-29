package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeRepository {

	protected WebDriverWait wait;

	@FindBy(xpath = "//*[@id='header']")
	public WebElement VerifyHeader;

	@FindBy(xpath = "//div[@class='menu_toggle']")
	public WebElement Menuicon;

	@FindBy(xpath = "//a[@class='watch_video']")
	public WebElement watchtutorial;

	@FindBy(xpath = "//a[contains(text(),'how to play')]")
	public WebElement howtoplay;

	@FindBy(xpath = "//a[@id='desktop_download']")
	public WebElement downloadAp;

	@FindBy(xpath = "//a[contains(text(),'play now')]")
	public WebElement playnow;

	@FindBy(xpath = "//*[@id=\"myTab\"]/li[1]/a")
	public WebElement cricket;

	@FindBy(xpath = "//*[@id=\"myTab\"]/li[1]/a")
	public WebElement football;

	@FindBy(xpath = "//*[@id=\"myTab\"]/li[3]/a")
	public WebElement kabaddi;

	@FindBy(xpath = "//*[@id=\"myTab\"]/li[4]/a")
	public WebElement basketball;

	@FindBy(xpath = "//input[@placeholder='Enter Mobile Number']")
	public WebElement Entermobilenumber;

	@FindBy(xpath = "//button[@class='get_btn']")
	public WebElement Sendlink;

	public WebElement getVerifyHeader() {
		return VerifyHeader;
	}

	public WebElement getMenuicon() {
		return Menuicon;
	}

	public WebElement getWatchtutorial() {
		return watchtutorial;
	}

	public void setWatchtutorial(WebElement watchtutorial) {
		this.watchtutorial = watchtutorial;
	}

	public WebElement getHowtoplay() {
		return howtoplay;
	}

	public WebElement getDownloadAp() {
		return downloadAp;
	}

	public WebElement getPlaynow() {
		return playnow;
	}

	public WebElement getCricket() {
		return cricket;
	}

	public WebElement getFootball() {
		return football;
	}

	public void setFootball(WebElement football) {
		this.football = football;
	}

	public WebElement getKabaddi() {
		return kabaddi;
	}


	public WebElement getBasketball() {
		return basketball;
	}

	public WebElement getEntermobilenumber() {
		return Entermobilenumber;
	}

	public WebElement getSendlink() {
		return Sendlink;
	}

}
