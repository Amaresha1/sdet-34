package com.crm.practise;

import org.testng.annotations.Test;

public class dependencyPriority {

	
	@Test(priority = 0, dependsOnMethods = "test2")
	
	public void test1() {
		int Array[]= {1,3};
		System.out.println(Array[5]);	
	}
	@Test (priority = 1, dependsOnMethods = "test3")
	public void test2() {
	
		System.out.println("=======2nd test======");	
	
}
	
	@Test(priority = 2) 
	public void test3() {
		
		System.out.println("=======3nd test======");	
	
}

}
	
