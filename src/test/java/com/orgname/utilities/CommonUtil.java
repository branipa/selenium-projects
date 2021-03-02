package com.orgname.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.orgname.base.BaseTest;

public class CommonUtil extends BaseTest {

	public static String screenShotPath;
	public static String screenShotName;

	public static void captureScreenshot(String testName) throws IOException {

		Date d = new Date();
		screenShotName = testName + "__" + d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot,
				new File(System.getProperty("user.dir") + "\\target\\Screenshots\\" + screenShotName));

	}

	@DataProvider(name = "dataProvider")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			for (int colNum = 0; colNum < cols; colNum++) {

				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);

			}
		}

		return data;

	}

	@DataProvider(name = "dataProviderHashtable")
	public Object[][] getData_Hashtable(Method m) {

		String sheetName = m.getName();
		Hashtable<String,String> table = null;
		int rows = excel.getRowCount(sheetName); //4
		int cols = excel.getColumnCount(sheetName); //4

		System.out.println("row count" + rows);
		System.out.println("row count" + cols);

		Object[][] data = new Object[rows - 1][1]; // data start at row 2

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			
			 table = new Hashtable<String,String>();

			for (int colNum = 0; colNum < cols; colNum++) {

				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				
				
				

			}
			data[rowNum - 2][0] = table;
		}

		return data;

	}

}
