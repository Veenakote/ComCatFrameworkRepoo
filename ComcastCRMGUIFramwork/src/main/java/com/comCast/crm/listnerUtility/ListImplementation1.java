package com.comCast.crm.listnerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comCast.crm.BaseClassTest.BaseClass1;
import com.comCast.crm.generic.webDriverUtility.JavaUtility;
import com.comCast.crm.generic.webDriverUtility.UtilityClassOject;

public class ListImplementation1 implements ITestListener,ISuiteListener 
{
	public ExtentReports report;
	public ExtentSparkReporter spark;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report configuration");
		String time=new Date().toString().replace(" ", "_").replace(":"," ");
		//Spark Report config
		 spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suit Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add enviormrnt inforation and create test
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows-10");
		report.setSystemInfo("Browser","chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println("====>"+result.getMethod().getMethodName()+">===Start==");
		 test=report.createTest(result.getMethod().getMethodName());
		 UtilityClassOject.setTest(test);
		 test.log(Status.INFO,result.getMethod().getMethodName()+"=====>Started<=====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("====>"+result.getMethod().getMethodName()+">====Sucessfully executed =");
		test.log(Status.PASS,result.getMethod().getMethodName()+"=====>COMPLETED<=====");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testname=result.getMethod().getMethodName();
		
	/*	TakesScreenshot ts1=(TakesScreenshot)BaseClass1.sdriver;
		File src = ts1.getScreenshotAs(OutputType.FILE);
		String time=new Date().toString().replace(" ", "_").replace(":"," ");
		File dest = new File("./FailedTestScriptsScreenShots/"+testname+"+"+time+".png");
		result.getThrowable();
		
		try {
			FileHandler.copy(src, dest);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		TakesScreenshot ts=(TakesScreenshot)BaseClass1.sdriver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		
		String time=new Date().toString().replace(" ", "_").replace(":"," ");
		test.log(Status.FAIL,"Failed");
		test.addScreenCaptureFromBase64String(filepath, testname+"_"+time);
		test.log(Status.FAIL,result.getThrowable());
		test.log(Status.FAIL,result.getMethod().getMethodName()+"=====>FAILED<=====");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP,result.getMethod().getMethodName()+"=====>SKIPPED<=====");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}
