package com.comCast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;

public class EmailPage extends WebDriverUtility
{
	public EmailPage(WebDriver driver)
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText ="Compose")
	private WebElement ComposeLink;
	public WebElement getComposeLink() {
		return ComposeLink;
	}
	
<<<<<<< HEAD
	@FindBy(name="find")
	private WebElement ele3;
=======
	@FindBy(id="search_text")
	private WebElement ele2;
	
>>>>>>> branch 'master' of https://github.com/Veenakote/ComCatFrameworkRepoo.git
}
