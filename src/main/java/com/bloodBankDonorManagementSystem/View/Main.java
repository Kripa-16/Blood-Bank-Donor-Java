package com.bloodBankDonorManagementSystem.View;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.bloodBankDonorManagementSystem.DAO.LoginDao;
public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws SQLException, ParseException, IOException {
		Scanner in = new Scanner(System.in);
		
		String login = "";
		String password = "";
		int i=3;
		while (i>=0) {
			if(i==0) {
				 System.out.println("\n   You have 3 Wrong attempts!! Try after some time!!");
				 System.exit(0);
			 }
			System.out.println("\n   Enter Your Login Id: ");
			 login=in.next();
			System.out.println("   Enter your Password: ");
			 password=in.next();
			 if(LoginDao.checkdata(login, password))
			 {
				 break;
			 }
			 
			 else {
				System.out.println("\n   Please Enter correct Login id & Password");
				i=i-1;
				System.out.println("\n   "+i+" Attempts left!!");
			} 
		}
		
		
		while(true) {
			System.out.println("**************************************************************************");
			System.out.println("                        BLOOD BANK MANAGEMENT SYSTEM                      ");
			System.out.println("**************************************************************************");
			System.out.println(   "   1.Add Donor\n\n"
							    + "   2.Update Donor details\n\n"
							    + "   3.View all Donors\n\n"
							    + "   4.Search Donor by Blood Group\n\n"
							    + "   5.Search Donor by City\n\n"
							    + "   6.Delete Donor(with ID)\n\n"
							    + "   7.View Stock\n\n"
							    + "   8.Donate Now!!\n\n"
							    + "   9.Supply Now!!\n\n"
							    + "   10.LogOut");
			
			System.out.println("\n\n     Choose your option");
			int opt =0;
			while (true) {
				try {
					opt = in.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Please enter your choice as an integer.");
					in.nextLine();  // Clear the invalid input
				}
			}

			switch(opt) {
			case 1: Menu.addDonor();
					break;
					
		    case 2: Menu.updateDonor();
		    		break;
		    		
		    case 3: Menu.displayDonorDetails();
		    		break;
		    		
		    case 4: Menu.searchByBgroup();
		    		break;
		    		
		    case 5: Menu.searchCity();
					break;
					
		    case 6: Menu.deleteDonorDetail();
		    		break;
		    		
		    case 7: Menu.viewStock();
		    		break;
		    
		    case 8: Menu.stockIncrease();
		    		break;
		    		
		    case 9: Menu.stockDecrease();
					break;
					
		   case 10: System.out.println("\nv   Logging out...");
		    		System.exit(0);
		    		
		   default: System.out.println("\n   Enter a valid option!!");
				}
		}
		
	}

}
