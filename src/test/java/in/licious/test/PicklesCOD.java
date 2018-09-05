package in.licious.test;

import java.sql.SQLException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import in.licious.pom.HomePage;
import in.licious.pom.NewAddressPage;
import in.licious.pom.NewCheckoutPage;
import in.licious.pom.NewDeliverySummaryPage;
import in.licious.pom.NewLoginFlow;
import in.licious.pom.NewPaymentPage;
import in.licious.pom.PicklesPage;
import in.licious.util.DataBaseCCC;
import in.licious.util.Helper;

public class PicklesCOD extends BaseTest {
	
	@Test (priority=37)
	public void testpickles() throws ClassNotFoundException, SQLException
	{
		
		// Sign In with New Login Flow
		NewLoginFlow newlogin = new NewLoginFlow(driver);
		Helper helper = new Helper();
		helper.clickOnElement(driver, newlogin.getSelectLocation());
		Helper.customWait(2);
		helper.clickOnElement(driver, newlogin.getbengaluruDeliveryLocation());
		Helper.customWait(2);
		helper.enterText(driver, newlogin.getLoactionTxtBox(), location);
		Helper.customWait(2);
		newlogin.getLoactionTxtBox().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		Helper.customWait(2);
		etest.log(LogStatus.PASS,"Location is selected");
		
		// Click on Login in HomePage
		newlogin.getLogin().click();
		Helper.customWait(2);
		
		// Enter valid UserName and Password
		helper.enterText(driver, newlogin.getMobileNumber(), userName);
		Helper.customWait(2);
		
		// Click on Proceed button
		helper.clickOnElement(driver, newlogin.getProceedBtn());
		Helper.customWait(2);
				
		// Click on Password login 
		helper.clickOnElement(driver, newlogin.getpasswordLogin());
		Helper.customWait(2);
				
		// Enter the password
		helper.enterText(driver, newlogin.getenterpassword(), passWord);
		Helper.customWait(2);
				
		
		// Click on OTP Login
		// Reading OTP  from DB
		DataBaseCCC db1=new DataBaseCCC(driver);
		System.out.println("Pass1");
		String s1=db1.otp1;
		System.out.println("otp1");
		System.out.println("pass2");
		System.out.println(s1);
		System.out.println("pass3");
		
		// Click on Login Button
		helper.clickOnElement(driver, newlogin.getpasswordloginBtn());
		Helper.customWait(5);
		
		/*// Click on Bangalore City
		SignInPage signInpage = new SignInPage(driver);
		Helper helper = new Helper();
		helper.clickOnElement(driver, signInpage.getSelectLocation());
		Helper.customWait(2);
		helper.clickOnElement(driver, signInpage.getbengaluruDeliveryLocation());
		Helper.customWait(2);
		
		// Enter the Delivery Location
		helper.enterText(driver, signInpage.getLoactionTxtBox(), location);
		Helper.customWait(2);
		signInpage.getLoactionTxtBox().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		Helper.customWait(2);
		etest.log(LogStatus.PASS,"Location is selected");
		
		
		// Click on Login in HomePage
		signInpage.getLogin().click();
		Helper.customWait(2);
		
		// Click on Login in SignUp Page
		SignupPage signuppage = new SignupPage(driver);
		WebElement login= signuppage.getAlreadyHaveAnAccountlogin();
		helper.scrollBar(driver, login);
		Helper.customWait(4);
		
		// Enter valid UserName and Password
		
		//signInpage.getUsernameTxtBox().sendKeys("9880335493");
		//String getUserName= properties.getProperty("username");
		helper.enterText(driver, signInpage.getUsernameTxtBox(), userName);
		
		
		
		//signInpage.getPasswordTxtBox().sendKeys("123456");
		//String getPassword= properties.getProperty("password");
		helper.enterText(driver, signInpage.getPasswordTxtBox(), passWord);
		
		Helper.customWait(2);
		
		// Minimizing the News Letter Subscription
		signInpage.getSubscribe().click();
		Helper.customWait(2);
		
		
		// Click on LoginButton
		signInpage.getLoginBtn().click();
		Helper.customWait(4);
		*/
		
		// Click on Pickles category
		HomePage home=new HomePage(driver);
		home.getpicklesCat().click();
		Helper.customWait(4);
		
		// Add Chiuncky_Chicken_Spread to cart
		PicklesPage picklesPage =new PicklesPage(driver);
		WebElement addtocart= picklesPage.getChunckyChickenSpread();
		Helper.customWait(4);
		helper.scrollBar(driver, addtocart );
		Helper.customWait(4);
		System.out.println("pass");
		
		// New Checkout flow
		
		// New Cart Page
		NewCheckoutPage cartloaded = new NewCheckoutPage(driver);
		cartloaded.getcartBtn().click();
		Helper.customWait(2);
		cartloaded.getCheckoutBtn().click();
		Helper.customWait(2);
		
		// New Address Summary Page
		NewAddressPage newAddressPage = new NewAddressPage(driver);
		newAddressPage.getInd().click();
		newAddressPage.getContinueBtn().click();
		Helper.customWait(2);
		
		// New Delivery Summary page
		NewDeliverySummaryPage  newDeliverySummary = new NewDeliverySummaryPage(driver);
		newDeliverySummary.getProceedToPaymentBtn().click();
		Helper.customWait(2);
		
		// New Payment Page
		NewPaymentPage newPaymentPage = new NewPaymentPage(driver);
		newPaymentPage.getCashOnDelivery().click();
		Helper.customWait(2);
		newPaymentPage.getPlaceOrder().click();
		Helper.customWait(10);
				
		System.out.println("Cash On Delivery Order Placed Sucessfully");
		
		
		/*// Click on Cart icon
		CheckoutPage cartloaded = new CheckoutPage(driver);
		cartloaded.getcartBtn().click();
		Helper.customWait(4);
		
		
		// Click on Checkout Button
		cartloaded.getCheckoutBtn().click();
		Helper.customWait(2);
		
		
		// Click on Continue button 
		CheckoutDelivery checkOutDelivery = new CheckoutDelivery(driver);
		
		// For Express Delivery or 120 Mins Delivery
		checkOutDelivery.getContinueBtn().click();
		Helper.customWait(2);
		
		// For Scheduled Delivery 
		checkOutDelivery.getSelectDeliverySlot().click();
		Helper.customWait(2);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		Helper.customWait(2);
		checkOutDelivery.getTimeSlot().click();
		Helper.customWait(1);
		checkOutDelivery.getContinueBtn().click();
		Helper.customWait(5);
		
		System.out.println("PASSSS");
		
		// Click on Proceed to Payment Button 
		DeliverySummaryPage proceedtopay = new DeliverySummaryPage(driver);
		WebElement proceedtopayment = proceedtopay.getProceedToPaymentBtn();
		helper.scrollBar(driver, proceedtopayment );
		Helper.customWait(2);
		
		
		// Click on NetBanking 
		PaymentPage paynow = new PaymentPage(driver);
		paynow.getNetBanking().click();
		Helper.customWait(2);
		
		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
				
		
		// Click on PayNow Button
		paynow.getPayNowBtn().click();
		Helper.customWait(5);
		
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		
		
		// Click on Success Button in RazorPay Page
		RayzorpayPage success = new RayzorpayPage(driver);
		System.out.println("maximized");
		success.getRayzorpayPage().click();
		Helper.customWait(5);
		System.out.println("Chuncky Chicken Spread order palced successfully");
		
		
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);*/
		
		
	}
	

}
