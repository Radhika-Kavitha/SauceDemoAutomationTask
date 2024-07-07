package org.sauceDemo.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	@DataProvider(name="InvalidUserCredentials")
	public Object userCredentialsData()
	{
		Object data[][]	= new String [3][2];
		
		data[0][0]="standard_user";
		data[0][1]="secret_sau";
		
		data[1][0]="standard_usasdcvbn";
		data[1][1]="secret_sauce";
		
		data[2][0]="standard_us";
		data[2][1]="secret_sausdb";
		
		return data;
	}
}
