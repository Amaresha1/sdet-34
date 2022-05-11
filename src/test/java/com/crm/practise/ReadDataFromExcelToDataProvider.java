package com.crm.practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.comcast.pomreporsitorylib.Home;
import com.crm.comcast.pomreporsitorylib.createNewOraganization;
import com.crm.comcast.pomreporsitorylib.createOraganization;
import com.crm.comcast.pomreporsitorylib.organizationInfo;
import com.crm.comcastgenericutility.BaseClass;
import com.crm.comcastgenericutility.ExcelUtility;
import com.crm.comcastgenericutility.JavaUtility;

public class ReadDataFromExcelToDataProvider extends BaseClass
{
		
		@Test(dataProvider = "data")
		public void readDataTest(String OrgName ,String indname) throws Throwable
		{
			
			//Step 3: Navigate to Organization
			Home hp = new Home(driver);
			hp.getOrganizationslink().click();
		
			//Step 4: Create Organization
			createOraganization co = new createOraganization(driver);
			co.getCreateOrgImg().click();
			
			
			createNewOraganization cop = new createNewOraganization(driver);
		//	cop.createNewOrganization(OrgName+JavaUtility.getRanDomNumber());
			cop.createOrgWithInd(OrgName+JavaUtility.getRanDomNumber(), indname);
			
			//Step 5: Validation
			organizationInfo oi = new organizationInfo(driver);
			 String header = oi.getSuccesfullmsg().getText();
			 if(header.contains(OrgName))
			 {
				 System.out.println("TC IS PASS");
			 }else {
				 System.out.println("TC IS FAIL");
			 }
		}
		//Step 1: Create data using DataProvider
		@DataProvider(name = "data")
		public Object[][] getData() throws Throwable
		{
			ExcelUtility eLib = new ExcelUtility();
			Object[][] data = eLib.readDataForDataProvider("Sheet3");
			return data;
		}

	}

