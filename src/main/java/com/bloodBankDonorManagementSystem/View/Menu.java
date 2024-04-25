package com.bloodBankDonorManagementSystem.View;


import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.bloodBankDonorManagementSystem.Controller.Donor;
import com.bloodBankDonorManagementSystem.Controller.Stock;
import com.bloodBankDonorManagementSystem.DAO.DonorDAO;
import com.bloodBankDonorManagementSystem.DAO.StockDAO;
public class Menu {
	@SuppressWarnings("resource")
	public static void addDonor() throws SQLException {
		
		
		Scanner in = new Scanner(System.in);
		//donor name
		String dname = "";
		while(true) {
			System.out.println("   Enter the name of the Donor : ");
			dname = in.nextLine();
			if(dname.matches("[a-zA-Z ]+$")) break;
			else
			System.out.println("   Please enter a valid Name!!"); 
		}
		//donor age
		int age = 0;
		while(true) {
			System.out.println("   Enter the age of the donor (only Numbers) : ");
			age = in.nextInt();
			if(age<18) System.out.println("   Sorry!! Below 18 years is not the right age to donate!! Enter the right age!!");
			else break;
		}
		//gender
		String gender;
		while(true) {
			System.out.println("   Enter the gender of the donor (M/F): ");
			gender = in.next();
			if(gender.matches("[MF]")) break;
			else System.out.println("   Please enter a valid Gender!!");
		}
		//blood group
		String bg = "";
		while(true) {
			System.out.println("   Enter the Blood Group of the donor(Eg:- A+ or O-) : ");
			bg = in.next();
			if(bg.equals("A+") || bg.equals("A-") || bg.equals("B+") || bg.equals("B-") || bg.equals("O+") || bg.equals("O-") || bg.equals("AB+") || bg.equals("AB-") || bg.equals("RH")) break;
			else System.out.println("   Please enter a valid Blood Group!!");
		}
		//city
		
		System.out.println("   Enter the City of the donor : ");
		String city = in.next();
		
		//phone number
		String phno = "";
		while(true) {
			System.out.println("   Enter the Phone number of the donor : ");
			phno = in.next();
			if(phno.matches("[6-9]{1}[0-9]{9}")) break;
			else System.out.println("   Please enter a valid Phone number!!");
		}
		//email id
//		System.out.println("Enter the Email-ID of the donor : ");
		String email = "";
		while(true) {
			System.out.println("   Enter the Email-ID of the donor : ");
			email = in.next();
			if(email.matches("^[A-Za-z0-9+_.-]+@(gmail.com|yahoo.com)$"))
				break;
			else 
				System.out.println("   Please enter a valid Email Address!!");
		}
		
		Date lastDonationDate = null;
		SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
		dFormat.setLenient(false);
		String lastDDate = "";
		while(true) {
			System.out.println("   Enter the Last Date of Donation (dd-MM-yyyy) : ");
			lastDDate=in.next();
			if(lastDDate.matches("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-20[0-9]{2}$")) {
				break;
			}
			System.out.println("   Please enter a Valid date!!");
		}
		
		try {
		lastDonationDate=dFormat.parse(lastDDate);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		
		//id 
		Donor d = new Donor(dname, age, gender, bg, city, phno, email,lastDonationDate);
		DonorDAO.addDonorDetails(d);
		//in.close();
	}
	
	@SuppressWarnings("resource")
	public static void updateDonor() throws SQLException, IOException {
		Scanner in = new Scanner(System.in);
		
		System.out.println("   City or Email-ID or Phone Number?\n\n   Choose the field to be updated(c or e or p): ");
		 
		char str = (char) System.in.read();
		if(str =='c') {
			System.out.println("   Enter the Donor ID : ");
			String idString1 = in.next();
			System.out.println("   Enter the new City : ");
			String newCity= in.next();
			DonorDAO.updateCity(idString1, newCity);
		}
		else if(str == 'e') {
			System.out.println("   Enter the Donor ID : ");
			String idString2 = in.next();
			String newEmail = "";
			while(true) {
				System.out.println("   Enter the new Email-ID of the donor : ");
				newEmail = in.next();
				if(newEmail.matches("^[A-Za-z0-9+_.-]+@(gmail.com|yahoo.com)$"))
					break;
				else 
					System.out.println("   Please enter a valid Email Address!!");
			}
			DonorDAO.updateEmail(idString2, newEmail);
		}
		else if(str =='p') {
			System.out.println("   Enter the Donor ID : ");
			String idString3 = in.next();
			String newPhno = "";
			while(true) {
				System.out.println("   Enter the Phone number of the donor : ");
				newPhno = in.next();
				if(newPhno.matches("[6-9]{1}[0-9]{9}")) break;
				else System.out.println("   Please enter a valid Phone number!!");
			}
			DonorDAO.updatePhoneNumber(idString3, newPhno);
		}
		//in.close();
	}
	
	public static void displayDonorDetails() throws SQLException {
		DonorDAO.displayDonorDetails();
	}
	
	@SuppressWarnings("resource")
	public static void searchByBgroup() throws SQLException {
		Scanner in = new Scanner(System.in);
		String bgroup = "";
		while(true) {
			System.out.println("   Enter the Blood Group of the donor(Eg:- A+ or O-) : ");
			bgroup = in.next();
			if(bgroup.equals("A+") || bgroup.equals("A-") || bgroup.equals("B+") || bgroup.equals("B-") || bgroup.equals("O+") || bgroup.equals("O-") || bgroup.equals("AB+") || bgroup.equals("AB-") || bgroup.equals("RH")) break;
			else System.out.println("   Please enter a valid Blood Group!!");
		}
		DonorDAO.searchByBloodGroup(bgroup);
	}
	
	@SuppressWarnings("resource")
	public static void searchCity() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.println("   Enter the City to be searched : ");
		String city1 = in.next();
		DonorDAO.searchByCity(city1);
	}
	
	@SuppressWarnings("resource")
	public static void deleteDonorDetail() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.println("   Enter the ID of the Donor to be deleted : ");
 		String donorID = in.next();
 		DonorDAO.deleteDonorDetails(donorID);
	}
	
	public static void viewStock() throws SQLException {
		System.out.println("--------------Stock Details-------------");;
		StockDAO.display();
	}
	
	@SuppressWarnings("resource")
	public static void stockIncrease() throws SQLException, ParseException {
		Scanner in = new Scanner(System.in);
		System.out.println("--------------Donation Update-------------");
		
		//donor id
		System.out.println("   Enter your Donor ID : ");
		int dID = in.nextInt();
		
        boolean exists = DonorDAO.updateDonation(dID);
        
        if(exists) {
    		//units to be donated
    		System.out.println("   Enter the no of units donated : ");
    		int units1 = in.nextInt();
    		
    		String bgString = DonorDAO.returnBloodGroup(dID);
    		
    		//passing the data to the stock class
    		Stock stock = new Stock(bgString, units1);
    		
    		//passing the donation update to Stock data
    		StockDAO.updateDonation(stock);
       }
       else return;
		
	}
	
	@SuppressWarnings("resource")
	public static void stockDecrease() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.println("--------------Supply Update-------------");
		
		//blood group
		String bgString2 = "";
		while(true) {
			System.out.println("   Enter the requested Blood Group(Eg:- A+ or O-) : ");
			bgString2 = in.next();
			if(bgString2.equals("A+") || bgString2.equals("A-") || bgString2.equals("B+") || bgString2.equals("B-") || bgString2.equals("O+") || bgString2.equals("O-") || bgString2.equals("AB+") || bgString2.equals("AB-") || bgString2.equals("RH")) break;
			else System.out.println("   Please enter a valid Blood Group!!");
		}
		
		//units to be supplied
		System.out.println("   Enter the no of units requested : ");
		int units2 = in.nextInt();
		
		//passing values to stock class
		Stock stock = new Stock(bgString2, units2);
		
		//passing the update of supply to Stock data
		StockDAO.updateSupply(stock);
	}
	
	
}
