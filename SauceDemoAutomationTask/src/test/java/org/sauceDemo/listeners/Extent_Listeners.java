package org.sauceDemo.listeners;


import org.sauceDemo.automation_core.Base;
import org.sauceDemo.extent_report.ExtentManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

/**
 * TestNG listener to manage ExtentReports for test reporting.
 */
public class Extent_Listeners extends Base implements ITestListener
{
	
	 // Instance of ExtentReports for managing test reports
	private static final ExtentReports extent= ExtentManager.createInstance();
	
	// ThreadLocal instance to manage ExtentTest instances per thread
	private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	
	
	/**
     * Called when the test suite starts.
     * @param context The context for the test suite
     */
	public synchronized void onStart(ITestContext context) {
        System.out.println("Extent Reports Version 3 Test Suite started!");
    }
	
	/**
     * Called when the test suite finishes.
     * @param context The context for the test suite
     */
	public synchronized void onFinish(ITestContext context) {
        System.out.println(("Extent Reports Version 3  Test Suite is ending!"));
        extent.flush();
    }
	
	/**
     * Called when a test method starts.
     * @param result The result of the test method
     */
	public synchronized void onTestStart(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " started!"));
     // Create a new ExtentTest and associate it with the current test method
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
     // Set the ExtentTest instance in ThreadLocal for thread safety
        test.set(extentTest);
    }
	
	/**
     * Called when a test method succeeds.
     * @param result The result of the test method
     */
	public synchronized void onTestSuccess(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " passed!"));
        test.get().pass("Test passed");// Mark the test as passed in ExtentReports
    }
	
	 /**
     * Called when a test method fails.
     * @param result The result of the test method
     */
	public synchronized void onTestFailure(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " failed!"));
        test.get().fail(result.getThrowable());// Mark the test as failed in ExtentReports
    }
	
	/**
     * Called when a test method is skipped.
     * @param result The result of the test method
     */
	public synchronized void onTestSkipped(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " skipped!"));
        test.get().skip(result.getThrowable());// Mark the test as skipped in ExtentReports
    }
	
	/**
     * Called when a test method fails within the success percentage.
     * @param result The result of the test method
     */
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }
	
	/**
     * Retrieves the ThreadLocal instance of ExtentTest for current thread.
     * @return The ThreadLocal instance containing ExtentTest
     */
	public static ThreadLocal<ExtentTest> getTestInstance(){
        return test;
    }
}
