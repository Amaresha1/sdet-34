package com.crm.practise;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit {
	
		public static void main(String[] args) throws InterruptedException, AWTException {
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.get("http://localhost:8888/index.php?action=Login&module=Users");
			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@id='submitButton']")).click();
			
			driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
			driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=EditView&record=18&return_module=Contacts&return_action=index&parenttab=Marketing&return_viewname=7']")).click();
	        driver.findElement(By.xpath("//input[@name='lastname']")).clear();
	        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("saachii");
	        
	        
	        driver.findElement(By.xpath("//input[@ title='Save [Alt+S]']")).click();
			Thread.sleep(2000);
			WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	        Thread.sleep(2000);
	        Actions act=new Actions(driver);
	        act.moveToElement(ele).perform();
	        driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	        Thread.sleep(1000);
	        driver.quit();
	        
		}

}
