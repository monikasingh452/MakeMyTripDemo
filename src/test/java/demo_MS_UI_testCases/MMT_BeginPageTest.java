package demo_MS_UI_testCases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.fail;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import demo_Base.PageBase;
import demo_Listener.CustomeListener;
import demo_Utilfirm.Demo_Utils;
import errorcollector.ErrorCollector;
import pages.MMTBeginPage;

@Listeners(demo_Listener.CustomeListener.class)
public class MMT_BeginPageTest extends PageBase {
	@BeforeMethod
	public void setup() {

		PageBase.initConfig();

	}

	@Test(priority=1)
	public void openMMTTest() {
		MMTBeginPage mmt= new MMTBeginPage();
		mmt.open_MMT();
		System.out.println("logo verified: Make my trip site open sucessfully.");
		
	}
	@Test(priority=2)
	public static void clickLoginSingUPBtnTest() {
		MMTBeginPage clickLoginSignUp= new MMTBeginPage();
		clickLoginSignUp.clickLoginSingUPBtn();
		System.out.println("Login/signup dialog open");
		
	}
	
	

	
	//@AfterMethod
	@AfterMethod
	//@AfterClass
	public void tearDown() {
		if (PageBase.driver != null) {
			PageBase.quitBrowser();
		}
	}
	
	



}


