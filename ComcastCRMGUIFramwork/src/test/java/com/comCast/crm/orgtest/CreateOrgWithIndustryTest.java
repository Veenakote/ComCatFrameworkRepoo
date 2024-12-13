package com.comCast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.comCast.crm.generic.fileUtility.ExcelUtility;
import com.comCast.crm.generic.fileUtility.FileUtility;
import com.comCast.crm.generic.webDriverUtility.JavaUtility;
import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;

public class CreateOrgWithIndustryTest {

	public static void main(String[] args) throws Exception 
	{
		
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
		String orgname=elib.getDataFromExcel("org",3,2)+randomint;
		String industry=elib.getDataFromExcel("org",3,3);
		String type=elib.getDataFromExcel("org",3,4);
		
		
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
		
		WebElement industryselectdropdown = driver.findElement(By.name("industry"));
		Select sel=new Select(industryselectdropdown);
		
		List<WebElement> industryoptions = sel.getOptions();
		for(WebElement insopt:industryoptions)
		{
			String exceptedinsdustry = insopt.getText();
			if(exceptedinsdustry.equals(industry))
			{
				insopt.click();
			}
		}
		
		System.out.println(type+"type");
		WebElement accounttypeselectdropdown = driver.findElement(By.cssSelector("select[name=\"accounttype\"]"));
		accounttypeselectdropdown.click();
		Thread.sleep(2000);
		Select sel1=new Select(accounttypeselectdropdown);
		
		sel1.selectByVisibleText(type);
		//wlib.selectByVisibleIndex(accounttypeselectdropdown, randomint)
		
		//click on the save button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verifly the drop down industries and type info
		Thread.sleep(3000);
		
		 String actualindustry=driver.findElement(By.id("mouseArea_Industry")).getText();
		 
		if(actualindustry.equals(industry))
		{
			System.out.println(industry+"industry is dropdown is verified===pass");
		}
		else
		{
			System.out.println(industry+"industry is dropdown is  not verified==fail");
		}
		//type drop down
		
		String actualtype=driver.findElement(By.id("dtlview_Type")).getText();
		
		if(actualtype.equals(type))
		{
			System.out.println(type+  "type dropdown is verified===pass");
		}
		else
		{
			System.out.println(type+  "type drop down is not is verified==fail");
		}
		//log out
		driver.quit();

	}

}
