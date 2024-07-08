package org.sauceDemo.constants;

/**
 * Class containing constant strings representing paths and sheet names in the test data Excel file.
 * Provides easy access to different types of test data used in the automation tasks.
 */
public class Constants 
{
	// Path to the Excel file containing test data
	public static final String TEST_DATA_EXCELPATH = "\\src\\main\\resources\\TestData.xlsx" ;
	
	// Directory path of the project
	public static final String HOME_DIRECTORY = System.getProperty("user.dir");
	
	// Sheet names in the Excel file
	public static final String LOGIN_PAGE_DATA = "LoginPageData";
	public static final String HOME_PAGE_DATA = "HomePageData";
	public static final String CART_PAGE_DATA = "CartPageData";
	public static final String CHECKOUT_STEPONE_PAGE_DATA = "CheckoutStepOnePageData";
	public static final String CHECKOUT_STEPTWO_PAGE_DATA = "CheckoutStepTwoPageData";
	public static final String CHECKOUT_COMPLETE_PAGE_DATA = "CheckCompletePageData";
}
