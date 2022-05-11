package com.crm.comcast.pomreporsitorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class campaigninfo {
	
	public campaigninfo (WebDriver driver) {
		PageFactory.initElements(driver, this);
}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement successfullmsg;

	public WebElement getSuccessfullmsg() {
		return successfullmsg;
	}
	
	

}
