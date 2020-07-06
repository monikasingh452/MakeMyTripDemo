package demo_Listener;
import org.apache.http.util.Args;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.Utils;

import com.relevantcodes.extentreports.LogStatus;

import demo_Base.PageBase;
import demo_Utilfirm.Demo_Utils;


public class CustomeListener extends PageBase implements ITestListener {
public void onTestStart(ITestResult result) {
		
		


		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		test = rep.startTest(result.getName().toUpperCase());//-- on testsrtat

		test.log(LogStatus.PASS, result.getName().toUpperCase() + " PASS");//-- on test success 
				rep.endTest(test);
				rep.flush();

		
		
	}

	public void onTestFailure(ITestResult result) {
		
		try {
			Demo_Utils.captureScreenshots(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.log(LogStatus.FAIL, result.getName().toUpperCase() + " Failed with exception : " + result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(Demo_Utils.sreenshotName));

		Reporter.log("Click to see Screenshot");
		Reporter.log("<a target=\"_blank\"href=" + Demo_Utils.sreenshotName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\"href=" + Demo_Utils.sreenshotName + "><img src=" + Demo_Utils.sreenshotName
				+ " height=200 width=200></img></a>");
		rep.endTest(test);
		rep.flush();
		
		
	}

	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		
		
	}
	

}


