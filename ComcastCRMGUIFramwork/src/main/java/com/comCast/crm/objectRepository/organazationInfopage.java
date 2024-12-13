package com.comCast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;

public class organazationInfopage extends WebDriverUtility
{

	//WebDriver driver;
	public organazationInfopage(WebDriver driver) 
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement veriflyHeaderInfo;
		
		@FindBy(id="mouseArea_Organization Name")
		private WebElement veriflyOrgName;
		
		
		@FindBy(id="dtlview_Phone")
		private WebElement veriflyphonenumber;
		
		@FindBy(id="mouseArea_Industry")
		private WebElement veriflyindustry;
		
		@FindBy(id="dtlview_Type")
		private WebElement veriflyindustryType;
		
		public WebElement getVeriflyindustry() {
			return veriflyindustry;
		}

		public WebElement getVeriflyindustryType() {
			return veriflyindustryType;
		}

		public WebElement getVeriflyHeaderInfo() {
			return veriflyHeaderInfo;
		}
		
		public WebElement getVeriflyOrgName() {
			return veriflyOrgName;
		}

		public WebElement getVeriflyphonenumber() {
			return veriflyphonenumber;
		}
		
		
	}
  

