package pages.custombdd.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cucumber.helper.UtilClass;

public class HomePage extends UtilClass {
	
	private static Logger Log = Logger.getLogger(HomePage.class);
	private WebDriver driver;
	private WebDriverWait wait;
	
	/*
	 * 	WebElement For Amazon - Home Page
	 */
	
	@FindBy(xpath = "//a[@id='nav-logo-sprites']")
	private WebElement amazonHomeButton;
	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement txtSearchFieldTextBox;
	
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	private WebElement btnSearch;

	@FindBy(xpath = "(//a[contains(@href,'Unit-Testing')]//span[@class='a-price-whole'])[1]")
	private WebElement firstResultBookPrice;
	
	@FindBy(xpath = "(//h2//a/span)[1]")
	private WebElement lnkFirstSearchResult;
	
	@FindBy(xpath = "(//div[contains(@id,'new')]//span[contains(@id,'rice')])[1]")
	private WebElement qaBookPrice;
	
	@FindBy(id = "add-to-cart-button")
	private WebElement btnAddToCart;	
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	    PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.titleContains("Amazon"));
	}
	
	/*
	 *   Methods for This Page
	 */
	
	public boolean verifyPageLoad() {
		wait.until(ExpectedConditions.visibilityOf(amazonHomeButton));
		boolean result = amazonHomeButton.isDisplayed();
		Log.info("Amazon Home Page Loaded Successfully");
		return result;
	}
	
	public void setSearchText(String input) throws InterruptedException {
		Log.info("Sendig Text To be Searched in Amazon Search Field :  " + input);
		setText(driver, txtSearchFieldTextBox, input);
		clickElement(driver, btnSearch);   
	}
	
	public boolean verifyBookPriceFromFirstSearchResult(String bookPrice) throws InterruptedException {
		boolean result = false;
		wait.until(ExpectedConditions.visibilityOf(lnkFirstSearchResult));
		String getBookPrice = firstResultBookPrice.getText().trim();
		Log.info("Book Price from First Result :  " + getBookPrice);
		if(getBookPrice.contains(bookPrice)) {
			return result=true;
		}
		return result;
	}
	
	public void clickFirstResultOfSearch() {
		Log.info("Clicking First Link of Search Result");
		clickElement(driver, lnkFirstSearchResult);
	}
	
	public boolean verifyBookPriceBeforeAddToCart(String bookPrice) throws InterruptedException {
		boolean result = false;
		wait.until(ExpectedConditions.visibilityOf(qaBookPrice));
		String getBookPrice = qaBookPrice.getText().trim();
		Log.info("Book Price from First Result :  " + getBookPrice);
		if(getBookPrice.contains(bookPrice)) {
			return result=true;
		}
		return result;
	}
	
	public void clickAddToCartBtn() {
		Log.info("Clicking Add To Cart Button");
		clickElement(driver, btnAddToCart);
	}
	
	
}
