package com.crm.comcastgenericutility;

import java.util.Random;

/**
 * 
 * @author Lingaraj
 *
 */


public class JavaUtility {
		/**
		 * it us used to generate random number
		 * @return int
		 */
	public static int getRanDomNumber()
	{
		Random random=new Random();
		int intrandom = random.nextInt(1000);
		return intrandom;
	}
	
    	/**
    	 * it is used to get system date & time in IST format
    	 * @return string
    	 */
    public String getSystemDateAndTime() {
    		java.util.Date date=new java.util.Date();
    		return	date.toString();
    }
    
    
    
    
    /**
     * used to get system date in YYYY=MM=DD
     * @return string
     */
    public String getSystemDateWithFormat() {
    	java.util.Date date=new java.util.Date();
    		String dateAndTime = date.toString();
    		
    		String YYYY = dateAndTime.split(" ")[5];
    	    String DD = dateAndTime.split(" ")[2];
    	    int MM = date.getMonth()+1;
    	    
    	    
    	    String finaleformate = YYYY +"-"+MM+"-"+DD;
    	    return finaleformate;
    }
    
    public String getsystemdate()
    {
    	java.util.Date date=new java.util.Date();
    	String dateAndTime=date.toString();
    	return dateAndTime.replace(" ","_").replace(":","_");
    	
    }
    	    		
    }
    
        
	
    	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

