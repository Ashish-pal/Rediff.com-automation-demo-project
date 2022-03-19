package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	static ExtentReports extentReport;

	public static ExtentReports getExtentReports() {

		String extentReportPath = System.getProperty("user.dir") + "\\reports\\extentReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
		reporter.config().setReportName("Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Operating System", "Windows 11 Home Single Language");
		extentReport.setSystemInfo("Tested by: ", "Ashish Pal");
		return extentReport;
	}
}
