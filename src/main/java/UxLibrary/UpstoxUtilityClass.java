package UxLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class UpstoxUtilityClass {

	public static String getUserLogins(int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\amrut\\eclipse-workspace\\UpstoxLakhan\\TestData\\upstoxlogin.xlsx");
		Sheet datasheet = WorkbookFactory.create(file).getSheet("Sheet2");

		String value = datasheet.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return value;
	}

	// get the main auth from properties files
	public static String getdataFromProperty(String key) throws IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\amrut\\eclipse-workspace\\UpstoxLakhan\\upstoxpropertyfile.properties");

		Properties property = new Properties();
		property.load(file);

		String value = property.getProperty(key);
		return value;
	}
	// this method will help us to capture a screenshots of failed testcases

	public static void captureScreenshot(WebDriver driver, int TestcaseId) throws IOException {

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File(
				"C:\\Users\\lakha\\eclipse\\eclipse-workspace\\Uptox\\Screenshots\\Screenshot_" + TestcaseId + ".jpg");
		FileHandler.copy(source, destination);
	}

	public static Actions actionClass(WebDriver driver) {

		Actions act = new Actions(driver);

		return act;

	}

}
