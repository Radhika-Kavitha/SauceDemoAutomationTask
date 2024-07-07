package org.sauceDemo.utilities;

import org.openqa.selenium.WebElement;

public class WebElementUtilities 
{
	public static void clickOnElement(WebElement element)
	{
		element.click();
	}
	public static void enterValue(WebElement element,String valueToEnter)
	{
		element.sendKeys(valueToEnter);
	}
	
	public static String getText(WebElement element)
	{
		return element.getText();
	}
}
