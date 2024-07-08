package org.sauceDemo.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	/**
     * Data provider for invalid user credentials.
     * This method returns a 2D array of invalid usernames and passwords for testing.
     *
     * @return Object[][] containing invalid user credentials.
     */
	@DataProvider(name="InvalidUserCredentials")
	public Object userCredentialsData()
	{
		// Initialize a 2D array with 3 rows and 2 columns
		Object data[][]	= new String [3][2];
		
		// Fill the array with invalid username and password combinations
		data[0][0]="standard_user"; //valid username
		data[0][1]="secret_sau";	//invalid password
		
		data[1][0]="standard_usasdcvbn";	//invalid username
		data[1][1]="secret_sauce";			//valid password
		
		data[2][0]="standard_us";		//invalid username
		data[2][1]="secret_sausdb";		//invalid password
		
		// Fill the array with invalid username and password combinations
		return data;
	}
}
