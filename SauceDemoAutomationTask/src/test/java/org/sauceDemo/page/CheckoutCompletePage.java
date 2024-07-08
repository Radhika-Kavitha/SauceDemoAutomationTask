package org.sauceDemo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sauceDemo.utilities.WebElementUtilities;

/**
 * Page Object class representing the Checkout Complete page.
 * It provides methods to interact with elements on the Checkout Complete page.
 */
public class CheckoutCompletePage 
{
	WebDriver driver;
	/**
     * Constructor to initialize the WebDriver and PageFactory elements.
     * @param driver The WebDriver instance to use for interacting with the browser.
     */
	public CheckoutCompletePage(WebDriver driver)
		{
			this.driver=driver;		
			PageFactory.initElements(driver, this); 
		}

	@FindBy(className  = "complete-header")
	WebElement complete_Header;
	
	/**
     * Method to retrieve the text of the complete header message on the Checkout Complete page.
     * @return The text of the complete header message.
     */
	public String getCompleteHeaderMessage()
	{
		String text = WebElementUtilities.getText(complete_Header);
		return text;
	}

}
