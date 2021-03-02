package com.orgname.base;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.orgname.utilities.CommonUtil;
import com.relevantcodes.extentreports.LogStatus;

public class ExecutionListeners extends BaseTest implements ITestListener {

	public void onTestStart(ITestResult result) {

		test = extentReport.startTest(result.getName().toUpperCase() );

	}

	/**
	 * Invoked each time a test succeeds.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#SUCCESS
	 */

	public void onTestSuccess(ITestResult result) {

		test.log(LogStatus.PASS, result.getName().toUpperCase() + "_PASS");

		extentReport.endTest(test);
		extentReport.flush();
		// not implemented
	}

	/**
	 * Invoked each time a test fails.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#FAILURE
	 */
	public void onTestFailure(ITestResult result) {

		// reportng class
		System.setProperty("org.uncommons.reporting.escapge-ouput", "false");

		try {
			CommonUtil.captureScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Capture Screenshot1");
		Reporter.log("<a target=\"_blank\" href=\"C:\\Automation\\error.jpg\">Screenshot</a>");

		test.log(LogStatus.FAIL, result.getName().toUpperCase() + "fail");
		test.log(LogStatus.FAIL, test.addScreenCapture(CommonUtil.screenShotName));
		extentReport.endTest(test);
		extentReport.flush();
	}

	/**
	 * Invoked each time a test is skipped.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#SKIP
	 */
	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	/**
	 * Invoked each time a method fails but has been annotated with
	 * successPercentage and this failure still keeps it within the success
	 * percentage requested.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
	 */
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	/**
	 * Invoked each time a test fails due to a timeout.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 */
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	/**
	 * Invoked before running all the test methods belonging to the classes inside
	 * the &lt;test&gt; tag and calling all their Configuration methods.
	 *
	 * @param context The test context
	 */
	public void onStart(ITestContext context) {
		// not implemented
	}

	/**
	 * Invoked after all the test methods belonging to the classes inside the
	 * &lt;test&gt; tag have run and all their Configuration methods have been
	 * called.
	 *
	 * @param context The test context
	 */
	public void onFinish(ITestContext context) {
		// not implemented
	}

}
