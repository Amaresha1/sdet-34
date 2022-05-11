package com.crm.practise;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase00 {

		public static void main(String[] args) throws Throwable {
			
			
			FileInputStream fis=new FileInputStream("./data/DDT.properties");
			Properties pObj=new Properties();
			pObj.load(fis);
		//	String BROWSER = pObj.getProperty("browser");
			String URL = pObj.getProperty("url");
			String USERNAME = pObj.getProperty("username");
			String PASSWORD = pObj.getProperty("password");
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.get(URL);
			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
			driver.findElement(By.xpath("//input[@id='submitButton']")).click();
			
			
			
			driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
			driver.findElement(By.xpath("//img[@ src='themes/softed/images/btnL3Add.gif']")).click();
			driver.findElement(By.xpath("//img[@language='javascript']")).click();
			
			
			Set<String> aw = driver.getWindowHandles();
		    ArrayList<String> l=new  ArrayList<String>(aw);
		    String w = l.get(1);
		    driver.switchTo().window(w);
		    
		    
		    driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys("tyss7");
		    driver.findElement(By.xpath("//input[@name='search']")).click();
		    Thread.sleep(2000);
		    
		    Set<String> a = driver.getWindowHandles();
		    ArrayList<String> z=new  ArrayList<String>(a);
		    String uu = z.get(0);
		    driver.switchTo().window(uu);
		    
		    
		    
		    
		    
		    WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	        Thread.sleep(2000);
	        Actions act1=new Actions(driver);
	        act1.moveToElement(ele1).perform();
	        driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	        Thread.sleep(1000);
	        driver.quit();
		    
		    

	}

}
