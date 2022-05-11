package com.crm.comcast.contactTest;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.crm.comcast.pomreporsitorylib.Home;
import com.crm.comcast.pomreporsitorylib.createContact;
import com.crm.comcastgenericutility.BaseClass;
import com.crm.comcastgenericutility.JavaUtility;

public class EditTest extends BaseClass {
	
	@Test(groups={"regressionTest"})
	
	
		public void edit() throws InterruptedException, AWTException, Throwable {
		
		int ramint = JavaUtility.getRanDomNumber();
		String contactname = elib.getDataFromExcel("contacts", 0, 0)+ramint;
		
		Home hp=new Home(driver);
		hp.getContactslink().click();
		
		createContact cc=new createContact(driver);
		cc.editContact(contactname, driver);
		
			
		/*	WebDriverUtility wlib=new WebDriverUtility();
			FileUtility flib=new FileUtility();  
			ExcelUtility elib=new ExcelUtility();
			
			
		/*	FileInputStream fis=new FileInputStream("./data/DDT.properties");
			Properties pObj=new Properties();
			pObj.load(fis);*/
		  /*  String BROWSER = flib.getPropertyKeyValue("browser");
			String URL = flib.getPropertyKeyValue("url");
//			String USERNAME = flib.getPropertyKeyValue("username");
	//		String PASSWORD = flib.getPropertyKeyValue("password");
			
		/*	Random ram=new Random();
			int ramint=ram.nextInt(1000); */
	//		int ramint = JavaUtility.getRanDomNumber();
			
			

		/*	FileInputStream fis1=new FileInputStream("./data/contacts.xlsx");
			Workbook wb = WorkbookFactory.create(fis1);
			Sheet sh = wb.getSheet("Sheet1");
			Row rw = sh.getRow(0);
			String contactname = rw.getCell(0).getStringCellValue() + ramint;
			wb.close();*/
	/*		String contactname = elib.getDataFromExcel("contacts", 0, 0)+ramint;
			
			WebDriver driver=null;
			if(BROWSER.equals("chrome")) {
				driver= new ChromeDriver();
			}else if(BROWSER.equals("firefox")) {
					driver=new FirefoxDriver();
				}else {
					driver=new ChromeDriver();
				}
			
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wlib.waitUntilPageLoad(driver);
			//step1; login
			Login lp=new Login(driver);
			driver.get(URL);
			lp.loginToApp();
			
			
			//navigate to contact
			Home hp=new Home(driver);
			hp.getContactslink().click();
			
			createContact cc=new createContact(driver);
			cc.editContact(contactname, driver);
			
			
			
			
			//logout
			
			hp.Logout();
			driver.close();
			
			
			
			
			
			
			
			
			
			
			
			
			
/*			driver.get(URL);
			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
			driver.findElement(By.xpath("//input[@id='submitButton']")).click();
			
			driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
			
		
			
			WebElement ele1 = driver.findElement(By.xpath("//a[.='edit']"));
	        wlib.waitForElementVisibility(driver, ele1);
	        ele1.click();
			driver.findElement(By.xpath("//input[@name='lastname']")).clear();
	        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(contactname);
	        
	        
	        driver.findElement(By.xpath("//input[@ title='Save [Alt+S]']")).click();
			//Thread.sleep(2000);
	        
	        //Thread.sleep(2000);
	        
	        String ContactInfo = driver.findElement(By.xpath("//a[.='"+contactname+"']")).getText();
	        
	        
	        if(ContactInfo.contains(contactname)) {
	        	System.out.println("test case is passed");
	        }else {
	        	System.out.println("test case is fail");
	        }
	        WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")); 
	        wlib.waitForElementVisibility(driver, ele);
	      /*  Actions act=new Actions(driver);
	        act.moveToElement(ele).perform();*/
	  //      wlib.mouseOver(driver, ele);
	  //      driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	        
	     //   driver.quit();
	        
		}

}
