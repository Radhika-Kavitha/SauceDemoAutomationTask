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

/**
 * Test class to verify adding low-priced products to the cart functionality.
 */
public class CartPageTest extends Base
{
	
	/**
     * Test case to verify adding the first three low-price products to the cart.
     * @throws IOException if there is an issue with reading Excel data
     * @throws InterruptedException if the thread is interrupted during execution
     */
	@Test(priority = 8, groups = {"Sanity", "Regression", "Smoke"})
	public void verifyAddedFirstThreeLowPriceProductintheCart() throws IOException, InterruptedException
	{
		// Login using credentials from Excel sheet
		String userName = ExcelUtility.stringDataRead(1, 0, Constants.LOGIN_PAGE_DATA);
		String password = ExcelUtility.stringDataRead(2, 0, Constants.LOGIN_PAGE_DATA);
		
		
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		HomePage home_page = loginObj.clickOnLoginButton();
		
		// Perform actions on Home Page
		HomePage homeObj = new HomePage(driver);
		homeObj.verifySortingByPriceLowToHigh();// Verify sorting by Price (Low to High)
		homeObj.addFirstThreeLowPriceProductsToCart();// Add first three low-price products to cart
		CartPage cart_page = homeObj.clickOnCartButton();// Navigate to Cart Page
		
		// Perform actions on Cart Page
		CartPage cartObj = new CartPage(driver);
		
		// Get product names from Homepage ( represent the added products)
        List<String> addedProductNames = homeObj.getAddedProductNames();
        
        //Navigate back to Cart Page 
        homeObj.clickOnCartButton();  
        
        //Get product names from Cart Page
        List<String> cartItemNames = cartObj.getCartItemNames();
        
        // Verification: Assert all added products are present in the cart
        Assert.assertTrue(cartItemNames.containsAll(addedProductNames), Messages.PRODUCT_MISSING_ERROR_MESSAGES);
        
	}
}
