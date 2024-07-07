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

public class CheckoutStepOnePageTest extends Base
{
	@Test
	public void verifyContinueFunctionalityNavigatesToCheckoutStepTwoPage() throws IOException
	{
		String userName = ExcelUtility.stringDataRead(0, 0, Constants.LOGIN_PAGE_DATA);
		String password = ExcelUtility.stringDataRead(2, 0, Constants.LOGIN_PAGE_DATA);
		String firstName = ExcelUtility.stringDataRead(0, 0, Constants.CHECKOUT_STEPONE_PAGE_DATA);
		String lastName = ExcelUtility.stringDataRead(1, 0, Constants.CHECKOUT_STEPONE_PAGE_DATA);
		String zipCode = ExcelUtility.integerDataRead(2, 0, Constants.CHECKOUT_STEPONE_PAGE_DATA);
		
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		HomePage home_page = loginObj.clickOnLoginButton();
		
		HomePage homeObj = new HomePage(driver);
		homeObj.selectHomePageDropDownSortingPriceLowtoHigh();
		homeObj.addFirstThreeLowPriceProductsToCart();
		CartPage cart_page = homeObj.clickOnCartButton();
		
		CartPage cartObj = new CartPage(driver);
		cartObj.clickOnCheckButton();
        
        CheckoutStepOnePage checkoutStepOneObj = new CheckoutStepOnePage(driver);
        checkoutStepOneObj.enterFirstName(firstName);
        checkoutStepOneObj.enterLastName(lastName);
        checkoutStepOneObj.enterZipCode(zipCode);
        checkoutStepOneObj.clickOnContinueButton();
        
        CheckoutStepTwoPage checkoutStepTwoObj = new CheckoutStepTwoPage(driver);
        String actual_checkoutStepTwo_Verification = checkoutStepTwoObj.getcheckoutStepTwo_Verification();
        String expected_checkoutStepTwo_Verification = ExcelUtility.stringDataRead(2, 0, Constants.CHECKOUT_STEPTWO_PAGE_DATA);
        Assert.assertEquals(actual_checkoutStepTwo_Verification, expected_checkoutStepTwo_Verification, Messages.MISMATCH_CHECKOUT_ONE_VERIFICATION);
        
	}	
		
}
