package com.crm.comcast.pomreporsitorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcastgenericutility.WebDriverUtility;

public class createContact extends WebDriverUtility{
	WebDriver driver=null;
	
	
	public createContact (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createcontactimg;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement searchfor;
	
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement in;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastname;
	
	@FindBy(xpath="(//input[@class='crmbutton small create'])[1]")
	private WebElement search;
	
	@FindBy(xpath="(//a[@title='Contacts']")
    private WebElement lastnameclick;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement delete1;

	@FindBy(xpath="//a[.='edit']")
	private WebElement edit;
	
	public WebElement getDelete1() {
		return delete1;
	}



	public WebElement getEdit() {
		return edit;
	}



	public WebElement getLastnameclick() {
		return lastnameclick;
	}



	public WebElement getDelete() {
		return delete1;
	}



	public WebDriver getDriver() {
		return driver;
	}



	public WebElement getCreatecontactimg() {
		return createcontactimg;
	}



	public WebElement getSearchfor() {
		return searchfor;
	}



	public WebElement getIn() {
		return in;
	}



	public WebElement getLastname() {
		return lastname;
	}



	public WebElement getSearch() {
		return search;
	}



	public void delectContact(String contactname,WebDriver driver) {
		searchfor.sendKeys(contactname);
		in.click();
		select(in, 2);
		search.click();
		driver.findElement(By.xpath("//a[.='"+contactname+"']")).click();
		
	//	getLastnameclick().click();
		delete1.click();
		acceptAlert(driver);
	}
		
		
		public void editContact(String ln,WebDriver driver) {
			edit.click();
			lastname.clear();
			lastname.sendKeys(ln);
			createNewContact cnc= new createNewContact(driver);
			cnc.getSavebutton().click();
			
			
		
		}
	




		
		
	}
		
		
		
		
		

	
	

