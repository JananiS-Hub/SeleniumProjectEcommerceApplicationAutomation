package TestAbstractComponent;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ECommerce.Reports.HTMLReportsUtility;

public class Listeners implements ITestListener {
	ExtentReports extent=HTMLReportsUtility.ExtentReportUtility();
	ExtentTest test;
	WebDriver driver;
	
	ThreadLocal<ExtentTest> threadUnique= new ThreadLocal<ExtentTest>();
	
	
	@Override
	public void onFinish(ITestContext contextFinish) {
		extent.flush();

	}

	@Override
	public void onStart(ITestContext contextStart) {
		

	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String path = null;
		threadUnique.get().fail("test case failed");
		try {
		driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		ScreenShotUtility ScreenShotUtilityObject = new ScreenShotUtility();
		path= ScreenShotUtilityObject.screenshotUtility(result.getMethod().getMethodName(), driver);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		threadUnique.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName()+"test failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	

	}

	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		threadUnique.set(test);
	
}
	@Override
	public void onTestSuccess(ITestResult result) {
	
			test.log(Status.PASS, "Test Passed sucessfully");
	}
	

}
