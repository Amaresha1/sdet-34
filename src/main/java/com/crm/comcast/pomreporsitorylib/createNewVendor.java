package com.crm.comcast.pomreporsitorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createNewVendor {

	public createNewVendor (WebDriver driver) {
		PageFactory.initElements(driver, this);
	
}

	@FindBy(xpath="//input[@ name='vendorname']")
	private WebElement lastname;
	
	@FindBy(xpath="//input[@ title='Save [Alt+S]']")
	private WebElement savebutton;

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

}