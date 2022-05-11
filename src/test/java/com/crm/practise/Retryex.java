package com.crm.practise;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcastgenericutility.BaseClass;
import com.crm.comcastgenericutility.RetryImpClass;

public class Retryex extends BaseClass {
	
	@Test(retryAnalyzer = RetryImpClass.class)
	
	public void retryy(){
		Assert.assertEquals("a", "n");
	}

}
