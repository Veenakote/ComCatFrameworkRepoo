package com.comCast.crm.documentstest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
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
import org.openqa.selenium.interactions.Actions;

import com.comCast.crm.generic.fileUtility.ExcelUtility;
import com.comCast.crm.generic.fileUtility.FileUtility;
import com.comCast.crm.generic.fileUtility.IpathConstants;
import com.comCast.crm.generic.webDriverUtility.JavaUtility;
import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;

public class DocumentsFileupload {

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
		String tiltename=elib.getDataFromExcel("documents",1,2)+randomint;
		String filepath=elib.getDataFromExcel("documents",1,3).toString();
		//lanching browser
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Documents']")).click();
		driver.findElement(By.xpath("//img[@title='Create Document...']")).click();
		driver.findElement(By.name("notes_title")).sendKeys(tiltename);
		WebElement choosefile = driver.findElement(By.id("filename_I__"));
		
		wlib.mouseOverActionOrMoveToElement(driver, choosefile);
		
		
		choosefile.sendKeys(IpathConstants.upload_filepath);
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				//verifly title
				String actualtitle = driver.findElement(By.id("dtlview_Title")).getText();
				if(actualtitle.equals(tiltename))
				{
					System.out.println(tiltename+"is verifed====pass");
				}
				else
				{
					System.out.println(tiltename+"is  not verifed====fail");
				}
				
				
				//verfily file name
				String actualfile=driver.findElement(By.xpath("//td[@class='dvtCellInfo']/a")).getText();
				System.out.println("actualfile is:"+actualfile);
				if(filepath.contains(actualfile))
				{
					System.out.println(filepath+"is verifed====pass");
				}
				else
				{
					System.out.println(filepath+"is  not verifed====fail");
				}
				

	}

}
