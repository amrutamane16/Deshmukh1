package UxLoginUserModule;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import UxLibrary.*;
import UxLogin.*;

public class UpstoxLoginTestClass extends UpstoxBaseClass {

	// declare variable globally
	Upstoxlogin1 login1;
	Upstoxlogin2 login2;
	Upstoxlogin3 login3;
	Upstoxlogin4 login4;
	String actuser4w;
	int TestcaseId = 02;

	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException {
		// open a browser and navigate to provided urls
		invokeBrowser();

		// create objects of classes
		login1 = new Upstoxlogin1(driver);
		login2 = new Upstoxlogin2(driver);
		login3 = new Upstoxlogin3(driver);
		login4 = new Upstoxlogin4(driver);
	}

	@Test
	public void login() throws InterruptedException, EncryptedDocumentException, IOException {

		login1.setUpstoxlogin1username(UpstoxUtilityClass.getdataFromProperty("userName"));

		login1.setUpstoxlogin1password(UpstoxUtilityClass.getdataFromProperty("passWord"));
		login1.clickUpstoxlogin1signBtn();
		// wait until the the testbox of year of birth not visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='yob']")));
		// Thread.sleep(2000);
		login2.setUpstoxlogin2pin(UpstoxUtilityClass.getdataFromProperty("passCode"));
		login3.clickUpstoxlogin3noBtn();
		actuser4w = login4.getUpstoxlogin4Userid();

	}

	@Test(dependsOnMethods = { "login" })
	public void verifyusertng() throws EncryptedDocumentException, IOException {

		String userid = UpstoxUtilityClass.getUserLogins(0, 3);
		Assert.assertNotEquals(userid, actuser4w);
		Reporter.log("Expected Userid = " + userid, true);
		Reporter.log("Actual Userid = " + actuser4w, true);
		Reporter.log("The User Loggined is same", true);
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
		actuser4w = null;

	}

}
