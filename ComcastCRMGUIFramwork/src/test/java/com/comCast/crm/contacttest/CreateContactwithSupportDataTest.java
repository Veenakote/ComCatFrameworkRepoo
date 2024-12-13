package com.comCast.crm.contacttest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comCast.crm.generic.fileUtility.ExcelUtility;
import com.comCast.crm.generic.fileUtility.FileUtility;
import com.comCast.crm.generic.webDriverUtility.JavaUtility;
import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;

public class CreateContactwithSupportDataTest {

	public static void main(String[] args) throws Exception 
	{
        /*craete object*/
		
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
			
		String lastname=elib.getDataFromExcel("contact",4,2)+randomint;
		
		
		//lanching browser
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

		// click on org link
		driver.findElement(By.linkText("Contacts")).click();
		//click in plus icon to create org
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		
		
		String startDate=jlib.getSystemDateyyyDDMM();
		String enddate=jlib.getRequiredDateYYYYDDMM(30);
		
		//org text filed
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		//supportstar date
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);
driver.findElement(By.name("support_end_date")).clear();
driver.findElement(By.name("support_end_date")).sendKeys(enddate);

//click on the save button
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

//verifly the drop down industries and type info
Thread.sleep(3000);

String actualastname=driver.findElement(By.id("dtlview_Last Name")).getText();



//verifly the satrt date
 String actualstartdate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
 if(actualstartdate.equals(startDate))
 {
	 System.out.println(startDate+"information is verified===pass");
 }
 else
 {
	 System.out.println(startDate+"information is  not verified===fail");
 }


//verifly the end date
 
 String actualenddate=driver.findElement(By.id("dtlview_Support End Date")).getText();
 if(actualenddate.equals(enddate))
 {
	 System.out.println(enddate+"information is verified===pass");
 }
 else
 {
	 System.out.println(enddate+"information is  not verified===fail");
 }

//log out
driver.quit();


	}

}
