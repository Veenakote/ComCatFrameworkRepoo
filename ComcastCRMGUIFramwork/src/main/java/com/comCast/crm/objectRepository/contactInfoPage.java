package com.comCast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This is class have contact InfoPage
 */
public class contactInfoPage
{
	//WebDriver driver;
	public contactInfoPage(WebDriver driver) 
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="dtlview_Last Name")
	private WebElement actualLastName;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement actualSupportStartdate;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement actualSupporEndtdate;
	public WebElement getActualLastName() {
		return actualLastName;
	}

	public WebElement getActualSupportStartdate() {
		return actualSupportStartdate;
	}

	public WebElement getActualSupporEndtdate() {
		return actualSupporEndtdate;
	}
	
	public void veriflycontact(String actualastname)
	{
		String actualastname1 = actualLastName.getText();
		if(actualastname1.contains(actualastname))
		{
			System.out.println(actualastname+"last name is verified===pass");
		}
		else
		{
			System.out.println(actualastname+"last name is  not verified==fail");
		}
		}
		
	}


