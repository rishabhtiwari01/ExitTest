package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.DockerRemoteDriver;
import Base.SetUpdrivers;
import Utilities.ScreenShots;

public class BaseTest {

	static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	static File file = new File(".\\resources\\config.properties");
	static FileInputStream fis = null;
	public static Properties prop = new Properties();
	public static Logger logger = Logger.getLogger(BaseTest.class);

	static {
		try {
			fis = new FileInputStream(file);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void setExtent() {
		extent = new ExtentReports(".\\Reports\\ExtentReport.html");
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
		extent.close();
	}

	@AfterMethod
	public void attachScreenshot(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = ScreenShots.takeScreenShot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, result.getName() + " test case Passed successfully");
		}
		extent.endTest(extentTest);
	}

	@BeforeMethod
	public static void intializeWebdriver() throws MalformedURLException {
		if (prop.getProperty("runEnvironment").equalsIgnoreCase("Remote")) {
			logger.info("Setting up docker..");
			driver = DockerRemoteDriver.setUpRemoteDriver();
		} else if (prop.getProperty("runEnvironment").equalsIgnoreCase("local")) {
			logger.info("Setting up local machine");
			driver = SetUpdrivers.setUp();
		} else {
			logger.info("Setting up local machine");
			driver = SetUpdrivers.setUp();
		}

	}

	@BeforeMethod
	public static void openBrowser() {
		logger.info("Fetching Url...");
		driver.get(prop.getProperty("baseURL"));
	}

	@AfterMethod
	public static void closeBrowser() {
		logger.info("Close browser..");
		driver.quit();
	}
}