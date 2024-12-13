package com.comCast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comCast.crm.generic.fileUtility.ExcelUtility;
/*
 * This class have createnew orgName page
 */
public class craeteNewOrganazationPage extends ExcelUtility
{
	//WebDriver driver;
	public craeteNewOrganazationPage(WebDriver driver) 
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="accountname")
	private WebElement orgTextField;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(id="phone")
	private WebElement phoneNumber;
	
	@FindBy(name="industry")
	private WebElement orgIndustry;
	
	
			@FindBy(xpath="//select[@name='accounttype']")
	private WebElement orgIndustryType;
	public WebElement getOrgIndustryType() {
				return orgIndustryType;
			}
	public WebElement getOrgTextField() {
		return orgTextField;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	
	public WebElement getPhoneNumber() {
		return phoneNumber;
	}
	public WebElement getOrgIndustry() {
		return orgIndustry;
	}
	public void createOrgName(String orgname)
	{
	  orgTextField.sendKeys(orgname);
	  saveBtn.click();
	}
	
	public void createOrgName(String orgname,String industry,String type)//method overloading
	{
		orgTextField.sendKeys(orgname);
		Select sel=new Select(orgIndustry);
		sel.selectByVisibleText(industry);
		Select sel1=new Select(orgIndustryType);
		sel1.selectByVisibleText(type);
		saveBtn.click();
	}
	public void createOrgName(String orgname,String phonenumber)//method overloading
	{
		orgTextField.sendKeys(orgname);
		phoneNumber.sendKeys(phonenumber);
		saveBtn.click();
	}
}
