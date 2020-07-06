package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import demo_Base.PageBase;
import errorcollector.ErrorCollector;
import pageLocator.MMTBeginPageLocator;


public class MMTBeginPage extends PageBase {
public  MMTBeginPageLocator  content;
	
	public MMTBeginPage() {
		this.content = new   MMTBeginPageLocator ();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.content);

	}

  public  void open_MMT() {
	  System.out.println("MMT OPen");
	  boolean result= content.verifyLogo.isDisplayed();
	   if(result) {
		  ErrorCollector.verifyTrue(result);
		//content.openMMTHome.click();
	
	}
  }
  
   public void clickLoginSingUPBtn() {
	   content.Click_Login_Signup_icon.click();
   }
   

}


