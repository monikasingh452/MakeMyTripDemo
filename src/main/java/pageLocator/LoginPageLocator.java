package pageLocator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocator {

	/*@FindBy (xpath="//a[contains(text(),' Create New Account ')]")
	public WebElement clickCreateAccount;*/
	
	
	
	/*@FindBy (xpath="//input[@id='emailOrPhone']")
	public WebElement EnterUN;*///sigup
	
	//login
	@FindBy (xpath="//div[@class='modalField makeFlex column appendBottom20']/div/input[@id='username']")
	//@FindBy (xpath="//input[@id='username']")
	public WebElement EnterUN;
	
	
	
	
	//@FindBy (xpath="//div[@class='btnContainer appendBottom25 ']/button[@data-cy='continueBtn']")
	@FindBy (xpath="//div[@class='modalField makeFlex column appendBottom20']/../div/button")
	//@FindBy (xpath="//span[contains(text(), 'Continue')]/..")
	public WebElement clickContinue;
	
	//WebElement element = driver.findElement(By.xpath("//a[@id='continue_button']));
			
	
	@FindBy (xpath="//div[@class='modalField makeFlex column appendBottom30']/div/input[@id='password']")
	public WebElement EnterPwd;
	
	
	@FindBy (xpath="//div[@class='modalField makeFlex column appendBottom30']/../div/button")
	public WebElement clickLogin;
	
	
	
	
	

}
