package org.sauceDemo.page;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sauceDemo.utilities.WebElementUtilities;


/**
 * Page Object Model (POM) class representing the home page of the application.
 */
public class HomePage
{

	WebDriver driver;
	public HomePage(WebDriver driver)
		{
			this.driver=driver;		
			PageFactory.initElements(driver, this); 
		}
	
	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement homepage_sortDropdown;
	@FindBy(xpath = "//option[@value='az']")
	WebElement homepage_invantoryList_NameAtoZ;
	@FindBy(xpath = "//option[@value='za']")
	WebElement homepage_invantoryList_NameZtoA;
	@FindBy(xpath = "//option[@value='lohi']")
	WebElement homepage_invantoryList_PriceLtoH;
	@FindBy(xpath = "//option[@value='hilo']")
	WebElement homepage_invantoryList_PriceHtoL;
	
	@FindBy(className = "inventory_item_name")
    List<WebElement> homepage_invantoryItemName;
	@FindBy(css = ".inventory_item_price")
    List<WebElement> homepage_invantoryItemPrice;
	
	@FindBy(className = "btn_inventory")
    List<WebElement> addToCartButtons;
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement shopping_cart_icon;
	
	@FindBy(xpath = "//span[text()='Products']")
	WebElement home_Verification;
	
	@FindBy(xpath = "//div[starts-with(text(), 'Sauce Labs')]")
	List <WebElement> productNamesList;

	
	/**
     * Selects sorting by "Name (A to Z)" and verifies if the products are sorted correctly.
     *
     * @return true if products are sorted correctly, false otherwise
     * @throws InterruptedException if the thread is interrupted
     */
    public boolean verifySortingByNameAtoZ() throws InterruptedException {
        WebElementUtilities.selectDropDownByVisibleText(homepage_sortDropdown, "Name (A to Z)");
        Thread.sleep(1000); // Add a wait time if necessary
        List<String> productNames = WebElementUtilities.extractTextFromElements(homepage_invantoryItemName);
        List<String> sortedProductNames = new ArrayList<>(productNames);
        Collections.sort(sortedProductNames);
        return productNames.equals(sortedProductNames);
    }
    
    /**
     * Selects sorting by "Name (Z to A)" and verifies if the products are sorted correctly.
     *
     * @return true if products are sorted correctly, false otherwise
     * @throws InterruptedException if the thread is interrupted
     */
    public boolean verifySortingByNameZtoA() throws InterruptedException {
        WebElementUtilities.selectDropDownByVisibleText(homepage_sortDropdown, "Name (Z to A)");
        Thread.sleep(1000); // Add a wait time if necessary
        List<String> productNames = WebElementUtilities.extractTextFromElements(homepage_invantoryItemName);
        List<String> sortedProductNames = new ArrayList<>(productNames);
        Collections.sort(sortedProductNames, Collections.reverseOrder());
        return productNames.equals(sortedProductNames);
    }
    
    /**
     * Selects sorting by "Price (low to high)" and verifies if the products are sorted correctly.
     *
     * @return true if products are sorted correctly, false otherwise
     * @throws InterruptedException if the thread is interrupted
     */
    public boolean verifySortingByPriceLowToHigh() throws InterruptedException {
        WebElementUtilities.selectDropDownByVisibleText(homepage_sortDropdown, "Price (low to high)");
        Thread.sleep(1000); // Add a wait time if necessary
        List<Double> actualPrices = WebElementUtilities.extractPricesFromElements(homepage_invantoryItemPrice);
        List<Double> sortedProductPrices = new ArrayList<>(actualPrices);
        Collections.sort(sortedProductPrices);
        return actualPrices.equals(sortedProductPrices);
    }
    
    /**
     * Selects sorting by "Price (high to low)" and verifies if the products are sorted correctly.
     *
     * @return true if products are sorted correctly, false otherwise
     * @throws InterruptedException if the thread is interrupted
     */
    public boolean verifySortingByPriceHighToLow() throws InterruptedException {
        WebElementUtilities.selectDropDownByVisibleText(homepage_sortDropdown, "Price (high to low)");
        Thread.sleep(1000); // Add a wait time if necessary
        List<Double> actualPrices = WebElementUtilities.extractPricesFromElements(homepage_invantoryItemPrice);
        List<Double> sortedProductPrices = new ArrayList<>(actualPrices);
        Collections.sort(sortedProductPrices, Collections.reverseOrder());
        return actualPrices.equals(sortedProductPrices);
    }
   
    /**
     * Adds the first three low-priced products to the cart based on their position in the addToCartButtons list.
     * The addToCartButtons list represents "Add To Cart" buttons in the order of product appearance.
     */
	public void addFirstThreeLowPriceProductsToCart() 
	{
        for (int i = 0; i < 3; i++) {
            addToCartButtons.get(i).click();
        }
    }
	
	/**
     * Clicks on the shopping cart icon and returns a new CartPage object.
     * The shopping_cart_icon WebElement represents the shopping cart icon on the page.
     * @return the CartPage .
     */
	public CartPage clickOnCartButton()
	{
		WebElementUtilities.clickOnElement(shopping_cart_icon);
		return new CartPage(driver);
	}
	
	/**
     * Gets a list of product names from the first three elements of the homepage_invantoryItemName list.
     * The homepage_invantoryItemName list represents product names displayed on the homepage.
     * @return A List containing the names of the first three products on the homepage.
     */
	public List<String> getAddedProductNames() 
	{
        return homepage_invantoryItemName.stream().limit(3).map(WebElement::getText).toList();
    }
	
	 /**
     * Gets the text content of the home_Verification WebElement.
     * The home_Verification WebElement represents a verification message on the homepage.
     * @return The text content of the home_Verification WebElement.
     */
	public String getHomeVerificationMessage()
	{
		String text = WebElementUtilities.getText(home_Verification);
		return text;
	}
}
	

