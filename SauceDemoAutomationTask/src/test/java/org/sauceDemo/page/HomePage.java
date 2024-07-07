package org.sauceDemo.page;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sauceDemo.utilities.WebElementUtilities;



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
	
	public boolean selectHomePageDropDownSortingNameAtoZ()
	{
			//Select select = new Select(homepage_sortDropdown);
			//select.selectByVisibleText("Name (A to Z)");
		homepage_sortDropdown.click();
		homepage_invantoryList_NameAtoZ.click();
				// Extract product names
		List<String> productNames = new ArrayList<>();
        for (WebElement element : homepage_invantoryItemName) {
            productNames.add(element.getText());
            //System.out.println(element.getText());
        }
        		// Create a copy of the list and sort it
        List<String> sortedProductNames = new ArrayList<>(productNames);
        Collections.sort(sortedProductNames);
        
        		// Verify if the product names are sorted correctly
        if (productNames.equals(sortedProductNames)) {
        	return true;
            //System.out.println("Products are sorted by name correctly.");
        } else {
            return false;
            //System.out.println("Products are NOT sorted by name correctly.");
        }
		
	}
	public boolean selectHomePageDropDownSortingNameZtoA()
	{
				//Select select = new Select(homepage_Dropdown);
				//select.selectByVisibleText("Name (Z to A)");
		homepage_sortDropdown.click();
		homepage_invantoryList_NameZtoA.click();
				// Extract product names
        List<String> productNames = new ArrayList<>();
        for (WebElement element : homepage_invantoryItemName) {
            productNames.add(element.getText());
           // System.out.println(element.getText());
        }
        		// Create a copy of the list and sort it
        List<String> sortedProductNames = new ArrayList<>(productNames);
        Collections.sort(sortedProductNames);
        
        		// Verify if the product names are sorted correctly
        if (productNames.equals(sortedProductNames)) 
        {
        	return false;
            //System.out.println("Products are NOT sorted by name correctly.");
        } else 
        {
            return true;
        	//System.out.println("Products are sorted by name correctly.");
        }
	}
	public boolean selectHomePageDropDownSortingPriceLowtoHigh()
	{
				//Select select = new Select(homepage_Dropdown);
				//select.selectByVisibleText("Price (low to high)");
		homepage_sortDropdown.click();
		homepage_invantoryList_PriceLtoH.click();
				// Extract product prices
        List<Double> actualPrices = new ArrayList<>();
        for (WebElement priceElement : homepage_invantoryItemPrice) {
        	String priceText = priceElement.getText().replace("$", "");
            actualPrices.add(Double.parseDouble(priceText));
            //System.out.println(priceText);
        }
        		// Create a copy of the list and sort it
        List<Double> sortedProductPrices = new ArrayList<>(actualPrices);
        Collections.sort(sortedProductPrices);
       

        		// Verify if the product prices are sorted correctly
        if (actualPrices.equals(sortedProductPrices)) 
        {
        	return true;
            //System.out.println("Products are sorted by price correctly.");
        } else 
        {
            return false;
        	//System.out.println("Products are NOT sorted by price correctly.");
        }
	}
	public boolean selectHomePageDropDownSortingPriceHightoLow()
	{
				//Select select = new Select(homepage_Dropdown);
				//select.selectByVisibleText("Price (high to low)");
		homepage_sortDropdown.click();
		homepage_invantoryList_PriceHtoL.click();
				
        List<Double> actualPrices = new ArrayList<>();
        for (WebElement priceElement : homepage_invantoryItemPrice) {
            String priceText = priceElement.getText().replace("$", "");
            actualPrices.add(Double.parseDouble(priceText));
            //System.out.println(priceText);
        }
        		// Create a sorted copy of product prices (ascending order)
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices);

        		// Verify if actual and expected prices match
        if (actualPrices.equals(expectedPrices)) 
        {
            return true;
        	//System.out.println("Products are sorted by Price (low to high) - PASS");
        } else 
        {
           return false;
        	//System.out.println("Products are NOT sorted by Price (low to high) - FAIL");
        }
	}
	
	public void addFirstThreeLowPriceProductsToCart() 
	{
        for (int i = 0; i < 3; i++) {
            addToCartButtons.get(i).click();
        }
    }
	
	public CartPage clickOnCartButton()
	{
		WebElementUtilities.clickOnElement(shopping_cart_icon);
		return new CartPage(driver);
	}
	
	public List<String> getAddedProductNames() 
	{
        return homepage_invantoryItemName.stream().limit(3).map(WebElement::getText).toList();
    }
	
	public String getHomeVerificationMessage()
	{
		String text = WebElementUtilities.getText(home_Verification);
		return text;
	}
}
	

