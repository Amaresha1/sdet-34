package com.crm.comcast.pomreporsitorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createProduct {
	
	public createProduct (WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement creatproductimg;

	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement searchproduct;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement search;
	
	public WebElement getSearchproduct() {
		return searchproduct;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getCreatproductimg() {
		return creatproductimg;
	}

	
	}
	
	


