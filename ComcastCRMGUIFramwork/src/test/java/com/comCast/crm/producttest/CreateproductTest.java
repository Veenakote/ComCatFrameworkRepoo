package com.comCast.crm.producttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comCast.crm.generic.fileUtility.ExcelUtility;
import com.comCast.crm.generic.fileUtility.FileUtility;
import com.comCast.crm.generic.webDriverUtility.JavaUtility;
import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;

public class CreateproductTest {

	public static void main(String[] args) throws Exception 
	{
		
       /*create object*/
		
		FileUtility fib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		int randomint=jlib.getRandomNumber();
		WebDriverUtility wlib=new WebDriverUtility();
		
		
		WebDriver driver=driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		wlib.waitForPageToLoad(driver);
		//properties
	
		String browser=fib.getDataFromPropertiesFile("browser");
		String url=fib.getDataFromPropertiesFile("url");
		String username=fib.getDataFromPropertiesFile("username");
		String password=fib.getDataFromPropertiesFile("password");
		String productname=elib.getDataFromExcel("product",1,2).toString()+randomint;
		
		//lanching browser
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(productname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//verifly the product name
		 String actualproductname=driver.findElement(By.id("dtlview_Product Name")).getText();
		 if(actualproductname.equals(productname))
		 {
			 System.out.println(productname+"is created ==pass");
		 }
		 else
		 {
			 System.out.println(productname+"is  not created ==fail");
		 }
		 //verifly the header info
		 String headerinfo = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		 if(headerinfo.contains(productname))
		 {
			 System.out.println(productname+"is created ==pass");
		 }
		 else
		 {
			 System.out.println(productname+"is created ==fail");
		 }

	}

}
