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

public class LoginPageTest extends Base
{
	
	@Test
	public void verifyLoginPageTitle() throws IOException
	{
		String actualTitle = driver.getTitle();
		String expectedTitle = ExcelUtility.stringDataRead(0, 0, Constants.LOGIN_PAGE_DATA);
		Assert.assertEquals(actualTitle, expectedTitle, Messages.TITLE_MESSAGES);
	}
	
	@Test
	public void verifyUserLoginWithValidCredentials() throws IOException 
	{
		String userName = ExcelUtility.stringDataRead(1, 0, Constants.LOGIN_PAGE_DATA);
		String password = ExcelUtility.stringDataRead(2, 0, Constants.LOGIN_PAGE_DATA);
		
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		HomePage home_page = loginObj.clickOnLoginButton();
		
		HomePage homeObj = new HomePage(driver);
		String actual_HomeVerification = homeObj.getHomeVerificationMessage();
		String expected_HomeVerification =ExcelUtility.stringDataRead(0, 0, Constants.HOME_PAGE_DATA );
		Assert.assertEquals(actual_HomeVerification, expected_HomeVerification, Messages.MISMAICH_HOMETITLE);
	}

	@Test(dataProvider = "InvalidUserCredentials", dataProviderClass = DataProviders.class)
	public void verifyErrorMessageWhileLoginWithInvalidCredentials(String userName, String password) throws IOException 
	{
		String expected_ErrorMessage = ExcelUtility.stringDataRead(4, 0, Constants.LOGIN_PAGE_DATA);
		
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUserName(userName);
		loginObj.enterPassword(password);
		HomePage home = loginObj.clickOnLoginButton();
		String actual_ErrorMessage = loginObj.getErrorMessage();
		System.out.println(actual_ErrorMessage);
		Assert.assertEquals(actual_ErrorMessage, expected_ErrorMessage, Messages.ERROR_MESSAGES);
	}
	
}
