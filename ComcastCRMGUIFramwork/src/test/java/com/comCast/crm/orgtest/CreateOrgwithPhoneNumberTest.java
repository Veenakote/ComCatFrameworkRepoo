package com.comCast.crm.orgtest;

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

public class CreateOrgwithPhoneNumberTest {

	public static void main(String[] args) throws Exception 
	{
		FileUtility fib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		int randomint=jlib.getRandomNumber();
		WebDriverUtility wlib=new WebDriverUtility();
		
		
		WebDriver driver=driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wlib.waitForPageToLoad(driver);
		
		String browser=fib.getDataFromPropertiesFile("browser");
		String url=fib.getDataFromPropertiesFile("url");
		String username=fib.getDataFromPropertiesFile("username");
		String password=fib.getDataFromPropertiesFile("password");
		String orgname=elib.getDataFromExcel("org",5,2)+randomint;
		String phonenumber=elib.getDataFromExcel("org",5,3);
		
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
		
		//phone number
		driver.findElement(By.id("phone")).sendKeys(phonenumber);
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
		
		//verifly phone number info
		String actualphonenumber=driver.findElement(By.id("dtlview_Phone")).getText();
		if(actualphonenumber.equals(phonenumber))
		{
			System.out.println(phonenumber+"is verified  ==pass");
		}
		
		else
		{
			System.out.println(phonenumber+"is not verifield ==fail");
		}
		
		//logout
		driver.quit();

	}

}
