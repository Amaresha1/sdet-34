package com.crm.comcast.contactTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.pomreporsitorylib.Home;
import com.crm.comcast.pomreporsitorylib.contactinfo;
import com.crm.comcast.pomreporsitorylib.createContact;
import com.crm.comcast.pomreporsitorylib.createNewContact;
import com.crm.comcastgenericutility.BaseClass;
import com.crm.comcastgenericutility.JavaUtility;

@Listeners(com.crm.comcastgenericutility.ListenerImpl.class)

public class CreateContactAndDeleteContactTest extends BaseClass {

@Test(groups={"regressionTest"})

	public void createContAndDel() throws Throwable {
	
	int ramint = JavaUtility.getRanDomNumber();
	String contactname = elib.getDataFromExcel("contacts", 0, 0)+ramint;
	//navigate to contact
	Home hp=new Home(driver);
	hp.getContactslink().click();
	
	//create contact

	createContact cc=new createContact(driver);
	cc.getCreatecontactimg().click();
	
	
	//create new contact
	createNewContact cnc= new createNewContact(driver);
	cnc.createnewcontact(contactname);
    
	//delete contact
	contactinfo ci=new contactinfo(driver);
	ci.deleteContact(driver);
	
	createContact cc1=new createContact(driver);
	cc1.delectContact(contactname, driver);
	
	
	
	
		
	/*	WebDriverUtility wlib=new WebDriverUtility();
		FileUtility flib=new FileUtility();
	    ExcelUtility elib=new ExcelUtility();
		
		
		// TODO Auto-generated method stub
		/*FileInputStream fis=new FileInputStream("./data/DDT.properties");
		Properties pObj=new Properties();
		pObj.load(fis);*/
	/*    String BROWSER = flib.getPropertyKeyValue("browser");
		String URL = flib.getPropertyKeyValue("url");
		//String USERNAME = flib.getPropertyKeyValue("username");
		//String PASSWORD = flib.getPropertyKeyValue("password");
		
		/*Random ram=new Random();
		int ramint=ram.nextInt(1000);*/
	//	int ramint = JavaUtility.getRanDomNumber();
		
		
	/*	FileInputStream fis1=new FileInputStream("./data/contacts.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Sheet1");
		Row rw = sh.getRow(0);
		String contactname = rw.getCell(0).getStringCellValue() + ramint;
		wb.close();*/
	//	String contactname = elib.getDataFromExcel("contacts", 0, 0)+ramint;
		
/*		WebDriver driver=null;
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
		
		//create contact

		createContact cc=new createContact(driver);
		cc.getCreatecontactimg().click();
		
		
		//create new contact
		createNewContact cnc= new createNewContact(driver);
		cnc.createnewcontact(contactname);
	    
		//delete contact
		contactinfo ci=new contactinfo(driver);
		ci.deleteContact(driver);
		
		createContact cc1=new createContact(driver);
		cc1.delectContact(contactname, driver);
		
		
		//logout
		
		hp.Logout();
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//contact info 
	/* cn=new contactinfo(driver);
		 String actualresult = cn.getSuccessfullmsg().getText();
		 
		  if(actualresult.contains(contactname)) {
	        	System.out.println("test case is passed");
	        }else {
	        	System.out.println("test case is fail");
	        	
	        	
	        }
		//to delete a contact
		 
		  
		/*		  
		 Home hh=new Home(driver);
		  hh.getContactslink().click(); 
		  
			createContact cx=new createContact(driver);
			cx.getCreatecontactimg().click();
		  
		  
		  
		//logout
		
	//	hp.Logout();
	//	driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		driver.get(URL);
	/*	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		driver.findElement(By.xpath("//img[@ src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@ name='lastname']")).sendKeys(contactname);
		driver.findElement(By.xpath("//input[@ title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		//WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
       // Thread.sleep(2000);
		//wlib.waitUntilPageLoad(driver);
        
        
        String ContactInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        if(ContactInfo.contains(contactname)) {
        	System.out.println("test case is passed");
        }else {
        	System.out.println("test case is fail");
        }
        driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
        driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(contactname);
        //Thread.sleep(2000);
       // wlib.waitUntilPageLoad(driver);
        WebElement ele1 = driver.findElement(By.xpath("//select[@name='search_field']"));
        Thread.sleep(2000);
        Select sel=new Select(ele1);
        sel.selectByVisibleText("Last Name");
      //  wlib.select(ele1, ContactInfo);
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        Thread.sleep(2000);
       // wlib.waitUntilPageLoad(driver);
        
        driver.findElement(By.xpath("//input[@type='checkbox' and @name='selected_id']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Delete']")).click();
       /* Alert a = driver.switchTo().alert();
        a.accept();*/
    //    wlib.acceptAlert(driver);
        
        
   //     WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
       // Thread.sleep(2000);
       // wlib.acceptAlert(driver);
        
        /*Actions act=new Actions(driver);
        act.moveToElement(ele2).perform();*/
   //     wlib.mouseOver(driver, ele2);
   //     driver.findElement(By.xpath("//a[.='Sign Out']")).click();
        //Thread.sleep(1000);
       // wlib.acceptAlert(driver);
     //   driver.quit();
        
        
        
        
	}



	}


