package org.sauceDemo.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * TestNG retry analyzer implementation to retry failed tests a specified number of times.
 */
public class Retry_Analyzer implements IRetryAnalyzer
{
	// Initialize count to track retry attempts
	int count = 0;
	
	// Set the maximum retry limit
	int retryLimit = 3;
	
	/**
     * Method to decide whether to retry a failed test or not.
     * @param result The result of the test method
     * @return true if the test should be retried, false otherwise
     */
	@Override
	public boolean retry(ITestResult result) 
	{
		// Check if count is less than the retry limit
		if(count<retryLimit)
		{
			count++;// Check if count is less than the retry limit
			return true;// Retry the test
		}
		return false;// Do not retry the test if count exceeds retry limit
	}
	
}
