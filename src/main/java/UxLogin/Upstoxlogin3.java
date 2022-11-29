package UxLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Upstoxlogin3 {

	@FindBy(xpath = "//button[@data-id='declineTour']")
	private WebElement noBtn;

	public Upstoxlogin3(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickUpstoxlogin3noBtn() throws InterruptedException {
		//Thread.sleep(3000);
		noBtn.click();
	}

}
