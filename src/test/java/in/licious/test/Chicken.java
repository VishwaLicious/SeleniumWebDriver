package in.licious.test;

import java.sql.SQLException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import in.licious.pom.ChickenPage;
import in.licious.pom.HomePage;
import in.licious.pom.NewAddressPage;
import in.licious.pom.NewCheckoutPage;
import in.licious.pom.NewDeliverySummaryPage;
import in.licious.pom.NewLoginFlow;
import in.licious.pom.NewPaymentPage;
import in.licious.util.DataBaseCCC;
import in.licious.util.Helper;

public class Chicken extends BaseTest {

	@Test (priority=1)
	public void testChicken() throws ClassNotFoundException, SQLException 
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
		
		/*SignInPage signInpage = new SignInPage(driver);
		Helper helper = new Helper();
		helper.clickOnElement(driver, signInpage.getSelectLocation());

		Helper.customWait(2);

		helper.clickOnElement(driver, signInpage.getbengaluruDeliveryLocation());
		// helper.enterText(driver, signInpage.getLoactionTxtBox(), "Indiranagar");
		helper.enterText(driver, signInpage.getLoactionTxtBox(), location);

		Helper.customWait(2);

		signInpage.getLoactionTxtBox().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		Helper.customWait(2);

		System.out.println("Pass1");

		Helper.customWait(2);

		etest.log(LogStatus.PASS, "Location is selected");
		System.out.println("Pass2");

		signInpage.getLogin().click();
		Helper.customWait(2);
		System.out.println("Pass3");

		// Using JavascriptExecutor to scroll the window abc
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// scroll the window by 1000 pixels
		js.executeScript("window.scrollBy(0,500)");
		System.out.println("Pass4");
		Helper.customWait(4);

		SignupPage signuppage = new SignupPage(driver);

		signuppage.getAlreadyHaveAnAccountlogin().click();
		Helper.customWait(2);
		System.out.println("Pass5");
		Helper.customWait(4);

		// Entering username from config.properties
		helper.enterText(driver, signInpage.getUsernameTxtBox(), userName);

		// signInpage.getUsernameTxtBox().sendKeys("9880335493");
		System.out.println("Pass6");

		// signInpage.getPasswordTxtBox().sendKeys("123456");
		helper.enterText(driver, signInpage.getPasswordTxtBox(), passWord);
		System.out.println("Pass7");
		Helper.customWait(4);

		// Minimizing the News Letter Subscription123
		signInpage.getSubscribe().click();
		Helper.customWait(2);
		signInpage.getLoginBtn().click();
		System.out.println("Pass8");
		Helper.customWait(4);
		*/
		
		// Click on Chicken category
		HomePage home=new HomePage(driver);
		home.getChickenCat().click();
		Helper.customWait(4);
		
		// Add Chicken_Thigh to cart
		ChickenPage chickenPage = new ChickenPage(driver);
		WebElement addtocart = chickenPage.getAddToCartBtn1();
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
		
		/*HomePage home = new HomePage(driver);
		home.getChickenCat().click();
		System.out.println("Pass9");
		Helper.customWait(4);

		// //Here the WebElement is changing dynamically 123456...
		// js.executeScript("window.scrollBy(0,100)");
		// System.out.println("Pass10");
		// Helper.customWait(10);

		ChickenPage chickenPage = new ChickenPage(driver);
		WebElement addtocart = chickenPage.getAddToCartBtn1();

		helper.scrollBar(driver, addtocart);
		Helper.customWait(4);

		// ChickenPage chickenPage =new ChickenPage(driver);
		// Helper.customWait(2);
		// chickenPage.getAddToCartBtn().click();
		// System.out.println("Pass11");
		// Helper.customWait(2);
		//

		CheckoutPage cartloaded = new CheckoutPage(driver);
		cartloaded.getcartBtn().click();
		Helper.customWait(2);
		System.out.println("Pass12");

		cartloaded.getCheckoutBtn().click();
		Helper.customWait(10);
		System.out.println("Pass13");

		CheckoutDelivery checkOutDelivery = new CheckoutDelivery(driver);
		checkOutDelivery.getSelectDeliverySlot().click();
		Helper.customWait(5);
		System.out.println("Pass14");
		String windowId = driver.getWindowHandle();
		driver.switchTo().window(windowId);
		System.out.println("Pass15");
		Helper.customWait(4);

		js.executeScript("window.scrollBy(0,100)");
		System.out.println("Pass16");
		Helper.customWait(10);

		checkOutDelivery.getTimeSlot().click();
		Helper.customWait(2);
		System.out.println("Pass17");

		checkOutDelivery.getContinueBtn().click();
		Helper.customWait(2);
		System.out.println("Pass18");

		js.executeScript("window.scrollBy(0,100)");
		Helper.customWait(5);
		System.out.println("Pass19");

		WebElement proceedtoPay=checkOutDelivery.getProceedtoPaybtn().click();
		helper.scrollBar(driver, proceedtoPay);

		DeliverySummaryPage proceedtopay = new DeliverySummaryPage(driver);
		proceedtopay.getProceedToPaymentBtn().click();
		Helper.customWait(5);
		System.out.println("Pass20");

		PaymentPage paynow = new PaymentPage(driver);
		paynow.getNetBanking().click();
		Helper.customWait(2);
		System.out.println("Pass21");

		paynow.getPayNowBtn().click();
		Helper.customWait(5);
		System.out.println("Pass22");

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		// String windowId1=driver.getWindowHandle();
		// driver.switchTo().window(windowId1);
		// Helper.customWait(5);
		// System.out.println("Pass23");

		RayzorpayPage success = new RayzorpayPage(driver);
		driver.manage().window().maximize();
		System.out.println("maximized");
		success.getRayzorpayPage().click();
		Helper.customWait(5);
		System.out.println("Chicken Wings order palced successfully");

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		// WebElement abcdefgh
		// helper.scrollBar(driver, elementToFind);
		// SignInPage signin=new SignInPage(driver);
		// Helper.customWait(4);
		//
		// System.out.println("Pass33");
		//
		//
		// signin.getLogin().click();
		//
		// System.out.println("Passe4");
		//
		// signin.().click();
		// System.out.println("Passe4");
		//
		// signin.getUsernameTxtBox().sendKeys("9880335493");
		// System.out.println("Pass4");
		//
		// signin.getPasswordTxtBox().sendKeys("123456");
		// signin.getLoginBtn().click();
		//
		// HomePage home=new HomePage(driver);
		// home.getChickenCat().click();
		//
		//
		//
		// ChickenPage cp=new ChickenPage(driver);
		// cp.getChickenBreastBoneless().click();
		// cp.getCart().click();
		//
		//
*/
	}
}
