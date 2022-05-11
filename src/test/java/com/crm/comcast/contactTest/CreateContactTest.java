package com.crm.comcast.contactTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.pomreporsitorylib.Home;
import com.crm.comcast.pomreporsitorylib.contactinfo;
import com.crm.comcast.pomreporsitorylib.createContact;
import com.crm.comcast.pomreporsitorylib.createNewContact;
import com.crm.comcastgenericutility.BaseClass;
import com.crm.comcastgenericutility.JavaUtility;

public class CreateContactTest extends BaseClass{
	@Test(groups={"smokeTest"})
	
	public void createcContactWithMan() throws Throwable {
	
        
     
		
		int ramint = JavaUtility.getRanDomNumber();
		String contactname = elib.getDataFromExcel("contacts", 0, 0)+ramint;
		
		
		//navigate to contact
				Home hp=new Home(driver);
				hp.getContactslink().click();
				
				//create contact

				createContact cc=new createContact(driver);
				cc.getCreatecontactimg().click();
				
				
				//create new contact
				createNewContact cnc= new createNewContact(driver);
				cnc.createnewcontact(contactname);
				
				//contact info 
				 contactinfo cn=new contactinfo(driver);
				 String actualresult = cn.getSuccessfullmsg().getText();
				 
					System.out.println(actualresult);
					boolean flag = actualresult.contains(contactname);
					Assert.assertTrue(flag, "contact  not created");
					System.out.println("contact created with mandatory field");
					
				 
			/*	  if(actualresult.contains(contactname)) {
			        	System.out.println("test case is passed");
			        }else {
			        	System.out.println("test case is fail");
			        }*/
	}

	
	
	@Test(groups={"smokeTest"})
	
	public void createContWithoutMan() throws Throwable {
		
		
		int ramint = JavaUtility.getRanDomNumber();
		String contactname = elib.getDataFromExcel("contacts", 0, 0)+ramint;
		
		
		
		//navigate to contact
		Home hp=new Home(driver);
		hp.getContactslink().click();
		
		//create contact

		createContact cc=new createContact(driver);
		cc.getCreatecontactimg().click();
		
		
		//create new contact
		createNewContact cs=new createNewContact(driver);
		cs.createContactWithoutManadatory(driver,contactname);
		
		//contact info 
		contactinfo cn=new contactinfo(driver);
	    String actualresult = cn.getSuccessfullmsg().getText();
	    
		System.out.println(actualresult);
		boolean flag = actualresult.contains(contactname);
		Assert.assertTrue(flag, "contact  not created");
		System.out.println("contact created without mandatory");
		
	 
		 
		/*  if(actualresult.contains(contactname)) {
	        	System.out.println("test case is passed");
	        }else {
	        	System.out.println("test case is fail");
	        }*/
		
	}
	@Test(groups={"smokeTest"})
	
	public void createAccountWithGroup() throws Throwable{
		
		int ramint = JavaUtility.getRanDomNumber();
		String contactname = elib.getDataFromExcel("contacts", 0, 0)+ramint;
		//navigate to contact
		Home hp=new Home(driver);
		hp.getContactslink().click();
		
		//create contact

		createContact cc=new createContact(driver);
		cc.getCreatecontactimg().click();
		
		//create new contact
		createNewContact cs=new createNewContact(driver);
		cs.createNewContactWithAssignedTo(contactname);
		
		//contact info 
		contactinfo cn=new contactinfo(driver);
	    String actualresult = cn.getSuccessfullmsg().getText();
	    
		System.out.println(actualresult);
		boolean flag = actualresult.contains(contactname);
		Assert.assertTrue(flag, "contact  not created");
		System.out.println("account created with group ");
		
	 
		 
		/*  if(actualresult.contains(contactname)) {
	        	System.out.println("test case is passed");
	        }else {
	        	System.out.println("test case is fail");
	        }*/
		
	}
	
	
}
