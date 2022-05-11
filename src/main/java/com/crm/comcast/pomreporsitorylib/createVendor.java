package com.crm.comcast.pomreporsitorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createVendor {
	
	public createVendor (WebDriver driver) {
		PageFactory.initElements(driver, this);

}

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebDriver createvendorimg;

	public WebDriver getCreatevendorimg() {
		return createvendorimg;
	}
	
}