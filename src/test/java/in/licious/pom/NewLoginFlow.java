package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLoginFlow extends BasePage{
	
	@FindBy(xpath="//a[@class='login-user']")
	private WebElement login;
	
	@FindBy(xpath="//input[@class='user-id']")
	private WebElement mobilenumber;
	
	@FindBy(xpath="//button[.='Proceed']")
	private WebElement proceedbtn;
	
	
	@FindBy(xpath="//input[@class='login-otp']")
	private WebElement enterotp;
	
	@FindBy(xpath="//button[@class='btns otp-login enabled']")
	private WebElement otploginBtn;

	@FindBy(xpath="//li[.='Password Login']")
	private WebElement passwordlogin;
	
	@FindBy(xpath="//input[@class='login-pass']")
	private WebElement enterpassword;
	
	@FindBy(xpath="//button[@class='btns password-login enabled']")
	private WebElement passwordloginBtn;
	
	// Facebook Login elements
	@FindBy(xpath="//span[@class='fb-login']")
	private WebElement facebookloginBtn;
	
	
	
	public NewLoginFlow(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLogin(){
		return login;
	}
	
	public WebElement getMobileNumber(){
		return mobilenumber;
	}
	
	public WebElement getProceedBtn(){
		return proceedbtn;
	}
	
	public WebElement getEnterOtp(){
		return enterotp;
	}
	
	public WebElement getotploginbtn(){
		return otploginBtn;
	}
	
	public WebElement getpasswordLogin(){
		return passwordlogin;
	}
	
	public WebElement getenterpassword(){
		return enterpassword;
	}
	
	public WebElement getpasswordloginBtn(){
		return passwordloginBtn;
	}
	
	
	public WebElement getfacebookloginBtn(){
		return facebookloginBtn;
	}
	
	
	@FindBy(xpath="//div[@class='minimize']")
	private WebElement subscribe;
	
	public WebElement getSubscribe()
	{
		return subscribe;
	}
	
	public void login() {
		
		
	}
}
