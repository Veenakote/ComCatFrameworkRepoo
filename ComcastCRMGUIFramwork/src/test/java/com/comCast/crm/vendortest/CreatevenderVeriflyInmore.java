package com.comCast.crm.vendortest;

import java.io.FileInputStream;


import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.comCast.crm.generic.fileUtility.ExcelUtility;
import com.comCast.crm.generic.fileUtility.FileUtility;
import com.comCast.crm.generic.webDriverUtility.JavaUtility;
import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;

public class CreatevenderVeriflyInmore {

	public static void main(String[] args) throws Exception 
	{
       /*create object*/
		
		FileUtility fib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		int randomint=jlib.getRandomNumber();
		WebDriverUtility wlib=new WebDriverUtility();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		wlib.waitForPageToLoad(driver);
		
		
		String browser=fib.getDataFromPropertiesFile("browser");
		String url=fib.getDataFromPropertiesFile("url");
		String username=fib.getDataFromPropertiesFile("username");
		String password=fib.getDataFromPropertiesFile("password");
		String vendorname=elib.getDataFromExcel("product",1,2).toString()+randomint;
        driver.get(url);
        driver.findElement(By.name("user_name")).sendKeys(username);
        driver.findElement(By.name("user_password")).sendKeys(password);
        driver.findElement(By.id("submitButton")).click();
        WebElement morelink = driver.findElement(By.xpath("//a[text()='More']"));
        Actions act=new Actions(driver);
        act.moveToElement(morelink).click().perform();
        driver.findElement(By.cssSelector("a[name='Vendors']")).click();
        driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
        driver.findElement(By.name("vendorname")).sendKeys(vendorname);
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
        
        //verifly vendor name 
        
      String  actualvendorname=driver.findElement(By.id("dtlview_Vendor Name")).getText();
      if(actualvendorname.equals(vendorname))
      {
    	  System.out.println(vendorname+"vendorname is verifield=====pass");
      }
      else
      {
    	  System.out.println(vendorname+"vendorname is not verifield=====fail"); 
      }
        
		String headerinfo=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(headerinfo.contains(vendorname))
		{
			System.out.println(vendorname+"vendor name header is verified===pass");
		}
		else
		{
			System.out.println(vendorname+"vendor name header is not verified===fail");
		}
		

	}

}
