package com.comCast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;
/*
 * This class have doumentsInfoPage details
 */
public class doumentsInfoPage extends WebDriverUtility
{
	public doumentsInfoPage (WebDriver driver)
	{
		
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="dtlview_Title")
	private WebElement veriflydocTitle;
	@FindBy(xpath="//td[@class='dvtCellInfo']/a")
	private WebElement veriflyfiletitle;
	public WebElement getVeriflydocTitle() {
		return veriflydocTitle;
	}
	public WebElement getVeriflyfiletitle() {
		return veriflyfiletitle;
	}
	
	
}
