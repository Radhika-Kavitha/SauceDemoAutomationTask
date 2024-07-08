package org.sauceDemo.test;

import java.io.IOException;
import org.sauceDemo.automation_core.Base;
import org.sauceDemo.constants.Constants;
import org.sauceDemo.constants.Messages;
import org.sauceDemo.page.CartPage;
import org.sauceDemo.page.CheckoutStepOnePage;
import org.sauceDemo.page.CheckoutStepTwoPage;
import org.sauceDemo.page.HomePage;
import org.sauceDemo.page.LoginPage;
import org.sauceDemo.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class to validate Checkout Step Two Page functionality.
 */
public class CheckoutStepTwoPageTest extends Base 
{
	/**
     * Test method to verify the total price of added products in the cart without tax.
     * @throws IOException            Signals that an I/O exception of some sort has occurred.
     * @throws InterruptedException   Indicates that a thread has been interrupted while waiting.
     */
	@Test(priority = 10, groups = {"Sanity", "Regression", "Smoke"})
	public void verifyTotalPriceOfAddedProductintheCartWithoutTax() throws IOException, InterruptedException
	{
		// Reading test data from Excel
		String userName = ExcelUtility.stringDataRead(1, 0, Constants.LOGIN_PAGE_DATA);
		String password = ExcelUtility.stringDataRead(2, 0, Constants.LOGIN_PAGE_DATA);
		String firstName = ExcelUtility.stringDataRead(0, 0, Constants.CHECKOUT_STEPONE_PAGE_DATA);
		String lastName = ExcelUtility.stringDataRead(1, 0, Constants.CHECKOUT_STEPONE_PAGE_DATA);
		String zipCode = ExcelUtility.integerDataRead(2, 0, Constants.CHECKOUT_STEPONE_PAGE_DATA);
		
		 // Login process
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		HomePage home_page = loginObj.clickOnLoginButton();
		
		 // Actions on Home Page
		HomePage homeObj = new HomePage(driver);
		homeObj.verifySortingByPriceLowToHigh();
		homeObj.addFirstThreeLowPriceProductsToCart();
		CartPage cart_page = homeObj.clickOnCartButton();
		
		 // Actions on Cart Page
		CartPage cartObj = new CartPage(driver);
		cartObj.clickOnCheckButton();
        
		// Actions on Checkout Step One Page
        CheckoutStepOnePage checkoutStepOneObj = new CheckoutStepOnePage(driver);
        checkoutStepOneObj.enterFirstName(firstName);
        checkoutStepOneObj.enterLastName(lastName);
        checkoutStepOneObj.enterZipCode(zipCode);
        checkoutStepOneObj.clickOnContinueButton();
        
        // Verification on Checkout Step Two Page
        CheckoutStepTwoPage checkoutStepTwoObj = new CheckoutStepTwoPage(driver);
        String actual_total_rate = checkoutStepTwoObj.getTotalPrice();
        String expected_total_rate = ExcelUtility.stringDataRead(0, 0, Constants.CHECKOUT_STEPTWO_PAGE_DATA);
        Assert.assertEquals(actual_total_rate, expected_total_rate, Messages.MISMAICH_IN_PRICE);
        
	}	
}
