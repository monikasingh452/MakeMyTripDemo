package pageLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MMTBeginPageLocator {
	@FindBy (xpath="//a[@class='mmtLogo makeFlex']//img")
	public WebElement verifyLogo;
	
   // @FindBy (xpath="//p[contains(text(),'Login or Create Account')]")
    @FindBy (xpath=" //label[contains(text(),'Login with Phone/Email')]")
	public WebElement Click_Login_Signup_icon;
	
 
	

}
