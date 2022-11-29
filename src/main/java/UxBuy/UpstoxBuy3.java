package UxBuy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import UxLibrary.UpstoxBaseClass;
import UxLibrary.UpstoxUtilityClass;

public class UpstoxBuy3 {
	@FindBy(xpath = "//div[@id='watchlistTestId']/div/div")
	private List<WebElement> stockList;
	@FindBy(xpath = "//div[@id='watchlistTestId']/div//div[@class='GVZPg514UQ_SC6KR0I5Cx']")
	private List<WebElement> moreoptions;
	@FindBy(xpath = "//button[@data-id='watchlistAdd']")
	private WebElement addNewStxtoListBtn;
	@FindBy(xpath = "//div[@id='watchlistSelect_dropdown']")
	private WebElement listBox2Stx;
	@FindBy(xpath = "//div[@id='new-watchlist_title']")
	private WebElement clicktoAddnewListname;
	@FindBy(xpath = "//div[@id='watchlistSelect']//input")
	private WebElement newNameWatchList;
	@FindBy(xpath = "//button[@data-id='save_newWatchlist']")
	private WebElement saveNewList;
	@FindBy(xpath = "//div[@id='watchlistSelect']//div[@data-testid='dropdown-option']/div[2]")
	private List<WebElement> NewAddWatchlist;

	public UpstoxBuy3(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void addNewWatchlist(WebDriver driver, WebDriverWait wait) throws InterruptedException {

		UpstoxUtilityClass.actionClass(driver).moveToElement(listBox2Stx).click().build().perform();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='new-watchlist_title']")));
		Thread.sleep(1000);
		clicktoAddnewListname.click();
		newNameWatchList.sendKeys("SeleStx");
		saveNewList.click();

	}

	public void selectNewWatchListAddStx(WebDriver driver) {

		listBox2Stx.click();
		UpstoxUtilityClass.actionClass(driver).moveToElement(listBox2Stx).click().build().perform();

		for (int i = 0; i < NewAddWatchlist.size(); i++) {

			if (NewAddWatchlist.get(i).getAttribute("id").contains("SeleStx")) {

				NewAddWatchlist.get(i).click();
			}
		}

	}

	public void clickstx2buy(WebDriver driver, String stxNm) {
		Actions act = new Actions(driver);

		for (int i = 0; i < stockList.size(); i++) {

			boolean results = stockList.get(i).getText().replaceAll("[^A-Za-z]", " ").contains(stxNm);

			if (results) {
				// click on particular stock to view chart
				act.moveToElement(moreoptions.get(i)).click().build().perform();
				// buy options will click
				stockList.get(i).click();
			}
		}
	}








//Buy Button xpath
//(//div[@id='watchlistTestId']/div//div[@class='GVZPg514UQ_SC6KR0I5Cx']/div[2]//div[@class='_25GgYS9rvOpD2p36aJBmB2'])[1]
//Sell Button xpath
//(//div[@id='watchlistTestId']/div//div[@class='GVZPg514UQ_SC6KR0I5Cx']/div[2]//div[@class='_25GgYS9rvOpD2p36aJBmB2'])[2]
	






}
