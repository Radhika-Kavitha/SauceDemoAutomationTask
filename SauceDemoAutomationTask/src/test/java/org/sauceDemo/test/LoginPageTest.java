package org.sauceDemo.test;
import java.io.IOException;
import org.sauceDemo.automation_core.Base;
import org.sauceDemo.constants.Constants;
import org.sauceDemo.constants.Messages;
import org.sauceDemo.dataprovider.DataProviders;
import org.sauceDemo.page.HomePage;
import org.sauceDemo.page.LoginPage;
import org.sauceDemo.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class for testing functionalities related to the LoginPage.
 * Inherits from Base class for WebDriver initialization and setup.
 */
public class LoginPageTest extends Base
{
	// Method to verify the login page title
	@Test(priority = 1, groups = "Smoke")
	public void verifyLoginPageTitle() throws IOException
	{
		// Get the actual title of the current page
		String actualTitle = driver.getTitle();
		
		// Read the expected title from an Excel file
		String expectedTitle = ExcelUtility.stringDataRead(0, 0, Constants.LOGIN_PAGE_DATA);
		
		// Assert that the actual title matches the expected title
		Assert.assertEquals(actualTitle, expectedTitle, Messages.TITLE_MESSAGES);
	}
	
	/*
     * Test to verify user login with valid credentials.
     * This method reads the username and password from an Excel file,
     * logs into the application, and verifies the home page message.
     * @throws IOException if there is an error reading the Excel file.
     */
	@Test(priority = 2, groups = "Smoke")
	public void verifyUserLoginWithValidCredentials() throws IOException 
	{
		// Read username and password from the Excel file
		String userName = ExcelUtility.stringDataRead(1, 0, Constants.LOGIN_PAGE_DATA);
		String password = ExcelUtility.stringDataRead(2, 0, Constants.LOGIN_PAGE_DATA);
		
		// Create an instance of the LoginPage and enter the username and password
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		
		// Click on the login button and navigate to the HomePage
		HomePage home_page = loginObj.clickOnLoginButton();
		
		 // Create an instance of the HomePage and get the verification message
		HomePage homeObj = new HomePage(driver);
		String actual_HomeVerification = homeObj.getHomeVerificationMessage();
		
		// Read the expected home verification message from the Excel file
		String expected_HomeVerification =ExcelUtility.stringDataRead(0, 0, Constants.HOME_PAGE_DATA );
		
		// Assert that the actual home verification message matches the expected message
		Assert.assertEquals(actual_HomeVerification, expected_HomeVerification, Messages.MISMAICH_HOMETITLE);
	}

	 /**
     * Test to verify the error message while logging in with invalid credentials.
     * This method reads the expected error message from an Excel file, attempts to log in with provided 
     * invalid credentials, and verifies that the actual error message matches the expected error message.
     * @DataProvider testng annotation is used for providing invalid user credentials 
     * @throws IOException if there is an error reading the Excel file
     */
	@Test(priority = 3, groups = {"Sanity", "Regression"}, dataProvider = "InvalidUserCredentials", dataProviderClass = DataProviders.class)
	public void verifyErrorMessageWhileLoginWithInvalidCredentials(String userName, String password) throws IOException 
	{
		// Read the expected error message from the Excel file
		String expected_ErrorMessage = ExcelUtility.stringDataRead(4, 0, Constants.LOGIN_PAGE_DATA);
		
		// Create an instance of the LoginPage and enter the invalid username and the invalid password
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		
		// Click on the login button and attempt to navigate to the HomePage
		HomePage home = loginObj.clickOnLoginButton();
		
		// Get the actual error message displayed on the login page
		String actual_ErrorMessage = loginObj.getErrorMessage();
		
		// Print the actual error message to the console (for debugging purposes)
		System.out.println(actual_ErrorMessage);
		
		// Assert that the actual error message matches the expected error message
		Assert.assertEquals(actual_ErrorMessage, expected_ErrorMessage, Messages.ERROR_MESSAGES);
	}
	
}
