package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ReadData;
import Utilities.SwtichToPages;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	public static Logger logger = Logger.getLogger(LoginTest.class);

	@DataProvider(name = "ValidLoginTestData")
	public Object[][] ValidLoginData() throws Exception {
		Object[][] arrayObject = ReadData.getExcelData(".//TestData//ExitTestData.xlsx", "ValidLogin");
		return arrayObject;
	}

	@Test(dataProvider = "ValidLoginTestData")
	public void ValidLogin_001(String EmailId, String Password, String ExecutionRequired) throws InterruptedException {

		if (ExecutionRequired.toLowerCase().equals("yes")) {
			extentTest = extent.startTest("ValidLogin_001","This test is to check the login functionality via valid details");
			logger.info("This is login test");
			logger.info("TestId: ValidLogin_001....test case Started");
			LoginPage login = new LoginPage(driver);
			logger.info("Click on the profile icon");
			logger.info("click on SignIn button/link");
			logger.info("SignIn with google");
			login.clickSignIN();
			SwtichToPages.switch_to_next_tab(driver);
			logger.info("Enter your email address and click next..");
			logger.info("Enter your password and click next..");
			login.google_signIN(EmailId, Password);
			Thread.sleep(2000);
			SwtichToPages.switch_back(driver);
			Thread.sleep(5000);
			logger.info("Close the pop-up and click on profile icon");
			logger.info("click on myProfile..");
			login.closePopUp();
			logger.info("User is signedIn....");
			Assert.assertEquals(login.getProfileName(), prop.getProperty("ProfileName"));
			logger.info("Test case Passed!!");
		}

	}
	
	@DataProvider(name = "InValidLoginTestData")
	public Object[][] InValidLoginData() throws Exception {
		Object[][] arrayObject = ReadData.getExcelData(".//TestData//ExitTestData.xlsx", "InValidLogin");
		return arrayObject;
	}
	
	@Test(dataProvider = "InValidLoginTestData")
	public void InvalidLogin_001(String EmailId, String Password, String ExecutionRequired) throws InterruptedException 
	{
		if(ExecutionRequired.toLowerCase().equals("yes")) 
		{
			extentTest = extent.startTest("InValidLogin_001","This test is to check invalid login details functionality");
			logger.info("This is login test");
			logger.info("TestId: InValidLogin_001....test case Started");
			LoginPage login = new LoginPage(driver);
			logger.info("click on the profile icon");
			logger.info("click on signIn button");
			logger.info("select signIn with google");
			login.clickSignIN();
			logger.info("Enter email and click next");
			logger.info("Enter password and click on next again");
			login.google_signIN(EmailId, Password);
			Assert.assertEquals(driver.getTitle(), prop.getProperty("homePage"));
			logger.info("Test case Passed");
			login.closePopUp();			
			
		}
	}

}
