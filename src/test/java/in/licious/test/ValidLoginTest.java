package in.licious.test;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import in.licious.pom.SignInPage;
import in.licious.util.Helper;
import in.licious.util.ReadData;
public class ValidLoginTest extends BaseTest{

	@Test(invocationCount=2,priority=2)
	public void testValidLoginTest1() throws InterruptedException{
		
		SignInPage signInpage=new SignInPage(driver);
		
		Helper  helper=new Helper();
		
		helper.clickOnElement(driver, signInpage.getSelectLocation());
		
		Helper.customWait(3);
		
		
		
		System.out.println("Pass 1");
		
		
		signInpage.getSelectLocation().click();
		
		
		//Assert.fail();
		
		helper.clickOnElement(driver, signInpage.getbengaluruDeliveryLocation());
		
		//signInpage.getbengaluruDeliveryLocation().click();
		helper.enterText(driver, signInpage.getLoactionTxtBox(), "Marathahalli");
		
		//signInpage.getLoactionTxtBox().sendKeys("Marathahalli");
		Helper.customWait(2);
		
		signInpage.getLoactionTxtBox().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		etest.log(LogStatus.PASS,"Location is selected");
	
//		List<WebElement> ele = driver.findElements(By.xpath("/html/body/div[1]/header/div/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div[3]/div[1]/span"));
//		System.out.println(ele.size());
//		Helper helper=new Helper();
//		helper.clickOnElement(driver, signInpage.getSelectLocation());
//		helper.clickOnElement(driver, signInpage.getbengaluruDeliveryLocation());
//		helper.enterText(driver, signInpage.getLoactionTxtBox(), "Marathahalli");
//		helper.clickOnElement(driver, driver.findElement(By.xpath("//div[@class='recent-searches show']//div[contains(.,'Marathahalli')]")),5);
//		
		//Am
		String excelPath="C:\\Users\\VISHWA\\eclipse-workspace3\\websiteautomation\\ExcelData\\loginCredentials.xlsx";
		String sheetName="loginData";
		int rnum=2;
		int cnum=1;
		ReadData readdataexcel=new ReadData();
		System.out.println(readdataexcel.readDataFromExcel(excelPath, sheetName, rnum, cnum));
		

	}
}
