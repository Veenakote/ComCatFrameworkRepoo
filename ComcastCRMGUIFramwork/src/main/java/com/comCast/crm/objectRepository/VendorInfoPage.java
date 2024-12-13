package com.comCast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;

public class VendorInfoPage extends WebDriverUtility
{
	public VendorInfoPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="dtlview_Vendor Name")
	private WebElement veriflyactualVendorName;
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement veriflyactualHeaderInfo;
	public WebElement getVeriflyactualVendorName() {
		return veriflyactualVendorName;
	}
	public WebElement getVeriflyactualHeaderInfo() {
		return veriflyactualHeaderInfo;
	}
	

}
