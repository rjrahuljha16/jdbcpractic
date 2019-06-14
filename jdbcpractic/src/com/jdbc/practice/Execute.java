package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Execute {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			PreparedStatement pst= con.prepareStatement("select * from emp2");
			boolean rst=pst.execute();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
