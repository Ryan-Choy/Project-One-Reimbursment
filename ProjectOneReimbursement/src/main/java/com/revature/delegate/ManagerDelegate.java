package com.revature.delegate;

import java.io.IOException;
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

public class ManagerDelegate  {

	private UserDAO ud = new UserDAOImpl();
	private ReimbursementDAO rd = new ReimbursementDAOImpl();
	private ObjectMapper mappy = new ObjectMapper();
	
	private int mId;
	
	public ManagerDelegate(HttpServletRequest request) {
		fetchSession(request);
	}
	
	public void fetchSession(HttpServletRequest request) {
		
		String token = request.getHeader("User");
		
		if(token != null) {
			String[] userInfo = token.split(":");
			mId = Integer.parseInt(userInfo[0]);
			
		}
	}

	//view all pending from all emp 
	public void viewAllPend(HttpServletRequest request, HttpServletResponse response) {
		List<Reimbursement> allPend = rd.viewPendingReimbursement();
		String allPendJSON = null;
		
		try {
			allPendJSON = mappy.writeValueAsString(allPend);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setStatus(200);
		response.setHeader("allPending", allPendJSON);
	}
	
	
	
	//view all resolved w manager
	public void viewAllRes(HttpServletRequest request, HttpServletResponse response) {
		List<Reimbursement> allRes = rd.viewReimbursement();
		String allResJSON = null;
		
		try {
			allResJSON = mappy.writeValueAsString(allRes);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setStatus(200);
		response.setHeader("allRes", allResJSON);
	}
	
	//view all employees
	public void viewAllEmp(HttpServletRequest request, HttpServletResponse response) {
		List<User> allEmp = ud.viewAllEmployees();
		String allEmpJSON = null;
		
		try {
			allEmpJSON = mappy.writeValueAsString(allEmp);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setStatus(200);
		response.setHeader("allEmp", allEmpJSON);
	}
	//view requests from an employee
	public void viewAllReqEmp(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("empId");
		List<Reimbursement> allReqEmp = rd.viewReimbursementEmp(Integer.parseInt(id));
		String allReqEmpJSON = null;
		
		try {
			allReqEmpJSON = mappy.writeValueAsString(allReqEmp);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setStatus(200);
		response.setHeader("allReqEmp", allReqEmpJSON);
	}
	
	//approve or deny requests
	public void updateReim(HttpServletRequest request, HttpServletResponse response) {
		
		
		int rId = Integer.parseInt(request.getParameter("reimId"));
		
		int statusId = Integer.parseInt(request.getParameter("type"));
		
		
		boolean success = rd.updateReimbursementRequest(statusId, rId,mId);
		
		if(success == true) {
			response.setStatus(200);
		}
		
	}
	
}
