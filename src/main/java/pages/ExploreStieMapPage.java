package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ExploreStieMapPage {

	WebDriver driver;

	public ExploreStieMapPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.LINK_TEXT, using = "Sitemap")
	public WebElement text_sitemap_linkText;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/article[2]/div[2]/ul/li[7]/a")
	public WebElement btn_viewMore_xpath;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/article[2]/div[1]/ul/li[17]/a")
	public WebElement btn_upBusService_xpath;

	@FindBy(how = How.XPATH, using = "//*[@id=\"time-btn-30\"]")
	public WebElement btn_bookNow_xpath;

	@FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[4]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[2]/li[31]/span[1]")
	public WebElement select_date_xpath;

	@FindBy(how = How.XPATH, using = "//body/section[@id='rh_main']/div[@id='mBWrapper']/div[@id='root']/div[1]/div[2]/div[2]/div[4]/div[1]/div[2]/ul[1]/div[1]/li[1]/div[1]/div[2]/div[1]")
	public WebElement btn_viewSeats_xpath;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'HIDE SEATS')]")
	public WebElement btn_hideSeats_xpath;

	@FindBy(how = How.XPATH, using = "//body/section[@id='rh_main']/div[@id='mBWrapper']/div[@id='root']/div[1]/div[2]/div[2]/div[4]/div[1]/div[2]/ul[1]/div[1]/li[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]")
	public WebElement busFare_xpath;

	@FindBy(how = How.LINK_TEXT, using = "redBus Singapore")
	public WebElement singaporeBus_linkText;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Agent registration')]")
	public WebElement singa_agentRegister_xpath;

	@FindBy(how = How.XPATH, using = "//body/div[4]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[1]/input[1]")
	public WebElement signa_regiterForFree_xpath;

	@FindBy(how = How.XPATH, using = "//body/div[@id='myModal']/div[1]/div[1]")
	public WebElement signa_registerFrame_xpath;

	@FindBy(how = How.XPATH, using = "//input[@id='name']")
	public WebElement singa_registerName_xpath;

	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	public WebElement singa_registerEmail_xpath;

	@FindBy(how = How.XPATH, using = "//input[@id='mobile']")
	public WebElement singa_registerMobile_xpath;

	@FindBy(how = How.XPATH, using = "//input[@id='location']")
	public WebElement singa_registerLocation_xpath;

	@FindBy(how = How.XPATH, using = "//input[@id='country']")
	public WebElement singa_registerCountry_xpath;

	@FindBy(how = How.XPATH, using = "//body/div[@id='myModal']/div[1]/div[1]/div[2]/form[1]/ul[1]/li[6]/input[1]")
	public WebElement btn_singa_registerSubmit_xpath;

	public void visitSiteMap() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		text_sitemap_linkText.click();
	}

	public void bookTicket() {
		btn_viewMore_xpath.click();
		btn_upBusService_xpath.click();
		btn_bookNow_xpath.click();
		select_date_xpath.click();
	}

	public void viewSeats() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		btn_viewSeats_xpath.click();
		btn_hideSeats_xpath.click();
	}

	public String getBusFare() {
		return busFare_xpath.getText();
	}

	public void singaporeBusService() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		singaporeBus_linkText.click();
	}

	public void clickAgentRegister() {
		singa_agentRegister_xpath.click();
	}

	public void freeRegistration() {
		signa_regiterForFree_xpath.click();
	}

	public void registerAgent(String name, String email, String mobileNo, String location, String country)
			throws InterruptedException {
		singa_registerName_xpath.sendKeys(name);
		singa_registerEmail_xpath.sendKeys(email);
		singa_registerMobile_xpath.sendKeys(mobileNo);
		singa_registerLocation_xpath.sendKeys(location);
		singa_registerCountry_xpath.sendKeys(country);
		btn_singa_registerSubmit_xpath.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}

}
