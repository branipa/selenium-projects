package com.orgname.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.orgname.utilities.ExcelReader;
import com.orgname.utilities.ExtentReporting;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;

public class BaseTest {

	/*
	 * WebDriver Extent Reports Logs Properties DB Excel mail
	 */

	public static WebDriver driver;
	public static Properties config;
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\TC002_AddCustomer.xlsx");
	public static WebDriverWait wait;
	public static ExtentReports extentReport = ExtentReporting.getInstance();
	public static ExtentTest test;

	

	@BeforeSuite
	public void setup() throws IOException {

		// Read the Property file
		Properties config = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
		config.load(fis);

		log.debug("config file is loaded");

		if (config.getProperty("browser").equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println(config.getProperty("URL"));
			driver.get(config.getProperty("URL"));
		//	driver.get(config.getProperty("URL"));
			
		}

		
		
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("Implicit.time")),
	//			TimeUnit.SECONDS);
		
		Assert.assertEquals(true, true);

		// for checking the alert

		wait = new WebDriverWait(driver, 5);
		// Alert alert = wait.until(ExpectedConditions(alerttext));

	}

	
	public void click() {

		test.log(LogStatus.INFO, "Clicking on Locator");
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[2]/div[1]/div[1]/div/div[2]/input/input")).click();

	}

	
	public void type(String value)

	{
		test.log(LogStatus.INFO, "Typing on" + value);

	}
	
	@AfterSuite
	public void Release() {

		if (driver != null)
			driver.quit();

	}

}
