package com.comCast.crm.documentstest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comCast.crm.BaseClassTest.BaseClass;
import com.comCast.crm.BaseClassTest.BaseClass1;
import com.comCast.crm.generic.fileUtility.IpathConstants;
import com.comCast.crm.generic.webDriverUtility.UtilityClassOject;
import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;
import com.comCast.crm.objectRepository.CreateLeadPage;
import com.comCast.crm.objectRepository.Hompage;
import com.comCast.crm.objectRepository.LeadPage;
import com.comCast.crm.objectRepository.ProductInfoPage;
import com.comCast.crm.objectRepository.VendorInfoPage;
import com.comCast.crm.objectRepository.craetedocumentPage;
import com.comCast.crm.objectRepository.createVendorPage;
import com.comCast.crm.objectRepository.createproductPage;
import com.comCast.crm.objectRepository.documentPage;
import com.comCast.crm.objectRepository.doumentsInfoPage;
import com.comCast.crm.objectRepository.leadInfoPage;
import com.comCast.crm.objectRepository.morePage;
import com.comCast.crm.objectRepository.productpage;
@Listeners(com.comCast.crm.listnerUtility.ListImplementation1.class)
public class testscripts extends BaseClass1 
{
 @Test(retryAnalyzer = com.comCast.crm.listnerUtility.RetryListnerImp.class)
 public void createdocuments() throws EncryptedDocumentException, IOException
 {
	 String tiltename=elib.getDataFromExcel("documents",1,2)+randomint;
	 UtilityClassOject.getTest().log(Status.INFO,"reading the Tilte name from excel");
		String filepath=elib.getDataFromExcel("documents",1,3).toString();
		UtilityClassOject.getTest().log(Status.INFO,"reading the file path from excel");
		Hompage hp=new Hompage(driver);
		hp.getDocumentLink().click();
		UtilityClassOject.getTest().log(Status.INFO,"Clicked on the Documentlink in the home page");
		documentPage dp=new documentPage(driver);
		
		UtilityClassOject.getTest().log(Status.INFO,"Clicked on the createDocumentPlusIcon ");
		craetedocumentPage cp=new craetedocumentPage(driver);
		cp.getTitletextfield().sendKeys(tiltename);
		UtilityClassOject.getTest().log(Status.INFO,"Entered text in title textfield");
		wlib.mouseOverActionOrMoveToElement(driver,cp.getChoosefileBTn());
		cp.getChoosefileBTn().sendKeys(IpathConstants.upload_filepath);
		UtilityClassOject.getTest().log(Status.INFO,"clicked on the choose file button");
		cp.getSaveBTn().click();
		UtilityClassOject.getTest().log(Status.INFO,"Clicke on the save button ");
		//verifly title
		
		doumentsInfoPage dip=new doumentsInfoPage(driver);
		String actualtitle=dip.getVeriflydocTitle().getText();
		SoftAssert sft=new SoftAssert();
		sft.assertEquals(actualtitle,tiltename);
		
		UtilityClassOject.getTest().log(Status.PASS,"Title name is verified");
		//verfily file name
		
		String actualfile=driver.findElement(By.xpath("//td[@class='dvtCellInfo']/a")).getText();
		SoftAssert sft1=new SoftAssert();
		sft1.assertEquals(actualfile,filepath);
		UtilityClassOject.getTest().log(Status.PASS,"filepath name is verified");
		
		
 }
 
 
 @Test(retryAnalyzer = com.comCast.crm.listnerUtility.RetryListnerImp.class)
 public void craeteleads() throws Throwable, IOException
 {
	 String lastname=elib.getDataFromExcel("leads",1,3).toString()+randomint;
	 UtilityClassOject.getTest().log(Status.INFO,"reading the lead name from excel");
		String comapnyname=elib.getDataFromExcel("leads",1,4).toString()+randomint;
		UtilityClassOject.getTest().log(Status.INFO,"reading the company name from excel");
		Hompage hp=new Hompage(driver);
		hp.getLeadsLink().click();
		UtilityClassOject.getTest().log(Status.INFO,"Clicke on the lead link in the home page");
		CreateLeadPage clp=new CreateLeadPage(driver);
		clp.craetelead(driver, lastname, comapnyname);
		UtilityClassOject.getTest().log(Status.INFO,"lead is created successfully");
		//verifly lastname
		leadInfoPage lip=new leadInfoPage(driver);
		String	actuallastname=lip.getVeriflyactualLastName().getText();
		
		Assert.assertEquals(actuallastname, lastname);
		UtilityClassOject.getTest().log(Status.PASS,"last name is verified");
			//verifly companyname
		String actualcompanyname=lip.getVeriflyactualCompanyName().getText();
		
		Assert.assertEquals(actualcompanyname,comapnyname);
		UtilityClassOject.getTest().log(Status.PASS,"company name is verified");
 }
 @Test(retryAnalyzer = com.comCast.crm.listnerUtility.RetryListnerImp.class)
 public void createproduct() throws EncryptedDocumentException, IOException
 {
	 String productname=elib.getDataFromExcel("product",1,2).toString()+randomint;
	 UtilityClassOject.getTest().log(Status.INFO,"reading the product name from excel");
	 Hompage hp=new Hompage(driver);
	 hp.getProductLink().click();
	 UtilityClassOject.getTest().log(Status.INFO,"Clicked on the product link in the home page");
	 productpage pg=new productpage(driver);
	 pg.getCreateproductplusIcon().click();
	 UtilityClassOject.getTest().log(Status.INFO,"Click don the craete productplusIcon");
	 createproductPage ccp=new createproductPage(driver);
	 ccp.createproduct(driver, productname);
	 UtilityClassOject.getTest().log(Status.INFO,"product is created successfully");

	//verifly the product name
	 ProductInfoPage pip=new ProductInfoPage(driver);
	 String actualproductname=pip.getVeriflyactualProductName().getText();
	// String actualproductname=driver.findElement(By.id("dtlview_Product Name")).getText();
	 Assert.assertEquals(actualproductname,productname);
	 UtilityClassOject.getTest().log(Status.PASS,"Verified productname ");

	 //verifly the header info
	 String headerinfo =pip.getVeriflyactualheaderInfo().getText();
	 boolean status = headerinfo.contains(productname);
	 Assert.assertEquals(status,true);
	 UtilityClassOject.getTest().log(Status.PASS,"Verified headerInfo of product ");

	 
 }
 
 @Test(retryAnalyzer = com.comCast.crm.listnerUtility.RetryListnerImp.class)
 public void createvendor() throws EncryptedDocumentException, IOException, InterruptedException
 {
	 String vendorname=elib.getDataFromExcel("product",1,2).toString()+randomint;
	 UtilityClassOject.getTest().log(Status.INFO,"reading the vendor name from excel");
	 Hompage hp=new Hompage(driver);
	 hp.getMoreLink().click();
	 UtilityClassOject.getTest().log(Status.INFO,"Cliked on the More link on the home page");
	 morePage mp=new morePage(driver);
	 wlib.waitForPageToLoad(driver);
	 Thread.sleep(3000);
	 wlib.mouseOverActionOrMoveToElementclick(driver,mp.getVendorlink());
	 UtilityClassOject.getTest().log(Status.INFO,"Cliked on the Vendor link ");
	// mp.getVendorlink().click();
	 wlib.waitForPageToLoad(driver);
	 createVendorPage cp=new createVendorPage(driver);
	 cp.createvendor(driver, vendorname);
	 UtilityClassOject.getTest().log(Status.INFO,"Vendor name is created successfully");
	//verifly vendor name 
	 VendorInfoPage vip=new VendorInfoPage(driver);
	 String  actualvendorname= vip.getVeriflyactualVendorName().getText();
     //String  actualvendorname=driver.findElement(By.id("dtlview_Vendor Name")).getText();
     Assert.assertEquals(actualvendorname,vendorname);
     UtilityClassOject.getTest().log(Status.PASS,"Verified Vendor name");
     String headerinfo=vip.getVeriflyactualHeaderInfo().getText();
     boolean status = headerinfo.contains(vendorname);
     Assert.assertEquals(status, true);
     UtilityClassOject.getTest().log(Status.PASS,"Verified headerInfoVendor name");
		
 }
 
}
