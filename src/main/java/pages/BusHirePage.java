package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusHirePage {

	WebDriver driver;

	public BusHirePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "redBus Bus Hire")
	public WebElement busHire;

	@FindBy(how = How.XPATH, using = "//*[@id='app']/div/div[4]/div[1]/div[1]/div[1]")
	public WebElement outstation;

	@FindBy(how = How.ID, using = "oneway")
	public WebElement oneWay;

	@FindBy(how = How.XPATH, using = "//input[@id='locationTextFieldLocal']")
	public WebElement source;

	@FindBy(how = How.XPATH, using = "//input[@id='local_dest_name']")
	public WebElement destination;
	
	@FindBy(how = How.XPATH,using = "//body/ul[@id='ui-id-2']/li[@id='ui-id-19']/div[1]")
	public WebElement selectSrcOutstation_xpath;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Mumbai Central Railway Station Building, Mumbai Ce')]")
	public WebElement selectSourcelocal_xpath;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Gorakhpur Railway Station, Bashratpur, Gorakhpur, ')]")
	public WebElement selectDestination;

	@FindBy(how = How.ID, using = "numberOfPax")
	public WebElement numberofPassangers;

	@FindBy(how = How.XPATH, using = "//button[@id='proceedButtonOutstation']")
	public WebElement proceedButtonOutstation;

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[4]/div[2]/div[1]/div[1]")
	public WebElement local;

	@FindBy(how = How.XPATH, using = "//*[@id=\"LocalLeadGen_Pckage_Tap\"]/label[2]/span[1]")
	public WebElement selectPackage;

	@FindBy(how = How.XPATH, using = "//button[@id='proceedButtonLocal']")
	public WebElement proceedButtonLocal;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Fill Contact Details')]")
	public WebElement headerLabel;

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[4]/div[3]/div[1]/div[1]")
	public WebElement airport;

	@FindBy(how = How.XPATH, using = "//div[@id='AirporLeadGen_SelectCity']")
	public WebElement selectcity;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Chennai')]")
	public WebElement city;

	@FindBy(how = How.XPATH, using = "//input[@id='locationTextFieldLocal']")
	public WebElement airportDestination;

	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Ambattur, Chennai')]")
	public WebElement selectAirportDestination;

	@FindBy(how = How.XPATH, using = "//button[@id='proceedButtonAirport']")
	public WebElement proceedButtonAirport;

	public void clickBusHire() throws InterruptedException {
		busHire.click();
	}

	public void clickOutstation() throws InterruptedException {

		driver.switchTo().frame(driver.findElement(By.tagName("object")));
		outstation.click();
		Thread.sleep(3000);
	}

	public void clickOneWay() {
		oneWay.click();
	}

	public void EnterSourceOutStation(String Src) {
		source.sendKeys(Src);
		selectSrcOutstation_xpath.click();
	}
	
	public void EnterSourcelocal(String Src) {
		source.sendKeys(Src);
		selectSourcelocal_xpath.click();
	}

	public void EnterDestination(String Dest) {
		destination.sendKeys(Dest);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(selectDestination));
		selectDestination.click();
	}

	@FindBy(how = How.XPATH, using = "/html/body/div[5]/div[3]/div/div[1]/div/div[3]/div[2]/div/div[4]/div[2]/button/span[1]/p")
	public WebElement FromWhenDate;
	@FindBy(how = How.XPATH, using = "/html/body/div[5]/div[3]/div/div[1]/div/div[3]/div[2]/div/div[5]/div[7]/button/span[1]/p")
	public WebElement Date;

	@FindBy(how = How.XPATH, using = "//div[@id='OSLeadGen_DoJEnd']")
	public WebElement TillWhen;

	@FindBy(how = How.XPATH, using = "//div[@id='OSLeadGen_DoJStart']")
	public WebElement FromWhen;
	@FindBy(how = How.XPATH, using = "//*[@id=\"LocalLeadGen_DateOfPickup_Click\"]")
	public WebElement StartingTime;

	@FindBy(how = How.XPATH, using = "//div[@id='AirporLeadGen_DoJ']")
	public WebElement AirportDate;

	public void selectFromWhen() throws InterruptedException {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		FromWhen.click();
		js.executeScript("document.getElementsByClassName('MuiIconButton-label')[28].click()");
		js.executeScript("document.getElementsByClassName('MuiButton-label')[7].click()");
	}

	public void selectTillWhen() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		TillWhen.click();
		Date.click();
		js.executeScript("document.getElementsByClassName('MuiButton-label')[7].click()");
	}

	public void enterNumberOfPassangers(String passangers) {
		numberofPassangers.sendKeys(passangers);
	}

	public void clickProceedButtonOutstation() {
		proceedButtonOutstation.click();
	}

	public void clickLocal1() throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.tagName("object")));
		local.click();
		Thread.sleep(3000);
	}

	public void clickLocal() throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.tagName("object")));
		local.click();
		Thread.sleep(3000);
	}

	public void clickSelectPackage() {
		selectPackage.click();
	}

	public void startingDateLocal() {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"document.getElementsByClassName('MuiInputBase-input MuiInput-input')[0].removeAttribute(\"readonly\")");
		js.executeScript("document.getElementsByClassName('MuiInputBase-input MuiInput-input')[0].click()");
		js.executeScript("document.getElementsByClassName('MuiIconButton-label')[1].click()");
		js.executeScript("document.getElementsByClassName('MuiIconButton-label')[28].click()");
		js.executeScript("document.getElementsByClassName('MuiButton-label')[7].click()");
	}

	public void clickProceedButtonLocal() {
		proceedButtonLocal.click();
	}

	public String getHeaderLabel() {
		return headerLabel.getText();
	}

	public void clickAirport() throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.tagName("object")));
		airport.click();
		Thread.sleep(3000);
	}

	public void selectCity() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(selectcity));
		selectcity.click();
		city.click();
	}

	public void enterAirportDestination(String destination) {
		airportDestination.sendKeys(destination);
		selectAirportDestination.click();
	}

	public void dateAirport() {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(AirportDate));
		AirportDate.click();
		Date.click();
		js.executeScript("document.getElementsByClassName('MuiButton-label')[7].click()");
	}

	public void clickProceedButtonAirport() {
		proceedButtonAirport.click();
	}
}