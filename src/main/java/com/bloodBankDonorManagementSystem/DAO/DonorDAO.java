package com.bloodBankDonorManagementSystem.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bloodBankDonorManagementSystem.Controller.Donor;
import com.bloodBankDonorManagementSystem.DBConnection.*;
public class DonorDAO {
	public static void addDonorDetails(Donor donor) throws SQLException {
		
		String query = "Insert into Donor(donor_name,age,gender,blood_group,city,phone_number,email_id,lastdonation_date) values(?,?,?,?,?,?,?,?);";
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		//preparedStatement.setString(1, donor.getDonorId());
		preparedStatement.setString(1, donor.getDonorName());
		preparedStatement.setInt(2,donor.getAge());
		preparedStatement.setString(3, donor.getGender());
		preparedStatement.setString(4, donor.getBloodGroup());
		preparedStatement.setString(5, donor.getCity());
		preparedStatement.setString(6, donor.getPhno());
		preparedStatement.setString(7, donor.getEmail());
		java.sql.Date donationDate=new java.sql.Date(donor.getLastDonationDate().getTime());
		preparedStatement.setDate(8, donationDate);
		preparedStatement.executeUpdate();
		System.out.println("\n   Donor Details updated successfully!!");
	}
	
	public static void updateCity(String donorID ,String city) throws SQLException {
		String query1 = "Select *  from donor where donor_id = ?;";
		Connection connection1 = DBConnection.getConnection();
		PreparedStatement preparedStatement1 = connection1.prepareStatement(query1);
		preparedStatement1.setString(1, donorID);
		ResultSet resultSet= preparedStatement1.executeQuery();
		
		String idString = "";
		while(resultSet.next()) {
			idString = resultSet.getString(1);
		}
		
		if(idString=="") {
			System.out.println("\n   Donor ID not found!!");
			return;
		}
		
		String query2 = "Update Donor set City = ? where Donor_id = ?;";
		Connection connection2 = DBConnection.getConnection();
		PreparedStatement preparedStatement2 = connection2.prepareStatement(query2);
		preparedStatement2.setString(1, city);
		preparedStatement2.setString(2, donorID);
		preparedStatement2.executeUpdate();
		System.out.println("\n   Donor's new City updated sucessfully!!");
	}
	
	public static void updatePhoneNumber(String donorID ,String phno) throws SQLException {
		String query1 = "Select donor_ID from donor where donor_ID = ?;";
		Connection connection1 = DBConnection.getConnection();
		PreparedStatement preparedStatement1 = connection1.prepareStatement(query1);
		preparedStatement1.setString(1, donorID);
		ResultSet resultSet= preparedStatement1.executeQuery();
		String idString = "";
		while(resultSet.next()) {
			idString = resultSet.getString(1);
		}
		if(idString=="") {
			System.out.println("\n   Donor ID not found!!");
			return;
		}
		
		String query = "Update Donor set Phone_Number = ? where Donor_ID = ?;";
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement2 = connection.prepareStatement(query);
		preparedStatement2.setString(1, phno);
		preparedStatement2.setString(2, donorID);
		preparedStatement2.executeUpdate();
		System.out.println("\n   Donor's new Phone Number updated sucessfully!!");
	}
	
	public static void updateEmail(String donorID ,String newEmail) throws SQLException {
		String query1 = "Select donor_ID from donor where donor_ID = ?;";
		Connection connection1 = DBConnection.getConnection();
		PreparedStatement preparedStatement1 = connection1.prepareStatement(query1);
		preparedStatement1.setString(1, donorID);
		ResultSet resultSet= preparedStatement1.executeQuery();
		String idString = "";
		while(resultSet.next()) {
			idString = resultSet.getString(1);
		}
		if(idString=="") {
			System.out.println("\n   Donor ID not found!!");
			return;
		}
		
		String query = "Update Donor set Email_ID = ? where Donor_ID = ?;";
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement2 = connection.prepareStatement(query);
		preparedStatement2.setString(1, newEmail);
		preparedStatement2.setString(2, donorID);
		preparedStatement2.executeUpdate();
		System.out.println("\n   Donor's new Email ID updated sucessfully!!");
	}
	
	public static void displayDonorDetails() throws SQLException {
		String query = "Select * from Donor;";
		Connection connection=DBConnection.getConnection();	
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery(query);
		
		if(resultSet.next()) {
			System.out.println("--------------Donor Details-------------");
			do {
				System.out.println(" ");
				System.out.println("Donor ID     : "+resultSet.getString(1));
				System.out.println("Donor Name   : "+resultSet.getString(2));
				System.out.println("Age          : "+resultSet.getString(3));
				System.out.println("Gender       : "+resultSet.getString(4));
				System.out.println("Blood Group  : "+resultSet.getString(5));
				System.out.println("City         : "+resultSet.getString(6));
				System.out.println("Phone number : "+resultSet.getString(7));
				System.out.println("Email ID     : "+resultSet.getString(8));
				System.out.println("\n");
			}
			while (resultSet.next()) ;
		}
		else {
			System.out.println("\n   No data found");
			return;
		}
			
	}
	
	public static void searchByCity(String citySearch) throws SQLException {
		String query = "Select * from Donor where City = ?;";
		Connection connection=DBConnection.getConnection();	
		PreparedStatement statement=connection.prepareStatement(query);
		statement.setString(1, citySearch);
		ResultSet resultSet=statement.executeQuery();
		
		if(!resultSet.isBeforeFirst()) {
			System.out.println("\n   No Donor Data Found with this city!!");
			return;
		}
		
		System.out.println("\n   Donor Details matching the city");
		while (resultSet.next()) {
			
			System.out.println("\n   Donor ID     : "+resultSet.getString(1));
			System.out.println("   Donor Name   : "+resultSet.getString(2));
			System.out.println("   Age          : "+resultSet.getString(3));
			System.out.println("   Gender       : "+resultSet.getString(4));
			System.out.println("   Blood Group  : "+resultSet.getString(5));
			System.out.println("   City         : "+resultSet.getString(6));
			System.out.println("   Phone number : "+resultSet.getString(7));
			System.out.println("   Email ID     : "+resultSet.getString(8));
			System.out.println("\n");
		}
	}
	
	public static void searchByBloodGroup(String bloodSearch) throws SQLException {
		String query = "Select * from Donor where Blood_Group = ?;";
		Connection connection=DBConnection.getConnection();	
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1, bloodSearch);
		ResultSet resultSet=preparedStatement.executeQuery();
		
		if(!resultSet.isBeforeFirst()) {
			System.out.println("\n   No Donor Data Found with this Blood Group!!!");
			return;
		}
		
		System.out.println("\n         Donor Details matching the Blood Group");
		while (resultSet.next()) {
			System.out.println("\n   Donor ID     : "+resultSet.getString(1));
			System.out.println("   Donor Name   : "+resultSet.getString(2));
			System.out.println("   Age          : "+resultSet.getString(3));
			System.out.println("   Gender       : "+resultSet.getString(4));
			System.out.println("   Blood Group  : "+resultSet.getString(5));
			System.out.println("   City         : "+resultSet.getString(6));
			System.out.println("   Phone number : "+resultSet.getString(7));
			System.out.println("   Email ID     : "+resultSet.getString(8));
			System.out.println("\n");
		}
	}
	
	public static void deleteDonorDetails(String id) throws SQLException {
		String query1 = "Select donor_ID from donor where donor_ID = "+id+";";
		Connection connection1 = DBConnection.getConnection();
		Statement statement1 = connection1.createStatement();
		ResultSet resultSet= statement1.executeQuery(query1);
		String idString = "";
		while(resultSet.next()) {
			idString = resultSet.getString(1);
		}
		if(idString=="") {
			System.out.println("\n   Donor ID not found!!");
			return;
		}
		
		String query = "Delete from Donor where Donor_ID ="+id+";";
		
		Connection connection = DBConnection.getConnection();
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		System.out.println("\n   Donor deleted Sucessfully");
	}

	


		public static boolean updateDonation(int dID) throws SQLException 
		{
			String query0 = "Select donor_ID from donor where donor_ID = ?;";
			Connection connection1 = DBConnection.getConnection();
			PreparedStatement statement1 = connection1.prepareStatement(query0);
			statement1.setInt(1, dID);
			ResultSet resultSet= statement1.executeQuery();
			
			int idString = 0;
			while(resultSet.next()) {
				idString = resultSet.getInt(1);
			}
			if(idString==0) {
				System.out.println("   Donor ID not found!!");
				return false;
			}
		
			String query="SELECT DATEDIFF(CURRENT_DATE(),lastdonation_date) FROM donor where Donor_id=?";
			Connection con=DBConnection.getConnection();	
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1,dID);
			ResultSet rSet=pst.executeQuery();
			
			long st=0;
			while (rSet.next()) {
				st=rSet.getLong(1);
				break;
			}
			
			if(st>=180) {
				String query1 = "update donor set LastDonation_Date = CURRENT_DATE() where Donor_ID =?;";
				Connection connection = DBConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(query1);
				statement.setInt(1, dID);
				statement.executeUpdate();
				return true;
			}
			
			else if(st==0) {
				System.out.println("\n   You are not eligible to donate blood now!!\n\n   Please Donate after 180 days!!");
				return false;
			}
			
			else {
				System.out.println("\n   You are not eligible to donate blood now!!\n\n   Please Donate after "+ (180-st) +" days!!");
				return false;
			}
		}

	public static String returnBloodGroup(int id) throws SQLException {
		String query1="select blood_group from donor where donor_id = ?;";
		Connection connection1=DBConnection.getConnection();	
		PreparedStatement preparedStatement1=connection1.prepareStatement(query1);
		preparedStatement1.setInt(1, id);
		
		ResultSet resultSet = preparedStatement1.executeQuery();
		String bgString = "";
		while(resultSet.next()) {
			bgString=resultSet.getString(1);
		}
		return bgString;
	}
		

}
