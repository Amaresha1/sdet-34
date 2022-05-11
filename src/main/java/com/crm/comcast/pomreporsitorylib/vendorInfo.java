package com.crm.comcast.pomreporsitorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vendorInfo {
	
	public vendorInfo (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
		@FindBy(xpath="//span[@class='lvtHeaderText']")
		private WebElement successfullmsg;
		public WebElement getSuccessfullmsg() {
			return successfullmsg;
		}

		
}
