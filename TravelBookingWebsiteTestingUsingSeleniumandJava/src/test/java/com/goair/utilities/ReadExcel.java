package com.goair.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public Sheet readExcel(int sheetNo) throws IOException {

		File file = new File(System.getProperty("user.dir")+"\\src/test/resources\\DataProvider.xlsx");

		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;

		workbook = new XSSFWorkbook(inputStream);

		Sheet sheet = workbook.getSheetAt(sheetNo);
		return sheet;
	}
}
