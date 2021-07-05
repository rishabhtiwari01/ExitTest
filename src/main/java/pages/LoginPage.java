package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//i[@id='i-icon-profile']")
	public WebElement profileIcon_xpath;

	@FindBy(how = How.XPATH, using = "//li[@id='signInLink']")
	public WebElement signIN_xpath;

	@FindBy(how = How.CLASS_NAME, using = "modalIframe")
	public WebElement frame_class;

	@FindBy(how = How.XPATH, using = "//div[@id='g_id_onload']")
	public WebElement googleSignIN_xpath;

	@FindBy(how = How.XPATH, using = "//input[@id='identifierId']")
	public WebElement signInEmail_xpath;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Next')]")
	public WebElement SignInNext_xpath;

	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
	public WebElement signInPassword_xpath;

	@FindBy(how = How.XPATH, using = "//*[@id='passwordNext']/div/button/span")
	public WebElement SignInPasswordNext_xpath;

	@FindBy(how = How.XPATH, using = "/html/body/div[6]/div/div[2]/div/div/div[2]/i")
	public WebElement closeICOn_Xpath;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'My Profile')]")
	public WebElement btn_myprofile_xpath;

	@FindBy(how = How.XPATH, using = "//span[@id='displayname']")
	public WebElement text_profileName_xpath;

	public void clickSignIN() throws InterruptedException {
		profileIcon_xpath.click();
		signIN_xpath.click();
		driver.switchTo().frame(frame_class);
		googleSignIN_xpath.click();
		Thread.sleep(5000);
	}

	public void google_signIN(String email, String password) throws InterruptedException {

		signInEmail_xpath.sendKeys(email);
		SignInNext_xpath.click();
		Thread.sleep(5000);
		signInPassword_xpath.sendKeys(password);
		SignInPasswordNext_xpath.click();

	}

	public void closePopUp() {
		closeICOn_Xpath.click();
		profileIcon_xpath.click();
		btn_myprofile_xpath.click();
	}

	public String getProfileName() {
		return text_profileName_xpath.getText();
	}
}
