package com.comCast.crm.vendortest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Retryanalazer 
{
	@Test(retryAnalyzer =com.comCast.crm.listnerUtility.RetryListnerImp.class)
	public void activatesim()
	{
		System.out.println("===excution create invoice");
		Assert.assertEquals("home", "login");
		System.out.println("===line1=====");
		System.out.println("======line2=====");
		System.out.println("===line3=====");
		System.out.println("===line4====");
	}

}
