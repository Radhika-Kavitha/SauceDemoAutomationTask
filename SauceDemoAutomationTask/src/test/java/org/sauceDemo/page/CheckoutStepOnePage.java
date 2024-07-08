package org.sauceDemo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sauceDemo.utilities.WebElementUtilities;

/**
 * Page Object class representing Checkout Step One Page.
 */
public class CheckoutStepOnePage 
{
	WebDriver driver;
	/**
     * Constructor to initialize WebDriver and Page Factory elements.
     * @param driver WebDriver instance used to interact with the browser
     */
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
	
	/**
     * Method to enter first name in the First Name field.
     * @param firstName String value of the first name to be entered
     */
	public void enterFirstName(String firstName)
	{
		WebElementUtilities.enterValue(first_Name, firstName);
	}
	
	 /**
     * Method to enter last name in the Last Name field.
     * @param lastName String value of the last name to be entered
     */
	public void enterLastName(String lastName)
	{
		WebElementUtilities.enterValue(last_Name, lastName);
	}
	
	/**
     * Method to enter zip code in the Zip Code field.
     * @param zipCode String value of the zip code to be entered
     */
	public void enterZipCode(String zipCode)
	{
		WebElementUtilities.enterValue(zip_Code, zipCode);
	}
	
	/**
     * Method to click on the Continue button and navigate to Checkout Step Two Page.
     * @return CheckoutStepTwoPage instance after clicking the Continue button
     */
	public CheckoutStepTwoPage clickOnContinueButton()
	{
		WebElementUtilities.clickOnElement(continue_button);
		return new CheckoutStepTwoPage(driver);
	}
}
