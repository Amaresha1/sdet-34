package com.crm.comcast.pomreporsitorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactinfo {
	

	public contactinfo (WebDriver driver) {
		PageFactory.initElements(driver, this);
}

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement successfullmsg;

	public WebElement getSuccessfullmsg() {
		return successfullmsg;
	}
	
	public void deleteContact(WebDriver driver) {
	
		
		Home hm=new Home(driver);
		hm.getContactslink().click();
		
		
	}

}
