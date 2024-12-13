package com.comCast.crm.BaseClassTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comCast.crm.generic.dataBaseutility.DataBaseUtility;
import com.comCast.crm.generic.fileUtility.ExcelUtility;
import com.comCast.crm.generic.fileUtility.FileUtility;
import com.comCast.crm.generic.fileUtility.JsonUtility;
import com.comCast.crm.generic.webDriverUtility.JavaUtility;
import com.comCast.crm.generic.webDriverUtility.UtilityClassOject;
import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;
import com.comCast.crm.objectRepository.Hompage;
import com.comCast.crm.objectRepository.loginPage;

public class BaseClass1 
{
	public WebDriver driver=null;
	public DataBaseUtility dlib=new DataBaseUtility();
	public ExcelUtility elib=new ExcelUtility();
	public FileUtility flib=new FileUtility();
	public JsonUtility jsonlib=new JsonUtility();
	public JavaUtility jlib=new JavaUtility();
	public int randomint=jlib.getRandomNumber();
	public WebDriverUtility wlib=new WebDriverUtility();
	public static WebDriver sdriver;
	
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuitConfig() throws Exception
	{
		System.out.println("========Connecting to DB=============");
		dlib.getConnection();
		
		
	}
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	 public void beforeClassonfig(/*String browser*/) throws Exception
	 {
		//String BROWSER=browser;
		System.out.println("========Launching browser=============");
		String BROWSER=flib.getDataFromPropertiesFile("browser");
		
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		 sdriver=driver;
		 UtilityClassOject.setDriver(driver);
	 }
	@BeforeMethod(alwaysRun = true)
	public void beforemethod() throws Exception
	{
		String URL=flib.getDataFromPropertiesFile("url");
		driver.get(URL);
		driver.manage().window().maximize();
		wlib.waitForPageToLoad(driver);
		String USERNAME=flib.getDataFromPropertiesFile("username");
		String PASSWORD=flib.getDataFromPropertiesFile("password");
		System.out.println("========Login to application=============");
		loginPage lp=new loginPage(driver);
		lp.getUsernameEdt().sendKeys(USERNAME);
		lp.getPasswordEdt().sendKeys(PASSWORD);
		lp.getLoginBtn().click();	
	}
	@AfterMethod(alwaysRun = true)
	public void aftermethodConfig() throws Exception
	{
		System.out.println("Hiiiii");
		System.out.println("========Logout from the application=============");
		Hompage hp=new Hompage(driver);
		
		hp.signOut();

		Thread.sleep(2000);
		
	}
	@AfterClass(alwaysRun = true)
	public void afteClassConfig()
	{
		System.out.println("========close browser=============");
		driver.quit();
	}
	@AfterSuite(alwaysRun = true)
	public void afterSuit() throws Exception
	{
		System.out.println("========close DB Connection=============");
		dlib.CloseDbConnection();
		
	}

}
