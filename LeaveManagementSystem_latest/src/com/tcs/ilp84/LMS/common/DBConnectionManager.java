package com.tcs.ilp84.LMS.common;

import java.sql.DriverManager;
import java.sql.Connection; //import java.sql.ResultSet;
import java.sql.SQLException;

//import java.sql.Statement;

public class DBConnectionManager {

	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@192.168.129.12:1521:ORCL";
	private static final String DB_USER = "a84core";
	private static final String DB_PASSWORD = "a84core";

	public static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
					DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}

}
