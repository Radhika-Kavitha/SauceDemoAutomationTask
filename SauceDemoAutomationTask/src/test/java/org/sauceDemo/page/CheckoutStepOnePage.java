package org.sauceDemo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sauceDemo.utilities.WebElementUtilities;

public class CheckoutStepOnePage 
{
	WebDriver driver;
	public CheckoutStepOnePage(WebDriver driver)
		{
			this.driver=driver;		
			PageFactory.initElements(driver, this); 
		}
	@FindBy(xpath = "//input[@id='first-name']")
	WebElement first_Name;
	@FindBy(xpath = "//input[@id='last-name']")
	WebElement last_Name;
	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement zip_Code;
	@FindBy(xpath = "//input[@id='continue']")
	WebElement continue_button;
	
	
	public void enterFirstName(String firstName)
	{
		WebElementUtilities.enterValue(first_Name, firstName);
	}
	public void enterLastName(String lastName)
	{
		WebElementUtilities.enterValue(last_Name, lastName);
	}
	public void enterZipCode(String zipCode)
	{
		WebElementUtilities.enterValue(zip_Code, zipCode);
	}
	public CheckoutStepTwoPage clickOnContinueButton()
	{
		WebElementUtilities.clickOnElement(continue_button);
		return new CheckoutStepTwoPage(driver);
	}
}
