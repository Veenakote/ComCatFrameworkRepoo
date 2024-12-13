package com.comCast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;
/*
 * This class have document page details
 */
public class documentPage extends WebDriverUtility
{

	
	
	
	public documentPage(WebDriver driver)
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createdocplusIcon;
	public WebElement getCreatedocplusIcon() {
		return createdocplusIcon;
	}
	
	
}
