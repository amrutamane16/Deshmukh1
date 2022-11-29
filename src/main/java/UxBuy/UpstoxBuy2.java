package UxBuy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpstoxBuy2 {
	@FindBy(xpath = "//div[@id='watchlistTestId']/div/div")
	private List<WebElement> stockList;
	@FindBy(xpath = "//div[@id='watchlistTestId']/div//div[@class='GVZPg514UQ_SC6KR0I5Cx']")
	private List<WebElement> moreoptions;
	@FindBy(xpath = "//div[@class='scrip-details-tour order-entry-tour']//div[contains(@class,'L8WooJepTO6Q9tbrujkiv')]")
	private WebElement price1Stock;
	@FindBy(xpath = "//input[@id='quantity']")
	private WebElement quantity2Buy;
	@FindBy(xpath = "(//div[@class='scrip-details-tour order-entry-tour']//div[@id='undefined_dropdown'])[1]")
	private WebElement productType;
	@FindBy(xpath = "//div[@class='scrip-details-tour order-entry-tour']//span[@class='_1YYA2Qt24RztqlfeEeazOp']")
	private WebElement calculatedPrice;

	public UpstoxBuy2(WebDriver driver) {
		PageFactory.initElements(driver, this);
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

	public void setUpstoxBuy2Quantity(String qty) {

		quantity2Buy.sendKeys(qty);

	}

	public void listUpstoxBuyProdType(WebDriver driver) throws InterruptedException {
		Actions act = new Actions(driver);
		String downEnter = Keys.chord(Keys.DOWN, Keys.ENTER);
		act.moveToElement(productType).click().sendKeys(downEnter).build().perform();
		Thread.sleep(2000);
	}

	public boolean calStockPrice() {

		String price1Stx = price1Stock.getText().replaceAll("[^0-9.]+", "").trim();
		double actStx1Price = Double.parseDouble(price1Stx);
		String quantityvalue = quantity2Buy.getAttribute("value");
		double qtyEnter = Double.parseDouble(quantityvalue);
		double result = actStx1Price * qtyEnter;
		String estprice = calculatedPrice.getText().replaceAll("[^0-9.]+", "").trim();
		double estStxPrice = Double.parseDouble(estprice);

//		System.out.println(actStx1Price);
//		System.out.println(qtyEnter);
//		System.out.println(result);
//		System.out.println(estStxPrice);

		boolean res = (result == estStxPrice);
		return res;
	}
}
