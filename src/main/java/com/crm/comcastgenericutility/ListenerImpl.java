package com.crm.comcastgenericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImpl implements ITestListener {
	
	public void onTestFailure(ITestResult result) {
		
		
		System.out.println("failure");
		
		JavaUtility jlib=new JavaUtility();
		
		
		String testName = result.getMethod().getMethodName();
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		File srcfile=edriver.getScreenshotAs(OutputType.FILE);
	    File destfile=new File("./screenshot/"+testName+"_"+jlib.getsystemdate()+".png");
	    
	    try {
			FileUtils.copyFile(srcfile, destfile);
		} catch (IOException e) {
			
		}
		
		
	
		
		
	}

}