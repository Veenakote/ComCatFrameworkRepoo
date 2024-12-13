package com.comCast.crm.vendortest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comCast.crm.BaseClassTest.BaseClass1;
import com.comCast.crm.generic.fileUtility.IpathConstants;
import com.comCast.crm.objectRepository.Hompage;
import com.comCast.crm.objectRepository.craetedocumentPage;
import com.comCast.crm.objectRepository.documentPage;

@Listeners(com.comCast.crm.vendortest.TestNGlisters.class)
public class classA extends BaseClass1
{
	
	@Test(retryAnalyzer = imentingIretryAnalazer.class)
	public void method1() throws EncryptedDocumentException, IOException
	{
		String vendorname=elib.getDataFromExcel("product",1,2).toString()+randomint;
		WebElement morelink = driver.findElement(By.xpath("//a[text()='More']"));
        Actions act=new Actions(driver);
        act.moveToElement(morelink).click().perform();
        driver.findElement(By.cssSelector("a[name='Vendors']")).click();
        driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
        driver.findElement(By.name("vendorname")).sendKeys(vendorname);
        driver.findElement(By.xpath("//input[@title='Save [Alt+']")).click();
	}

}
