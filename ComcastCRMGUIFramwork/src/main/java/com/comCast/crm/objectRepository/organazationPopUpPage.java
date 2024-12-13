package com.comCast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organazationPopUpPage 
{
	//WebDriver driver;
	public organazationPopUpPage(WebDriver driver) 
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(id="search_txt")
	private WebElement searchtextfield;
	
	
	
	@FindBy(name="search")
	private WebElement searchbutton;
	
	public WebElement getSearchbutton() {
		return searchbutton;
	}

	public WebElement getSearchtextfield() {
		return searchtextfield;
	}
	
	
}
