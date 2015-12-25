package com.tcs.ilp84.LMS.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String DB_Driver="oracle.jdbc.driver.OracleDriver";
	private static final String DB_Connection="jdbc:oracle:thin:@192.168.129.12:1521:ORCL";
	private static final String DB_user="a84core";
	private static final String DB_password="a84core";
	
	public static Connection getDBconnection()
	{
		Connection con=null;
		
		
		try
		{
			Class.forName(DB_Driver);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		try
		{
			con=DriverManager.getConnection(DB_Connection,DB_user,DB_password);
			return con;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			System.out.println(con);
		}
		return con;
		
	}


}
