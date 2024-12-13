package com.comCast.crm.generic.webDriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility 
{
	//public WebDriver driver;
  public void waitForPageToLoad(WebDriver driver)
  {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  public void WaitForElementPresent(WebDriver driver,WebElement element)
  {
	  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	  wait.until(ExpectedConditions.visibilityOf(element));
  }
  
  public void switchToTabOnURL(WebDriver driver,String partialURL)
  {
	  Set<String> set = driver.getWindowHandles();
	  Iterator<String> it = set.iterator();
	  while(it.hasNext())
	  {
		  String windowID=it.next();
		  driver.switchTo().window(windowID);
		  String actualurl = driver.getCurrentUrl();
		  if(actualurl.contains(partialURL))
		  {
			  break;
		  }
	  }
  }	
	  public void switchToTabOnTitle(WebDriver driver,String partialtitle)
	  {
		  Set<String> set = driver.getWindowHandles();
		  Iterator<String> it = set.iterator();
		  while(it.hasNext())
		  {
			  String windowID=it.next();
			  driver.switchTo().window(windowID);
			  String actualurl = driver.getTitle();
			  if(actualurl.contains(partialtitle))
			  {
				  break;
			  }
		  }

  }
	  
	  public void switchToFrame(WebDriver driver,int index)
	  {
		  driver.switchTo().frame(index);
	  }
	  
	  public void switchToFrame(WebDriver driver,String nameId)
	  {
		  driver.switchTo().frame(nameId);
	  }
	  
	  public void switchToFrame(WebDriver driver,WebElement element)
	  {
		  driver.switchTo().frame(element);
	  }
	  
	  public void SwitchToAlertAndAccept(WebDriver driver)
	  {
		  driver.switchTo().alert().accept();
	  }
	  
	  public void SwitchToAlertAndDismiss(WebDriver driver)
	  {
		  driver.switchTo().alert().dismiss();
	  }
	  
	  public void selectByVisibleText(WebElement element,String text)
	  {
		  Select sel=new Select(element);
		  sel.selectByVisibleText(text);
	  }
	  
	  public void selectByVisibleIndex(WebElement element,int index)
	  {
		  Select sel=new Select(element);
		  sel.selectByIndex(index);
	  }
	  
	  public void mouseMoveOnElement(WebDriver driver,WebElement element)
	  {
		  Actions act=new Actions(driver);
		  act.moveToElement(element).build().perform();
	  }
	  public void doubleClick(WebDriver driver,WebElement element)
	  {
		  Actions act=new Actions(driver);
		  act.doubleClick(element).perform();;
	  }
	  
	//***********************************************************************************************//
	  
	  //**Explicit wait methods**//
	   public void webDriverwait(WebDriver driver,WebElement element)
	  
	   {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	   }
	   
	   public void webDriverWait(WebDriver driver,String title)
	   {
		   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		   wait.until(ExpectedConditions.titleContains(title));
	   }
	   
	   public void webDriverWait(WebDriver driver,WebElement element,String attributename,String value)
	   {
		   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		   wait.until(ExpectedConditions.attributeContains(element, attributename, value));
	   }
	   
	   public void webDriverWait(WebDriver driver,WebElement element)
	   {
		   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		   wait.until(ExpectedConditions.visibilityOf(element));
	   }
	   public void webDriverWait(WebDriver driver)
	   {
		   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		   wait.until(ExpectedConditions.alertIsPresent());
	   }
	   
	  //********Drop down methods*************************//
	   public void SelectByValue(WebElement element ,String text)
	   {
		   Select sel=new Select(element);
		   sel.selectByValue(text);
	   }
	    public void SelectAllOption(WebElement element)
	    {
	    	Select sel=new Select(element);
			   List<WebElement> alloptions = sel.getAllSelectedOptions();
			   for(WebElement options:alloptions)
			   {
				   options.click();
				  
			   }
	    }
    public void SelectByFirstElement(WebElement element)
    {
    	Select sel=new Select(element);
    	sel.getFirstSelectedOption();
    }
    public boolean SelectClassIsMutiple(WebElement element)
    {
    	Select sel=new Select(element);
      boolean ismultiple =sel.isMultiple();
      
      return ismultiple;
      
    }  
    
    public void deselectByAllOption(WebElement element)
    {
    	Select sel=new Select(element);
    	sel.deselectAll();
    	
    }
    
    /**********************Actions class************************************/
    
    public void mouseOverActionOrMoveToElement(WebDriver driver,WebElement element)
    {
    	Actions act=new Actions(driver);
    	act.moveToElement(element).click().perform();
    }
    public void mouseOverActionOrMoveToElementclick(WebDriver driver,WebElement element)
    {
    	Actions act=new Actions(driver);
    	act.moveToElement(element).click().build().perform();
    	
    }
    public void dragAndDrop(WebDriver driver,WebElement source,WebElement targert)
    {
    	Actions act=new Actions(driver);
    	act.dragAndDrop(source, targert).perform();
    }
    
    public void rightClickonWebPage(WebDriver driver)
    {
    	Actions act=new Actions(driver);
    	act.contextClick().perform();
    }
    public void rightClickOnWebElement(WebDriver driver,WebElement element)
    {
    	Actions act=new Actions(driver);
    	act.contextClick(element).perform();
    }
    
    public void sendKeysByactionClass(WebDriver driver,WebElement element,String text)
    {
    	Actions act=new Actions(driver);
    	
    	act.sendKeys(element, text).perform();
    }
    
    //**********************Scroll down****************************//
    public void scrollDown(WebDriver driver)
    {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    
    public void ScrollToElement(WebDriver driver,WebElement element)
    {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView()", element);
    }
     
    public void ScrollBycordinates(WebDriver driver, int x,int y)
    {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy("+x+","+y+")");
    }
	    
}
