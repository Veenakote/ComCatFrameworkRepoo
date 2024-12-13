package com.comCast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;

public class organazationpage extends WebDriverUtility
{
  //WebDriver driver;
	public organazationpage(WebDriver driver) 
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[contains(@title,'Cr')]")
	private WebElement plusIconForcreateorgName;
	
	
	
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(id="bas_searchfield")
	private WebElement searchDropdown;
	
	@FindBy(name="submit")
	private WebElement searchBtn;
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}


	public WebElement getSearchEdt() {
		return searchEdt;
	}


	public WebElement getSearchDropdown() {
		return searchDropdown;
	}


	public WebElement getPlusIconForcreateorgName() {
		return plusIconForcreateorgName;
	}
	
	
	
 
}
