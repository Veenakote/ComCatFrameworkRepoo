package com.comCast.crm.documentstest;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class SampleReoptTest 
{
	public ExtentReports report;
	@BeforeSuite
	public void configBS()
	{
		//Spark Report config
		String time=new Date().toString().replace(" ", "_").replace(":"," ");
				ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report"+time+".html");
				spark.config().setDocumentTitle("CRM Test Suit Results"+time);
				spark.config().setReportName("CRM Report");
				spark.config().setTheme(Theme.DARK);
				
				//add enviormrnt inforation and create test
				 report=new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("OS","Windows-10");
				report.setSystemInfo("Browser","chrome");
	}
	@AfterSuite
	public void configAS()
	{
		report.flush();
	}
	
	@Test
 public void createContactTest()
 {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888"); 
		TakesScreenshot ts=(TakesScreenshot)driver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		
		
		ExtentTest test=report.createTest("createContactTest");
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page ");
		test.log(Status.INFO,"craete contact");
		if("HgDFC".equals("HDFC"))
		{
			test.log(Status.PASS,"contact is created");
		}
		else
		{
			test.addScreenCaptureFromBase64String(filepath, "errorFile");
		}
		driver.close();
 }	
	@Test
		public void createContactWithOrg()
		{
ExtentTest test=report.createTest("createContactWithOrg");
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page ");
		test.log(Status.INFO,"craete contact");
		if("HDFC".equals("HDFC"))
		{
			test.log(Status.PASS,"contact is created");
		}
		else
		{
			test.log(Status.FAIL,"contact is  not created");
		}
		
	}
	@Test
	public void createContactWithPhoneNumber()
	{
ExtentTest test=report.createTest("createContactWithPhoneNumber");
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page ");
		test.log(Status.INFO,"craete contact");
		if("HDFC".equals("HFC"))
		{
			test.log(Status.PASS,"contact is created");
		}
		else
		{
			test.log(Status.FAIL,"contact is  not created");
		}
	}	
	
	 
 
}
