package com.revature;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.models.Mainclass;
import com.revature.util.ConnectionFactory;
import com.util.controller.AuthController;
import com.util.controller.EmployeeController;

import io.javalin.Javalin;
public class Driver {
	
 public static void main(String[] args) {
	 
	 AuthController ac = new AuthController();
	 EmployeeController ec = new EmployeeController();
	// Mainclass main = new Mainclass();
    	
    //	main.displayMenu();
   try(Connection conn = ConnectionFactory.getConnection()){
			System.out.println("Connection Successful :)");
		} catch(SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		


         Javalin app = Javalin.create(
		config -> {
			config.enableCorsForAllOrigins();
		}
		).start(3000);

       
        app.get("/employee", ec.getEmployeesHandler);
        app.post("/employee", ec.insertEmployeeHandler);
        app.get("/employee/{ers_users_id}", ec.getEmployeesHandlerp);
        app.put("/employee/{ers_users_id}", ec.updatetEmployeeHandler);
        app.delete("/employee/{ers_users_id}", ec.deletetEmployeeHandler);
        app.get("/allemployee", ec.getHandler);
        app.get("/allemployee/{reimb_id}",ec.getEmployeHandlerp);
        app.put("/allemployee/{reimb_id}",ec.updatereEmployeeHandler);
        app.post("/allemployee", ec.insertrmEmployeeHandler);
        app.get("/status/{e_st}",ec.getStatusHandler);
        app.post("/login", ac.loginHandler);
 }
}
    	
    	
    	
    	
    	
    	
    	
    	
    	
 	
    	
    	
    	

