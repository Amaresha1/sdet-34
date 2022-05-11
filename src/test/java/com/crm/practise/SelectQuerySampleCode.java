
package com.crm.practise;

import java.sql.ResultSet;

import com.crm.comcastgenericutility.DataBaseUtility;

public class SelectQuerySampleCode {
	public static void main(String[] args) throws Throwable {
		DataBaseUtility dlib=new DataBaseUtility();
		
		dlib.connectToDatabase();
		ResultSet resultset = dlib.ExceuteQuery("select * from students_info");
		while(resultset.next())
		{
			System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4));
		}
		dlib.closeDb();
	}
	}
		
	/*		
		//step1;load/register
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step;2
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		System.out.println("connection is done");
		
		//step;3 create query statement
		Statement stat = conn.createStatement();
		String query = "select * from students_info";
		
		//step4; execute the query
		ResultSet resultset = stat.executeQuery(query);
		while(resultset.next()) {
			System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4));
			
		}
	    //step5;close the connection
			conn.close();
			System.out.println("close db");
		}

	}*/


