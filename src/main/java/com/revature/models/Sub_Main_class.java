package com.revature.models;

import java.util.List;

import java.util.Scanner;

import com.revature.repositories.ReimbursementDAO;
import com.revature.repositories.UserDAO;

public class Sub_Main_class {
	
	
		public static void displayMenu2() {
			ReimbursementDAO DAO = new ReimbursementDAO();
			UserDAO u = new UserDAO();
			boolean displayMenu = true; 
			Scanner scan = new Scanner(System.in); 
			
			
			System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
			System.out.println("Welcome to The Finance managers System");
			System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
		
			
			while(displayMenu) { 
				
				
				System.out.println("\n1 ->  all employees");
				System.out.println("2 -> past history for all employees");
				System.out.println("3 -> exit the application\n");
			
				
				
				int input = scan.nextInt();
				
				
				switch(input) {
				
				case 1 :{
					try {
					List<User> employees = u.getEmployees();
					for (User e : employees)
						System.out.println(e);
					
				} catch (Exception e) {
					System.out.println("we catch");
				}
					
					break;
					}
				
				case 2 :{
					try{List<Reimbursement> employees = DAO.getAllEmployeesall();
					for (Reimbursement e : employees)
						System.out.println(e);

				} catch (Exception e) {
					System.out.println("we catch");
				}
					
					
					System.out.println(" inside case 3");
					break;	
				}
				
				
				case 3: {
					displayMenu = false;
					break;
				}
				
				//this default block will catch any user inputs that don't match a valid menu option
				default: {
					System.out.println("Invalid selection... try again :'( ");
					break;
				}
		
				
				
				}
			}
		}
}
				
			
			
			//****
		