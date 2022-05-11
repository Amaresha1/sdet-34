package com.crm.comcastgenericutility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Lingaraj
 *
 */
public class FileUtility {
	/**
	 * to read the data from property file
	 * @param key
	 * @return
	 * @throws Throwable
	 */

    public String getPropertyKeyValue(String key) throws Throwable {
    	 FileInputStream fis = new FileInputStream(IConstants.PropertyFilePath);
    	 Properties pobj = new Properties();
    	 pobj.load(fis);
    	 String value = pobj.getProperty(key);
		return value;
   
		
		
		
		
		
	
			
		

}
}
