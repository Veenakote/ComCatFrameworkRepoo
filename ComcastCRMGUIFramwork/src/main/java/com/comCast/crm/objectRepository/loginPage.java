package com.comCast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;

public class loginPage extends WebDriverUtility
//rule 1:create a seperate java class
//rule2: object creation
//rule3 :object intilazation(create in testscript)
/**
 * Author veena k s
 * Contains Login page elemnts and business lib like login()method
 */

{
	//WebDriver driver;
	public loginPage(WebDriver driver)
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	@FindBy(id="submitButton")
	private WebElement loginBtn;
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
	/**
	 * Login to application based on username ,password,url arguments
	 * @param driver
	 * @param url
	 * @param username
	 * @param password
	 */
	public void loginToApp(WebDriver driver,String url,String username,String password)//bussiness method
	{
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}

}
