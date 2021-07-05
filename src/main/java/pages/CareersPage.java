package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareersPage {
	
	WebDriver driver;

	public CareersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.LINK_TEXT,using = "Careers")
	public WebElement text_careers_linkText;
	
	@FindBy(how = How.XPATH,using = "//a[@id='scroll-aHref-3']")
	public WebElement btn_jobs_xpath;
	
	@FindBy(how = How.XPATH,using = "//body/div[@id='reactContentMount']/div[1]/div[1]/div[9]/ul[1]/a[3]/img[1]")
	public WebElement img_instahyre_xpath;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"apply-btn-sidebar\"]/div/a")
	public WebElement btn_aaplyForRedbus_xpath;
	
	@FindBy(how = How.XPATH,using = "//input[@id='name']")
	public WebElement input_enterName_xpath;
	
	@FindBy(how = How.XPATH,using = "//input[@id='email']")
	public WebElement input_enterEmail_xpath;
	
	@FindBy(how = How.XPATH,using = "//input[@id='email']")
	public WebElement input_enterPassword_xpath;
	
	@FindBy(how = How.XPATH,using = "//button[@id='candidate-register-btn']")
	public WebElement btn_getStarted_xpath;
	
	public void clickCarrers() 
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		text_careers_linkText.click();
	}
	
	public void viwJobPartners() 
	{
		btn_jobs_xpath.click();
	}
	
	public void openInstahyre() 
	{
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(img_instahyre_xpath));
		img_instahyre_xpath.click();
	}
	
	public void applyForJob() 
	{
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(btn_aaplyForRedbus_xpath));
		btn_aaplyForRedbus_xpath.click();	
	}
	
	public void fill_job_details(String name,String email,String password) 
	{
		input_enterName_xpath.sendKeys(name);
		input_enterEmail_xpath.sendKeys(email);
		input_enterPassword_xpath.sendKeys(password);
		btn_getStarted_xpath.click();
	}

}
