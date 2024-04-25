package com.bloodBankDonorManagementSystem.DAO;

import java.sql.*;

import com.bloodBankDonorManagementSystem.Controller.*;
import com.bloodBankDonorManagementSystem.DBConnection.*;
public class StockDAO {
	
	public static void updateDonation(Stock stock) throws SQLException {
		
		String query2="update Stocks set Stock_Left=Stock_Left+? where Blood_Group= ?;";
		
		Connection connection2=DBConnection.getConnection();	
		PreparedStatement preparedStatement2=connection2.prepareStatement(query2);
		preparedStatement2.setInt(1, stock.getStock());
		preparedStatement2.setString(2, stock.getBloodGroup());
		preparedStatement2.executeUpdate();
		System.out.println("\n   Thank you for the contribution!!Have a Great Day!!");
	}
	
	
	public static void updateSupply(Stock stock) throws SQLException {
		String query3 = "Select stock_left from stocks where blood_group =?;";
		Connection connection3=DBConnection.getConnection();	
		PreparedStatement prepareStatement3=connection3.prepareStatement(query3);
		prepareStatement3.setString(1, stock.getBloodGroup());
		ResultSet resultSet1 = prepareStatement3.executeQuery();
		int unitsLeft = 0;
		while(resultSet1.next()) {
			unitsLeft = resultSet1.getInt(1);
		}
		if(unitsLeft==0) {
			System.out.println("\n   Out of Stocks!!");
			return;
		}
		else if(unitsLeft<stock.getStock()) {
			System.out.println("\n   Insufficient Stocks!!");
			return;
		}
		else {
			String query="update Stocks set Stock_Left=Stock_Left-? where Blood_Group=?;";
			
			Connection connection=DBConnection.getConnection();	
			PreparedStatement preparedstatement=connection.prepareStatement(query);
			preparedstatement.setInt(1, stock.getStock());
			preparedstatement.setString(2, stock.getBloodGroup());
			preparedstatement.executeUpdate();
			System.out.println("\n   Supplied Successfully!!");
		}
		
		
	}
	
	public static void display() throws SQLException
	{
		String query="select * from Stocks";
		Connection connection=DBConnection.getConnection();	
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery(query);
		
		while (resultSet.next()) {
			System.out.println("\n   Blood_group : "+resultSet.getString(2));
			System.out.println("   Stock_left  : "+resultSet.getInt(3));
			System.out.println("\n");
		}	
		resultSet.close();
		}
}
