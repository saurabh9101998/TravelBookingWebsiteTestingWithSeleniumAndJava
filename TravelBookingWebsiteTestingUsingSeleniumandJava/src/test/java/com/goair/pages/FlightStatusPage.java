package com.goair.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.goair.utilities.ScreenShotCapture;

public class FlightStatusPage {
	 
	 @FindBy(xpath="//*[@id='byroute1']") WebElement clickArrowDownButton;
	 @FindBy(xpath="//*[@id='flightContent1']/div/div[2]/div/span[1]") WebElement flightNumber;
	 @FindBy(xpath="//*[@id='flightContent1']/div/div[1]/div/div[2]/span[2]") WebElement estimatedDepartureTime;
	 @FindBy(xpath="//*[@id='flightContent1']/div/div[1]/div/div[2]/span[3]") WebElement scheduledDepartureTime;
	 @FindBy(xpath="//*[@id='flightContent1']/div/div[3]/div/div[2]/span[2]") WebElement estimatedArrivalTime;
	 @FindBy(xpath="//*[@id='flightContent1']/div/div[3]/div/div[2]/span[3]") WebElement scheduledArrivalTime;
	 @FindBy(className="mdl-data-table") List<WebElement> numberOfFlights;
	 
	 
	 public FlightStatusPage(WebDriver driver)
		{
		    //Initializing web elements
			PageFactory.initElements(driver, this);
		}
		
		public void getDetailsForFlight(WebDriver driver, ScreenShotCapture screenShotCapture, String typeOfGetFlight) throws InterruptedException, IOException {
			//performing operations on web elements
			clickArrowDownButton.click();
			Thread.sleep(2000);
			screenShotCapture.capscrshot(driver, typeOfGetFlight+"Success");
			System.out.println("Total number of flights available :"+numberOfFlights.size());
            System.out.println("Details of all flights........................");
	        for (WebElement webElement : numberOfFlights) {
	            String name = webElement.getText();
	            System.out.print(name);
	        
	        }
			
		}
}