package demo_Base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import demo_Utilfirm.ExtendManager;

public class PageBase {
	/*webdriver,
	properties,
	excel reading,
	logs,
	extents report, 
	database, 
	email purpose*/
	
	public static WebDriver driver;
	public static Properties config = new Properties(); 	
	public static Properties OR = new Properties();  
	//public static ExcelReader excelreadr= new ExcelReader(System.getProperty("user.dir") + "/home/ambrish/Kautsav_WorkSpace/monika_Framework/xcel/Data.xlsx");
	public static ExcelReader excelreadr= new ExcelReader("/home/ambrish/Documents/Read_File/Data.xlsx");
	public static ExtentReports rep= ExtendManager.getInstance();
	public static ExtentTest test;
	public static FileInputStream fis;
    //public  String browser;
    public static WebDriverWait wait;
    public static Logger Log= Logger.getLogger("DemoLogger");
    public static String path = System.getProperty("user.dir");
	
	
	@BeforeSuite
	public void configLoad()  {
		if(driver==null) {
			
				try {
					fis= new FileInputStream(System.getProperty("user.dir")+"/prop/Config.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				try {
					config.load(fis);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
				try {
					fis= new FileInputStream(System.getProperty("user.dir")+"/prop/OR.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
				try {
					OR.load(fis);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		}	
	}
	
	
	public static void initConfig() {
		try {
			String browser=	config.getProperty("browser");
			
			if (browser.equalsIgnoreCase("chrome")) {
			
				//System.setProperty("webdriver.chrome.driver",path +"/Drivers/chromedriver");
				System.setProperty("webdriver.chrome.driver",
						"/home/ambrish/Kautsav_WorkSpace/MakeMyTrip/Drivers/chromedriver");
				driver= new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")) {
			
				System.setProperty("webdriver.gecko.driver", path+"/Drivers/geckodriver");
				 driver= new FirefoxDriver();
				 
				
			}
			 driver.get(config.getProperty("Url"));
			 driver.manage().window().maximize();
			 driver.navigate().refresh();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		} catch (Exception e) {
			
			e.printStackTrace();
			Assert.fail();
		}
		 
		
	}
	
	public static void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	public void tearDown() {
		
	}



}
