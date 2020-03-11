package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutRepository {
	
	@FindBy(xpath = "//div[@class='avtar menu_toggle']//img")
	private WebElement leftPanelprfl;

	public WebElement getLeftPanelprfl() {
		return leftPanelprfl;
	}

	@FindBy(xpath = "//a[contains(text(),'My Profile')]")
	private WebElement MyProfile;
	
	public WebElement getMyProfile() {
		return MyProfile;
	}

	@FindBy(xpath = "//button[@class='btn logout']")
	private WebElement Logoutbtn;

	public WebElement getLogoutbtn() {
		return Logoutbtn;
	}

	@FindBy(xpath = "//div[@class='verify_steps']")
	private WebElement Verificationsteps;

	public WebElement getVerificationsteps() {
		return Verificationsteps;
	}
}
