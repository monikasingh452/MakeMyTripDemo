package demo_Utilfirm;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import demo_Base.PageBase;
import demo_Base.ReportMethod;
import errorcollector.ErrorCollector;

public class Demo_Utils  extends PageBase{
	
	public static String sreenshotpath;
	public static String sreenshotName;

	public static void captureScreenshots(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		sreenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + sreenshotName));
		System.out.println("this is the Capture Screenshots");

	}

	/********************************************************************************************
	 * * Method Name : getData Owner : Kaustav Das * * Description : This Method
	 * helps to take data from the excel * * Arguments : Object[][]. * * * Creation
	 * Date : 15/03/2019 Last Modified : 22/03/2019 * * *
	 ********************************************************************************************/

	@DataProvider(name = "dp")
	public static Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excelreadr.getRowCount(sheetName);
		int cols = excelreadr.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];

		Hashtable<String, String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String, String>();

			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(excelreadr.getCellData(sheetName, colNum, 1), excelreadr.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		return data;

	}

	/********************************************************************************************
	 * * Method Name : elementVisible Owner : Kaustav Das * * Description : This
	 * Method helps to Understand the presence of the WebElement * * Arguments :
	 * WebElement * * * Creation Date : 27/03/2019 Last Modified : 27/03/2019 * * *
	 ********************************************************************************************/

	public static boolean elementVisible(WebElement element, String btn) {

		try {
			if (element.isDisplayed()) {
				System.out.println("Element is Visible");
				ReportMethod.htmlInfo(btn + " is Visible  ");
				return true;
			} else {
				System.out.println("Element is InVisible");
				ReportMethod.htmlFail(btn + " is InVisible : ");
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ReportMethod.htmlFail(btn + " is InVisible : ");
			e.printStackTrace();

			return false;
		}
	}

	/********************************************************************************************
	 * * Method Name : elementVisible Owner : Kaustav Das * * Description : This
	 * Method helps to understand that WebElement is enabled or not . * * Arguments
	 * : WebElement * * * Creation Date : 27/03/2019 Last Modified : 27/03/2019 * *
	 * *
	 ********************************************************************************************/
	public static boolean elementEnable(WebElement element) {

		try {
			if (element.isEnabled()) {
				System.out.println("Element is Enable");
				ReportMethod.htmlInfo("Element is Enable : " + element);
				return true;
			} else {
				System.out.println("Element is Disabled");
				ReportMethod.htmlInfo("Element is Disabled : " + element);
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	/********************************************************************************************
	 * * Method Name : selectByText Owner : Kaustav Das * * Description : This
	 * Method helps to Select the Text from the dropdown . * * Arguments :
	 * WebElement , String * * * Creation Date : 08/04/2019 Last Modified :
	 * 08/04/2019 * * *
	 ********************************************************************************************/

	public static void selectByText(WebElement element, String text) {

		try {
			Select select = new Select(element);
			select.selectByVisibleText(text);
			ReportMethod.htmlInfo("User able to select the " + text);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			ReportMethod.htmlFail("User unable to select the " + text);
			ErrorCollector.assertFalse(true);

			e.printStackTrace();
		}

	}

	/********************************************************************************************
	 * * Method Name : selectByText Owner : Kaustav Das * * Description : This
	 * Method helps to click on any webElement by JsScript * * Arguments :
	 * WebElement * * * Creation Date : 08/04/2019 Last Modified : 08/04/2019 * * *
	 ********************************************************************************************/

	public static void safeJavaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element " + e.getStackTrace());
		}
	}

	public static void checkboxJavaScriptClick(WebElement element)
	{
		if (!element.isSelected()) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			System.out.println("this is the Code ");
			}
		else
		{
			System.out.println("Unable to click on check box");
		}
	}
	public static void getstable(List<WebElement> listPolicy, String Pname) {

		try {
			int s = listPolicy.size();
			System.out.println("blacklist size=" + s);

			for (int i = 0; i < s; i++) {

				WebElement ele = listPolicy.get(i);
				System.out.println("ele=" + ele);
				String mss = listPolicy.get(i).getText();
			

				System.out.println("mss=" + mss);
				if (mss.equalsIgnoreCase(Pname)) {
					ele.click();
					System.out.println("Its clicking the policy");

				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void zip_Filed() {
		// TODO Auto-generated method stub
		
	}

	public static void email_Report() {
		// TODO Auto-generated method stub
		
	}

	
	
}


