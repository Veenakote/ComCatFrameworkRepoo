package com.comCast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;
/*
 * This class have Hompage details
 */
public class Hompage extends WebDriverUtility
{
	
	//WebDriver driver;
	WebDriverUtility wlib = new WebDriverUtility();
	public Hompage(WebDriver driver) 
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement orgNameLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(name="Campaigns")
	private WebElement CampaignsLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement SignOutLink;
	
	
	@FindBy(linkText="Documents")
	private WebElement documentLink;

	@FindBy(linkText="Leads")
	private WebElement leadsLink;
	
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(linkText="Vendors")
	private WebElement vendorLink;
	
	@FindBy(linkText="Email")
	private WebElement emailLink;
	
	public WebDriverUtility getWlib() {
		return wlib;
	}

	public WebElement getEmailLink() {
		return emailLink;
	}




	public WebElement getDocumentLink() {
		return documentLink;
	}




	public WebElement getLeadsLink() {
		return leadsLink;
	}




	public WebElement getProductLink() {
		return productLink;
	}




	public WebElement getVendorLink() {
		return vendorLink;
	}




	public WebElement getAdminImg() {
		return adminImg;
	}




	public WebElement getSignOutLink() {
		return SignOutLink;
	}




	public WebElement getContactLink() {
		return contactLink;
	}
	



	public WebElement getCampaignsLink() {
		return CampaignsLink;
	}



	public WebElement getOrgNameLink() {
		return orgNameLink;
	}
	
	
	
	
	
	public WebElement getMoreLink() {
		return moreLink;
	}




	//***********Business logic******************************//
	public void navigateToCampaginPage()
	{
		
	    CampaignsLink.click();	
	}
	
	public void signOut() throws Exception
   {
		
		adminImg.click();
		SignOutLink.click();

//		mouseOverActionOrMoveToElementclick(driver,SignOutLink );
//		
//		System.out.println("signout clicked");
//		Thread.sleep(2000);
		
	}
	
}
