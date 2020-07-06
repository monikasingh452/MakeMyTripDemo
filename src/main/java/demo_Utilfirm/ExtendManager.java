package demo_Utilfirm;
import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;


public class ExtendManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {

		if (extent == null) {
			extent = new ExtentReports(System.getProperty("user.dir") + "/target/surefire-reports/html/extentReort.html",
					true, DisplayOrder.OLDEST_FIRST);
			// extent.loadConfig(new
			// File(System.getProperty("user.dir")+"\\src\\test\\resources\\extentconfig\\ReportsConfig.xml"));
			extent.loadConfig(new File(System.getProperty("user.dir") + "/report/ReportConfig.xml"));
		}
		return extent;

	}

}
