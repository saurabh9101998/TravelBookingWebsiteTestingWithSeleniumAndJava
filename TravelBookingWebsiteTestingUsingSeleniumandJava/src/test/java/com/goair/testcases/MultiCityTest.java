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

public class MultiCityTest extends TestBase {
//	WebDriver driver;
//	HomePage homePage;
//	FlightSelectPage flightSelectPage;
//	PassengerDetailsPage passengerDetailsPage;
//	ExtrasPage extrasPage;
//	ReadProperties object;
//	Properties p;
//	ScreenShotCapture screenShotCapture;
//	JavascriptExecutor jse;

	@Test(dataProvider = "hybridData1")
	public void MultiCityDriver(String keyword, String src1, String dest1, String departDate1, String currencyVal,
			String dest2, String departDate2, String dest3, String departDate3, String fname, String lname,
			String email, String mno, String emno) throws IOException {
		
		try
		{
			switch (keyword.toUpperCase()) {
			case "MULTICITYSEARCH":
				homePage = new HomePage(driver);
				homePage.multiCityTripEntryProcess(driver, src1, dest1, departDate1, currencyVal, dest2, departDate2, dest3,
						departDate3,screenShotCapture,keyword);
				break;
	
			case "FLIGHTSELECT":
				Thread.sleep(5000);
				flightSelectPage = new FlightSelectPage(driver);
				flightSelectPage.flightSelectionProcess(driver,jse,screenShotCapture,keyword);
				break;
				
			case "SUBMITPASSENGERDETAILS":
				passengerDetailsPage = new PassengerDetailsPage(driver);
				passengerDetailsPage.submitPassengerDetails(driver, fname, lname, email, mno, emno,screenShotCapture,keyword);
				break;
				
			case "SUBMITXTRAS":
				extrasPage = new ExtrasPage(driver);
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
		return  getData(3, 14);
//		Object[][] object = null;
//		ReadExcel file = new ReadExcel();
//
//		Sheet sheet = file.readExcel(3);
//
//		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
//		object = new Object[rowCount][14];
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
	public void beforeClass() throws IOException, InterruptedException {
		initialisation();
//		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
//		ChromeOptions ops = new ChromeOptions();
//		ops.addArguments("--disable-notifications");
//		driver = new ChromeDriver(ops);
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		object = new ReadProperties();
//		p = object.ReadAllObjects();
//		screenShotCapture = new ScreenShotCapture();
//		driver.get(p.getProperty("url"));
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		//Thread.sleep(10000); // just for viewing it the final result
		driver.close();
	}

}
