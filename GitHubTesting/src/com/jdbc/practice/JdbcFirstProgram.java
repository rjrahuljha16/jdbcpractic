package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcFirstProgram {
	public static void main(String[] args) {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			Statement st= con.createStatement();
			int i= st.executeUpdate("create table emp2(name varchar(30) not null,empid number(20) not null,salary number(30) not null)");
		    System.out.println(i+" Table created");
		}
		catch(Exception e)
		{
			System.out.println("Exception occured");
			e.printStackTrace();
		}
	}
}
