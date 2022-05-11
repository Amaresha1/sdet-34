package com.crm.comcast.pomreporsitorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcastgenericutility.WebDriverUtility;

public class createNewCampaign extends WebDriverUtility{
	WebDriver driver;
	
	public createNewCampaign (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
}

	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campaignName;
	
	
	@FindBy(xpath="//input[@id='jscal_field_closingdate']")
	private WebElement exceptedCloseDate;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;

	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement productimg;
	
	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getExceptedCloseDate() {
		return exceptedCloseDate;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	
    public void createcampaign(String campaignname,String productName)	{
    	campaignName.sendKeys(campaignname);
    	productimg.click();
    	switchToWindow(driver,"Products&action");
    	createProduct cp=new createProduct(driver);
    	cp.getSearchproduct().sendKeys(productName);
    	cp.getSearch().click();
    	driver.findElement(By.xpath("//a[.='"+productName+"']")).click();
    	switchToWindow(driver, "Campaigns&action");
    	savebutton.click();
    	
    	
    }

	public WebElement getProductimg() {
		return productimg;
	}

}
