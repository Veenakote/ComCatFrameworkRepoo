package com.comCast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;

public class productpage extends WebDriverUtility
{

	public productpage(WebDriver driver)
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createproductplusIcon;
	public WebElement getCreateproductplusIcon() {
		return createproductplusIcon;
	}
	
}
