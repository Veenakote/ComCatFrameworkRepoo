package com.comCast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;

public class morePage extends WebDriverUtility
{
	public morePage(WebDriver driver)
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@name='Vendors']")
	private WebElement vendorlink;
	public WebElement getVendorlink() {
		return vendorlink;
	}
}
