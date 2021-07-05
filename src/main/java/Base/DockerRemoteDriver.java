package Base;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.collections4.map.StaticBucketMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import tests.BaseTest;

public class DockerRemoteDriver {
	
	public static Logger logger = Logger.getLogger(DockerRemoteDriver.class);

	public static WebDriver setUpRemoteDriver() throws MalformedURLException {

		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = null;
		

		if (BaseTest.prop.getProperty("dockerContainter").equalsIgnoreCase("chrome")) {
			logger.info("Running chrome container");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-gpu");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--no-sandbox");
			options.addArguments("--allow-insecure-localhost");
			options.addArguments("user-agent=Chrome/91.0.4472.124");
			driver = new RemoteWebDriver(url, options);
		} else if (BaseTest.prop.getProperty("dockerContainer").equalsIgnoreCase("fireFox")) {
			logger.info("Running fireFox container...");
			DesiredCapabilities dc = DesiredCapabilities.firefox();
			driver = new RemoteWebDriver(url, dc);
		} else if (BaseTest.prop.getProperty("dockerContainer").equalsIgnoreCase("edge")) {
			logger.info("Running Edge container...");
			DesiredCapabilities dc = DesiredCapabilities.edge();
			driver = new RemoteWebDriver(url, dc);
		} else {
			logger.info("Running chrome container...");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-gpu");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--no-sandbox");
			options.addArguments("--allow-insecure-localhost");
			options.addArguments("user-agent=Chrome/91.0.4472.124");
			driver = new RemoteWebDriver(url, options);
		}
		return driver;
	}

}
