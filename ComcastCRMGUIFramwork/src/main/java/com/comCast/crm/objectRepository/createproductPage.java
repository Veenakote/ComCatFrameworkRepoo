package com.comCast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;
/*
 * This class have product page details
 */
public class createproductPage extends WebDriverUtility
{
	public createproductPage(WebDriver driver)
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="productname")
	private WebElement productnametextfield;
	public WebElement getProductnametextfield() {
		return productnametextfield;
	}
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
public void createproduct(WebDriver driver,String productname)
{
	createproductPage ccp=new createproductPage(driver);
	 ccp.getProductnametextfield().sendKeys(productname);
	 ccp.getSaveBtn().click();
}
	
	
	
}
