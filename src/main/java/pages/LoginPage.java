package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import demo_Base.PageBase;
import pageLocator.LoginPageLocator;


public class LoginPage extends PageBase  {
	
	
	public LoginPageLocator content;
	
	public LoginPage() {
		
		this.content = new   LoginPageLocator();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.content);

	}
	
	
	
	public void EnterUserName() {
		   try {
			content.EnterUN.sendKeys("monikasingh452@gmail.com");
			
			//log is missing need to add assertion 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	
	public void clickcontinue() {
		try {
			System.out.println("this is hte main area ");
			   content.clickContinue.click();
			   /*JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", content.clickContinue);
			   System.out.println("this main area work has been done ");*/
			
			//new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#continue_button span.button-content"))).click();
			//content.clickContinue.sendKeys(Keys.ENTER);
			
			/*WebElement element = driver.findElement(By.xpath("//a[@id='continue_button']"));
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", element);*/
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	
	public void enterPwd() {
		   content.EnterPwd.sendKeys("rocker5377");
	   }
	
	public void clickLogin() {
		   content.clickLogin.click();
	   }
	  
}
