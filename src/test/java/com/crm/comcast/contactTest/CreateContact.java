package com.crm.comcast.contactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.comcast.pomreporsitorylib.Home;
import com.crm.comcast.pomreporsitorylib.Login;
import com.crm.comcast.pomreporsitorylib.contactinfo;
import com.crm.comcast.pomreporsitorylib.createContact;
import com.crm.comcast.pomreporsitorylib.createNewContact;
import com.crm.comcastgenericutility.ExcelUtility;
import com.crm.comcastgenericutility.FileUtility;
import com.crm.comcastgenericutility.JavaUtility;
import com.crm.comcastgenericutility.WebDriverUtility;

public class CreateContact {

	
	
	@Test(groups={"smokeTest"})
	
	
	public void crecon() throws InterruptedException, Throwable {
		WebDriverUtility wlib=new WebDriverUtility();
        FileUtility flib=new FileUtility();
        ExcelUtility elib=new ExcelUtility();
        
        
		/*
		//read common data from properties file
		/*FileInputStream fis=new FileInputStream("./data/DDT.properties");
		Properties pObj=new Properties();
		pObj.load(fis);*/
		
	    String BROWSER = flib.getPropertyKeyValue("browser");
		String URL = flib.getPropertyKeyValue("url");
	/*	String USERNAME = flib.getPropertyKeyValue("username");
		String PASSWORD = flib.getPropertyKeyValue("password");*/
		
		/*Random ram=new Random();
		int ramint=ram.nextInt(1000);*/
		int ramint = JavaUtility.getRanDomNumber();
		//ssssachinnnnnnnnnnnnnnnnnnnnn
		
		
	/*	FileInputStream fis1=new FileInputStream("./data/contacts.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Sheet1");
		Row rw = sh.getRow(0);
		String contactname = rw.getCell(0).getStringCellValue() + ramint;
		wb.close();*/
		String contactname = elib.getDataFromExcel("contacts", 0, 0)+ramint;
		
		WebDriver driver=null;
		if(BROWSER.equals("chrome")) {
			driver= new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
				driver=new FirefoxDriver();
			}else {
				driver=new ChromeDriver();
			}//sachin
		
		
		
		
	    //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wlib.waitUntilPageLoad(driver);
		
		//step1; login
		Login lp=new Login(driver);
		driver.get(URL);
		lp.loginToApp();
		
		
		//navigate to contact
		Home hp=new Home(driver);
		hp.getContactslink().click();
		
		//create contact

		createContact cc=new createContact(driver);
		cc.getCreatecontactimg().click();
		
		
		//create new contact
		createNewContact cnc= new createNewContact(driver);
		cnc.createnewcontact(contactname);
		
		//contact info 
		 contactinfo cn=new contactinfo(driver);
		 String actualresult = cn.getSuccessfullmsg().getText();
		 
		  if(actualresult.contains(contactname)) {
	        	System.out.println("test case is passed");
	        }else {
	        	System.out.println("test case is fail");
	        }
		
		//logout
		
		hp.Logout();
		driver.close();
		
		
		
		
	/*	

		driver.get(URL);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		driver.findElement(By.xpath("//img[@ src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@ name='lastname']")).sendKeys(contactname);
		driver.findElement(By.xpath("//input[@ title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.waitUntilPageLoad(driver);
        
        /*
        String ContactInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        if(ContactInfo.contains(contactname)) {
        	System.out.println("test case is passed");
        }else {
        	System.out.println("test case is fail");
        }
        */
        
       /* Actions act=new Actions(driver);
        act.moveToElement(ele).perform();*/
     /*   wlib.mouseOver(driver, ele);
        driver.findElement(By.xpath("//a[.='Sign Out']")).click();
        wlib.waitUntilPageLoad(driver);
        driver.quit();
        */
        
	}

	
	}


