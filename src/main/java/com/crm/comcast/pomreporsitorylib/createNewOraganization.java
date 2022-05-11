package com.crm.comcast.pomreporsitorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcastgenericutility.WebDriverUtility;

public class createNewOraganization extends WebDriverUtility {

	public createNewOraganization(WebDriver driver){
		PageFactory.initElements(driver, this);
		
		
		
	}
	
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement organizationname;
	

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;

	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industryDropDown;
	

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}


	public WebElement getOrganizationname() {
		return organizationname;
	}


	public WebElement getSavebutton() {
		return savebutton;
	}
	
	
	public void createNewOrganization(String Orgname) {
		getOrganizationname().sendKeys(Orgname);
		getSavebutton().click();
	}
	
	public void createOrgWithInd(String Orgname,String indname) {
		getOrganizationname().sendKeys(Orgname);
		select(industryDropDown, indname);
		getSavebutton().click();
		
	}
}
