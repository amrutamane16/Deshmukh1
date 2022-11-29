package UxLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Upstoxlogin4 {

	@FindBy(xpath = "//div[@data-id='accountDropDown']//span[1]")
	private WebElement actUser;
	@FindBy(xpath = "//div[@data-id='accountDropDown']/div")
	private WebElement accSetBtn;
	@FindBy(xpath = "//div[@id='logout']")
	private WebElement logouBtn;
	

	public Upstoxlogin4(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

		
	public String getUpstoxlogin4Userid() {
		String actUserw=actUser.getText();
		return actUserw;
	}
	
	
	public void clickUpstoxlogin4LogoutBtn(WebDriver driver,WebDriverWait wait) throws InterruptedException {
		Actions act=new Actions(driver);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(120,0)","");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-id='accountDropDown']/div")));
		act.moveToElement(accSetBtn).click().build().perform();
		Thread.sleep(2500);
		act.moveToElement(logouBtn).click().build().perform();
	}
	
	

}
