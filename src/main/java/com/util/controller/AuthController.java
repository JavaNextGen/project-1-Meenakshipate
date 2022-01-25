package com.util.controller;
import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.services.AuthService;

import io.javalin.http.Handler;

public class AuthController {
	AuthService as = new AuthService();

	public Handler loginHandler = (ctx) -> {
		
		String body = ctx.body(); 
		Gson gson = new Gson(); 
		
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class); 
		int userval = as.login(LDTO.getUsername(), LDTO.getPassword());
			if(userval > 0) {
			ctx.req.getSession(); 
			ctx.res.setHeader("Set-Cookie", "key=value; HttpOnly; SameSite=None; Secure");
			ctx.status(202); 
			if(userval == 1) {
				ctx.result("Login Successfull");
				ctx.status(201);
			}else {
				ctx.result("Login Success!");
			}
			System.out.println(userval);
		} else {
			
			ctx.status(401); 
			ctx.result("Login Failed! :(");
			
		}
		
	};

}

