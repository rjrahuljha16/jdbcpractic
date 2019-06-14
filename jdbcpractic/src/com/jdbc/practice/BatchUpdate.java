package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchUpdate {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
		//	con.setAutoCommit(false);
			Statement statement = con.createStatement();
			//statement.addBatch("select * from emp2");
			statement.addBatch("insert into emp2 values('rohit',1001,25000)");
			statement.addBatch("update emp2 set name='rahul' where empid=5001");
			int res[]= statement.executeBatch();
			
			for(int i=1; i<res.length; i++)
			{
				System.out.println("Number of record affected "+res[i]);
			}
			//con.commit();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
