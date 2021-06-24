package pages.custombdd.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cucumber.helper.UtilClass;

public class CartPage extends UtilClass {
	
	private static Logger Log = Logger.getLogger(CartPage.class);
	private WebDriver driver;
	private WebDriverWait wait;
	
	/*
	 * 	WebElement For Amazon - Home Page
	 */
	
	@FindBy(xpath = "(//span[contains(@class,'a-color-price hlb-price a-inline-block a-text-bold')])[1]")
	private WebElement finalbookPrice;
	
	@FindBy(xpath = "(//a[contains(text(),'Proceed to checkout')])[1]")
	private WebElement btnCheckout;
	

	public CartPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	    PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.titleContains("Amazon"));
	}
	
	/*
	 *   Methods for This Page
	 */
	
	public boolean verifyBookPriceFromCartPage(String bookPrice) throws InterruptedException {
		boolean result = false;
		wait.until(ExpectedConditions.visibilityOf(finalbookPrice));
		String getBookPrice = finalbookPrice.getText().trim();
		Log.info("Book Price from First Result :  " + getBookPrice);
		if(getBookPrice.contains(bookPrice)) {
			return result=true;
		}
		return result;
	}
	
}
