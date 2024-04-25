package com.bloodBankDonorManagementSystem.DBConnection;

import java.sql.*;

public class DBConnection {
	private static final String url="jdbc:mysql://localhost:3306/bloodbank";
	private static final String userName="root";
	private static final String  password="root";
	 public static Connection getConnection() throws SQLException{
		 return DriverManager.getConnection(url, userName, password);
	 }
}
