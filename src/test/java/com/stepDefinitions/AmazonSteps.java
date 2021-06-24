package com.stepDefinitions;

import pages.custombdd.pages.WebDriverManager;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.custombdd.pages.HomePage;
import pages.custombdd.pages.CartPage;

public class AmazonSteps {

	public WebDriver driver = getDriver();
	public HomePage homePage;
	public CartPage cartPage;

	public WebDriver getDriver() {
		return WebDriverManager.driver;
	}
	
	@Given("I Select Chrome Browser To Launch {string} For Test Execution")
	public void i_login_to_application_with_in_browser(String url) throws Throwable {
		driver.get(url);
		homePage = new HomePage(driver);
	}
	
	@Then("I Verify Amazon Home Page is Loaded Successfully")
	public void verifyBankHomePageLoad() throws Throwable {
		homePage = new HomePage(driver);
		boolean result = homePage.verifyPageLoad();
		Assert.assertTrue("Home Page is Loaded Properly.", result);
	}
	
	@When("I Set Bookname as {string} in Search Text Field")
	public void clickFlightLik(String bookName) throws Throwable {
		homePage = new HomePage(driver);
		homePage.setSearchText(bookName);
	}
	
	@Then("I Verify Price of Book as {string} from the Search Result")
	public void verifyBookPrice(String bookPrice) throws Throwable {
		homePage = new HomePage(driver);
		boolean result = homePage.verifyBookPriceFromFirstSearchResult(bookPrice);
		Assert.assertTrue("Book Price is not Correct.", result);
	}
	
	@When("I Select First Option from Result")
	public void clickFirstResultOption() throws Throwable {
		homePage = new HomePage(driver);
		homePage.clickFirstResultOfSearch();
	}
	
	@Then("I Verify Price of Book Price as {string} After Selecting Book from Search Result")
	public void verifyBookPriceAfterSelectingBook(String bookPrice) throws Throwable {
		homePage = new HomePage(driver);
		boolean result = homePage.verifyBookPriceBeforeAddToCart(bookPrice);
		Assert.assertTrue("Book Price is not Correct.", result);
	}
	
	@When("I Click On Add To Cart")
	public void clickAddToCartBtn() throws Throwable {
		homePage = new HomePage(driver);
		homePage.clickAddToCartBtn();
	}
	
	@Then("I Verify Price of Book Price as {string} Before Proceed To Checkout in Cart Page")
	public void verifyBookPriceInCartPage(String bookPrice) throws Throwable {
		cartPage = new CartPage(driver);
		boolean result = cartPage.verifyBookPriceFromCartPage(bookPrice);
		Assert.assertTrue("Book Price is not Correct.", result);
	}
	
	
	
}