package com.goair.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.goair.utilities.ScreenShotCapture;

public class HomePage {

	WebDriver driver;

	// flight status
	@FindBy(xpath = "//a[@href='#flightstatus']") WebElement clickFlightStatus;
	@FindBy(xpath = "//*[@id='myRadioGroup']/ul/li[2]/label/input")	WebElement clickFlightNumberRadioButton;
	@FindBy(xpath = "//*[@id='Flightstatus2']/div/table/tbody/tr/td[2]/span/input")	WebElement enterOrigin;
	@FindBy(xpath = "//*[@id='Flightstatus2']/div/table/tbody/tr/td[3]/span/input")	WebElement enterDestination;
	@FindBy(xpath = "//*[@id='txtMobile']")	WebElement enterFlightNumber;
	@FindBy(xpath = "//*[@id='Flightstatus2']/div/table/tbody/tr/td[4]/div/button")	WebElement checkNowButtonByRoute;
	@FindBy(xpath = "//*[@id='Flightstatus3']/div/table/tbody/tr/td[4]/div/button")	WebElement checkNowButtonByFlightNumber;
	@FindBy(xpath = "//*[@id='flightStatusForm']/div/h3") WebElement printDetails;

	// one extra element for negative cases
	@FindBy(xpath = "//*[@id='sectionBody']/div[1]/div[2]/div/span/b")
	WebElement printDetail;

	// alert for negative cases
	Alert alert;

	// One way elements
	@FindBy(xpath = "//*[@id='bookflights']/div[2]/ul/li[2]") WebElement OneWayPopUp;
	@FindBy(xpath = "//*[@id='bookflights']/div[2]/div[2]/div[2]/form/table/tbody/tr[2]/td[1]/span/input") WebElement enterSource;
	@FindBy(xpath = "//*[@id='bookflights']/div[2]/div[2]/div[2]/form/table/tbody/tr[2]/td[3]/span/input") WebElement enterDestination1;
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr/td") List<WebElement> DepartDateSelect;
	@FindBy(xpath = "//*[@id='bookflights']/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/button")	WebElement BookTicket;

	// Round way elements
	@FindBy(xpath = "//*[@id='rdt']") WebElement roundTripSelect;
	@FindBy(xpath = "//*[@id='bookflights']/div[2]/div[2]/div[1]/form/table/tbody/tr[2]/td[1]/span/input") WebElement roundTripFrom;
	@FindBy(xpath = "//*[@id='bookflights']/div[2]/div[2]/div[1]/form/table/tbody/tr[2]/td[3]/span/input") WebElement roundTripTo;
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr/td") List<WebElement> departCalendar;
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr/td") List<WebElement> returnCalendar;
	@FindBy(xpath = "//*[@id='bookflights']/div[2]/div[2]/div[1]/form/table/tbody/tr[2]/td[6]/div/div")	WebElement passengerBtn;
	@FindBy(xpath = "//*[@id='bookflights']/div[2]/div[2]/div[1]/div/div[2]/div/div[2]/div/button")	WebElement bookNowRound;

	// MultiCity elements
	@FindBy(xpath = "//*[@id='mct']") WebElement multiCityTabSelect;
	@FindBy(xpath = "//table[@id='multicityTable']/tbody/tr[2]/td[1]/span/input") WebElement fromEntry1;
	@FindBy(xpath = "//table[@id='multicityTable']/tbody/tr[2]/td[3]/span/input") WebElement toEntry1;
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr/td") List<WebElement> departDatePicker1;
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr/td") List<WebElement> departDatePicker2;
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr/td") List<WebElement> departDatePicker3;
	@FindBy(xpath = "//table[@id='multicityTable']/tbody/tr[3]/td[1]/span/input") WebElement fromEntry2;
	@FindBy(xpath = "//table[@id='multicityTable']/tbody/tr[3]/td[3]/span/input") WebElement toEntry2;
	@FindBy(xpath = "//table[@id='multicityTable']/tbody/tr[4]/td[1]/span/input") WebElement fromEntry3;
	@FindBy(xpath = "//table[@id='multicityTable']/tbody/tr[4]/td[3]/span/input") WebElement toEntry3;
	@FindBy(xpath = "//*[@id='traveler_done_multicity']") WebElement passengerSelectDone;
	@FindBy(xpath = "//table[@id='multicityTable']/tbody/tr[2]/td[6]/select") WebElement currencySelect;
	@FindBy(xpath = "//div[@class='maniPage-addTrip']/button[1]") WebElement addCitiesButton;
	@FindBy(xpath = "//*[@id='bookflights']/div[2]/div[2]/div[3]/div/div[2]/div/div[2]/div/button")	WebElement bookButton;

	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void dateSelect(List<WebElement> departDatePick, String dateValue) {
		for (WebElement e1 : departDatePick) {
			if (e1.getText().equals(dateValue)) {
				e1.click();
				break;
			}
		}
	}

	// Negative cases - Methods
	public void sourceAndDestination(WebDriver driver, String Source, String Destination) throws InterruptedException {
		enterOrigin.sendKeys(Source);
		Thread.sleep(2000);
		enterOrigin.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		enterOrigin.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		enterDestination.sendKeys(Destination);
		Thread.sleep(2000);
		enterDestination.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		enterDestination.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		checkNowButtonByRoute.click();
		Thread.sleep(4000);
	}

	public void directlyClickOnCheckNow(WebDriver driver, String Source, String Destination, ScreenShotCapture screenShotCapture, String keyword)
			throws InterruptedException, IOException {
		clickFlightStatus.click();
		Thread.sleep(2000);

		checkNowButtonByRoute.click();
		Thread.sleep(2000);
		alert = driver.switchTo().alert();
		System.out.println("Alert Data: " + alert.getText());
		alert.accept();

		Thread.sleep(2000);
		sourceAndDestination(driver, Source, Destination);
		
		Thread.sleep(2000);

	}

	public void withoutDestinationCheckNow(String Source, WebDriver driver, ScreenShotCapture screenShotCapture, String keyword) throws InterruptedException, IOException {
		clickFlightStatus.click();
		Thread.sleep(2000);

		enterOrigin.click();
		Thread.sleep(1000);

		enterOrigin.sendKeys(Source);
		Thread.sleep(1000);
		enterOrigin.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		enterOrigin.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		checkNowButtonByRoute.click();
		Thread.sleep(2000);

		alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert Data: " + alertText);
		alert.accept();
		Thread.sleep(2000);
	}

	public void wrongInputs(WebDriver driver, String Source, String Destination, ScreenShotCapture screenShotCapture, String keyword) throws InterruptedException, IOException {
		clickFlightStatus.click();
		Thread.sleep(2000);

		Thread.sleep(2000);
		sourceAndDestination(driver, Source, Destination);

		//System.out.println("Number of Flights: " + printDetail.getText());
		Thread.sleep(2000);
		screenShotCapture.capscrshot(driver, keyword+"Negative");

	}

	public void detialsUsingFlightNumber(WebDriver driver, String flightNo, ScreenShotCapture screenShotCapture, String keyword) throws InterruptedException, IOException {
		clickFlightStatus.click();
		Thread.sleep(2000);

		clickFlightNumberRadioButton.click();
		Thread.sleep(2000);

		enterFlightNumber.sendKeys("" + flightNo);
		Thread.sleep(2000);

		checkNowButtonByFlightNumber.click();
		Thread.sleep(2000);

		//System.out.println("Number of Flights: " + printDetail.getText());
		Thread.sleep(2000);
		screenShotCapture.capscrshot(driver, keyword+"Negative");
	}

	public void negativeOneWay(WebDriver driver, String Source, String Destination, ScreenShotCapture screenShotCapture, String keyword) throws InterruptedException, IOException {
		OneWayPopUp.click();
		Thread.sleep(2000);

		enterSource.sendKeys(Source);
		Thread.sleep(2000);
		enterSource.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		enterSource.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		enterDestination1.sendKeys(Destination);
		Thread.sleep(2000);
		enterDestination1.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		enterDestination1.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		BookTicket.click();
		
		Thread.sleep(2000);
		
		alert = driver.switchTo().alert();
		System.out.println("Alert Data: " + alert.getText());
		alert.accept();
		
		Thread.sleep(2000);
	}

	// Flight Status - Methods
	public void checkFlightStatusByRoute(String Source, String Destination) throws InterruptedException {
		// performing operations on web elements
		clickFlightStatus.click();
		Thread.sleep(1000);
		enterOrigin.click();
		Thread.sleep(1000);
		enterOrigin.sendKeys(Source);
		Thread.sleep(1000);
		System.out.println("source is: " + Source);
		enterOrigin.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		enterOrigin.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		enterDestination.sendKeys(Destination);
		Thread.sleep(1000);
		System.out.println("destination  is: " + Destination);
		enterDestination.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		enterDestination.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		checkNowButtonByRoute.click();
		Thread.sleep(2000);
		System.out.println(printDetails.getText());
		Thread.sleep(2000);

	}

	public void checkFlightStatusByFlightNumber(String Fno) throws InterruptedException {
		// performing operations on web elements
		clickFlightStatus.click();
		Thread.sleep(2000);
		clickFlightNumberRadioButton.click();
		Thread.sleep(1000);
		enterFlightNumber.click();
		Thread.sleep(1000);
		enterFlightNumber.sendKeys(Fno);
		Thread.sleep(2000);
		checkNowButtonByFlightNumber.click();
		Thread.sleep(2000);
		System.out.println(printDetails.getText());
		Thread.sleep(2000);

	}

	// One Way - Methods
	public void OneWayTripByRoute(WebDriver driver, String Origin, String Destination, String ddate, ScreenShotCapture screenShotCapture, String keyword) throws InterruptedException, IOException {
		// performing operations on web elements

		OneWayPopUp.click();
		Thread.sleep(1000);
		enterSource.sendKeys(Origin);
		Thread.sleep(1000);
		enterDestination1.sendKeys(Destination);
		Thread.sleep(1000);
		dateSelect(DepartDateSelect, ddate);
		Thread.sleep(1000);
		BookTicket.click();
		Thread.sleep(2000);
		screenShotCapture.capscrshot(driver,keyword+"Success");

	}

	// Round Trip - Methods
	public void roundTripSearchFlight(WebDriver driver, String source, String destination, String ddate, String rdate, ScreenShotCapture screenShotCapture,String keyword)
			throws InterruptedException, IOException {
		roundTripFrom.sendKeys(source);
		Thread.sleep(1000);
		roundTripTo.sendKeys(destination);
		Thread.sleep(1000);
		dateSelect(departCalendar, ddate);
		Thread.sleep(1000);
		dateSelect(returnCalendar, rdate);
		Thread.sleep(1000);
		passengerBtn.click();
		Thread.sleep(1000);
		bookNowRound.click();
		Thread.sleep(3000);
		screenShotCapture.capscrshot(driver, keyword+"Success");
	}

	// MultiCity - Methods
	public void multiCityTripEntryProcess(WebDriver driver, String src1, String dest1, String departDate1,
			String currencyVal, String dest2, String departDate2, String dest3, String departDate3, ScreenShotCapture screenShotCapture, String keyword)
			throws InterruptedException, IOException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		multiCityTabSelect.click();

		jse.executeScript("window.scrollBy(0,600)");

		fromEntry1.click();
		fromEntry1.sendKeys(src1);
		Thread.sleep(2000);
		toEntry1.sendKeys(dest1);
		Thread.sleep(2000);

		dateSelect(departDatePicker1, departDate1);
		Thread.sleep(2000);

		passengerSelectDone.click();
		Select currency = new Select(currencySelect);
		currency.selectByVisibleText(currencyVal);
		Thread.sleep(2000);

		Thread.sleep(2000);
		toEntry2.sendKeys(dest2);
		Thread.sleep(2000);

		dateSelect(departDatePicker2, departDate2);
		Thread.sleep(2000);

		addCitiesButton.click();

		Thread.sleep(2000);
		toEntry3.sendKeys(dest3);
		Thread.sleep(2000);

		dateSelect(departDatePicker3, departDate3);
		Thread.sleep(2000);

		bookButton.click();
		Thread.sleep(2000);
		screenShotCapture.capscrshot(driver,keyword+"Success");
	}

}
