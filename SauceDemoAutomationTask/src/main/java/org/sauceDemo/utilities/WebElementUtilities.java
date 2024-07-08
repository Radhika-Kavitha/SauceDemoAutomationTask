package org.sauceDemo.utilities;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Utility class for common operations on WebElements.
 */
public class WebElementUtilities 
{	
		
	/**
     * Performs a click action on the specified WebElement.
     * @param element The WebElement to perform the click action on.
     */
	public static void clickOnElement(WebElement element)
	{
		element.click();
	}	
		
	/**
     * Enters the specified value into the WebElement.
     * @param element The WebElement to enter value into.
     * @param valueToEnter The value to be entered into the WebElement.
     */
	public static void enterValue(WebElement element,String valueToEnter)
	{
		element.sendKeys(valueToEnter);
	}
	
	/**
     * Retrieves the visible text of the WebElement.
     * @param element The WebElement from which to retrieve text.
     * @return The visible text of the WebElement.
     */
	public static String getText(WebElement element)
	{
		return element.getText();
	}
	
	/**
     * Selects an option from a dropdown by visible text.
     * @param dropdown the WebElement representing the dropdown
     * @param visibleText the visible text of the option to select
     */
    public static void selectDropDownByVisibleText(WebElement dropdown, String visibleText) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }

    /**
     * Extracts text from a list of WebElements.
     * @param elements the list of WebElements
     * @return a list of strings representing the text of each element
     */
    public static List<String> extractTextFromElements(List<WebElement> elements) {
        List<String> textList = new ArrayList<>();
        for (WebElement element : elements) {
            textList.add(element.getText());
        }
        return textList;
    }

    /**
     * Extracts prices from a list of WebElements, removing the "$" symbol and converting to Double.
     * @param elements the list of WebElements
     * @return a list of doubles representing the prices of each element
     */
    public static List<Double> extractPricesFromElements(List<WebElement> elements) {
        List<Double> priceList = new ArrayList<>();
        for (WebElement element : elements) {
            String priceText = element.getText().replace("$", "");
            priceList.add(Double.parseDouble(priceText));
        }
        return priceList;
    }
	
	
}
