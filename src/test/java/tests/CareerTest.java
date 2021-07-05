package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ReadData;
import Utilities.SwtichToPages;
import pages.CareersPage;

public class CareerTest extends BaseTest {

	public static Logger logger = Logger.getLogger(CareerTest.class);

	@DataProvider(name = "CareerTest001")
	public Object[][] CareerData() throws Exception {
		Object[][] arrayObject = ReadData.getExcelData(".//TestData//ExitTestData.xlsx", "CareerTestData");
		return arrayObject;
	}

	@Test(dataProvider = "CareerTest001")
	public void carrerTest001(String Name, String EmailId, String Password, String ExecutionRequired)
			throws InterruptedException {
		if (ExecutionRequired.toLowerCase().equals("yes")) {
			extentTest = extent.startTest("carrerTest001");
			CareersPage career = new CareersPage(driver);
			logger.info("This is Career Page test");
			career.clickCarrers();
			logger.info("Career test started");
			SwtichToPages.switch_to_next_tab1(driver);
			logger.info("Click on Jobs button");
			career.viwJobPartners();
			career.openInstahyre();
			logger.info("Open Instahyre....");
			SwtichToPages.switch_to_next_tab1(driver);
			career.applyForJob();
			logger.info("Click on apply jobs...");
			career.fill_job_details(Name, EmailId, Password);
			logger.info("Enter jobs details");
			Assert.assertEquals(prop.getProperty("careerPage"), driver.getTitle());
			logger.info("Test case Passed.");
		}
	}
}
