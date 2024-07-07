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

public class HomePageTest extends Base
{
	@Test
	public void verifyProductSortedByNameAtoZ() throws IOException 
	{
		String userName = ExcelUtility.stringDataRead(1, 0, Constants.LOGIN_PAGE_DATA);
		String password = ExcelUtility.stringDataRead(2, 0, Constants.LOGIN_PAGE_DATA);
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		HomePage home_page = loginObj.clickOnLoginButton();
		
		HomePage homeObj = new HomePage(driver);
		homeObj.selectHomePageDropDownSortingNameAtoZ();
		Assert.assertTrue(true, Messages.SORTING_ERROR_MESSAGES);
	}
	
	@Test
	public void verifyProductSortedByNameZtoA() throws IOException 
	{
		String userName = ExcelUtility.stringDataRead(1, 0, Constants.LOGIN_PAGE_DATA);
		String password = ExcelUtility.stringDataRead(2, 0, Constants.LOGIN_PAGE_DATA);
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		HomePage home_page = loginObj.clickOnLoginButton();
		
		HomePage homeObj = new HomePage(driver);
		homeObj.selectHomePageDropDownSortingNameZtoA();
		Assert.assertTrue(true, Messages.SORTING_ERROR_MESSAGES);
	}
	
	@Test
	public void verifyProductSortedByPriceHtoL() throws IOException
	{
		String userName = ExcelUtility.stringDataRead(1, 0, Constants.LOGIN_PAGE_DATA);
		String password = ExcelUtility.stringDataRead(2, 0, Constants.LOGIN_PAGE_DATA);
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		HomePage home_page = loginObj.clickOnLoginButton();
		
		HomePage homeObj = new HomePage(driver);
		homeObj.selectHomePageDropDownSortingPriceHightoLow();
		Assert.assertTrue(true, Messages.SORTING_ERROR_MESSAGES);
	}
	
	@Test
	public void verifyProductSortedByPriceLtoH() throws IOException
	{
		String userName = ExcelUtility.stringDataRead(1, 0, Constants.LOGIN_PAGE_DATA);
		String password = ExcelUtility.stringDataRead(2, 0, Constants.LOGIN_PAGE_DATA);
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		HomePage home_page = loginObj.clickOnLoginButton();
		
		HomePage homeObj = new HomePage(driver);
		homeObj.selectHomePageDropDownSortingPriceLowtoHigh();
		Assert.assertTrue(true, Messages.SORTING_ERROR_MESSAGES);
	}
	
}


       
		
		
		

