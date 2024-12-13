package com.comCast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comCast.crm.BaseClassTest.BaseClass;
import com.comCast.crm.generic.webDriverUtility.UtilityClassOject;
import com.comCast.crm.objectRepository.Hompage;
import com.comCast.crm.objectRepository.craeteNewOrganazationPage;
import com.comCast.crm.objectRepository.loginPage;
import com.comCast.crm.objectRepository.organazationInfopage;
import com.comCast.crm.objectRepository.organazationpage;

@Listeners(com.comCast.crm.listnerUtility.ListImplementation1.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups ="smokeTest",retryAnalyzer = com.comCast.crm.listnerUtility.RetryListnerImp.class)
	public void createOrganazationTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		
		String orgname = elib.getDataFromExcel("org", 1, 1) + randomint;
		UtilityClassOject.getTest().log(Status.INFO,"read the OrgNamedata from the excel ");
		Hompage hp = new Hompage(driver);
		hp.getOrgNameLink().click();
		UtilityClassOject.getTest().log(Status.INFO,"Clicked on the Organazation link in Home Page ");
		organazationpage op = new organazationpage(driver);
		op.getPlusIconForcreateorgName().click();
		UtilityClassOject.getTest().log(Status.INFO,"Clicked on the OrganazationPLusIcon");
		craeteNewOrganazationPage cop = new craeteNewOrganazationPage(driver);

		cop.createOrgName(orgname);
		UtilityClassOject.getTest().log(Status.INFO,"Organazation has Created Successfully");
		
		System.out.println(orgname + " " + driver.getTitle());
		System.out.println("Actual value:" + driver.findElement(By.id("mouseArea_Organization Name")).getText());
		
		String actualheaderinfo = driver.findElement(By.id("dtlview_Organization Name")).getText();
		
		SoftAssert sft=new SoftAssert();
		sft.assertEquals(orgname,actualheaderinfo);
		UtilityClassOject.getTest().log(Status.PASS,"Verifiled Organazation header information");
		Thread.sleep(1000);
		String actualorgname = driver.findElement(By.id("dtlview_Organization Name")).getText();
		Assert.assertEquals(actualorgname, orgname);
		UtilityClassOject.getTest().log(Status.PASS,"Verifiled Organazation information");
	}
    
	@Test(groups ="regressionTest",retryAnalyzer = com.comCast.crm.listnerUtility.RetryListnerImp.class)
	public void createOrgWithIndustry() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String orgname=elib.getDataFromExcel("org",3,2)+randomint;
		UtilityClassOject.getTest().log(Status.INFO,"Reading the Orgname from excel");
		String industry=elib.getDataFromExcel("org",3,3);
		UtilityClassOject.getTest().log(Status.INFO,"Reading the IndustryName from excel");
		String type=elib.getDataFromExcel("org",3,4);
		UtilityClassOject.getTest().log(Status.PASS,"Reading the type from excel");
		
		Hompage hp = new Hompage(driver);
		hp.getOrgNameLink().click();
		UtilityClassOject.getTest().log(Status.INFO,"Clicked on the organazation libnk in the Home page");
		organazationpage op = new organazationpage(driver);
		op.getPlusIconForcreateorgName().click();
		UtilityClassOject.getTest().log(Status.INFO,"Clicked on the Organation PlusIcon");
		craeteNewOrganazationPage cop = new craeteNewOrganazationPage(driver);
		cop.createOrgName(orgname, industry, type);
		UtilityClassOject.getTest().log(Status.INFO,"Organazation has created with industryand type");
		Thread.sleep(3000);
		
		
		 organazationInfopage oip=new organazationInfopage(driver);
		 String actualindustry=oip.getVeriflyindustry().getText();
		 
		 Assert.assertEquals(actualindustry, industry);
		 UtilityClassOject.getTest().log(Status.PASS,"Verified industry");
		//type drop down
		 String actualtype=oip.getVeriflyindustryType().getText();
		
		Assert.assertEquals(actualtype, type);
		
		UtilityClassOject.getTest().log(Status.PASS,"Verified type");
	}
	
	@Test(groups ="regressionTest",retryAnalyzer = com.comCast.crm.listnerUtility.RetryListnerImp.class)
	public void createOrgWithPhnumber() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String orgname=elib.getDataFromExcel("org",5,2)+randomint;
		UtilityClassOject.getTest().log(Status.INFO,"reading the Orgname from excel");
		String phonenumber=elib.getDataFromExcel("org",5,3);
		UtilityClassOject.getTest().log(Status.INFO,"reading the Phonumber from excel");
		Hompage hp = new Hompage(driver);
		hp.getOrgNameLink().click();
		UtilityClassOject.getTest().log(Status.INFO,"Clicked on the Orglink in the home page");
		organazationpage op = new organazationpage(driver);
		op.getPlusIconForcreateorgName().click();
		UtilityClassOject.getTest().log(Status.INFO,"Clicked on the create orgnamePlusIcon");
		craeteNewOrganazationPage cop = new craeteNewOrganazationPage(driver);
		cop.createOrgName(orgname, phonenumber);
		Thread.sleep(5000);
		UtilityClassOject.getTest().log(Status.INFO,"Orgnazation has created successfully");
		//verifly the excepted message
		organazationInfopage oip=new organazationInfopage(driver);
		String actualheaderinfo=oip.getVeriflyHeaderInfo().getText();
		boolean status=actualheaderinfo.contains(orgname);
		Assert.assertEquals(status, true);
		UtilityClassOject.getTest().log(Status.PASS,"Verified OrgnazationHeader");
				
				
				//verifly phone number info
		String actualphonenumber=oip.getVeriflyphonenumber().getText();
				
				SoftAssert soft=new SoftAssert();
				soft.assertEquals(actualphonenumber, phonenumber);
				UtilityClassOject.getTest().log(Status.PASS,"Verified phonenumber");
				
		

	}
}
