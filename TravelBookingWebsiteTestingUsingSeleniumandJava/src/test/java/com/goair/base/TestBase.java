package com.goair.base;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.goair.pages.ExtrasPage;
import com.goair.pages.FlightSelectPage;
import com.goair.pages.FlightStatusPage;
import com.goair.pages.HomePage;
import com.goair.pages.PassengerDetailsPage;
import com.goair.utilities.ReadExcel;
import com.goair.utilities.ReadProperties;
import com.goair.utilities.ScreenShotCapture;

public class TestBase {
	
	protected static WebDriver driver;
	protected static HomePage homePage;
	protected static FlightSelectPage flightSelectPage;
	protected static FlightSelectPage searchResultPage;
	protected static PassengerDetailsPage passengerDetailsPage;
	protected static ExtrasPage extrasPage;
	protected static FlightStatusPage flightStatusPage;
	protected static ReadProperties object;
	protected static Properties p;
	protected static ScreenShotCapture screenShotCapture;
	protected static JavascriptExecutor jse;
	
	
	public static void initialisation() throws IOException, InterruptedException {
		// set chrome driver
				System.setProperty("webdriver.chrome.driver", "F:\\SeleniumDrivers\\chromedriver.exe");
				ChromeOptions ops = new ChromeOptions();
				ops.addArguments("--disable-notifications");
				driver = new ChromeDriver(ops);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				object = new ReadProperties();
				p = object.ReadAllObjects();
				screenShotCapture = new ScreenShotCapture();
				driver.get(p.getProperty("url"));
				Thread.sleep(1000);
		
	}
	
	public static Object[][] getData(int sheetIndex, int columnSize) throws IOException {
		Object[][] object = null;
		ReadExcel file = new ReadExcel();

		Sheet sheet = file.readExcel(sheetIndex);

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		object = new Object[rowCount][columnSize];
		for (int i = 0; i < rowCount; i++) {
			Row row = sheet.getRow(i + 1);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				 if(row.getCell(j).getCellType() == CellType.NUMERIC)	 
					object[i][j] =String.valueOf((long)row.getCell(j).getNumericCellValue());
				  else if(row.getCell(j).getCellType() == CellType.STRING)
					  	object[i][j] = row.getCell(j).toString();
			}
		}
		System.out.println(" ");
		return object;
		
	}

}
