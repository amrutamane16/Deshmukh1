package UxBuyModule;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import UxBuy.UpstoxBuy1;
import UxBuy.UpstoxBuy2;
import UxLibrary.UpstoxBaseClass;
import UxLibrary.UpstoxUtilityClass;
import UxLogin.Upstoxlogin4;

public class UpstoxBuyTestClass extends UpstoxBaseClass {

	// declare variable globally
	UpstoxBuy1 buy1;
	UpstoxBuy2 buy2;
	public Upstoxlogin4 login4;
	SoftAssert soft;
	int TestcaseId = 03;

	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException, InterruptedException {
		// open a browser and navigate to provided urls
		invokeBrowser();
		logintoapp();
		// create objects of classes
		login4 = new Upstoxlogin4(driver);
		buy1 = new UpstoxBuy1(driver);
		buy2 = new UpstoxBuy2(driver);
		soft = new SoftAssert();
	}

	@Test
	public void getListofStocks() throws EncryptedDocumentException, IOException, InterruptedException {

		// this required a driver and name of stock
		// buy1.getStoxList();
		soft.assertTrue(buy1.checkgetStoxList());
		// click on a particular bstock which we want to comapair
		buy2.clickstx2buy(driver, "RII");

		// this will required to no of stock to purchase
		buy2.setUpstoxBuy2Quantity("10");
		buy2.listUpstoxBuyProdType(driver);
		soft.assertTrue(buy2.calStockPrice());

		soft.assertAll();
	}

	@AfterMethod
	public void logout(ITestResult result) throws InterruptedException, IOException {
		if (result.getStatus() == result.FAILURE) {

			UpstoxUtilityClass.captureScreenshot(driver, TestcaseId);
		}
		login4.clickUpstoxlogin4LogoutBtn(driver, wait);

	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		driver.quit();
		login1 = null;
		login2 = null;
		login3 = null;
		login4 = null;

	}

}
