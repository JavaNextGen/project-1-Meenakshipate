package com.revature.models;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.revature.exceptions.NewUserHasNonZeroIdException;
import com.revature.repositories.ReimbursementDAO;
import com.revature.repositories.UserDAO;
import com.util.controller.ConstantVariable;

public class Mainclass {

	ReimbursementDAO eDAO = new ReimbursementDAO();
	
	UserDAO u = new UserDAO();

	public void displayMenu() {

		Scanner scan = new Scanner(System.in);

		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
		System.out.println("Welcome to The  Employee Reimbursement System");
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");

		System.out.println("1 -> for EMPLOYEE or 2 -> for FINANCE_MANAGER ");
		int role = scan.nextInt();
		if (role == 2) {
			Sub_Main_class.displayMenu2();
		} else if (role == 1) {

			boolean displayMenu = true;
			while (displayMenu) {

				System.out.println("\n1 -> add reimbursement request ");
				System.out.println("2 -> view your past tickets");
				System.out.println("3 -> check Status");
				System.out.println("4 -> Exit\n");
                
                
				int input = scan.nextInt();

				switch (input) {

				case 1: {
					
					System.out.println("Enter your role_id");
					int role_id = scan.nextInt();
					scan.nextLine();
					if(role_id == 11145) {
					   System.out.println("Enter your Firstname");
				       String firstname = scan.nextLine();
					 
				       System.out.println("Enter your Lastname");
				       String lastname = scan.nextLine();	
					
							
				       System.out.println("Enter your username");
				       String username = scan.nextLine();	
					
					
					   System.out.println("Enter your password");
					   String password = scan.nextLine();
					
					   System.out.println("Enter your email");
					   String email = scan.nextLine();

					int id = 0;
					
					User newEmployee = new User(id,username, password, firstname,lastname,email,role_id);
				    u.insertEmployee(newEmployee);
					
					}else {
						System.out.println(" Not Authorized ");
					}
				}
					break;

				case 2: {
					try {
						
						List<Reimbursement> employees = eDAO.getAllEmployees();
						for (Reimbursement e : employees)
							System.out.println(e);

					} catch (Exception e) {
						System.out.println("we catch");
					}
					
					break;
				}
				case 3: {
					//145 , 146 , 147
					System.out.println("Enter your id"); 
					int id = scan.nextInt();
					//ConstantVariable.statusFinder(id);
				
					System.out.println(ConstantVariable.statusFinder(id));
						
						
					}
					
					break;
				

				case 4: {
					displayMenu = false;
					System.out.println("in case 4");
					break;
				}

				// this default block will catch any user inputs that don't match a valid menu
				// option
				default: {
					System.out.println("Invalid selection... try again  ");
					break;
				}
				}
			}
		}
	}

	
}
