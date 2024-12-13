package com.comCast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;

public class leadInfoPage extends WebDriverUtility
{
	public leadInfoPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="dtlview_Last Name")
	private WebElement veriflyactualLastName;
	@FindBy(id="dtlview_Company")
	private WebElement veriflyactualCompanyName;
	public WebElement getVeriflyactualLastName() {
		return veriflyactualLastName;
	}
	public WebElement getVeriflyactualCompanyName() {
		return veriflyactualCompanyName;
	}
	
}
