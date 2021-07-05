package pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public List<String> monthList = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "July", "Aug", "Sept",
			"Oct", "Nov", "Dec");
	public Boolean dateNotFound;

	@FindBy(how = How.XPATH, using = "//input[@id='src']")
	public WebElement input_fromsource_xpath;

	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div/div[1]/div/ul/li[1]")
	public WebElement select_source_xpath;

	@FindBy(how = How.XPATH, using = "//input[@id='dest']")
	public WebElement input_toDestination_xpath;

	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div/div[2]/div/ul/li[1]")
	public WebElement select_destination_xpath;

	@FindBy(how = How.XPATH, using = "//input[@id='onward_cal']")
	public WebElement open_calendar_xpath;

	@FindBy(how = How.XPATH, using = "//*[@id='search_btn']")
	public WebElement search_xpath;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'All bus ratings include safety as a major factor')]")
	public WebElement nextpageText_xpath;

	@FindBy(how = How.XPATH, using = "//span[@id='togglebtn']")
	public WebElement btn_toggle_xpath;

	@FindBy(how = How.XPATH, using = "//*[@id=\\\"fixer\\\"]/div/div/div[1]/h2")
	public WebElement toggledCity_xpath;
	
	@FindBy(how = How.XPATH,using = "//div[contains(text(),'Modify')]")
	public WebElement btn_modify_xpath;
	
	@FindBy(how = How.XPATH,using = "//span[@id='switchButton']")
	public WebElement btn_switch_xpath;
	
	@FindBy(how = How.XPATH,using = "//*[@id=\"fixer\"]/section/div/div[4]/button")
	public WebElement btn_searchModify_xpath;
	
	@FindBy(how = How.XPATH,using = "//h1[contains(text(),'Meerut to Gaziyabad Bus')]")
	public WebElement text_modifysearch_xpath;

	@FindBy(how = How.XPATH, using = "//input[@id='smsTXTBOX']")
	public WebElement input_sendSms_xpath;

	@FindBy(how = How.XPATH, using = "//input[@id='sendLinkButton']")
	public WebElement btn_sendSms_xpath;
	
	@FindBy(how = How.LINK_TEXT,using = "Contact Us")
	public WebElement contact_linkText;
	
	@FindBy(how = How.XPATH,using = "//tbody/tr[2]/td[1]/div[1]/div[1]/div[1]/div[3]/ul[1]/li[6]")
	public WebElement contactDetails_xpath;

	public void fillSourceDestination(String source, String destination) {
		input_fromsource_xpath.sendKeys(source);
		select_source_xpath.click();
		input_toDestination_xpath.sendKeys(destination);
		select_destination_xpath.click();
	}

	public void setDate(int month, int year, String date) {
		open_calendar_xpath.click();
		dateNotFound = true;
		while (dateNotFound) {
			WebElement monthYearEle = driver
					.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']//table//td[@class='monthTitle']"));
			String monthYear = monthYearEle.getAttribute("innerHTML");

			String[] s = monthYear.split(" ");
			String calMonth = s[0];
			int calYear = Integer.parseInt(s[1]);

			// If current selected month and year are same as expected month and year then
			// go Inside this condition.
			if (monthList.indexOf(calMonth) + 1 == month && year == calYear) {
				selectDate(date);
				dateNotFound = false;
			}

			// If current selected month and year are less than expected month and year then
			// go Inside this condition
			else if (monthList.indexOf(calMonth) + 1 < month && year == calYear || year > calYear) {
				open_calendar_xpath
						.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[3]/button"))
						.click();
			}

		}
	}

	public void selectDate(String date) {
		WebElement datePicker = driver.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']"));
		List<WebElement> dates = datePicker.findElements(By.tagName("td"));
		for (WebElement temp : dates) {
			if (temp.getText().equals(date)) {
				temp.click();
				break;
			}
		}
	}

	public void search_bus() {
		search_xpath.click();
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(nextpageText_xpath));
	}

	public String getBusText() {
		return nextpageText_xpath.getText();
	}

	public void toggleCity() {
		btn_toggle_xpath.click();
	}

	public String swappedCityText() {
		return toggledCity_xpath.getText();
	}
	
	public void modifySearchBus() {
		btn_modify_xpath.click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(btn_switch_xpath));
		btn_switch_xpath.click();
		btn_searchModify_xpath.click();
	}
	
	public String getTextModify() {
		return text_modifysearch_xpath.getText();
	}

	public void enterNumber(String mobile) {
		input_sendSms_xpath.sendKeys(mobile);
	}

	public void sendMsg() {
		btn_sendSms_xpath.click();
	}
	
	public void clickContacts() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		contact_linkText.click();
	}
	
	public String getContact() {
		return contactDetails_xpath.getText();
	}
}
