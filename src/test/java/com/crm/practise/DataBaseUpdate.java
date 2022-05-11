package com.crm.practise;

import com.crm.comcastgenericutility.DataBaseUtility;

public class DataBaseUpdate {

	public static void main(String[] args) throws Throwable {
		DataBaseUtility dlib=new DataBaseUtility();
		
		dlib.connectToDatabase();
		
		
		int result = dlib.insertdata("insert into students_info values(9,'sachi','sachiii','h')");
		
		if(result==1)
		{
			System.out.println("data inserted");
		}
		else {
			System.out.println("data not inserted");
		}

		
		dlib.closeDb();
	}

}
