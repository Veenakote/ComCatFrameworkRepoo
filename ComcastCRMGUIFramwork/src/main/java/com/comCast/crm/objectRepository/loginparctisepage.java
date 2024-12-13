package com.comCast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginparctisepage 
{
  WebDriver driver;
  public loginparctisepage(WebDriver driver)
  {
	  this.driver=driver;
	  
  }
	
	@FindBy(name="user_name")
	public WebElement usernameEdt;
	@FindBy(name="user_password")
	public WebElement passwordEdt;
	@FindBy(id="submitButton")
	public WebElement loginBtn;
	//rule 4:object encapsulation
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//rule:provide action
	public void loginToApp(String username,String password)//bussiness method
	{
		//driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
}
