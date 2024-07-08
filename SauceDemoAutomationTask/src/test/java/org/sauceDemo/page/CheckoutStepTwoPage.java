package org.sauceDemo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sauceDemo.utilities.WebElementUtilities;

/**
 * Page Object class representing Checkout Step Two Page.
 */
public class CheckoutStepTwoPage 
{
	WebDriver driver;
	/**
     * Constructor to initialize WebDriver and Page Factory elements.
     * @param driver WebDriver instance used to interact with the browser
     */
	public CheckoutStepTwoPage(WebDriver driver)
		{
			this.driver=driver;		
			PageFactory.initElements(driver, this); 
		}
	@FindBy(xpath = "//div[@class='summary_subtotal_label']")
	WebElement price_total;
	@FindBy(xpath = "//button[@id='finish']")
	WebElement finish_button;
	@FindBy(xpath = "//span[text()='Checkout: Overview']")
	WebElement checkoutStepTwo_Verification;
	
	/**
     * Method to click on the Finish button and navigate to Home Page.
     * @return HomePage instance after clicking the Finish button
     */
	public CheckoutStepTwoPage clickOnLoginButton()
	{
		WebElementUtilities.clickOnElement(finish_button);
		return new CheckoutStepTwoPage(driver);
	}
	
	/**
     * Method to get the total price displayed on Checkout Step Two Page.
     * @return String representing the total price
     */
	public String getTotalPrice()
	{
		String text = WebElementUtilities.getText(price_total);
		return text;
	}
	
	 /**
     * Method to get the verification text displayed on Checkout Step Two Page.
     * @return String representing the verification text
     */
	public String getcheckoutStepTwo_Verification()
	{
		String text = WebElementUtilities.getText(checkoutStepTwo_Verification);
		return text;
	}
	
	/**
     * Method to click on the Finish button and navigate to CheckoutComplete Page.
     * @return CheckoutCompletePage instance after clicking the Finish button
     */
	public CheckoutCompletePage clickOnFinishButton()
	{
		WebElementUtilities.clickOnElement(finish_button);
		return new CheckoutCompletePage(driver);
	}
}
