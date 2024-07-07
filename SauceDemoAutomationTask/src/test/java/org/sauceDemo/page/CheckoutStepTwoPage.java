package org.sauceDemo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sauceDemo.utilities.WebElementUtilities;

public class CheckoutStepTwoPage 
{
	WebDriver driver;
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
	
	public CheckoutStepTwoPage clickOnLoginButton()
	{
		WebElementUtilities.clickOnElement(finish_button);
		return new CheckoutStepTwoPage(driver);
	}
	public String getTotalPrice()
	{
		String text = WebElementUtilities.getText(price_total);
		return text;
	}
	public String getcheckoutStepTwo_Verification()
	{
		String text = WebElementUtilities.getText(checkoutStepTwo_Verification);
		return text;
	}
	public HomePage clickOnFinishButton()
	{
		WebElementUtilities.clickOnElement(finish_button);
		return new HomePage(driver);
	}
}
