package com.goair.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.goair.utilities.ScreenShotCapture;

public class FlightSelectPage {

	//one way and round trip flight
	@FindBy(xpath = "//*[@id='submit_search_button']") WebElement tripButton;
	
	//multi city flight
	@FindBy(xpath="//*[@id='submit_search_button']") WebElement submitSearch;
	@FindBy(xpath="//table[@id='js-avail-table0']/tbody/tr[1]/td[5]") WebElement flightFlexiFirst;
	@FindBy(xpath="//table[@id='js-avail-table1']/tbody/tr[1]/td[5]") WebElement flightFlexiSecond;
	@FindBy(xpath="//table[@id='js-avail-table2']/tbody/tr[1]/td[5]") WebElement flightFlexiThird;
	
	public FlightSelectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//one way and round trip - methods
	public void planeSelectContinue(WebDriver driver, ScreenShotCapture screenShotCapture, String keyword) throws InterruptedException, IOException {
		Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,document.documentElement.scrollHeight)");
		Thread.sleep(1000);
		tripButton.click();
		Thread.sleep(3000);
		screenShotCapture.capscrshot(driver,keyword+"Success");
	}
	
	//multi city - methods
	public void flightSelectionProcess(WebDriver driver, JavascriptExecutor jse, ScreenShotCapture screenShotCapture,String keyword) throws InterruptedException, IOException
	{
		jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,150)");		
		flightFlexiFirst.click();
		Thread.sleep(1000);
		flightFlexiSecond.click();
		Thread.sleep(1000);
		flightFlexiThird.click();
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");		
		submitSearch.click();
		Thread.sleep(2000);
		screenShotCapture.capscrshot(driver,keyword+"Success");
	}
	
	
}
