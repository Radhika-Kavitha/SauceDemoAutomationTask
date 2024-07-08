package org.sauceDemo.automation_core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sauceDemo.utilities.WaitUtility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * Base class for initializing WebDriver, setting up and tearing down browser sessions,
 * and capturing screenshots on test failure.
 */
public class Base 
{
	public WebDriver driver; 
	 /**
     * Initializes the WebDriver instance based on the specified browser.
     * @param browser The name of the browser (e.g., "Chrome", "Edge", "Firefox").
     */
	public void initializeBrowser(String browser)  
	{
		if(browser.equals("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equals("Edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browser.equals("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			throw new RuntimeException("Invalid browser received");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	/**
     * Setup method executed before each test method.
     * Initializes the browser, navigates to the specified URL, and sets implicit wait.
     * @param browsername The name of the browser obtained from TestNG XML parameter.
     * @param url The base URL of the application obtained from TestNG XML parameter.
     */
	@BeforeMethod(alwaysRun = true)
	@Parameters({"browser", "baseurl"})
	public void setUp(String browsername, String url)
	{
		initializeBrowser(browsername);
		driver.get(url);
		WaitUtility.waitUsingImplicityWait(driver);
	}
	
	/**
     * Tear down method executed after each test method.
     * Closes the browser and takes a screenshot if the test fails.
     * @param result The result of the test method.
     * @throws IOException If an error occurs while capturing or saving the screenshot.
     */
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			takeScreenShot(result);
		}
		
		driver.close();
	}
	
	/**
     * Takes a screenshot when a test method fails and saves it to the ScreenShots folder.
     * @param result The result of the failed test method.
     * @throws IOException If an error occurs while capturing or saving the screenshot.
     */
	public void takeScreenShot(ITestResult result) throws IOException
	{
		TakesScreenshot takesScreenShot = (TakesScreenshot) driver;
		File screenShot = takesScreenShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File("./ScreenShots/"+result.getName()+".png"));
	}
	
	
	
}
