package com.comCast.crm.vendortest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comCast.crm.BaseClassTest.BaseClass1;

@Listeners(com.comCast.crm.listnerUtility.ListImplementation1.class)
public class createInvoice extends BaseClass1
{
	@Test
   public void createInvoiceTest()
   {
	   System.out.println("execute createinvoiceTest");
	  String actualtitle=driver.getTitle();
	  Assert.assertEquals(actualtitle,"login");
	   System.out.println("step1");
	   System.out.println("step2");
	   System.out.println("step3");
	   System.out.println("step4");
   }
   @Test
   public void createInvoicewithTest()
   {
	   System.out.println("execute createinvoiceTest with contact"); 
	   System.out.println("step1");
	   System.out.println("step2");
	   System.out.println("step3");
	   System.out.println("step4");
   }
}
