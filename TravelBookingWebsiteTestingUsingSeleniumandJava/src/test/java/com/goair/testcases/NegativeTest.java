package com.goair.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.goair.base.TestBase;
import com.goair.pages.HomePage;
import com.goair.utilities.ReadExcel;

public class NegativeTest extends TestBase {
	// creating objects
//	WebDriver driver;
//	HomePage homePage;
//	ReadProperties object;
//	Properties p;
//	ScreenShotCapture screenShotCapture;

	@Test(dataProvider = "hybridData1")
	public void negativeFlightStatus(String keyword, String source, String destination, String flightNumber)
			throws IOException {

		//System.out.println(".........Negative Test Cases for FlightStatus using ByRoute Method.............");
		// call the pages and methods
		try
		{
			homePage = new HomePage(driver);
			switch (keyword.toUpperCase()) {
			case "DIRECTLYCLICKONCHECKNOW":
				homePage.directlyClickOnCheckNow(driver, source, destination,screenShotCapture,keyword);
				Thread.sleep(1000);
				driver.navigate().back();
				break;
	
			case "WITHOUTDESTINATIONCHECKNOW":
				homePage.withoutDestinationCheckNow(source, driver,screenShotCapture,keyword);
				Thread.sleep(1000);
				break;
	
			case "WRONGINPUTS":
				homePage.wrongInputs(driver, source, destination,screenShotCapture,keyword);
				Thread.sleep(1000);
				driver.navigate().back();
				break;
	
			case "DETIALSUSINGFLIGHTNUMBER":
				//System.out.println(
				//		"............Negative Test Cases for FlightStatus using ByFlight Number Method.............");
				homePage.detialsUsingFlightNumber(driver, flightNumber,screenShotCapture,keyword);
				Thread.sleep(1000);
				driver.navigate().back();
				break;
				
			case "NEGATIVEONEWAY":
				// homePage = new HomePage(driver);
				//System.out.println("...............Negative Test Cases for One Way Method.............");
				homePage.negativeOneWay(driver, source, destination,screenShotCapture,keyword);
				Thread.sleep(2000);
				driver.navigate().to(p.getProperty("url"));
				break;
			}
		}
		catch(NoSuchElementException e)
		{
			screenShotCapture.capscrshot(driver, keyword+"Failiure");
			assertTrue(false);
		}
		catch(Exception e)
		{
			screenShotCapture.capscrshot(driver, keyword+"Failiure");
			assertTrue(false);
		}

	}

	@DataProvider(name = "hybridData1")
	public Object[][] getDataFromDataprovider() throws IOException {
		return  getData(4, 4);
//		Object[][] object = null;
//		ReadExcel file = new ReadExcel();
//
//		Sheet sheet = file.readExcel(4);
//
//		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
//		object = new Object[rowCount][4];
//		for (int i = 0; i < rowCount; i++) {
//			Row row = sheet.getRow(i + 1);
//			for (int j = 0; j < row.getLastCellNum(); j++) {
//				if (row.getCell(j).getCellType() == CellType.NUMERIC)
//					object[i][j] = String.valueOf((long) row.getCell(j).getNumericCellValue());
//				else if (row.getCell(j).getCellType() == CellType.STRING)
//					object[i][j] = row.getCell(j).toString();
//			}
//		}
//		System.out.println(" ");
//		return object;
	}

	@BeforeClass
	public void beforeClass() throws InterruptedException, IOException {
		initialisation();
//		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
//		ChromeOptions ops = new ChromeOptions();
//		ops.addArguments("--disable-notifications");
//		driver = new ChromeDriver(ops);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		object = new ReadProperties();
//		p = object.ReadAllObjects();
//		screenShotCapture = new ScreenShotCapture();
//		driver.get(p.getProperty("url"));
//		Thread.sleep(1000);
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		//Thread.sleep(4000);
		driver.close();
	}
}