package org.sauceDemo.test;

import java.io.IOException;
import java.util.List;

import org.sauceDemo.automation_core.Base;
import org.sauceDemo.constants.Constants;
import org.sauceDemo.constants.Messages;
import org.sauceDemo.page.CartPage;
import org.sauceDemo.page.HomePage;
import org.sauceDemo.page.LoginPage;
import org.sauceDemo.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTest extends Base
{
	
	@Test
	public void verifyAddedFirstThreeLowPriceProductintheCart() throws IOException
	{
		String userName = ExcelUtility.stringDataRead(0, 0, Constants.LOGIN_PAGE_DATA);
		String password = ExcelUtility.stringDataRead(2, 0, Constants.LOGIN_PAGE_DATA);
		
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		HomePage home_page = loginObj.clickOnLoginButton();
		
		HomePage homeObj = new HomePage(driver);
		homeObj.selectHomePageDropDownSortingPriceLowtoHigh();
		homeObj.addFirstThreeLowPriceProductsToCart();
		CartPage cart_page = homeObj.clickOnCartButton();
		
		CartPage cartObj = new CartPage(driver);
        List<String> addedProductNames = homeObj.getAddedProductNames();
        homeObj.clickOnCartButton();
        List<String> cartItemNames = cartObj.getCartItemNames();
        Assert.assertTrue(cartItemNames.containsAll(addedProductNames), Messages.PRODUCT_MISSING_ERROR_MESSAGES);
        
	}
}
