package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class RetriveDataWithMetadata 
{
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			Statement st=con.createStatement();
			ResultSet rst=st.executeQuery("select * from emp2");
			ResultSetMetaData rsmd=rst.getMetaData();
			int n=rsmd.getColumnCount();
			for(int i=1; i<=n; i++)
			{
				System.out.println("Feild number "+1);
				System.out.println("Feild NAME "+ rsmd.getColumnName(i));
				System.out.println("Feild Type "+ rsmd.getColumnType(i));
				System.out.println("File Size "+rsmd.getColumnDisplaySize(i));
			}
			while(rst.next())
			{
				for(int i=1; i<=3; i++)
				{
					System.out.println(rst.getString(i)+" ");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
