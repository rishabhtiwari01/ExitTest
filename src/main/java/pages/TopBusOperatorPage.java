package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopBusOperatorPage {
	
	WebDriver driver;
	public TopBusOperatorPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH,using = "//a[contains(text(),'All Operators >')]")
	public WebElement text_allOperator_xpath;
	
	@FindBy(how = How.LINK_TEXT,using = "D")
	public WebElement text_operator_DCateogory_linkText;
	
	@FindBy(how = How.LINK_TEXT,using = "Dadi Maa Travels")
	public WebElement text_selectEnterprise_linkText;
	
	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Travels')]")
	public WebElement heading_enterPriseName_xpath;
	
	@FindBy(how = How.XPATH,using = "//input[@id='txtSource']")
	public WebElement input_enterSource_xpath;
	
	@FindBy(how = How.XPATH,using = "//*[@id=\"C120_suggestion-wrap\"]/li[1]/strong")
	public WebElement select_sourceLocation_xpath;
	
	@FindBy(how = How.XPATH,using = "//input[@id='txtDestination']")
	public WebElement input_enterDestination_xpath;
	
	@FindBy(how = How.XPATH,using = "//*[@id=\"C120_suggestion-wrap\"]/li[3]")
	public WebElement list_selectDestination_xpath;
	
	@FindBy(how = How.ID, using = "txtOnwardCalendar")
	public WebElement data_id;
		
	@FindBy(how = How.XPATH, using = "//*[@id=\"rb-calmiddle\"]/ul[2]/li[30]/span")
	public WebElement select_date_xpath;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[1]/div[3]/button")
	public WebElement btn_search_xpath;
	
	public void tapAllOperator() 
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		text_allOperator_xpath.click();
	}
	public void selectEnterPrises() 
	{
		text_operator_DCateogory_linkText.click();
		text_selectEnterprise_linkText.click();
	}
	
	public String getHeading() 
	{
		return heading_enterPriseName_xpath.getText();
	}
	
	public void enterTravelDetails(String source,String destination,String date)
	{
		input_enterSource_xpath.sendKeys(source);
		select_sourceLocation_xpath.click();
		input_enterDestination_xpath.sendKeys(destination);
		list_selectDestination_xpath.click();
		data_id.sendKeys(date);
		btn_search_xpath.click();
		
	}
	

}
