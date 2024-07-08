package org.sauceDemo.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Utility class for handling various types of waits in WebDriver automation.
 */
public class WaitUtility 
{
	// Default implicit wait time in seconds
	public static final long IMPLICIT_WAIT = 10;
	
	// Default explicit wait time in seconds
	public static final long EXPLICIT_WAIT = 10;
	
	/**
     * Sets the implicit wait time for the WebDriver instance.
     * @param driver The WebDriver instance to set implicit wait for.
     */
	public static void waitUsingImplicityWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
	}
	
	 /**
     * Waits for the visibility of a WebElement using explicit wait.
     * @param driver The WebDriver instance to perform the wait on.
     * @param element The WebElement to wait for visibility.
     */
	public static void waitforElementVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
	}
}
