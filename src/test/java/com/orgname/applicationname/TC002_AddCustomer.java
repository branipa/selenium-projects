package com.orgname.applicationname;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orgname.base.BaseTest;

public class TC002_AddCustomer extends BaseTest{

	@Test(dataProvider = "getData")
	public void AddCust1(String firstName, String lastName, String postCode) {

		
		System.setProperty("org.uncommons.reporting.escapge-ouput","false");
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(postCode);
		click();
		type("first test");	
		
		log.debug("Testing");
	//	Assert.fail();
		
		// reportNG 
	//	Reporter.log("testing is good");
		
		//Reporter.log("<a target=\"_blank\" href=\"C:\\Automation\\error.jpg\">Screenshot</a>");
		//Reporter.log("<a target=\"_blank\" href=\"C:\\Automation\\error.jpg\">Screenshot</a>");
		
	}

	@DataProvider
	public Object[][] getData() {
		
		
		
		String sheetName = "TC002_AddCustomer";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows-1][cols];
		
		for(int rowNum=2; rowNum<=rows; rowNum++) {
			
			for(int colNum=0; colNum<cols; colNum++) {
				
				data[rowNum -2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
				
			}
		}

		return data;

	}
}
