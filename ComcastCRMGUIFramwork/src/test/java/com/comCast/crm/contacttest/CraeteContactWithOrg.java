package com.comCast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class CraeteContactWithOrg {

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
		
		
		
		String browser=fib.getDataFromPropertiesFile("browser");
		String url=fib.getDataFromPropertiesFile("url");
		String username=fib.getDataFromPropertiesFile("username");
		String password=fib.getDataFromPropertiesFile("password");
		String orgname=elib.getDataFromExcel("contact",7,2)+randomint;
		String contactname=elib.getDataFromExcel("contact",7,3)+randomint;
		//lanching browser
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		// click on org link
		driver.findElement(By.linkText("Organizations")).click();
		//click in plus icon to create org
		driver.findElement(By.xpath("//img[contains(@title,'Cr')]")).click();
		//org text filed
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		//click on the save button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verifly the excepted message
		String headerdinfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerdinfo.contains(orgname))
		{
			System.out.println(orgname+"is created ==pass");
		}
		else
		{
			System.out.println(orgname+"is not created ==fail");
		}
		
		
	      //navigate contact module
		
				driver.findElement(By.linkText("Contacts")).click();
				//click in plus icon to create org
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				//org text filed
				driver.findElement(By.name("lastname")).sendKeys(contactname);
				
				//org + need click
				driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
			
				wlib.switchToTabOnURL(driver, "module=Accounts");
				driver.findElement(By.id("search_txt")).sendKeys(orgname);
				driver.findElement(By.name("search")).click();
				//dynamic xpath 
				driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
				
				
				
				wlib.switchToTabOnURL(driver,"Contacts&action");
				
				//click on the save button
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				//
				//verifly org name info
				String actualorgname=driver.findElement(By.id("mouseArea_Organization Name")).getText();
				if(actualorgname.contains(orgname))
				{
					System.out.println(orgname+"orgname is verified  ==pass");
				}
				
				else
				{
					System.out.println(orgname+"orgname is not verifield ==fail");
				}
		
		//logout
		driver.quit();
	}

}
