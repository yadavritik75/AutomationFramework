package ritik.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public  class ExtentReportTesting {
public static  ExtentReports getReport()
{
	String path = System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	reporter.config().setDocumentTitle("Automation Results");
	reporter.config().setReportName("Result Ecommerce Automation");
	
	ExtentReports extent=new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("QA", "Ritik");
	return extent;
	
	}
}
