package com.bloodBankDonorManagementSystem.DAO;

import java.sql.*;

import com.bloodBankDonorManagementSystem.DBConnection.*;

public class LoginDao {
	
public static boolean checkdata(String login_id,String password) throws SQLException
{
	String query1="select * from login;";
	Connection con1=DBConnection.getConnection();
	Statement statement = con1.createStatement();
	ResultSet resultSet = statement.executeQuery(query1);
	while(resultSet.next()) {
		
		if(resultSet.getString(1).equalsIgnoreCase(login_id)&&resultSet.getString(2).equalsIgnoreCase(password))
		{
			return true;
		}
	}
	return false;
}
}
