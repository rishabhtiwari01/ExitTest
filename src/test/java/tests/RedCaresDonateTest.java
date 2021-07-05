package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ReadData;
import Utilities.SwtichToPages;
import pages.RedCaresDonatePage;

public class RedCaresDonateTest extends BaseTest {

	public static Logger logger = Logger.getLogger(RedCaresDonateTest.class);

	@DataProvider(name = "DonateTestData")
	public Object[][] donateTstData() throws Exception {
		Object[][] arrayObject = ReadData.getExcelData(".//TestData//ExitTestData.xlsx", "Donate");
		return arrayObject;
	}

	@Test(dataProvider = "DonateTestData")
	public void donateTest_001(String Name, String EmailId, String MobileNo, String ExecutionRequired) {
		if (ExecutionRequired.toLowerCase().equals("yes")) {
			extentTest = extent.startTest("donateTest_001","This test is to check the redCare donate");
			logger.info("TestId: donateTest_001");
			logger.info("Test case started");
			RedCaresDonatePage donate = new RedCaresDonatePage(driver);
			logger.info("Tap the donate banner");
			donate.tapDonateBanner();
			SwtichToPages.switch_to_next_tab1(driver);
			logger.info("Select amount to be donated");
			logger.info("Enter required details");
			logger.info("Click on pay now");
			Assert.assertEquals(donate.getDonateHeading(), prop.getProperty("donatePageHeading"));
			donate.enterDonateDetails(Name, EmailId, MobileNo);
			logger.info("Select payement option");
			logger.info("Select bank");
			donate.selectBankOption();
			Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("paymentURl"));
			logger.info("Test Case Passed!!");

		}
	}

}
