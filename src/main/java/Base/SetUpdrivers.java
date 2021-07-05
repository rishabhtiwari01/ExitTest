package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import tests.BaseTest;

public class SetUpdrivers {

	static WebDriver driver = null;

	public static WebDriver setUp() {

		if (BaseTest.prop.getProperty("browserName").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			boolean isHeadlessMode = Boolean.parseBoolean(BaseTest.prop.getProperty("headless"));
			if (isHeadlessMode) {
//	            To open Chrome Driver in Headless mode
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920,1080");
				options.addArguments("user-agent=whatever you want");
				driver = new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver = new ChromeDriver(options);
			} else {
				driver = new ChromeDriver(); 
				}
		} else if (BaseTest.prop.getProperty("browserName").equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.edge.driver", ".\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver(); // To open Edge Driver
		} else if (BaseTest.prop.getProperty("browserName").equalsIgnoreCase("gecko")) {

			System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver(); // To open FireFox Driver
		}

		driver.manage().window().maximize();
		BaseTest.logger.info("Setting up chrome browser....");
//	    Implicit Wait
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(BaseTest.prop.getProperty("implicitWaitTimeout")),
				TimeUnit.SECONDS);

		return driver;
	}

}
