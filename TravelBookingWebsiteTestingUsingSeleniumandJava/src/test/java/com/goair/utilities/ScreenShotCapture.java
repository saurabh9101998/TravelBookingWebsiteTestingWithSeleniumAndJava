package com.goair.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotCapture {

	public void capscrshot(WebDriver driver, String fileName) throws IOException {
		
		fileName = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss_").format(new Date()) + fileName;
		
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		
		File destFile = new File(System.getProperty("user.dir") + "\\test-output\\screenshots\\" + fileName + ".png");
		
		FileUtils.copyFile(srcFile, destFile);
	}
}
