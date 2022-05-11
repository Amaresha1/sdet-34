package com.crm.comcastgenericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.comcast.pomreporsitorylib.Home;
import com.crm.comcast.pomreporsitorylib.Login;

public class BaseClass {
	
		
	public DataBaseUtility dlib=new DataBaseUtility();
	public FileUtility flib=new FileUtility();
	public 	WebDriverUtility wlib=new WebDriverUtility();
    public JavaUtility jlib=new JavaUtility();
	public ExcelUtility elib=new ExcelUtility();
	public WebDriver driver;
	public  static WebDriver sdriver=null;
	
/*	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	
	public void bsConf() throws Throwable {
		//connect to database
	//	Dlib.connectToDatabase();
	}*/
	
//@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	
	public void bcConf( ) throws Throwable {
		//launch the browser
		String BROWSER=flib.getPropertyKeyValue("browser");
		String URL=flib.getPropertyKeyValue("url");
		
		
	
		if(BROWSER.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equals("chrome"))
		{
			driver =new ChromeDriver();
		}
		else if (BROWSER.equals("ie"))
		{
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		sdriver=driver;
		wlib.waitUntilPageLoad(driver);
		driver.get(URL);
	}
		
	
    @BeforeMethod(groups = {"smokeTest","regressionTest"})
    
    public void bmConf() throws Throwable {
    	Login lp=new Login(driver);
    	lp.loginToApp();
    	
    }
	
	
    @AfterMethod(groups = {"smokeTest","regressionTest"})
    
    public void amConf() {
    	Home hp=new Home(driver);
    	hp.Logout();		
    }
    
    
    @AfterClass(groups = {"smokeTest","regressionTest"})
    public void acConf() {
    	driver.quit();
    }
    
    
    @AfterSuite(groups = {"smokeTest","regressionTest"})
    public void asSuit() throws Throwable {
  //   Dlib.closeDb();
    }
    
    
    
    
}

