package resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class listener extends baseTestClass implements ITestListener {
	public static Logger log = LogManager.getLogger(baseTestClass.class.getName());
	ExtentReports extendreport = ExtentReportNG.Reports();
	ExtentTest test;
	ThreadLocal<ExtentTest> extendReport = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test = extendreport.createTest(result.getMethod().getMethodName());
		extendReport.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		String testCaseName = result.getMethod().getMethodName();
		log.info("############## test case: " + testCaseName + " is passed" + "########################");
		extendReport.get().log(Status.PASS, (testCaseName + " is passed"));
	}

	public void onTestFailure(ITestResult result) {

		// code to capture screen shot on fail
		String testCaseName = result.getMethod().getMethodName();
		try {

			WebDriver driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
			String path = takeScreenShotonFail(testCaseName, driver);
			extendReport.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			log.info("##############" + testCaseName + " is failed" + "########################");
			extendReport.get().fail(result.getThrowable());
		}

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		extendreport.flush();

	}

}
