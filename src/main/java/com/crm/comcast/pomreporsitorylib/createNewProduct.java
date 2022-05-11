package com.crm.comcast.pomreporsitorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createNewProduct {

	public createNewProduct (WebDriver driver) {
		PageFactory.initElements(driver, this);
}

	@FindBy(xpath="//input[@name='productname']")
	private WebElement productname;
	
	@FindBy(xpath="//input[@ title='Save [Alt+S]']")
	private WebElement savebutton;

	public WebElement getProductname() {
		return productname;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	
	public void createProductInformation(String productname) {
		getProductname().sendKeys(productname);
		savebutton.click();
	}
	
}
