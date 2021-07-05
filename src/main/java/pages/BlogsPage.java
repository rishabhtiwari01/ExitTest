package pages;

import java.util.Set;

import javax.swing.JSeparator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import tests.BaseTest;

public class BlogsPage extends BaseTest {

	WebDriver driver;

	public BlogsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.LINK_TEXT, using = "Blog")
	public WebElement text_blog_link;

	@FindBy(how = How.XPATH, using = "//body/div[@id='page']/div[@id='content']/div[1]/aside[1]/section[1]/form[1]/label[1]/input[1]")
	public WebElement text_searchBox_xpath;

	@FindBy(how = How.XPATH, using = "//a[@class='blogpost-button']")
	public WebElement btn_readMore_xpath;
	
	@FindBy(how = How.XPATH,using = "//a[contains(text(),'redBus Blog')]")
	public WebElement blog_home;

	public void click_blogs() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		text_blog_link.click();
	}

	public void search_blog(String blog_topic) {
		text_searchBox_xpath.sendKeys(blog_topic);
	}
	
	public void read_more() 
	{
		Actions action = new Actions(driver);
		btn_readMore_xpath.click();
		action.sendKeys(Keys.PAGE_UP).build().perform();
		action.sendKeys(Keys.PAGE_UP).build().perform();
	}
	public String home_text() 
	{
		return blog_home.getText();
	}

}
