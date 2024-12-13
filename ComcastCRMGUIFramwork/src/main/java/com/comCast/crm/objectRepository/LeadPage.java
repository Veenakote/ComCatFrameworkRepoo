package com.comCast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;

public class LeadPage extends WebDriverUtility
{
	public LeadPage(WebDriver driver)
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[contains(@alt,'Create Lead...')]")
	private WebElement createleadplusIcon;
	public WebElement getCreateleadplusIcon() {
		return createleadplusIcon;
	}
	
}
