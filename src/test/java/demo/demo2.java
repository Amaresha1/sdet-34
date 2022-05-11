package demo;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.comcastgenericutility.ExcelUtility;
import com.crm.comcastgenericutility.FileUtility;
import com.crm.comcastgenericutility.JavaUtility;
import com.crm.comcastgenericutility.WebDriverUtility;

public class demo2 {
	
	
	public static void main(String[] args) throws Throwable 
	{
		WebDriverUtility wlib= new WebDriverUtility();
		ExcelUtility Elib= new ExcelUtility();
		FileUtility Flib=new FileUtility();
		
		
		//Read data from property file
		String BROWSER=Flib.getPropertyKeyValue("browser");
		String URL=Flib.getPropertyKeyValue("url");
		String USERNAME=Flib.getPropertyKeyValue("username");
		String PASSWORD=Flib.getPropertyKeyValue("password");
	
		//creating random number
		int rndm1 = JavaUtility.getRanDomNumber();
		
		
		
		
		
		//READ DATA from EXCEL
		String productName = Elib.getDataFromExcel("Campaign", 1, 0)+rndm1;
		String campaignName = Elib.getDataFromExcel("Campaign", 1, 1)+rndm1;

		
		
		
		//type of browser to launch
		WebDriver driver=null;
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
		
		
		
		wlib.waitUntilPageLoad(driver);
		//login
		driver.get(URL);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		
		//create product
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		wlib.mouseOver(driver, ele2);
		
		
		
		
		//create campaign
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
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actualresult = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(actualresult.contains(campaignName))
		{
			System.out.println(campaignName+"---------TEST CASE PASS--------");
		}
		else
		{
			System.out.println(campaignName+"---------TEST CASE FAIL--------");
		}
	
		WebElement ele3 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.waitForElementVisibility(driver, ele3);

		
		//mouse over actions on signout
		wlib.mouseOver(driver, ele3);
		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
		driver.close();
	}
}



