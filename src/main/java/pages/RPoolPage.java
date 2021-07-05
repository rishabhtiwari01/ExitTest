package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RPoolPage {

	WebDriver driver;

	public RPoolPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[@id='cars']")
	public WebElement rPool;

	@FindBy(how = How.XPATH, using = "//div[@class='youTubeVideo']")
	public WebElement youtube;

	@FindBy(how = How.XPATH, using = "//*[@id=\"movie_player\"]/div[4]/button")
	WebElement playVideo;
	
	@FindBy(how = How.XPATH,using = "//a[contains(text(),'Corporate+')]")
	public WebElement btn_coporate_xpath;
	
	@FindBy(how = How.XPATH,using = "//body/div[@id='reactContentMount']/div[1]/div[1]/div[12]/div[2]/ul[1]/li[1]/a[1]")
	public WebElement text_bangalore_xpath; 
	
	@FindBy(how = How.XPATH,using = "//*[@id=\"reactContentMount\"]/div/div/div[9]/div[3]/div[1]/span[1]")
	public WebElement text_offerTrip_xpath;
	
	@FindBy(how = How.XPATH,using = "//h3[contains(text(),'How do I offer Trips?')]")
	public WebElement text_howToOffer_xpath;

	public void clickRPool() {
		rPool.click();
	}

	public void switchFrame() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"aboutRpool\"]/div/div[1]/div[2]/div/div/iframe"));
		jse.executeScript("arguments[0].scrollIntoView();", frame);
		driver.switchTo().frame(frame);
	}

	public void clickPlay() {
		(new WebDriverWait(driver, 20)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"movie_player\"]/div[4]/button")));
		playVideo.click();
	}
	
	public void clickCorporate() {
		btn_coporate_xpath.click();
	}
	public void clickCity() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		text_bangalore_xpath.click();
		text_offerTrip_xpath.click();
	}
	
	public String toOfferTrip() {
		return text_howToOffer_xpath.getText();
	}

}
