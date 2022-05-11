package com.crm.comcast.organizationTest;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.comcastgenericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationExcel {
	public static void main(String[] args) throws InterruptedException, Throwable {
		
		WebDriverUtility wlib=new WebDriverUtility();
		
		FileInputStream fis=new FileInputStream("./data/DDT.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
	//	String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		
		FileInputStream fis1=new FileInputStream("./data/organization.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
	    Sheet sh = wb.getSheet("Sheet1");
	    sh.getRow(0);
	    
    
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wlib.waitUntilPageLoad(driver);
		
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
        driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
        driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("tyss1101");
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        Thread.sleep(2000);
        WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        Thread.sleep(2000);
      /*  Actions act=new Actions(driver);
        act.moveToElement(ele).perform();*/
        wlib.mouseOver(driver, ele);
        driver.findElement(By.xpath("//a[.='Sign Out']")).click();
        Thread.sleep(1000);
        driver.quit();
        
        
        
	}

}



