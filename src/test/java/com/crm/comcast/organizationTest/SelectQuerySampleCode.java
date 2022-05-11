package com.crm.comcast.organizationTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQuerySampleCode {
	public static void main(String[] args) throws Throwable {
		
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

	}


