package org.sauceDemo.page;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sauceDemo.utilities.WebElementUtilities;

public class CartPage 
{
	WebDriver driver;
	public CartPage(WebDriver driver)
		{
			this.driver=driver;		
			PageFactory.initElements(driver, this); 
		}
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	List<WebElement> cartItem_Names;
	@FindBy(xpath = "//button[@id='checkout']")
	WebElement checkout_button;
	
	public List<String> getCartItemNames() {
        return cartItem_Names.stream().map(WebElement::getText).toList();
    }
	public CheckoutStepOnePage clickOnCheckButton()
	{
		WebElementUtilities.clickOnElement(checkout_button);
		return new CheckoutStepOnePage(driver);
	}
	
	
	
}
