package com.comCast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;
/*
 * This class have createvendoe paeg
 */
public class createVendorPage extends WebDriverUtility
{
	public createVendorPage(WebDriver driver)
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="vendorname")
	private WebElement vendornameTextFild;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getVendornameTextFild() {
		return vendornameTextFild;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createvendor(WebDriver driver,String vendorname)
	{
		createVendorPage cp=new createVendorPage(driver);
		vendorPage vp=new vendorPage(driver);
		vp.getCreatevendorplusIcon().click();
		cp.getVendornameTextFild().sendKeys(vendorname);
		cp.getSaveBtn().click();
	}
}
