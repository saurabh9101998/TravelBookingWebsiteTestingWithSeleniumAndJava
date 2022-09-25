package com.goair.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.goair.base.TestBase;
import com.goair.pages.FlightStatusPage;
import com.goair.pages.HomePage;
import com.goair.utilities.ReadExcel;

public class FlightStatusTest extends TestBase  {
//	WebDriver driver;
//	HomePage homePage;
//	FlightStatusPage flightStatusPage;
//	ReadProperties object;
//	Properties p;
//	ScreenShotCapture screenShotCapture;
//	JavascriptExecutor jse;

	@Test(dataProvider = "hybridData1")
	public void flightStatus(String keyword, String Source, String Destination, String Fno) throws IOException {

		try
		{
			switch (keyword.toUpperCase()) {
			case "FLIGHTSTATUSBYROUTE":
	//			System.out.println("Searching for FlightStatus using ByRoute Method.............");
				
				homePage = new HomePage(driver);
				Thread.sleep(2000);
				homePage.checkFlightStatusByRoute(Source, Destination);
				Thread.sleep(5000);
	
	//			System.out.println("                                                             ");
	//			System.out.println("getting the status for flight............");
				
				jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,300)");
				Thread.sleep(2000);
				flightStatusPage = new FlightStatusPage(driver);
				flightStatusPage.getDetailsForFlight(driver,screenShotCapture,keyword);
				Thread.sleep(2000);
				driver.navigate().back();
				break;
	
			case "FLIGHTSTATUSBYFLIGHTNUMBER":
	//			System.out.println("                                                             ");
	//			System.out.println("Searching for FlightStatus using ByFlightNumber Method.............");
				
				homePage = new HomePage(driver);
				
				Thread.sleep(2000);
				homePage.checkFlightStatusByFlightNumber(Fno);
				Thread.sleep(3000);
	
	//			System.out.println("                                                             ");
	//			System.out.println("getting the status for flight............");
				
				jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,300)");
				Thread.sleep(2000);
				flightStatusPage = new FlightStatusPage(driver);
				flightStatusPage.getDetailsForFlight(driver,screenShotCapture,keyword);
				Thread.sleep(3000);
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
		
		return  getData(0, 4);
//		Object[][] object = null;
//		ReadExcel file = new ReadExcel();
//
//		Sheet sheet = file.readExcel(0);
//
//		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
//		object = new Object[rowCount][4];
//		for (int i = 0; i < rowCount; i++) {
//			Row row = sheet.getRow(i + 1);
//			for (int j = 0; j < row.getLastCellNum(); j++) {
//				 if(row.getCell(j).getCellType() == CellType.NUMERIC)	 
//					object[i][j] =String.valueOf((int)row.getCell(j).getNumericCellValue());
//				  else if(row.getCell(j).getCellType() == CellType.STRING)
//					  	object[i][j] = row.getCell(j).toString();
//			}
//		}
//		System.out.println(" ");
//		return object;
	}

	@BeforeClass
	public void beforeClass() throws InterruptedException, IOException {
		// set chrome driver
		initialisation();
//		System.setProperty("webdriver.chrome.driver", "F:\\SeleniumDrivers\\chromedriver.exe");
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