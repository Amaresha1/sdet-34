package com.crm.comcast.pomreporsitorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createCampaign {
	
	
	public createCampaign (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createcampaignimg;

	public WebElement getCreatecampaignimg() {
		return createcampaignimg;
	}

	
	}
	
	
	



