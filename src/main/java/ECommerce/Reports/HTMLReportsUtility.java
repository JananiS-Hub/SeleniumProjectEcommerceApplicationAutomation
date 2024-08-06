package ECommerce.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class HTMLReportsUtility {
	
	
	public static ExtentReports ExtentReportUtility() {
		String pathToStoreTheHtmlReport=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(pathToStoreTheHtmlReport);
		reporter.config().setReportName("ECommerce project Test report");
		reporter.config().setDocumentTitle("Test case result");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Janani");
		return extent;
		
	}

}
