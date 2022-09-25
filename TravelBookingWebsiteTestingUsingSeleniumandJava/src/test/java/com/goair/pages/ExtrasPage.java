package com.goair.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.goair.utilities.ScreenShotCapture;

public class ExtrasPage {
	
	@FindBy(xpath="//*[@id='insuranceNo']/span[2]") WebElement noTravelProtect;		
	@FindBy(xpath="//*[@id='submit_search_button']/span") WebElement submitBtn;
	
	public ExtrasPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	
	public void submitXtras(WebDriver driver, JavascriptExecutor jse, ScreenShotCapture screenShotCapture, String keyword) throws InterruptedException, IOException {
		jse = (JavascriptExecutor)driver;
		
		noTravelProtect.click();
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");	
		Thread.sleep(1000);
		submitBtn.click();
		Thread.sleep(3000);
		screenShotCapture.capscrshot(driver,keyword+"Success");
		
	}
}
