package com.crm.comcast.organizationTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.pomreporsitorylib.Home;
import com.crm.comcast.pomreporsitorylib.createNewOraganization;
import com.crm.comcast.pomreporsitorylib.createOraganization;
import com.crm.comcast.pomreporsitorylib.organizationInfo;
import com.crm.comcastgenericutility.BaseClass;
import com.crm.comcastgenericutility.JavaUtility;

public class CreateOraganizationTest extends BaseClass{

	
	@Test (groups={"smokeTest"})
	
	public void createOrg() throws InterruptedException, Throwable {
		
		int ramint = JavaUtility.getRanDomNumber();
		String OrgName = elib.getDataFromExcel("organization", 0, 0)+ramint;
		
		//step2;navigate to organization
				Home hp =new Home(driver);
				hp.getOrganizationslink().click();
				
		
	    //step3;create organization
			createOraganization co=new createOraganization(driver);
			co.getCreateOrgImg().click();
			
			//step4;create new organization
			createNewOraganization cno=new createNewOraganization(driver);
			cno.createNewOrganization(OrgName);
			
			//step5;org info
			organizationInfo oi=new organizationInfo(driver);
			String actualresult = oi.getSuccesfullmsg().getText();
			
			System.out.println(actualresult);
			boolean flag = actualresult.contains(OrgName);
			Assert.assertTrue(flag , "contact  not created");
			System.out.println("organization name created ");
			
			
			
			/*
			 if(actualresult.contains(OrgName)) {
		        	System.out.println("test case is passed");
		        }else {
		        	System.out.println("test case is fail");
		        }*/
			
		
		
		
		
		
		
		
		
		
		
		
		
		
	/*	WebDriverUtility wlib=new WebDriverUtility();
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();	
		
	/*	FileInputStream fis=new FileInputStream("./data/DDT.properties");
		Properties pObj=new Properties();
		pObj.load(fis);*/
     /*   String BROWSER = flib.getPropertyKeyValue("browser");
		String URL = flib.getPropertyKeyValue("url");
		//String USERNAME = flib.getPropertyKeyValue("username");
	//	String PASSWORD = flib.getPropertyKeyValue("password");
		
		
		/*Random ram=new Random();
		int ramint=ram.nextInt(1000);*/
	/*	int ramint = JavaUtility.getRanDomNumber();
		
		
	/*	FileInputStream fis1=new FileInputStream("./data/organization.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Sheet1");
		Row rw = sh.getRow(0);
		String OrgName = rw.getCell(0).getStringCellValue() + ramint;
		wb.close();*/
	/*	String OrgName = elib.getDataFromExcel("organization", 0, 0)+ramint;
		
		
		

		/*WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();*/
		
	/*	WebDriver driver=null;
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
		
		//step2;navigate to organization
		Home hp =new Home(driver);
		hp.getOrganizationslink().click();
		
	    //step3;create organization
		createOraganization co=new createOraganization(driver);
		co.getCreateOrgImg().click();
		
		//step4;create new organization
		createNewOraganization cno=new createNewOraganization(driver);
		cno.createNewOrganization(OrgName);
		
		//step5;org info
		organizationInfo oi=new organizationInfo(driver);
		String actualresult = oi.getSuccesfullmsg().getText();
		 if(actualresult.contains(OrgName)) {
	        	System.out.println("test case is passed");
	        }else {
	        	System.out.println("test case is fail");
	        }
		

			//logout
			
			hp.Logout();
			driver.close();
			
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/*	driver.get(URL);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();*/
		
	//	driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		//Thread.sleep(2000);
      //  driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
       // Thread.sleep(2000);
        
       
       // driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(OrgName);
       // driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
       // Thread.sleep(2000);
      //  WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
       // Thread.sleep(2000);
       // wlib.waitForElementVisibility(driver, ele);
        
     //   String actOrgNameInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
       /* if(actOrgNameInfo.contains(OrgName)) {
        	System.out.println("test case is passed");
        }else {
        	System.out.println("test case is fail");
        }
       // Thread.sleep(2000);
      
     /*   WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        wlib.waitForElementVisibility(driver, ele);*/
  
        
     /*   Actions act=new Actions(driver);
        act.moveToElement(ele).perform();*/
      /*  wlib.mouseOver(driver, ele);
        driver.findElement(By.xpath("//a[.='Sign Out']")).click();
       // Thread.sleep(1000);
        driver.quit();*/
        
        
	}

}
