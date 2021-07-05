package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ReadData;
import Utilities.SwtichToPages;
import pages.BlogsPage;

public class ReadBlogTest extends BaseTest {
	public static Logger logger = Logger.getLogger(ReadBlogTest.class);

	@DataProvider(name = "ReadBlog001")
	public Object[][] blogData() throws Exception {
		Object[][] arrayObject = ReadData.getExcelData(".//TestData//ExitTestData.xlsx", "ReadBlog");
		return arrayObject;
	}

	@Test(dataProvider = "ReadBlog001")
	public void readBlog(String SearchBlog, String ExecutionRequired) throws InterruptedException {
		if (ExecutionRequired.toLowerCase().equals("yes")) {
			extentTest = extent.startTest("readBlog","This test is to check the Blog page");
			logger.info("This is the read blog test");
			BlogsPage blog = new BlogsPage(driver);
			logger.info("click on the blog link text");
			blog.click_blogs();
			SwtichToPages.switch_to_next_tab(driver);
			logger.info("search for a blog topic to read");
			blog.search_blog(SearchBlog);
			blog.read_more();
			Thread.sleep(5000);
			logger.info("Reading blogs!!!!!");
			String title = blog.home_text();
			Assert.assertEquals(prop.getProperty("BlogActual"), blog.home_text());
			logger.info("Test case Passed");
			SwtichToPages.switch_back(driver);
		}
	}

}
