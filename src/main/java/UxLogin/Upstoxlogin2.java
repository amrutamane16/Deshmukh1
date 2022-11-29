package UxLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Upstoxlogin2 {

	@FindBy(xpath = "//input[@id='yob']")
	private WebElement pin;

	public Upstoxlogin2(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setUpstoxlogin2pin(String passpin) {
		pin.sendKeys(passpin);
	}

}
