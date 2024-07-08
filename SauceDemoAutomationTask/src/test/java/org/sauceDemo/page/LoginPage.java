package org.sauceDemo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sauceDemo.utilities.WebElementUtilities;

/**
 * Page Object Model (POM) class representing the login page of the application.
 */
public class LoginPage 
{

	WebDriver driver;
	/**
     * Constructor to initialize the WebDriver and PageFactory elements.
     * @param driver the WebDriver instance to be used for interacting with web elements
     */
	public LoginPage(WebDriver driver)
		{
			this.driver=driver;		
			PageFactory.initElements(driver, this); 
		}
	// Locating the username field using XPath
	@FindBy(xpath = "//input[@id='user-name']")
	WebElement userName_field;
	
	// Locating the password field using XPath
	@FindBy(xpath = "//input[@id='password']")
	WebElement password_field;
	
	// Locating the login button using XPath
	@FindBy(xpath = "//input[@id='login-button']")
	WebElement login_button;
	
	// Locating the error message using XPath
	@FindBy(xpath = "//*[contains(text(),'Epic sadface: Username and password do not match any user in this service')]")
	WebElement error_message;
	
	/**
     * Method to enter the username in the username field.
     * @param userName the username to be entered
     */
	public void enterUserName(String userName)
	{
		WebElementUtilities.enterValue(userName_field, userName);
	}
	
	/**
     * Method to enter the password in the password field.
     * @param pass_word the password to be entered
     */
	public void enterPassword(String pass_word)
	{
		WebElementUtilities.enterValue(password_field, pass_word);
	}
	
	/**
     * Method to click on the login button.
     * @return HomePage instance if login is successful
     */
	public HomePage clickOnLoginButton()
	{
		WebElementUtilities.clickOnElement(login_button);
		return new HomePage(driver);
	}
	
	/**
     * Method to get the error message displayed on the login page.
     * @return the error message text
     */
	public String getErrorMessage()
	{
		String text = WebElementUtilities.getText(error_message);
		return text;
	}
}
