//public class PassengerDetailsPage {
//
//	@FindBy(xpath = "//select[@id='goAirPassengers_0__Name_Title']") WebElement titleSelect;
//	@FindBy(xpath = "//input[@id='goAirPassengers_0__Name_First']") WebElement firstNameInput;
//	@FindBy(xpath = "//input[@id='goAirPassengers_0__Name_Last']") WebElement lastNameInput;
//	@FindBy(xpath = "//select[@id='nationality_0']") WebElement nationalitySelect;
//	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div/div/select[1]") WebElement dobMonthSelect;
//	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div/div/select[2]") WebElement dobYearSelect;
//	@FindBy(xpath = "//*[@id='ui-datepicker-div']/table/tbody/tr/td") List<WebElement> dobDatePicker;
//	@FindBy(xpath = "//*[@id='im_first_passenger']") WebElement contactPassengerCheckBox;
//	@FindBy(xpath = "//input[@id='goAirContact_EmailAddress']")	WebElement contactPassengerEmailInput;
//	@FindBy(xpath = "//input[@id='txtMobileEdit']")	WebElement contactPhoneInput;
//	
//	public PassengerDetailsPage(WebDriver driver) {
//		PageFactory.initElements(driver, this);
//	}
//	
//	public void contactEntryProcess()
//	{
//		
//	}
//}

package com.goair.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.goair.utilities.ScreenShotCapture;

public class PassengerDetailsPage {

	@FindBy(xpath = "//*[@id='goAirPassengers_0__Name_Title']")	WebElement title;
	@FindBy(xpath = "//*[@id='goAirPassengers_0__Name_First']")	WebElement firstName;
	@FindBy(xpath = "//*[@id='goAirPassengers_0__Name_Last']") WebElement lastName;
	@FindBy(xpath = "//*[@id='nationality_0']")	WebElement nationality;
	@FindBy(xpath = "//*[@id='date_of_birth_date_0']") WebElement dob;
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[6]/a") WebElement dobSelect;
	@FindBy(xpath = "//*[@id='passengerForm']/div[4]/div[1]/label/span[4]")	WebElement iamPassenger;
	@FindBy(xpath = "//*[@id='goAirContact_EmailAddress']")	WebElement contactEmail;
	@FindBy(xpath = "//*[@id='txtMobileEdit']")	WebElement contactMobileNumber;
	@FindBy(xpath = "//*[@id='goAirContact_EmergencyContactAreaNumber']") WebElement contactAreaCode;
	@FindBy(xpath = "//*[@id='goAirContact_EmergencyNumber']") WebElement contactEMobileNumber;
	@FindBy(xpath = "//*[@id='submit_search_button']/span")	WebElement submitBtn;

	public PassengerDetailsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void submitPassengerDetails(WebDriver driver, String fname, String lname, String email, String mno, String emno, ScreenShotCapture screenShotCapture, String keyword)
			throws InterruptedException, IOException {
		title.click();
		title.sendKeys(Keys.DOWN);
		title.sendKeys(Keys.DOWN);
		title.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		firstName.sendKeys(fname);
		lastName.sendKeys(lname);

		nationality.click();
		nationality.sendKeys(Keys.DOWN);
		nationality.sendKeys(Keys.ENTER);

		dob.click();
		Thread.sleep(1000);
		dobSelect.click();

		iamPassenger.click();
		Thread.sleep(1000);

		contactEmail.sendKeys(email);
		contactMobileNumber.sendKeys(mno);
		// contactAreaCode.sendKeys("400601");
		contactEMobileNumber.sendKeys(emno);

		submitBtn.click();
		Thread.sleep(3000);
		screenShotCapture.capscrshot(driver,keyword+"Success");

	}

}
