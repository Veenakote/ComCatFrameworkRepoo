package com.comCast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;

public class ProductInfoPage extends WebDriverUtility
{
	public ProductInfoPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="dtlview_Product Name")
	private WebElement veriflyactualProductName;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement veriflyactualheaderInfo;

	public WebElement getVeriflyactualProductName() {
		return veriflyactualProductName;
	}

	public WebElement getVeriflyactualheaderInfo() {
		return veriflyactualheaderInfo;
	}
	
}
