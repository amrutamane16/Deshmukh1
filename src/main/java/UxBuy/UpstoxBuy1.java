package UxBuy;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpstoxBuy1 {

	@FindBy(xpath = "//div[@id='watchlistTestId']/div/div")
	private List<WebElement> stockList;

	@FindBy(xpath = "//div[@id='watchlistTestId']/div//div[@class='GVZPg514UQ_SC6KR0I5Cx']")
	private List<WebElement> moreoptions;

	@FindBy(xpath = "//div[@class='ciq-nav full-screen-hide']/div[1]")
	private WebElement grid;

	public UpstoxBuy1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
// print the top twenty stock 
	public void getStoxList() {

		for (int i = 0; i < stockList.size()-1; i++) {
			// this will print the list of top 20 stocks in market
			String xx = stockList.get(i).getText().replaceAll("[^A-Za-z]", " ").replace("NSE EQ", "");

			System.out.println((i + 1) + ") " + xx);
		}

	}

	
	// validate the top 20 stocks are present in list check if 20 item are there
	public boolean checkgetStoxList() {

		for (int i = 0; i < stockList.size()-1; i++) {
			// this will print the list of top 20 stocks in market
			String xx = stockList.get(i).getText().replaceAll("[^A-Za-z]", " ").replace("NSE EQ", "");
			//System.out.println((i + 1) + ") " + xx);
		}
		System.out.println(stockList.size());
		boolean value=(stockList.size()-1==20);
		return value;

	}
}
