package com.comCast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comCast.crm.BaseClassTest.BaseClass;
import com.comCast.crm.BaseClassTest.BaseClass1;
import com.comCast.crm.generic.fileUtility.ExcelUtility;
import com.comCast.crm.generic.fileUtility.FileUtility;
import com.comCast.crm.generic.webDriverUtility.JavaUtility;
import com.comCast.crm.generic.webDriverUtility.UtilityClassOject;
import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;
import com.comCast.crm.listnerUtility.ListImplementation1;
import com.comCast.crm.objectRepository.Hompage;
import com.comCast.crm.objectRepository.contactInfoPage;
import com.comCast.crm.objectRepository.contactPage;
import com.comCast.crm.objectRepository.craeteContactPage;
import com.comCast.crm.objectRepository.craeteNewOrganazationPage;
import com.comCast.crm.objectRepository.organazationInfopage;
import com.comCast.crm.objectRepository.organazationPopUpPage;
import com.comCast.crm.objectRepository.organazationpage;

@Listeners(com.comCast.crm.listnerUtility.ListImplementation1.class)
/**
 * @author Veena K S
 */

public class CreateContactPractiseTest extends BaseClass1 {
	/**
	 * @author Veena K S
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(groups ="smokeTest",retryAnalyzer = com.comCast.crm.listnerUtility.RetryListnerImp.class)
	public void createcontactTest() throws EncryptedDocumentException, IOException, InterruptedException {
		//ListImplementation1.test.log(Status.INFO,"read the data from excel");
		UtilityClassOject.getTest().log(Status.INFO,"Read the data from excel");
		String lastname = elib.getDataFromExcel("contact", 1, 2) + randomint;

		// click on org link
		UtilityClassOject.getTest().log(Status.INFO,"Click on ContactInfo");
		Hompage hp = new Hompage(driver);
		hp.getContactLink().click();
		UtilityClassOject.getTest().log(Status.INFO,"Click on Craete ContactPlus Icon");
		contactPage cp = new contactPage(driver);
		cp.getCraeteContactIcon().click();
		
		craeteContactPage ccp = new craeteContactPage(driver);
		ccp.createContact(lastname);
		UtilityClassOject.getTest().log(Status.INFO,"Entered Last Name in TextField");
		String actualastname = driver.findElement(By.id("dtlview_Last Name")).getText();
		contactInfoPage cip=new contactInfoPage(driver);
		String actuallastname=cip.getActualLastName().getText();

		UtilityClassOject.getTest().log(Status.INFO,"Verifield Last Name in TextField");

		Assert.assertEquals(actualastname, lastname);


	}
	/**
	 * @author Veena K S
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(groups ="regressionTest",retryAnalyzer = com.comCast.crm.listnerUtility.RetryListnerImp.class)
	public void createContactWithSupportDate() throws EncryptedDocumentException, IOException, InterruptedException
	{
		UtilityClassOject.getTest().log(Status.INFO,"Read the data from excel");
		String lastname=elib.getDataFromExcel("contact",4,2)+randomint;
		String startDate=jlib.getSystemDateyyyDDMM();
		String enddate=jlib.getRequiredDateYYYYDDMM(30);
		Hompage hp = new Hompage(driver);
		hp.getContactLink().click();

		UtilityClassOject.getTest().log(Status.INFO,"Clicked on the contactLink in Home Module");
		contactPage cp = new contactPage(driver);
		cp.getCraeteContactIcon().click();
		UtilityClassOject.getTest().log(Status.INFO,"Clicked on the CreateContactOlusIcon");
		craeteContactPage ccp = new craeteContactPage(driver);
		ccp.createcontact(lastname,startDate,enddate);
		UtilityClassOject.getTest().log(Status.INFO,"Contact has been Created");
		Thread.sleep(3000);
		contactInfoPage cip=new contactInfoPage(driver);

		//verifly the satrt date
		String actualstartdate=cip.getActualSupportStartdate().getText();

		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actualstartdate, startDate);
		UtilityClassOject.getTest().log(Status.PASS,"Verified Startdate");
		String actualenddate=cip.getActualSupporEndtdate().getText();

		SoftAssert soft1=new SoftAssert();
		soft1.assertEquals(actualenddate, enddate);

		UtilityClassOject.getTest().log(Status.PASS,"Verified Enddate");

	}
	/**
	 * @author Veena K S
	 * @throws InterruptedException
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	@Test(groups ="regressionTest",retryAnalyzer = com.comCast.crm.listnerUtility.RetryListnerImp.class)
	public void createContactWithOrg() throws InterruptedException, EncryptedDocumentException, IOException
	{
		UtilityClassOject.getTest().log(Status.INFO,"Reading the OrgName From excel");
		String orgname=elib.getDataFromExcel("contact",7,2)+randomint;
		UtilityClassOject.getTest().log(Status.INFO,"Reading the OrgName From excel");
		String contactname=elib.getDataFromExcel("contact",7,3)+randomint;
		UtilityClassOject.getTest().log(Status.INFO,"Reading the ContactName From excel");



		Hompage hp=new Hompage(driver);
		hp.getOrgNameLink().click();
		UtilityClassOject.getTest().log(Status.INFO,"Clicked on the Organazation link in home page");
		organazationpage op=new organazationpage(driver);
		op.getPlusIconForcreateorgName().click();
		UtilityClassOject.getTest().log(Status.INFO,"Clicked on the craete Organazation plusIcon");
		craeteNewOrganazationPage cop=new craeteNewOrganazationPage(driver);

		cop.createOrgName(orgname);

		//verifly the drop down industries and type info
		Thread.sleep(3000);
		hp.getContactLink().click();
		UtilityClassOject.getTest().log(Status.INFO,"Clicked on the craete contact link");
		contactPage cp = new contactPage(driver);
		cp.getCraeteContactIcon().click();
		UtilityClassOject.getTest().log(Status.INFO,"Clicked on the craete contact plusIcon");
		Thread.sleep(2000);
		craeteContactPage ccp = new craeteContactPage(driver);

		ccp.getLastNameTextField().sendKeys(contactname);
		UtilityClassOject.getTest().log(Status.INFO,"Entered text in the last name TextField");

		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();

		String parentid = driver.getWindowHandle();
		organazationPopUpPage oop=new organazationPopUpPage(driver);
		
		Thread.sleep(2000);

		wlib.switchToTabOnURL(driver, "Accounts&action");
		UtilityClassOject.getTest().log(Status.INFO,"Switching to parent Organazation pop up");
		oop.getSearchtextfield().sendKeys(orgname);
		UtilityClassOject.getTest().log(Status.INFO,"Entered OrgName in the searchTextFiled in orgName pop up");
		oop.getSearchbutton().click();
		UtilityClassOject.getTest().log(Status.INFO,"Clicked searchButton in orgName pop up");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		UtilityClassOject.getTest().log(Status.INFO,"Slected Orgname in orgName pop up");
		wlib.switchToTabOnURL(driver,"Contacts&action");
		UtilityClassOject.getTest().log(Status.INFO,"Switching back to parent contact page");
		ccp.getSaveBtn().click();
		UtilityClassOject.getTest().log(Status.INFO,"Clicked on the save button in the create contact page ");
		Thread.sleep(3000);
		//
		//verifly org name info
		String actualorgname=driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println("actualorgname"+actualorgname.trim());
		System.out.println("orgname"+orgname);
		Assert.assertEquals(actualorgname.trim(),orgname);
		UtilityClassOject.getTest().log(Status.PASS,"Verified OrgName");



	}

}
