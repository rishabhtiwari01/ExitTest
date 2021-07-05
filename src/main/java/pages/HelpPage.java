package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelpPage {

	WebDriver driver;

	public HelpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Help')]")
	public WebElement btn_help_xpath;

	@FindBy(how = How.XPATH, using = "//i[@class='icon-close']")
	public WebElement icon_closeIcon_xpath;

	@FindBy(how = How.CLASS_NAME, using = "parentText")
	public WebElement text_parentText_class;

	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Child fare policy')]")
	public WebElement text_askChildWelfarePolicy_xpath;

	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'No, thanks')]")
	public WebElement selectText_noThanks_xpath;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'😐 Average')]")
	public WebElement selectText_good_xpath;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'It has been a pleasure to help you. Please rate yo')]")
	public WebElement text_feedback_xpath;

	public void clickHelp() {
		btn_help_xpath.click();
	}

	public void clickCloseIcon() {
		icon_closeIcon_xpath.click();
		driver.switchTo().frame(0);
	}

	public void clickParentText() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(text_parentText_class));
		text_parentText_class.click();
	}

	public void ask_child_policy() {
		text_askChildWelfarePolicy_xpath.click();
	}

	public void clickNoThanks() {
		selectText_noThanks_xpath.click();
	}

	public void clickAverage() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(selectText_good_xpath));
		selectText_good_xpath.click();
	}

	public String getFeedback() {
		return text_feedback_xpath.getText();
	}

}
