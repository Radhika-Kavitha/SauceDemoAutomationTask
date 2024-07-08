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
 * Test class to verify functionality on Checkout Step One Page.
 */
public class CheckoutStepOnePageTest extends Base
{
	/**
     * Test to verify that the continue functionality navigates to Checkout Step Two Page.
     * @throws IOException            if an I/O exception occurs
     * @throws InterruptedException   if the thread is interrupted during a wait
     */
	@Test(priority = 9, groups = {"Sanity", "Regression", "Smoke"})
	public void verifyContinueFunctionalityNavigatesToCheckoutStepTwoPage() throws IOException, InterruptedException
	{
		//Read test data from Excel
		String userName = ExcelUtility.stringDataRead(1, 0, Constants.LOGIN_PAGE_DATA);
		String password = ExcelUtility.stringDataRead(2, 0, Constants.LOGIN_PAGE_DATA);
		String firstName = ExcelUtility.stringDataRead(0, 0, Constants.CHECKOUT_STEPONE_PAGE_DATA);
		String lastName = ExcelUtility.stringDataRead(1, 0, Constants.CHECKOUT_STEPONE_PAGE_DATA);
		String zipCode = ExcelUtility.integerDataRead(2, 0, Constants.CHECKOUT_STEPONE_PAGE_DATA);
		
		//Perform login
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		HomePage home_page = loginObj.clickOnLoginButton();
		
		//Navigate to Home Page and perform actions
		HomePage homeObj = new HomePage(driver);
		homeObj.verifySortingByPriceLowToHigh();
		homeObj.addFirstThreeLowPriceProductsToCart();
		CartPage cart_page = homeObj.clickOnCartButton();
		
		//Navigate to Cart Page and proceed to Checkout Step One Page
		CartPage cartObj = new CartPage(driver);
		cartObj.clickOnCheckButton();
        
		//Fill out Checkout Step One details
        CheckoutStepOnePage checkoutStepOneObj = new CheckoutStepOnePage(driver);
        checkoutStepOneObj.enterFirstName(firstName);
        checkoutStepOneObj.enterLastName(lastName);
        checkoutStepOneObj.enterZipCode(zipCode);
        checkoutStepOneObj.clickOnContinueButton();
        
        //Verify navigation to Checkout Step Two Page
        CheckoutStepTwoPage checkoutStepTwoObj = new CheckoutStepTwoPage(driver);
        String actual_checkoutStepTwo_Verification = checkoutStepTwoObj.getcheckoutStepTwo_Verification();
        String expected_checkoutStepTwo_Verification = ExcelUtility.stringDataRead(2, 0, Constants.CHECKOUT_STEPTWO_PAGE_DATA);
        Assert.assertEquals(actual_checkoutStepTwo_Verification, expected_checkoutStepTwo_Verification, Messages.MISMATCH_CHECKOUT_ONE_VERIFICATION);
        
	}	
		
}
