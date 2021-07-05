package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedCaresDonatePage {

	WebDriver driver;

	public RedCaresDonatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//body/section[@id='rh_main']/div[@id='mBWrapper']/main[1]/div[1]/div[1]/div[1]/div[4]/div[2]/ul[1]/li[3]")
	public WebElement tapdonateBanner_xpath;

	@FindBy(how = How.XPATH, using = "//body/div[@id='reactContentMount']/div[1]/div[2]/div[2]/div[1]/ul[1]/li[2]")
	public WebElement selectAmount_xpath;

	@FindBy(how = How.XPATH, using = "//body/div[@id='reactContentMount']/div[1]/div[2]/div[2]/div[7]/div[1]/span[2]/input[1]")
	public WebElement doniesName_xpath;

	@FindBy(how = How.XPATH, using = "//body/div[@id='reactContentMount']/div[1]/div[2]/div[2]/div[7]/div[2]/span[2]/input[1]")
	public WebElement doneesEmail_xpath;

	@FindBy(how = How.XPATH, using = "//body/div[@id='reactContentMount']/div[1]/div[2]/div[2]/div[7]/div[3]/span[2]/input[1]")
	public WebElement doneesMobile_xpath;

	@FindBy(how = How.XPATH, using = "//body/div[@id='reactContentMount']/div[1]/div[2]/div[2]/div[8]/button[1]")
	public WebElement btn_donateNow_xpath;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Net Banking')]")
	public WebElement select_paymentMode_xpath;

	@FindBy(how = How.XPATH, using = "//body/div[@id='reactContentMount']/div[1]/div[2]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]")
	public WebElement select_bank_xpath;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'PAY NOW')]")
	public WebElement btn_payNow_xpath;
	
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'GIVE YOUR SUPPORT')]")
	public WebElement donatePageHeading_xpath;
	
	@FindBy(how = How.XPATH,using = "/html/body/form/table[2]/tbody/tr/td[1]/table/tbody/tr[1]/td[1]/table[1]/tbody/tr[1]/td")
	public WebElement netBankingLogin_xpath;
	
	public void tapDonateBanner() 
	{
		tapdonateBanner_xpath.click();
	}
	
	public void enterDonateDetails(String name,String email,String mobile) 
	{
		selectAmount_xpath.click();
		doniesName_xpath.sendKeys(name);
		doneesEmail_xpath.sendKeys(email);
		doneesMobile_xpath.sendKeys(mobile);
		btn_donateNow_xpath.click();
	}
	
	public String getDonateHeading() 
	{
		return donatePageHeading_xpath.getText();
	}
	
	public void selectBankOption() 
	{
		select_paymentMode_xpath.click();
		select_bank_xpath.click();
		btn_payNow_xpath.click();
		
	}
	public String netBankingPage() 
	{
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(netBankingLogin_xpath));
		return netBankingLogin_xpath.getText();
	}

}
