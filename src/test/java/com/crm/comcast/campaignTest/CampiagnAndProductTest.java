package com.crm.comcast.campaignTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.pomreporsitorylib.Home;
import com.crm.comcast.pomreporsitorylib.campaigninfo;
import com.crm.comcast.pomreporsitorylib.createCampaign;
import com.crm.comcast.pomreporsitorylib.createNewCampaign;
import com.crm.comcast.pomreporsitorylib.createNewProduct;
import com.crm.comcast.pomreporsitorylib.createProduct;
import com.crm.comcastgenericutility.BaseClass;
import com.crm.comcastgenericutility.JavaUtility;

public class CampiagnAndProductTest extends BaseClass {
	@Test(groups={"regressionTest"})

	public void campAndProd() throws Throwable {
		
		int rndm1 = JavaUtility.getRanDomNumber();
		//*sachin
		 String productName = elib.getDataFromExcel("Campaign", 1, 0)+rndm1;
		 String campaignName = elib.getDataFromExcel("Campaign", 1, 1)+rndm1;
			//step2;navigate to product
			//navigate to contact
			Home hp=new Home(driver);
			hp.getProductslink().click();
			//ssss
			
			//step3;create product
			createProduct cp=new createProduct(driver);
			cp.getCreatproductimg().click();
			
			//step4;create new product
			createNewProduct cnp=new createNewProduct(driver);
			cnp.createProductInformation(productName);
			
		    //step5; create campaiagn
			hp.MoreCampiganLink(driver);
			createCampaign cc=new createCampaign(driver);
			cc.getCreatecampaignimg().click();
			createNewCampaign cnc=new createNewCampaign(driver);
			cnc.createcampaign(campaignName, productName);
			
			
			//verification
			campaigninfo ci=new campaigninfo(driver);
			String actualresult = ci.getSuccessfullmsg().getText();
			System.out.println(actualresult);
			boolean flag = actualresult.contains(campaignName);
			Assert.assertTrue(flag, "campiagn  not created");
			System.out.println("campigan created");
			
	}
}
		
		
	/*		WebDriverUtility Wlib= new WebDriverUtility();
			ExcelUtility Elib= new ExcelUtility();
			FileUtility Flib=new FileUtility();
			
			
			//Read data from property file
			String BROWSER=Flib.getPropertyKeyValue("browser");
			String URL=Flib.getPropertyKeyValue("url");
/*			String USERNAME=Flib.getPropertyKeyValue("username");
			String PASSWORD=Flib.getPropertyKeyValue("password");
			*/
		
			//creating random number
			//int rndm1 = JavaUtility.getRanDomNumber();
			
			
			
			
			//READ DATA from EXCEL
		/*	 String productName = Elib.getDataFromExcel("Campaign", 1, 0)+rndm1;
			 String campaignName = Elib.getDataFromExcel("Campaign", 1, 1)+rndm1;

			
			
			
			/*type of browser to launch*/
		/*	WebDriver driver=null;
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
			
			
			
			Wlib.waitUntilPageLoad(driver);
			//login
			//step1; login
			Login lp=new Login(driver);
			driver.get(URL);
			lp.loginToApp();   
			
			
			//step2;navigate to product
			//navigate to contact
			Home hp=new Home(driver);
			hp.getProductslink().click();
			
			//step3;create product
			createProduct cp=new createProduct(driver);
			cp.getCreatproductimg().click();
			
			//step4;create new product
			createNewProduct cnp=new createNewProduct(driver);
			cnp.createProductInformation(productName);
			
		    //step5; create campaiagn
			hp.MoreCampiganLink(driver);
			createCampaign cc=new createCampaign(driver);
			cc.getCreatecampaignimg().click();
			createNewCampaign cnc=new createNewCampaign(driver);
			cnc.createcampaign(campaignName, productName);
			
			//step6;logout
			
			hp.Logout();
			driver.close();
	}
}
			
			
			
			
			
			
			
			
		//	driver.get(URL);
	/*		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
			driver.findElement(By.xpath("//input[@id='submitButton']")).click();
			
			
			//create product
			driver.findElement(By.linkText("Products")).click();
			driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
			driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productName);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
			wlib.mouseOver(driver, ele2);
			*/
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	/*		//create campaign
			driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			WebElement ele = driver.findElement(By.xpath("//img[@alt='Create Campaign...']"));
			wlib.waitForElementVisibility(driver, ele);
			ele.click();
			driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campaignName);
			
			driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();	
			
			//switch to child window
			wlib.switchToWindow(driver, "Products&action");
			
			//actions on child browser
			driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(productName);
			driver.findElement(By.xpath("//input[@name='search']")).click();
			driver.findElement(By.xpath("//a[.='"+productName+"']")).click();
			
			
			//switching to parent window
			wlib.switchToWindow(driver, "campaigns");
			
			driver.findElement(By.xpath("//input[@ title='Save [Alt+S]']")).click();
			
			String actualresult = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			
			if(actualresult.contains(campaignName))
			{
				System.out.println(campaignName+"TEST CASE PASS");
			}
			else
			{
				System.out.println(campaignName+"TEST CASE FAIL");
			}
		
			WebElement ele3 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wlib.waitForElementVisibility(driver, ele3);

			
			//mouse over actions on signout
			wlib.mouseOver(driver, ele3);
			driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
			driver.close();
		}
	}
*/

