package com.comCast.crm.vendortest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class imentingIretryAnalazer implements IRetryAnalyzer
{
	int count=1;int max=5;

	@Override
	public boolean retry(ITestResult result) 
	{
		if(count<max)
		{
			count++;
			return true;
		}
		
		return false;
	}
	

}
