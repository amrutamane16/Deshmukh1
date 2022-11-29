package UxLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import UxLogin.Upstoxlogin1;
import UxLogin.Upstoxlogin2;
import UxLogin.Upstoxlogin3;

public class UpstoxBaseClass {
	public WebDriver driver;
	public WebDriverWait wait;

	public Upstoxlogin1 login1;
	public Upstoxlogin2 login2;
	public Upstoxlogin3 login3;
	

	// Author: Lakhan S Adewar
	// base file for upstox
	// method to invoke a browser and navigate to the the upstox web site

	public void invokeBrowser() throws IOException {
		// to run a test in head less mode
		// ChromeOptions options=new ChromeOptions();
		// options.addArguments("headless");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\amrut\\eclipse-workspace\\UpstoxLakhan\\Browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get(UpstoxUtilityClass.getdataFromProperty("URL"));
		
	}

	// method to login to the app
	public void logintoapp() throws IOException, InterruptedException {
		login1 = new Upstoxlogin1(driver);
		login2 = new Upstoxlogin2(driver);
		login3 = new Upstoxlogin3(driver);

		login1.setUpstoxlogin1username(UpstoxUtilityClass.getdataFromProperty("userName"));
		login1.setUpstoxlogin1password(UpstoxUtilityClass.getdataFromProperty("passWord"));
		login1.clickUpstoxlogin1signBtn();
		// wait until the the testbox of year of birth not visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='yob']")));
		login2.setUpstoxlogin2pin(UpstoxUtilityClass.getdataFromProperty("passCode"));
		login3.clickUpstoxlogin3noBtn();

	}

}
