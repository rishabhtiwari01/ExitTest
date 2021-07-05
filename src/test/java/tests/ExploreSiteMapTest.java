package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ReadData;
import Utilities.SwtichToPages;
import junit.framework.Assert;
import pages.ExploreStieMapPage;

public class ExploreSiteMapTest extends BaseTest {

	public static Logger logger = Logger.getLogger(ExploreSiteMapTest.class);

	@DataProvider(name = "executionStatus")
	public Object[][] askExecutionStatus() throws Exception {
		Object[][] arrayObject = ReadData.getExcelData(".//TestData//ExitTestData.xlsx", "AskExecutionStatus");
		return arrayObject;
	}

	@Test(dataProvider = "executionStatus")
	public void exploreSiteMap_001(String ExecutionRequired) {
		if (ExecutionRequired.toLowerCase().equals("yes")) {
			extentTest = extent.startTest("exploreSiteMap_001");
			logger.info("Test case Started");
			logger.info("TestId: exploreSiteMap_001");
			ExploreStieMapPage siteMap = new ExploreStieMapPage(driver);
			logger.info("Click on sitemap");
			siteMap.visitSiteMap();
			SwtichToPages.switch_to_next_tab1(driver);
			Assert.assertEquals(driver.getTitle(), prop.getProperty("siteMap"));
			logger.info("Select redbus with RTC");
			logger.info("Click on book now");
			siteMap.bookTicket();
			logger.info("Click on view seats");
			logger.info("click on hide seat");
			siteMap.viewSeats();
			logger.info("View bus fare");
			Assert.assertEquals(driver.getTitle(), prop.getProperty("Tickets"));
			Assert.assertEquals(siteMap.getBusFare(), prop.getProperty("BusFare"));
			logger.info("exploreSiteMap_001 test case Passed!!");
		}

	}

	@DataProvider(name = "agentRegistration")
	public Object[][] registerWithSingaporeBusService() throws Exception {
		Object[][] arrayObject = ReadData.getExcelData(".//TestData//ExitTestData.xlsx", "AgentRegistration");
		return arrayObject;
	}

	//@Test(dataProvider = "agentRegistration")
	public void exploreSiteMap_002(String Name, String EmailId, String Mobile, String Location, String Country,
			String ExecutionRequired) throws InterruptedException {
		if (ExecutionRequired.toLowerCase().equals("yes")) {
			extentTest = extent.startTest("exploreSiteMap_002");
			logger.info("Test case Started");
			logger.info("TestId: exploreSiteMap_002");
			ExploreStieMapPage siteMap = new ExploreStieMapPage(driver);
			logger.info("Click on sitemap");
			siteMap.visitSiteMap();
			SwtichToPages.switch_to_next_tab1(driver);
			logger.info("Looking for singapore bus service and select it");
			siteMap.singaporeBusService();
			Assert.assertEquals(driver.getTitle(), prop.getProperty("SingaporeServie"));
			logger.info("Click on agent registration");
			siteMap.clickAgentRegister();
			SwtichToPages.switch_to_next_tab1(driver);
			logger.info("Tap on register for free");
			siteMap.freeRegistration();
			logger.info("Enter the registration details");
			siteMap.registerAgent(Name, EmailId, Mobile, Location, Country);
			logger.info("Accept the pop-up");
			Assert.assertEquals(driver.getTitle(), prop.getProperty("BusAgent"));
			logger.info("exploreSiteMap_001 test case Passed!!");
		}

	}

}
