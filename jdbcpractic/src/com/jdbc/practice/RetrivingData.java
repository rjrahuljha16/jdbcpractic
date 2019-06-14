package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RetrivingData 
{
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			PreparedStatement pst= con.prepareStatement("select * from emp2");
			ResultSet rst=pst.executeQuery();
			while(rst.next())
			{
				for(int i=1;i<=3; i++)
				{
					System.out.println(rst.getString(i)+" ");
				}
				System.out.println("=====");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
