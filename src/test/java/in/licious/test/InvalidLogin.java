package in.licious.test;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import in.licious.pom.SignInPage;
import in.licious.util.Helper;
public class InvalidLogin extends BaseTest{

	@Test
	public void testInvalidLogin() throws InterruptedException{
		SignInPage signInpage=new SignInPage(driver);
		signInpage.getSelectLocation().click();
		signInpage.getbengaluruDeliveryLocation().click();
		signInpage.getLoactionTxtBox().sendKeys("Marathahalli");
		Helper.customWait(2);
		signInpage.getLoactionTxtBox().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		Assert.fail();
	//	etest.log(LogStatus.,"Location is selected");
//		List<WebElement> ele = driver.findElements(By.xpath("/html/body/div[1]/header/div/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div[3]/div[1]/span"));
//		System.out.println(ele.size());
//		Helper helper=new Helper();
//		helper.clickOnElement(driver, signInpage.getSelectLocation());
//		helper.clickOnElement(driver, signInpage.getbengaluruDeliveryLocation());
//		helper.enterText(driver, signInpage.getLoactionTxtBox(), "Marathahalli");
//		helper.clickOnElement(driver, driver.findElement(By.xpath("//div[@class='recent-searches show']//div[contains(.,'Marathahalli')]")),5);
//		
	}
}
