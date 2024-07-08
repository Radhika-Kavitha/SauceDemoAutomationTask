package org.sauceDemo.test;


import java.io.IOException;
import org.sauceDemo.automation_core.Base;
import org.sauceDemo.constants.Constants;
import org.sauceDemo.constants.Messages;
import org.sauceDemo.page.HomePage;
import org.sauceDemo.page.LoginPage;
import org.sauceDemo.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
	
/**
 * Test class to validate sorting functionalities on the Home Page.
 */

public class HomePageTest extends Base
{
	/**
     * Test case to verify product sorting by Name (A to Z).
     * @throws IOException if there is an issue with reading Excel data
     * @throws InterruptedException if the thread is interrupted during execution
     */
	@Test(priority = 4, groups = {"Sanity", "Regression"})
	public void isVerifyProductSortedByNameAtoZ() throws IOException, InterruptedException 
	{
		// Read username and password from Excel sheet
		String userName = ExcelUtility.stringDataRead(1, 0, Constants.LOGIN_PAGE_DATA);
		String password = ExcelUtility.stringDataRead(2, 0, Constants.LOGIN_PAGE_DATA);
		
		 // Perform login
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		HomePage home_page = loginObj.clickOnLoginButton();
		
		 // Verify sorting by Name (A to Z)
		HomePage homeObj = new HomePage(driver);
		boolean isSorted = homeObj.verifySortingByNameAtoZ();
		Assert.assertTrue(isSorted, Messages.SORTING_ERROR_AtoZ);
	}
	
	/**
     * Test case to verify product sorting by Name (Z to A).
     * @throws IOException if there is an issue with reading Excel data
     * @throws InterruptedException if the thread is interrupted during execution
     */
	@Test(priority = 5, groups = {"Sanity", "Regression"})
	public void isVerifyProductSortedByNameZtoA() throws IOException, InterruptedException 
	{
		// Read username and password from Excel sheet
		String userName = ExcelUtility.stringDataRead(1, 0, Constants.LOGIN_PAGE_DATA);
		String password = ExcelUtility.stringDataRead(2, 0, Constants.LOGIN_PAGE_DATA);
		
		// Perform login
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		HomePage home_page = loginObj.clickOnLoginButton();
		
		 // Verify sorting by Name (Z to A)
		HomePage homeObj = new HomePage(driver);
		boolean isSorted = homeObj.verifySortingByNameZtoA();
		Assert.assertTrue(isSorted, Messages.SORTING_ERROR_ZtoA);
	}
	
	/**
     * Test case to verify product sorting by Price (High to Low).
     * @throws IOException if there is an issue with reading Excel data
     * @throws InterruptedException if the thread is interrupted during execution
     */
	@Test(priority = 6, groups = {"Sanity", "Regression"})
	public void isVerifyProductSortedByPriceHtoL() throws IOException, InterruptedException
	{
		// Read username and password from Excel sheet
		String userName = ExcelUtility.stringDataRead(1, 0, Constants.LOGIN_PAGE_DATA);
		String password = ExcelUtility.stringDataRead(2, 0, Constants.LOGIN_PAGE_DATA);
		
		// Perform login
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		HomePage home_page = loginObj.clickOnLoginButton();
		
		// Verify sorting by Price (High to Low)
		HomePage homeObj = new HomePage(driver);
		boolean isSorted = homeObj.verifySortingByPriceHighToLow();
		Assert.assertTrue(isSorted, Messages.SORTING_ERROR_HtoL);
	}
	
	/**
     * Test case to verify product sorting by Price (Low to High).
     * @throws IOException if there is an issue with reading Excel data
     * @throws InterruptedException if the thread is interrupted during execution
     */
	@Test(priority = 7, groups = "Smoke")
	public void isVerifyProductSortedByPriceLtoH() throws IOException, InterruptedException
	{
		// Read username and password from Excel sheet
		String userName = ExcelUtility.stringDataRead(1, 0, Constants.LOGIN_PAGE_DATA);
		String password = ExcelUtility.stringDataRead(2, 0, Constants.LOGIN_PAGE_DATA);
		
		// Perform login
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		HomePage home_page = loginObj.clickOnLoginButton();
		
		 // Verify sorting by Price (Low to High)
		HomePage homeObj = new HomePage(driver);
		boolean isSorted = homeObj.verifySortingByPriceLowToHigh();
        Assert.assertTrue(isSorted, Messages.SORTING_ERROR_LtoH);
	}
	
}


       
		
		
		

