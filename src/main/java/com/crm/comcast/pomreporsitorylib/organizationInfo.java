package com.crm.comcast.pomreporsitorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organizationInfo {
	
	public organizationInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement succesfullmsg;

	public WebElement getSuccesfullmsg() {
		return succesfullmsg;
	}
	
	

}
