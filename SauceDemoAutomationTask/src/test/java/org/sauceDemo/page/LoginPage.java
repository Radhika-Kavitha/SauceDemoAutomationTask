package org.sauceDemo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sauceDemo.utilities.WebElementUtilities;


public class LoginPage 
{

	WebDriver driver;
	public LoginPage(WebDriver driver)
		{
			this.driver=driver;		
			PageFactory.initElements(driver, this); 
		}
	@FindBy(xpath = "//input[@id='user-name']")
	WebElement userName_field;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password_field;
	@FindBy(xpath = "//input[@id='login-button']")
	WebElement login_button;
	@FindBy(xpath = "//*[contains(text(),'Epic sadface: Username and password do not match any user in this service')]")
	WebElement error_message;
	
	public void enterUserName(String userName)
	{
		WebElementUtilities.enterValue(userName_field, userName);
	}
	public void enterPassword(String pass_word)
	{
		WebElementUtilities.enterValue(password_field, pass_word);
	}
	public HomePage clickOnLoginButton()
	{
		WebElementUtilities.clickOnElement(login_button);
		return new HomePage(driver);
	}
	public String getErrorMessage()
	{
		String text = WebElementUtilities.getText(error_message);
		return text;
	}
}
