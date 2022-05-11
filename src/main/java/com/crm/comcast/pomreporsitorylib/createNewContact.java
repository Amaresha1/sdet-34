package com.crm.comcast.pomreporsitorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcastgenericutility.WebDriverUtility;

public class createNewContact extends WebDriverUtility {
	//WebDriver driver=null;
	

	public createNewContact (WebDriver driver) {
		PageFactory.initElements(driver, this);
}

	@FindBy(xpath="//input[@ name='lastname']")
	private WebElement lastname;
	
	@FindBy(xpath="//input[@ title='Save [Alt+S]']")
	private WebElement savebutton;
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement groupRadio;
	
	@FindBy(xpath="//select[@name='assigned_group_id']")
	private WebElement supportGroup;
	
	
	

	public WebElement getGroupRadio() {
		return groupRadio;
	}

	public WebElement getSupportGroup() {
		return supportGroup;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	
	public void createnewcontact(String contactname) {
		getLastname().sendKeys(contactname);
		savebutton.click();
		
	}
	
	public void createNewContactWithAssignedTo(String contactname) {
		getLastname().sendKeys(contactname);
		getGroupRadio().click();
		select(supportGroup, 1);
		savebutton.click();
	}
		
	public void createContactWithoutManadatory(WebDriver driver,String contactname) {
		savebutton.click();
		acceptAlert(driver);
		getLastname().sendKeys(contactname);
		savebutton.click();
		
		
	}	
		
	
	
}