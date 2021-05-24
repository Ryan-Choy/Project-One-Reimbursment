package com.revature.delegate;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.Reimbursement;
import com.revature.models.User;

public class EmployeeDelegate {
	private UserDAO ud = new UserDAOImpl();
	private ReimbursementDAO rd = new ReimbursementDAOImpl();
	private ObjectMapper mappy = new ObjectMapper();
	
	private int uId;
	
	public EmployeeDelegate(HttpServletRequest request) {
		fetchSession(request);
	}
	
	public void fetchSession(HttpServletRequest request) {
		String token = request.getHeader("User");
		
		if(token != null) {
			String[] uInfo = token.split(":");
			uId = Integer.parseInt(uInfo[0]);
		}
	}
	
	
	//view pending reimbursements
	public void viewPendReim(HttpServletRequest request, HttpServletResponse response) {
		List<Reimbursement> pendList = rd.viewPendingReimbursement(uId);
		String pendJSON = null;
		
		try {
			pendJSON = mappy.writeValueAsString(pendList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setStatus(200);
		response.setHeader("pendingList", pendJSON);
		
	}
	
	
	//view all resolved reimbursements
	public void viewResReim(HttpServletRequest request, HttpServletResponse response) {
		List<Reimbursement> resList = rd.viewReimbursement(uId);
		String resJSON = null;
		try {
			resJSON = mappy.writeValueAsString(resList);

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setStatus(200);
		response.setHeader("resolvedList", resJSON);
		
		
	}

	//submit reimbursement
	public void submitReim(HttpServletRequest request, HttpServletResponse response) {
		BigDecimal amount = new BigDecimal(request.getParameter("amount"));
		String reimType = request.getParameter("type");
		String desc = request.getParameter("description");
		int statusId = 1;
		int rId = 0;
		
		switch (reimType) {
		case "Lodging":
			//Lodging
			rId = 1;
			break;
		case "Travel":
			//Travel
			rId = 2;
			break;
		case "Food":
			//Food
			rId = 3;
			break;
		case "Other":
			//Other
			rId = 4;
			break;

		default:
			break;
		}
		
		Reimbursement r = new Reimbursement();
		r.setAuthor(uId);
		r.setAmount(amount);
		r.setDescription(desc);
		r.setStatusId(statusId);
		r.setTypeId(rId);
		
		rd.submitReinRequest(r);
		
	}
	
	//view profile
	public void viewProfile(HttpServletRequest request, HttpServletResponse response) {
		User profile = ud.findById(uId);
		
		String uJson = null;
		
		try {
			uJson = mappy.writeValueAsString(profile);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setStatus(200);
		response.setHeader("userProfile", uJson);

	}
	
	
	//update profile
	public void updateProfile(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		User u = new User();
		u.setUserName(username);
		u.setPassword(password);
		u.setEmail(email);
		u.setUserId(uId);
		
		boolean update = ud.updateProfile(u);
		if(update == true) {
			response.setStatus(400);
		}
		
	}
	
	
}
