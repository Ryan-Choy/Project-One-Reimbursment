package com.revature.delegate;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

public class UserDelegate  {
	
	private static Logger uLog = Logger.getLogger(UserDelegate.class);
	
	private UserService us = new UserServiceImpl();
	private ObjectMapper om = new ObjectMapper();

	public void logins(HttpServletRequest request, HttpServletResponse response)throws IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User u = us.login(username, password);
		
		if (u.getUserId() != null) {
			String dough = u.getUserId()+":"+ u.getRoleId()+":"+u.getFirstName()+":"+u.getLastName();
			
			System.out.println("token is made");
			switch(u.getRoleId()) {
			case 1:
				uLog.info("Employee "+ u.getFirstName()+" "+u.getLastName()+" has logged in.");
				break;
				
			case 2:
				uLog.info("Manager "+ u.getFirstName()+" "+u.getLastName()+" has logged in.");
				break;
			default:
				break;
			}
			
			response.setStatus(200);
			response.setHeader("User", dough);
			
		} else {
			response.sendError(401);
		}
		
	}
	
	public boolean uType(HttpServletRequest request) throws ServletException, IOException{
		String useToken = request.getHeader("User");
		
		if(useToken != null) {
			String[] crumble = useToken.split(":");
			
			if(crumble.length == 4) {
				String userId = crumble[0];
				String roleId = crumble[1];
				User u = us.findById(Integer.parseInt(userId));
				
				if(u != null && u.getRoleId().equals(Integer.parseInt(roleId))) {
					System.out.println("authorize is called");
					return true;
				}
				
			}
		}
		
		return false;
	}
	

	
	

}
