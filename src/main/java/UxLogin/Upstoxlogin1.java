package UxLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Upstoxlogin1 {

	// global variables
	@FindBy(xpath = "//input[@id='userCode']")
	private WebElement userid;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	@FindBy(xpath = "//button[@id='submit-btn']")
	private WebElement signBtn;

	public Upstoxlogin1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setUpstoxlogin1username(String usernm) {
		
		userid.sendKeys(usernm);
	}

	public void setUpstoxlogin1password(String passwd) {

		password.sendKeys(passwd);
	}

	public void clickUpstoxlogin1signBtn() {

		signBtn.click();
	}

}
