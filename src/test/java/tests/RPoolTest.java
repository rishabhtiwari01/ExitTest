package tests;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ReadData;
import junit.framework.Assert;
import pages.RPoolPage;

public class RPoolTest extends BaseTest {

	public static Logger logger = Logger.getLogger(RPoolTest.class);

	@DataProvider(name = "RPoolTest")
	public Object[][] contactTestData() throws Exception {
		Object[][] arrayObject = ReadData.getExcelData(".//TestData//ExitTestData.xlsx", "AskExecutionStatus");
		return arrayObject;
	}

	@Test(dataProvider = "RPoolTest")
	public void checkVideoLink_001(String ExecutionRequired) {
		if (ExecutionRequired.toLowerCase().equals("yes")) {
			extentTest = extent.startTest("checkVideoLink_001","This test is to check the video hyperLinks");
			logger.info("This test is to check whether the videos hyperlink is playable or not");
			logger.info("TestId: checkVideoLink_001...test case started!");
			RPoolPage rPool = new RPoolPage(driver);
			logger.info("Click on rPool");
			rPool.clickRPool();
			logger.info("GO to video frame");
			rPool.switchFrame();
			logger.info("Click on play button");
			rPool.clickPlay();
			logger.info("Test case passed!");
		}
	}

	@Test(dataProvider = "RPoolTest")
	public void toOfferTripProcedure_002(String ExecutionRequired) {
		if (ExecutionRequired.toLowerCase().equals("yes")) {
			extentTest = extent.startTest("toOfferTripProcedure_002");
			logger.info("This test is to view procedure to offer a trip");
			logger.info("TestId: toOfferTripProcedure_002...test case started!");
			RPoolPage rPool = new RPoolPage(driver);
			logger.info("Click on rPool");
			rPool.clickRPool();
			logger.info("Click on corporate");
			rPool.clickCorporate();
			logger.info("Select city to which offer trip");
			rPool.clickCity();
			logger.info("Choose how to offer a trip");
			Assert.assertEquals(rPool.toOfferTrip(), prop.getProperty("tripOffer"));
			logger.info("Test case Passed!!");
		}
	}

}
