package com.comCast.crm.BaseClassTest;

import java.time.Duration;

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

import com.comCast.crm.generic.dataBaseutility.DataBaseUtility;
import com.comCast.crm.generic.fileUtility.ExcelUtility;
import com.comCast.crm.generic.fileUtility.FileUtility;
import com.comCast.crm.generic.webDriverUtility.JavaUtility;
import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;
import com.comCast.crm.objectRepository.Hompage;
import com.comCast.crm.objectRepository.loginPage;

public class BaseClass
{
	public WebDriver driver=null;
	public FileUtility fib=new FileUtility();
	public ExcelUtility elib=new ExcelUtility();
	public JavaUtility jlib=new JavaUtility();
	public int randomint=jlib.getRandomNumber();
	public WebDriverUtility wlib=new WebDriverUtility();
	
	
	
	//creation of object
	public DataBaseUtility dblib=new DataBaseUtility();
	public FileUtility flib=new FileUtility();
	
	
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Exception
	{
		System.out.println("=====Connect to DB  Repot config=======");
		dblib.getConnection();
		
	}
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configBC() throws Exception
	{
		System.out.println("Launch the browser");
		String BROWSER=flib.getDataFromPropertiesFile("browser");
		//String BROWSER=browser;
		System.out.println(BROWSER);
		
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
		
		
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Exception
	{
		String URL=flib.getDataFromPropertiesFile("url");
		driver.get(URL);
		driver.manage().window().maximize();
		wlib.waitForPageToLoad(driver);
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		//String BROWSER=flib.getDataFromPropertiesFile("browser");
		//String URL=flib.getDataFromPropertiesFile("url");
		//driver.get(URL);
		//Thread.sleep(2000);
		
		String USERNAME=flib.getDataFromPropertiesFile("username");
		String PASSWORD=flib.getDataFromPropertiesFile("password");
		System.out.println("login to application");
		//lp.loginToApp(URL, USERNAME, PASSWORD);
		loginPage lp=new loginPage(driver);
		lp.getUsernameEdt().sendKeys(USERNAME);
		lp.getPasswordEdt().sendKeys(PASSWORD);
		lp.getLoginBtn().click();		
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void configAM() throws Exception
	{
		System.out.println("Logout from application");
		Hompage hp=new Hompage(driver);
		//Thread.sleep(2000);
		hp.signOut();
		Thread.sleep(2000);
		System.out.println("========================");
	}
	
	
	
	
	
	@AfterClass(alwaysRun = true)
	public void configAC() throws Exception
	{
		System.out.println("close the browser");
		driver.quit();
		
	}
	
	@AfterSuite(alwaysRun = true)
	public void configAS() throws Exception
	{
		System.out.println("======Close DB ,Report BakUp=======");
		dblib.CloseDbConnection();
	}
}
