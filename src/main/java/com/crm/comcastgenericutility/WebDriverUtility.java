package com.crm.comcastgenericutility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 *  
	 * @author Lingaraj
	 *
	 */

	
	/**
	 * this method wait for 20 secs for page loading
	 * @param driver
	 */
   public void waitUntilPageLoad(WebDriver driver)
   {
	   driver.manage().timeouts().implicitlyWait(IConstants.Implicitly_TIMEOUT, TimeUnit.SECONDS);
	
   }

   
   
   
   /**
    * This method wait for the element to be visible
    * @param driver
    * @param element
    * 
    */
   public void waitForElementVisibility(WebDriver driver,WebElement element)
   {
	  WebDriverWait wait = new WebDriverWait(driver, IConstants.Explicitly_TIMEOUT);
	  wait.until(ExpectedConditions.visibilityOf(element));
   }


   
 
   
   /**
    * this methods enables user to handle dropdown using index
    * @param element
    * @param index
    */

   public void select(WebElement element, int index)
   {
	   Select select=new Select(element);
	   select.selectByIndex(index);   
   }

   
   
   /**
    * this method is used handle the drop down using value
    * @param element
    * @param value
    */
   public void select(WebElement element ,String value)
   {
	   Select s=new Select(element);
	   s.selectByValue(value);
   }
   
   
   
   /**
    * This method will perform mouse over action
    * @param driver
    * @param element
    */

   public void mouseOver(WebDriver driver,WebElement element)
   {
	   Actions act = new Actions(driver);
	   act.moveToElement(element).perform();
	
   }

   
   
   /**
    * This method performs right click operation 
    * @param driver
    * @param element
    */
   public void rightClick(WebDriver driver,WebElement element)
   {
	   Actions act = new Actions(driver);
	   act.contextClick(element).perform();
   }

   
   
   /**
    * This method helps to switch from one window to another
    * @param driver
    * @param partialWinTitle
    */
   public void switchToWindow(WebDriver driver, String partialWinTitle)
   {
	   Set<String> window = driver.getWindowHandles();
	   Iterator<String> it = window.iterator();
	   while(it.hasNext())
	   {
		   String winId=it.next();
		   String title=driver.switchTo().window(winId).getTitle();
           if(title.contains(partialWinTitle))
           {
	   break;
           }
		
	   }
	
   }

   
   
   
   /**
    * Accept alert 
    * @param driver
    */

   public void acceptAlert(WebDriver driver)
   {
	   driver.switchTo().alert().accept();
   }


   
   /**
    * Cancel Alert
    * @param driver
    */
   public void cancelAlert(WebDriver driver)
   {
	   driver.switchTo().alert().dismiss();
   }

   
   
   
   
 /*  public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
	TakesScreenshot ts=(TakesScreenshot)driver;
	 File src = ts.getScreenshotAs(OutputType.FILE);
	 File dest=new File("./screenshot/"+screenshotName+".PNG");
     file.copy(src, dest);*/
   }



     
     
    
    

