package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class demo1 {
	public static void main(String[] args) throws Throwable {
		  Connection conn = null;
		  int result=0;
		
		 
		//step1;load/register
				Driver driverRef=new Driver();
				DriverManager.registerDriver(driverRef);
				
				//step;2
				
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
				System.out.println("connection is done");
				
				//step;3 create query statement
				Statement stat = conn.createStatement();
				String query = "insert into students_info values(8,'cam','linga','h')";
				
				//step4; execute the query
			    result= stat.executeUpdate(query);
		 
			if(result==1) {
			
				System.out.println("student inserted successfully");
		}else {
			    System.out.println("student not inserted");
		}
	
			    //step5;close the connection
					conn.close();
					System.out.println("close db");
				}

		


                      // En samachara en madtidiya
	}





