package com.util.controller;
import io.javalin.http.Handler;
import java.util.List;
import java.util.Optional;

import com.google.gson.Gson;
import com.revature.models.*;
import com.revature.repositories.ReimbursementDAO;
import com.revature.repositories.UserDAO;
import com.revature.services.ReimbursementService;

public class EmployeeController {
	
	
	ReimbursementDAO rs = new ReimbursementDAO();
	UserDAO es = new UserDAO();
	ReimbursementService ce = new ReimbursementService();
	
	
	// for status
	
	public Handler getStatusHandler = (ctx) -> {
		if(ctx.req.getSession(true) != null) { 
		//	System.out.println("inside status");
			String e_id = ctx.pathParam("e_st");
		//	System.out.println(e_id);
			Status status = Status.valueOf(e_id);
		//	System.out.println(status);
			List<Reimbursement> allEmployees = ce.getReimbursementsByStatus(status);
			Gson gson = new Gson();
			String JSONEmployees = gson.toJson(allEmployees);
			ctx.result(JSONEmployees);
			ctx.status(201);
			

		} else {
			ctx.result("Oh no you failed to get the employees!!!!");
			ctx.status(404);
		}
	};
	
	public Handler getHandler = (ctx) -> {
		if(ctx.req.getSession() != null) { 
			
			List<Reimbursement> allEmployees = rs.getAllEmployeesall();
			Gson gson = new Gson();
			String JSONEmployees = gson.toJson(allEmployees);
			ctx.result(JSONEmployees);
			ctx.status(200);
			

		} else {
			ctx.result("Oh no you failed to get the employees!!!!");
			ctx.status(404);
		}
	};
	
	public Handler getEmployeesHandler = (ctx) -> {
		if(ctx.req.getSession() != null) { 
			
			List<User> allEmployees = es.getEmployees();
			Gson gson = new Gson();
			String JSONEmployees = gson.toJson(allEmployees);
			ctx.result(JSONEmployees);
			ctx.status(200);
			

		} else {
			ctx.result("Oh no you failed to get the employees!!!!");
			ctx.status(404);
		}
	};
	
	public Handler insertEmployeeHandler = (ctx) -> {
		
		if(ctx.req.getSession() != null) {
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			User employee = gson.fromJson(body, User.class);
			
			es.insertEmployee(employee);
			
			ctx.result("Employee was successfully added!");
			ctx.status(201);
			
		} else {
			ctx.result(" You failed to insert an employee!!!!");
			ctx.status(404);
		}
		
		
	};
	
public Handler insertrmEmployeeHandler = (ctx) -> {
		
		if(ctx.req.getSession() != null) {
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			Reimbursement newEmployee = gson.fromJson(body, Reimbursement.class);
			
			rs.insertrmEmployee(newEmployee);
			
			ctx.result("Employee was successfully added!");
			ctx.status(200);
			
		} else {
			ctx.result(" You failed to insert an employee!!!!");
			ctx.status(404);
		}
		
		
	};
public Handler updatereEmployeeHandler = (ctx) -> {
		
		if(ctx.req.getSession() != null) {
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			Reimbursement employee = gson.fromJson(body, Reimbursement.class);
			
			rs. update(employee);
			
			ctx.result("Employee was successfully added!");
			ctx.status(201);
			
		} else {
			ctx.result(" You failed to insert an employee!!!!");
			ctx.status(404);
		}
		
		
	};
	public Handler getEmployeHandlerp = (ctx) -> {
        if(ctx.req.getSession() != null) {
            int reimb_id = Integer.parseInt(ctx.pathParam("reimb_id")) ;
            
            List<Reimbursement> Employeesp = rs.getById(reimb_id);
            Gson gson = new Gson();
            String JSONEmployees = gson.toJson(Employeesp);
            ctx.result(JSONEmployees);
            ctx.status(200);
        }else {
            ctx.result("You failed to get the employees!! ");
            ctx.status(404);
        }
    };
	public Handler getEmployeesHandlerp = (ctx) -> {
        if(ctx.req.getSession() != null) {
            int ers_users_id = Integer.parseInt(ctx.pathParam("ers_users_id")) ;
            
            User Employeesp = es.getEmployeeById(ers_users_id);
            Gson gson = new Gson();
            String JSONEmployees = gson.toJson(Employeesp);
            ctx.result(JSONEmployees);
            ctx.status(200);
        }else {
            ctx.result("You failed to get the employees!! ");
            ctx.status(404);
        }
    };
    public Handler updatetEmployeeHandler = (ctx) -> {
        if(ctx.req.getSession() != null) {
            int e_id = Integer.parseInt(ctx.pathParam("ers_users_id")) ;
            String body = ctx.body();
            Gson gson = new Gson();
            User employee = gson.fromJson(body, User.class);
            es.updateEmployee(employee);
            ctx.result("oh you update the employees!!");
            ctx.status(200);

        }else {
            ctx.result("You failed to update the employees!! ");
            ctx.status(200);
        }

    };
    
    public Handler deletetEmployeeHandler = (ctx) -> {
        if(ctx.req.getSession() != null) {
            int e_id = Integer.parseInt(ctx.pathParam("ers_users_id"));
            
            Boolean demployeesp = es.deleteEmployee(e_id);
           
            ctx.result(" we Delete the employee!!");

            ctx.status(204);

        }else {
            ctx.result("You failed to delete the employees!! ");
            ctx.status(200);
        }

    };
    

	

}
