package demo_MS_UI_testCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import demo_Base.PageBase;
import pages.LoginPage;
import pages.MMTBeginPage;



@Listeners(demo_Listener.CustomeListener.class)
public class LoginPageTest extends PageBase{
	//static MMTBeginPage StartPage;
     //static CreateAccountPage cAp;
     
	
	@BeforeMethod
	public void setup() {

		PageBase.initConfig();

	}
	//enter username and click continue
	@Test(priority=1)
	public static void enterUNTest() throws InterruptedException {
		MMT_BeginPageTest.clickLoginSingUPBtnTest();
		LoginPage logintc= new LoginPage();
		logintc.EnterUserName();
		System.out.println("id entered");
		//Thread.sleep(3000);
		logintc.clickcontinue();
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("continue clicked");
		
		
		logintc.enterPwd();
		System.out.println("pwd enterd");
		logintc.clickLogin();
		System.out.println("login clicked");
		
	}
	/*@Test(priority=2)
	public static void 	enterPWDTest() {
		CreateAccountPage pwd= new CreateAccountPage();
		pwd.enterPwd();
		System.out.println("pwd enterd");
		pwd.clickLogin();
	}
	*/
	
	
	
	@AfterMethod
	public void tearDown() {
		if (PageBase.driver != null) {
			PageBase.quitBrowser();
		}
	}

}
