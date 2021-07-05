package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ReadData;
import Utilities.SwtichToPages;
import pages.HelpPage;

public class TestHelp extends BaseTest {

	public static Logger logger = Logger.getLogger(TestHelp.class);

	@DataProvider(name = "executionStatus")
	public Object[][] askExecutionStatus() throws Exception {
		Object[][] arrayObject = ReadData.getExcelData(".//TestData//ExitTestData.xlsx", "AskExecutionStatus");
		return arrayObject;
	}

	@Test(dataProvider = "executionStatus")
	public void Help_001(String ExecutionRequired) {
		if (ExecutionRequired.toLowerCase().equals("yes")) {
			extentTest = extent.startTest("Help_001","This test is to check help page");
			logger.info("************** Help_001 **************");
			logger.info("This test is to check the help chatBot");
			logger.info("Click on Help");
			HelpPage help = new HelpPage(driver);
			help.clickHelp();
			SwtichToPages.switch_to_next_tab(driver);
			help.clickCloseIcon();
			logger.info("Close the pop-up...");
			help.clickParentText();
			logger.info("Select the cateogory...");
			help.ask_child_policy();
			logger.info("Looking for child welfare policy");
			help.clickNoThanks();
			logger.info("click no, thanks");
			help.clickAverage();
			logger.info("Give the feedBack Average");
			Assert.assertEquals(help.getFeedback(), prop.getProperty("HelpFeedback"));
			logger.info("Help test_001 Passed!!!");
			SwtichToPages.switch_back(driver);
		}

	}

}
