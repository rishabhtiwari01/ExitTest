package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ReadData;
import Utilities.SwtichToPages;
import pages.HomePage;

public class HomePageTest extends BaseTest {

	public static Logger logger = Logger.getLogger(HomePageTest.class);

	@DataProvider(name = "homesearchBus")
	public Object[][] validSearchBusData() throws Exception {
		Object[][] arrayObject = ReadData.getExcelData(".//TestData//ExitTestData.xlsx", "HomeSearchBus");
		return arrayObject;
	}

	@Test(dataProvider = "homesearchBus")
	public void validSearch_001(String Source, String Destination, String Month, String Year, String Date,
			String ExecutionRequired) throws Throwable {

		if (ExecutionRequired.toLowerCase().equals("yes")) {
			extentTest = extent.startTest("validSearch_001","This test is to search bus on homePage");
			logger.info("This valid seach bus home page test");
			logger.info("TestId: validSearch_001....test case started");
			HomePage home = new HomePage(driver);
			logger.info("Enter soruce..");
			logger.info("Enter destination");
			home.fillSourceDestination(Source, Destination);
			logger.info("select date of journey");
			int m = Integer.parseInt(Month);
			int y = Integer.parseInt(Year);
			home.setDate(m, y, Date);
			logger.info("Click on search Bus");
			home.search_bus();
			logger.info("View Buses....");
			Assert.assertEquals(home.getBusText(), prop.getProperty("searchBusNxt"));
			logger.info("Test case Passed");
		}
	}

	@DataProvider(name = "inValidhomesearchBus")
	public Object[][] invalidSearchBusData() throws Exception {
		Object[][] arrayObject = ReadData.getExcelData(".//TestData//ExitTestData.xlsx", "InvalidHomesearchBus");
		return arrayObject;
	}

	@Test(dataProvider = "inValidhomesearchBus")
	public void inValidSearch_002(String Source, String Destination, String Month, String Year, String Date,
			String ExecutionRequired) {
		if (ExecutionRequired.toLowerCase().equals("yes")) {
			logger.info("This is invalid bus search");
			logger.info("TestId: inValidSearch_002 test case started...");
			extentTest = extent.startTest("inValidSearch_001","This test is to check whether the bus will search for invalid details");
			HomePage home = new HomePage(driver);
			logger.info("Enter soruce..");
			logger.info("Enter invalid destination");
			home.fillSourceDestination(Source, Destination);
			logger.info("select date of journey");
			int m = Integer.parseInt(Month);
			int y = Integer.parseInt(Year);
			home.setDate(m, y, Date);
			logger.info("Click on search Bus");
			home.search_bus();
			logger.info("View Buses....");
			Assert.assertEquals(home.getBusText(), prop.getProperty("searchBusNxt"));
			logger.info("Test case Passed");
		}
	}

	@Test(dataProvider = "homesearchBus")
	public void swapCities_003(String Source, String Destination, String Month, String Year, String Date,
			String ExecutionRequired) {
		if (ExecutionRequired.toLowerCase().equals("yes")) {
			logger.info("This test to check whether the toggle button is working fine or not");
			logger.info("TestId: swapCities_003...test case started");
			extentTest = extent.startTest("swapCities_003","This test is to check toggle present in Bus search in homePage");
			HomePage home = new HomePage(driver);
			logger.info("Enter soruce..");
			logger.info("Enter destination");
			home.fillSourceDestination(Source, Destination);
			logger.info("select date of journey");
			int m = Integer.parseInt(Month);
			int y = Integer.parseInt(Year);
			home.setDate(m, y, Date);
			logger.info("Click on toggle button");
			home.toggleCity();
			home.search_bus();
			Assert.assertEquals(home.swappedCityText(), prop.getProperty("togglecity"));
			logger.info("Check whether cities swapped successfully");
			logger.info("Test case passed!!");

		}
	}

	@DataProvider(name = "sendMeTheLink")
	public Object[][] sendAppLink() throws Exception {
		Object[][] arrayObject = ReadData.getExcelData(".//TestData//ExitTestData.xlsx", "sendmeLink");
		return arrayObject;
	}

	@Test(dataProvider = "sendMeTheLink")
	public void sendAppInviteLink_004(String Mobile, String ExecutionRequired) throws InterruptedException {
		if (ExecutionRequired.toLowerCase().equals("yes")) {
			logger.info("This test is to send the RedBus application link to a mobile number");
			logger.info("TestId: sendAppInviteLink_004..test case started");
			extentTest = extent.startTest("sendAppInviteLink_004","This test is to send invite to other via mobile");
			HomePage home = new HomePage(driver);
			Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("baseURL"));
			logger.info("Enter mobile number");
			home.enterNumber(Mobile);
			logger.info("Click on send link button");
			home.sendMsg();
			logger.info("Test case Passed!!");
		}
	}

	@DataProvider(name = "contactTest")
	public Object[][] contactTestData() throws Exception {
		Object[][] arrayObject = ReadData.getExcelData(".//TestData//ExitTestData.xlsx", "AskExecutionStatus");
		return arrayObject;
	}

	@Test(dataProvider = "contactTest")
	public void contactUs_005(String ExecutionRequired) {
		if (ExecutionRequired.toLowerCase().equals("yes")) {
			extentTest = extent.startTest("contactUs_005","This test is to check the contact info present in contactUs");
			logger.info("This test is to validate the contact detials");
			logger.info("TestId: contactUs_005...test case started");
			Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("baseURL"));
			HomePage home = new HomePage(driver);
			home.clickContacts();
			SwtichToPages.switch_to_next_tab1(driver);
			Assert.assertEquals(home.getContact(), prop.getProperty("contactDetails"));
			logger.info("Test case Passed!!");
		}

	}
	
	@Test(dataProvider = "homesearchBus")
	public void modifyBusSearch_006(String Source, String Destination, String Month, String Year, String Date,
			String ExecutionRequired) {
		if(ExecutionRequired.toLowerCase().equals("yes")) {
			extentTest = extent.startTest("modifyBusSearch_006","This test to check whether we modify search details or not");
			logger.info("TestId: modifyBusSearch_006...test case started");
			HomePage home = new HomePage(driver);
			logger.info("Enter soruce..");
			logger.info("Enter destination");
			home.fillSourceDestination(Source, Destination);
			logger.info("select date of journey");
			int m = Integer.parseInt(Month);
			int y = Integer.parseInt(Year);
			home.setDate(m, y, Date);
			logger.info("Click on search Bus");
			home.search_bus();
			logger.info("Click on modify");
			logger.info("modify search details");
			logger.info("Again click on search");
			home.modifySearchBus();
			Assert.assertEquals(home.getTextModify(), prop.getProperty("modifySearch"));
		}
		
	}

}
