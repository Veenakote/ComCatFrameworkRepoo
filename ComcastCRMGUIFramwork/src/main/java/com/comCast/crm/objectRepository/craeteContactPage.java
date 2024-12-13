package com.comCast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This is class has craete contactPage 
 */


public class craeteContactPage
{
	//WebDriver driver;
	public craeteContactPage(WebDriver driver) 
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastNameTextField;
	@FindBy(name="support_start_date")
	private WebElement supportDate;
	@FindBy(name="support_end_date")
	private WebElement supportEnddate;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orgplusIconinConatctpg;
	
	public WebElement getSupportDate() {
		return supportDate;
	}

	public WebElement getOrgplusIconinConatctpg() {
		return orgplusIconinConatctpg;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getSupportStartDate() {
		return supportDate;
	}

	public WebElement getSupportEnddate() {
		return supportEnddate;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createcontact(String lastname,String startdate,String enddate)
	{
		lastNameTextField.sendKeys(lastname);
		
		supportDate.clear();
		supportDate.sendKeys(startdate);
		supportEnddate.clear();
		supportEnddate.sendKeys(enddate);
		saveBtn.click();
		
	}
	
	public void createContact(String lastname)
	{
		lastNameTextField.sendKeys(lastname);
		saveBtn.click();
	}
}
