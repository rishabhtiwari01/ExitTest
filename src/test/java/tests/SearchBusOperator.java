package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ReadData;
import Utilities.SwtichToPages;
import pages.TopBusOperatorPage;

public class SearchBusOperator extends BaseTest {

	public static Logger logger = Logger.getLogger(SearchBusOperator.class);

	@DataProvider(name = "busByOperator")
	public Object[][] searchDetails() throws Exception {
		Object[][] arrayObject = ReadData.getExcelData(".//TestData//ExitTestData.xlsx", "SearchBus");
		return arrayObject;
	}

	@Test(dataProvider = "busByOperator")
	public void searchBusByOperator(String source, String destination,String date, String ExecutionRequired)
			throws InterruptedException {
		if (ExecutionRequired.toLowerCase().equals("yes")) {
			extentTest = extent.startTest("searchBusByOperator","This test is to search bus via particular operator");
			logger.info("This is Search bus By Operator test");
			TopBusOperatorPage busOperator = new TopBusOperatorPage(driver);
			logger.info("Test Started...");
			busOperator.tapAllOperator();
			logger.info("Click on all operators");
			SwtichToPages.switch_to_next_tab1(driver);
			busOperator.selectEnterPrises();
			logger.info("Select the name cateogory");
			Assert.assertEquals(busOperator.getHeading(), prop.getProperty("busOperatorName"));
			busOperator.enterTravelDetails(source, destination,date);
			logger.info("Enter search details");
			logger.info("click on search details");
			logger.info("Test case Passed!!");
		}
	}

}