package org.sauceDemo.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/**
 * Annotation transformer for TestNG to set RetryAnalyzer for test methods.
 */
public class Annotation_Transformer implements IAnnotationTransformer
{
	
	/**
     * Method to transform test annotations.
     * @param annotation The test annotation to be transformed
     * @param testClass The test class containing the test method
     * @param testConstructor The constructor of the test class
     * @param testMethod The test method to which the annotation is applied
     */
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)
	{
		annotation.setRetryAnalyzer(Retry_Analyzer.class);
	}
}
