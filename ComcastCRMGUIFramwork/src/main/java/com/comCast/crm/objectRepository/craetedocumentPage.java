package com.comCast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comCast.crm.generic.fileUtility.IpathConstants;
import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;
/*
 * This class have carete documentpage details
 */
public class craetedocumentPage extends WebDriverUtility
{
	public craetedocumentPage(WebDriver driver)
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="notes_title")
	private WebElement titletextfield;
	
	@FindBy(id="filename_I__")
	private WebElement choosefileBTn;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBTn;

	public WebElement getTitletextfield() {
		return titletextfield;
	}

	public WebElement getChoosefileBTn() {
		return choosefileBTn;
	}

	public WebElement getSaveBTn() {
		return saveBTn;
	}

	
	
	
}
