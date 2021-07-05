package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ReadData;
import pages.BusHirePage;

public class BusHireTest extends BaseTest {
	
	@DataProvider(name = "outStationBusHireTestData")
	public Object[][] outstationTestData() throws Exception {
		Object[][] arrayObject = ReadData.getExcelData(".//TestData//ExitTestData.xlsx", "outstation");
		return arrayObject;
	}

	public static Logger log = Logger.getLogger(BusHireTest.class);

	@Test(dataProvider = "outStationBusHireTestData")
	public void outStation_001(String Source,String Destination,String passenger,String ExecutionRequired) throws InterruptedException {
		if(ExecutionRequired.toLowerCase().equals("yes")) {
			extentTest = extent.startTest("outStation_001","This test is to check the functionality of outStation in BusHire");
			BusHirePage busHire = new BusHirePage(driver);
			log.info("TestId: outStation_001...test case started");
			BusHirePage bus = new BusHirePage(driver);
			log.info("Click on Bus Hire link");
			bus.clickBusHire();
			log.info("Select outstation");
			bus.clickOutstation();
			log.info("Click on One Way Option");
			bus.clickOneWay();
			log.info("Entering source location");
			bus.EnterSourceOutStation(Source);
			log.info("Entering destination location");
			bus.EnterDestination(Destination);
			log.info("Select date and time");
			bus.selectFromWhen();
			bus.selectTillWhen();
			log.info("Enter number of passangers");
			bus.enterNumberOfPassangers(passenger);
			log.info("Click on proceed button");
			bus.clickProceedButtonOutstation();
			log.info("Test case Passed!!");
		}

	}

	@DataProvider(name = "localBusHireTestData")
	public Object[][] localTestData() throws Exception {
		Object[][] arrayObject = ReadData.getExcelData(".//TestData//ExitTestData.xlsx", "airport");
		return arrayObject;
	}
	
    @Test(dataProvider = "airportBusHireTestData")
    public void busHireLocal_002(String Source, String Passenger,String ExecutionRequired) throws InterruptedException {

        if (ExecutionRequired.toLowerCase().equals("yes")) {
            extentTest = extent.startTest("busHireLocal_002","This test is to check the local in busHire section");
            log.info("TestId: busHireLocal_002...test started");
            BusHirePage bus = new BusHirePage(driver);
            log.info("Click on Bus Hire");
            bus.clickBusHire();
            log.info("Select Local...");
            bus.clickLocal();
            log.info("Enter on source location");
            bus.EnterSourcelocal(Source);
            log.info("Select a package");
            bus.clickSelectPackage();
            log.info("Enter starting date and time");
            bus.startingDateLocal();
            log.info("Enter number of passangers");
            bus.enterNumberOfPassangers(Passenger);
            log.info("Click on proceed button");
            bus.clickProceedButtonLocal();
            Assert.assertEquals(bus.getHeaderLabel(), "Fill Contact Details");
            log.info("Test case passed!!");
        }
    }
    
    @DataProvider(name = "airportBusHireTestData")
	public Object[][] airportTestData() throws Exception {
		Object[][] arrayObject = ReadData.getExcelData(".//TestData//ExitTestData.xlsx", "airport");
		return arrayObject;
	}
    
    @Test(dataProvider = "airportBusHireTestData")
    public void busHireAirport_003(String Destination, String Passanger,String ExecutionRequired)
            throws InterruptedException {

        if (ExecutionRequired.toLowerCase().equals("yes")) {
            extentTest = extent.startTest("busHireAirport_003","Bus Hire for Airport scenario Test");
            log.info("TestId: busHireAirport_003...test case started");
            BusHirePage bus = new BusHirePage(driver);
            log.info("Click on Bus Hire link");
            bus.clickBusHire();
            log.info("Select Airport...");
            bus.clickAirport();
            log.info("Select City");
            bus.selectCity();
            log.info("Enter airport to destination");
            bus.enterAirportDestination(Destination);
            log.info("Select date and time");
            Thread.sleep(2000);
            bus.dateAirport();
            log.info("Enter number of passangers");
            bus.enterNumberOfPassangers(Passanger);
            log.info("Click on proceed button");
            bus.clickProceedButtonAirport();
            Assert.assertEquals(bus.getHeaderLabel(), "Fill Contact Details");
            log.info("Test case passed!!");
        } 
    }

}
