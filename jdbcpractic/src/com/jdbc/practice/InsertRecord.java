package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class InsertRecord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			PreparedStatement pst =con.prepareStatement("insert into emp2 values(?,?,?)");
			System.out.println("=============================");
			System.out.println("Employee Details");
			System.out.println("Eneter Employee name");
			String name =sc.next();
			System.out.println("Enter employee Id");
			String empid=sc.next();
			System.out.println("Enter the emp salary");
			String salary=sc.next();
			pst.setString(1, name);
			pst.setString(2, empid);
			pst.setString(3, salary);
			int i=pst.executeUpdate();
			System.out.println(i+" emp table is updated");
			PreparedStatement pst1=con.prepareStatement("Select * from emp2 where name='"+name+"' ");
			ResultSet rst=pst1.executeQuery();
			while(rst.next()) {
				System.out.println(rst.getString("name"));
				System.out.println(rst.getString("empid"));
				System.out.println(rst.getString("salary"));
				}
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured");
			e.printStackTrace();
		}
		sc.close();
	}

}
