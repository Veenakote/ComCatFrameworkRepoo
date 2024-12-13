package com.comCast.crm.Leadstest;

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
import org.testng.annotations.Test;

import com.comCast.crm.generic.fileUtility.ExcelUtility;
import com.comCast.crm.generic.fileUtility.FileUtility;
import com.comCast.crm.generic.webDriverUtility.JavaUtility;
import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;

public class CraeteLeadsTest {

	@Test
	public void craeteLeadsTest() throws Exception 
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
		
		String browser=fib.getDataFromPropertiesFile("browser");
		String url=fib.getDataFromPropertiesFile("url");
		String username=fib.getDataFromPropertiesFile("username");
		String password=fib.getDataFromPropertiesFile("password");
		String lastname=elib.getDataFromExcel("leads",1,3).toString()+randomint;
		String comapnyname=elib.getDataFromExcel("leads",1,4).toString()+randomint;
		//lanching browser
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//img[contains(@alt,'Create Lead...')]")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("company")).sendKeys(comapnyname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//verifly lastname
	String	actuallastname=driver.findElement(By.id("dtlview_Last Name")).getText();
	
	 if(actuallastname.equals(lastname))
	 {
		 System.out.println(lastname+"is created ==pass");
	 }
	 else
	 {
		 System.out.println(lastname+"is  not created ==fail");
	 }
		//verifly companyname
	String actualcompanyname=driver.findElement(By.id("dtlview_Company")).getText();
	 if(actualcompanyname.equals(comapnyname))
	 {
		 System.out.println(comapnyname+"is created ==pass");
	 }
	 else
	 {
		 System.out.println(comapnyname+"is  not created ==fail");
	 }
	
		

	}

}
