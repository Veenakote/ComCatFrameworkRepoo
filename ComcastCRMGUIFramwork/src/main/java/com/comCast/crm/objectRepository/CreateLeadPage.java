package com.comCast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;
/*
 * This classs have leadpage details
 */
public class CreateLeadPage extends WebDriverUtility
{
	public CreateLeadPage(WebDriver driver)
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="lastname")
	private WebElement lastnametxtfield;
	
	@FindBy(name="company")
	private WebElement companynametxtfield;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBTn;

	public WebElement getLastnametxtfield() {
		return lastnametxtfield;
	}

	public WebElement getCompanynametxtfield() {
		return companynametxtfield;
	}

	public WebElement getSaveBTn() {
		return saveBTn;
	}
	
	public void craetelead(WebDriver driver,String lastname,String comapnyname)
	
	{
		LeadPage lp=new  LeadPage(driver);
		 lp.getCreateleadplusIcon().click();
		 CreateLeadPage clp=new CreateLeadPage(driver);
		 clp.getLastnametxtfield().sendKeys(lastname);
		 clp.getCompanynametxtfield().sendKeys(comapnyname);
		 clp.getSaveBTn().click();
	}
	
	
	
}
