package com.jdbc.properties;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DataBaseConnectionUsingPropFile {
	public static void main(String[] args) throws Exception {
		FileInputStream fis= new FileInputStream("C:\\Users\\SRS-Employee\\git\\repository\\jdbcpractic\\src\\com\\jdbc\\properties\\database.properties");
		Properties properties=new Properties();
		properties.load(fis);
		String Dname=(String)properties.get("Dname");
		String Url=(String)properties.get("Url");
		String User=(String)properties.get("UserName");
		String Password=(String)properties.get("Password");
		try {
		Class.forName(Dname);
		Connection connection=DriverManager.getConnection(Url, User, Password);
		Statement statement = connection.createStatement();
		System.out.println("Connection done");
		ResultSet resultset= statement.executeQuery("Select * from emp2");
		while(resultset.next())
		{
			for(int i=1; i<=3; i++)
			{
				System.out.println(resultset.getString(i));
			}
			System.out.println("--------");
		}
		}
		catch(Exception e)
		{
			System.out.println("Exception in database");
			e.printStackTrace();
		}
				
	}

}
