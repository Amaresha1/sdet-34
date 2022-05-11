package com.crm.comcast.pomreporsitorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcastgenericutility.WebDriverUtility;

public class Home extends WebDriverUtility{

		WebDriver driver;
		
		
		 public Home(WebDriver driver) {
			 this.driver= driver;
			 PageFactory.initElements(driver,this);
		 }
		 
		 @FindBy(linkText = "Organizations")
		 private WebElement Organizationslink;
		 
		 @FindBy(linkText = "Contacts")
		 private WebElement Contactslink;
		 
		 
		 @FindBy(linkText = "Products")
		 private WebElement Productslink;
		 
		 
		 @FindBy(linkText = "More")
		 private WebElement Morelink;
		 
		 @FindBy( xpath = "//a[@name='Campaigns']")
		 private WebElement Campaignlink;
		 
		 @FindBy( xpath = "//img[@src='themes/softed/images/user.PNG']")
		 private WebElement administratorimg;
		 
		 @FindBy(xpath = "//a[.='Sign Out']")
		 private WebElement Signoutlink;


		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getOrganizationslink() {
			return Organizationslink;
		}

		public WebElement getContactslink() {
			return Contactslink;
		}

		public WebElement getProductslink() {
			return Productslink;
		}

		public WebElement getMorelink() {
			return Morelink;
		}

		public WebElement getCampaignlink() {
			return Campaignlink;
		}

		public WebElement getAdministratorimg() {
			return administratorimg;
		}

		public WebElement getSignoutlink() {
			return Signoutlink;
		}
		 
		 /*
		  * method for logout
		  */
		public void Logout(){
			mouseOver(driver,administratorimg);
			Signoutlink.click();
			
			
			
		}
		
		public void MoreCampiganLink(WebDriver driver) {
			waitForElementVisibility(driver, Morelink);
			mouseOver(driver, Morelink);
			Campaignlink.click();
		}
		 
		 
		 
		 
		 
		 
			 
		 
		


	}


