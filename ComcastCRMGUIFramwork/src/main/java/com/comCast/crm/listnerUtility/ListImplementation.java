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





public class ListImplementation implements ITestListener,ISuiteListener 
{
	public ExtentReports report;
	public ExtentSparkReporter spark;
	

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report configuration");
		String time=new Date().toString().replace(" ", "_").replace(":"," ");
		//Spark Report config
		 spark=new ExtentSparkReporter("./AdvanceReport/report"+time+".html");
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
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("====>"+result.getMethod().getMethodName()+">====Sucessfully executed =");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testname=result.getMethod().getMethodName();
		
		TakesScreenshot ts1=(TakesScreenshot)BaseClass1.sdriver;
		File src = ts1.getScreenshotAs(OutputType.FILE);
		String time=new Date().toString().replace(" ", "_").replace(":"," ");
		File dest = new File("./FailedTestScriptsScreenShots/"+testname+"+"+time+".png");
		result.getThrowable();
		
		try {
			FileHandler.copy(src, dest);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result.getName() + " Test case is fail");
		TakesScreenshot ts=(TakesScreenshot)BaseClass1.sdriver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test=report.createTest(result.getMethod().getMethodName());
		test.log(Status.FAIL,"Failed");
		test.addScreenCaptureFromBase64String(filepath, "errorFile");
		test.log(Status.FAIL,result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
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
