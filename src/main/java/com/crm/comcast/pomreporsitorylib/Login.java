package com.crm.comcast.pomreporsitorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcastgenericutility.FileUtility;

public class Login extends FileUtility {
	WebDriver driver=null;

	public Login(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
		
	
		
		@FindBy(name="user_name")
	     private WebElement username;
		
		@FindBy(name="user_password")
	     private WebElement password;
		
		@FindBy(id="submitButton")
	     private WebElement login;

		public WebElement getUsername() {
			return username;
		}

		public WebElement getPassword() {
			return password;
		}

		public WebElement getSubmit() {
			return login;
		}
		/*
		 * login to application by passin username and password
		 */
		public void loginToApp(String username1 , String password1 ) throws Throwable {
			
			username.sendKeys(username1);
			password.sendKeys(password1);
			login.click();
		}
			
			
		/*
		 * login to application by calling method
		 */
	    public void loginToApp() throws Throwable {
	    	
	    	username.sendKeys(getPropertyKeyValue("username"));
	        password.sendKeys(getPropertyKeyValue("password"));
	        login.click();
	        
	        
	    
	    	
	    	
	    }
	

}
