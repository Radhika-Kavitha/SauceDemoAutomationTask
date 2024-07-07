package org.sauceDemo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sauceDemo.utilities.WebElementUtilities;

public class CheckoutCompletePage 
{
	WebDriver driver;
	public CheckoutCompletePage(WebDriver driver)
		{
			this.driver=driver;		
			PageFactory.initElements(driver, this); 
		}

	@FindBy(className  = "complete-header")
	WebElement complete_Header;
	
	public String getCompleteHeaderMessage()
	{
		String text = WebElementUtilities.getText(complete_Header);
		return text;
	}

}
