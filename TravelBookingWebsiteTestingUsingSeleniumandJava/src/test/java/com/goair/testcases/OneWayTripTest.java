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
import com.goair.pages.ExtrasPage;
import com.goair.pages.FlightSelectPage;
import com.goair.pages.HomePage;
import com.goair.pages.PassengerDetailsPage;
import com.goair.utilities.ReadExcel;

public class OneWayTripTest extends TestBase {
//	WebDriver driver;
//	HomePage homePage;
//	FlightSelectPage searchResultPage;
//	PassengerDetailsPage passengerDetailsPage;
//	ExtrasPage extrasPage;
//	ReadProperties object;
//	Properties p;
//	ScreenShotCapture screenShotCapture;
//	JavascriptExecutor jse;
	
	@Test (dataProvider="hybridData1")
	public void OneWayTripMethod(String keyword, String source, String destination, String departDate,
			String fname, String lname, String email, String mno, String emno) throws IOException {
		
		try
		{
			switch (keyword.toUpperCase()) {
			case "ONEWAYTRIPBYROUTE":
			homePage= new HomePage(driver);
			homePage.OneWayTripByRoute(driver,source,destination,departDate,screenShotCapture,keyword);
			break;
			
			case "PLANESELECTCONTINUE":
			searchResultPage= new FlightSelectPage(driver);
			searchResultPage.planeSelectContinue(driver,screenShotCapture,keyword);
			break;
			
			case "SUBMITPASSENGERDETAILS":
			passengerDetailsPage= new PassengerDetailsPage(driver);
			passengerDetailsPage.submitPassengerDetails(driver, fname, lname, email, mno, emno,screenShotCapture, keyword);
			break;
			
			case "SUBMITXTRAS":
			extrasPage= new ExtrasPage(driver);
			extrasPage.submitXtras(driver,jse,screenShotCapture,keyword);
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
		return  getData(2, 9);
//		Object[][] object = null;
//		ReadExcel file = new ReadExcel();
//
//		Sheet sheet = file.readExcel(2);
//
//		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
//		object = new Object[rowCount][9];
//		for (int i = 0; i < rowCount; i++) {
//			Row row = sheet.getRow(i + 1);
//			for (int j = 0; j < row.getLastCellNum(); j++) {
//				 if(row.getCell(j).getCellType() == CellType.NUMERIC)
//					 object[i][j] =String.valueOf((long)row.getCell(j).getNumericCellValue());
//				  else if(row.getCell(j).getCellType() == CellType.STRING)
//					  	object[i][j] = row.getCell(j).toString();
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
//		object= new ReadProperties();
//		p=object.ReadAllObjects();
//		driver.get(p.getProperty("url"));
//		screenShotCapture = new ScreenShotCapture();
//		Thread.sleep(4000);
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		//Thread.sleep(5000);
		driver.close();
	}

}