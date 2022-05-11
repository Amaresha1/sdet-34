package com.crm.comcastgenericutility;
/**
 * 
 * @author Lingaraj
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	
	
	Connection conn=null;
 
/**
 * to connect to database
 * @throws Throwable
 */
	public void connectToDatabase() throws Throwable{
		
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
		    conn = DriverManager.getConnection(IConstants.JDBC_URL_STRING, IConstants.JDBC_USERNAME, IConstants.JDBC_PASSWORD);
		
		
			
     }
			
/**
 * to execute only select query
 * @param Query
 * @return
 * @throws Throwable
 */
	
	public ResultSet ExceuteQuery(String Query) throws Throwable
	{
	  ResultSet	resultset=null;
		{

			Statement stat = conn.createStatement();
	        resultset = stat.executeQuery(Query);
	        return resultset;	
         }
	}
	

	/**
	 * to insert data into the database
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	
	public int insertdata (String query) throws Throwable {
		
			Statement stat = conn.createStatement();
			int result=stat.executeUpdate(query);
			return result;
		
	}
	/**
	 * to close the database
	 * @throws Throwable
	 */
	
	public void closeDb() throws Throwable {
		conn.close();
	}

	
	
	
	/**
	 * to exceute query and verify
	 * @param querry
	 * @param cloumnIndex
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	
	public boolean executeQuerryAndVerify(String querry,int cloumnIndex,String expectedData) throws Throwable {
		boolean flag=false;
		ResultSet result = conn.createStatement().executeQuery(querry);
		while(result.next()) {
			if(result.getString(cloumnIndex).equals(expectedData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println(expectedData+"Data is verified");
			return flag;
		}else {
			System.out.println(expectedData+"Data is not verified");
			return flag;
		}

	}


}
	



		
		
