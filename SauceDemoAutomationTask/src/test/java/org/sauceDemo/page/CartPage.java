package org.sauceDemo.page;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sauceDemo.utilities.WebElementUtilities;

/**
 * Page Object Model (POM) class representing the Cart Page in the application.
 */
public class CartPage 
{
	WebDriver driver;
	/**
     * Constructor to initialize the CartPage with WebDriver and initialize elements using PageFactory.
     * @param driver WebDriver instance to interact with the browser
     */
	public CartPage(WebDriver driver)
		{
			this.driver=driver;		
			PageFactory.initElements(driver, this); 
		}
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	List<WebElement> cartItem_Names;
	@FindBy(xpath = "//button[@id='checkout']")
	WebElement checkout_button;
	
	/**
     * Method to retrieve names of items in the cart.
     * @return List of item names in the cart
     */
	public List<String> getCartItemNames() {
        return cartItem_Names.stream().map(WebElement::getText).toList();
    }
	
	/**
     * Method to click on the checkout button and navigate to CheckoutStepOnePage.
     * @return CheckoutStepOnePage instance after clicking on the checkout button
     */
	public CheckoutStepOnePage clickOnCheckButton()
	{
		WebElementUtilities.clickOnElement(checkout_button);
		return new CheckoutStepOnePage(driver);
	}
}
