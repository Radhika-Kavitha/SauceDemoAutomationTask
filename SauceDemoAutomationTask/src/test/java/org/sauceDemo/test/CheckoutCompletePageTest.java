package org.sauceDemo.test;

import java.io.IOException;
import org.sauceDemo.automation_core.Base;
import org.sauceDemo.constants.Constants;
import org.sauceDemo.constants.Messages;
import org.sauceDemo.page.CartPage;
import org.sauceDemo.page.CheckoutCompletePage;
import org.sauceDemo.page.CheckoutStepOnePage;
import org.sauceDemo.page.CheckoutStepTwoPage;
import org.sauceDemo.page.HomePage;
import org.sauceDemo.page.LoginPage;
import org.sauceDemo.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class to verify successful completion of checkout process.
 */
public class CheckoutCompletePageTest extends Base
{
	/**
     * Test method to verify successful completion of checkout.
     * @throws IOException            Signals that an I/O exception of some sort has occurred.
     * @throws InterruptedException   Indicates that a thread has been interrupted while waiting.
     */
	@Test(priority = 11, groups = {"Sanity", "Regression", "Smoke"})
	public void verifySuccessfullyCompletetheCheckout() throws IOException, InterruptedException
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
        
        // Actions on Checkout Step Two Page
        CheckoutStepTwoPage checkoutStepTwoObj = new CheckoutStepTwoPage(driver);
        checkoutStepTwoObj.clickOnFinishButton();
        
        // Verification on Checkout Complete Page
        CheckoutCompletePage CheckoutCompletePageObj = new CheckoutCompletePage(driver);
        String actual_CompleteHeaderMessage = CheckoutCompletePageObj.getCompleteHeaderMessage();
        String expected_CompleteHeaderMessage = ExcelUtility.stringDataRead(0, 0, Constants.CHECKOUT_COMPLETE_PAGE_DATA);
        Assert.assertEquals(actual_CompleteHeaderMessage, expected_CompleteHeaderMessage, Messages.MISMATCH_CHECKOUT_FINAL);
        
	}
}
