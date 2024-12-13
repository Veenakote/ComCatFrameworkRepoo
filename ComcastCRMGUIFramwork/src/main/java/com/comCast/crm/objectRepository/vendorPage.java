package com.comCast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;

public class vendorPage extends WebDriverUtility
{
	public vendorPage(WebDriver driver)
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@title='Create Vendor...']")
	private WebElement createvendorplusIcon;
	public WebElement getCreatevendorplusIcon() {
		return createvendorplusIcon;
	}
}
