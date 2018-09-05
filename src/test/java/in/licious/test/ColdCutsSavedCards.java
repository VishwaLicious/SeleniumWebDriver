package in.licious.test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import in.licious.pom.ColdCutsPage;
import in.licious.pom.HomePage;
import in.licious.pom.NewAddressPage;
import in.licious.pom.NewCheckoutPage;
import in.licious.pom.NewDeliverySummaryPage;
import in.licious.pom.NewLoginFlow;
import in.licious.pom.NewPaymentPage;
import in.licious.util.DataBaseCCC;
import in.licious.util.Helper;

public class ColdCutsSavedCards extends BaseTest {
	
	@Test (priority=12)
	public void testfishandseafood() throws ClassNotFoundException, SQLException
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
		
				
		// Click on Cold cuts category
		HomePage home=new HomePage(driver);
		home.getcoldcutsCat().click();
		Helper.customWait(4);
		
		// Add Chicken_Sausage to cart
		ColdCutsPage coldcutsPage =new ColdCutsPage(driver);
		WebElement addtocart= coldcutsPage.getChickenSausage();
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
		//NewDeliverySummaryPage  newDeliverySummary = new NewDeliverySummaryPage(driver);
		
		// Click on OTP Login
				
		
		// Delivery Slot Selection Express or Scheduled
		NewDeliverySummaryPage  newDeliverySummary = new NewDeliverySummaryPage(driver);
		WebElement TxtBoxContent = driver.findElement(By.xpath("//div[@class='slots-selector']"));
		Helper.customWait(2);
		System.out.println("Printing " + TxtBoxContent.getText());
		Helper.customWait(2);
		
		if (TxtBoxContent.getText().equalsIgnoreCase("Today 120 MIN"))
		{
			System.out.println("Order Placing as Express Delivery");
			newDeliverySummary.getProceedToPaymentBtn().click();	
			Helper.customWait(2);
		}
		
		else 
		{
			System.out.println("Order Placing as Scheduled Delivery");
			
			// Select the Delivery Slot for scheduled delivery
			newDeliverySummary.getSelectDeliverySlot().click();
			Helper.customWait(2);
			newDeliverySummary.getTimeSlot().click();
			Helper.customWait(2);
			newDeliverySummary.getProceedToPaymentBtn().click();
			Helper.customWait(2);
		}
		// New Payment Page
				NewPaymentPage newPaymentPage = new NewPaymentPage(driver);
				
				// Saved card payment 
				newPaymentPage.getSavedCard1().click();
				Helper.customWait(2);
				//helper.enterText(driver, newlogin.getMobileNumber(), userName);
				helper.enterText(driver, newPaymentPage.getCvv1(), "111");
				Helper.customWait(5);
				newPaymentPage.getSavedCardButton().click();
				Helper.customWait(5);
				
				
				
				System.out.println("Saved card Order Placed Sucessfully");
							
		
	}
	

}
