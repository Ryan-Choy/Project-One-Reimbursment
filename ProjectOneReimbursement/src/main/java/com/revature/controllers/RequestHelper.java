package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegate.EmployeeDelegate;
import com.revature.delegate.ManagerDelegate;
import com.revature.delegate.UserDelegate;


public class RequestHelper {
//doget dopost, etc.
	// front controller -> request helper -> delegate -> services -> dao

	private UserDelegate ud = new UserDelegate();

	public void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		EmployeeDelegate ed = new EmployeeDelegate(request);
		ManagerDelegate md = new ManagerDelegate(request);

		System.out.println("in doGet");
		String path = request.getServletPath();

		System.out.println(path);
		// Get information
		switch (path) {
		
		case "/login":
			request.getRequestDispatcher("/static/views/login.html").forward(request, response);
			break;
			
		case "/logout":
			// calls sessionStorage.clear();
			request.getRequestDispatcher("/static/views/logout.html").forward(request, response);
			break;
			
		case "/error":
			request.getRequestDispatcher("/static/views/error.html").forward(request, response); 
			break;
		
		case "/employee":
			request.getRequestDispatcher("static/views/employee.html").forward(request, response);
			break;
		case "/manager":
			request.getRequestDispatcher("static/views/manager.html").forward(request, response);
			break;
			
		case "/submit":
			request.getRequestDispatcher("static/menu/submit.html").forward(request, response);
		
		case "/viewPendEmp":
			request.getRequestDispatcher("static/menu/viewPendEmp.html").forward(request, response);
			break;

		case "/viewPendingByEmp":
			ed.viewPendReim(request, response);
			break;
			
		case "/viewResEmp":
			request.getRequestDispatcher("static/menu/viewResEmp.html").forward(request, response);
			break;

		case "/viewResReimByEmp":
			ed.viewResReim(request, response);
			break;

		case "/viewInfo":
			request.getRequestDispatcher("static/menu/viewProfile.html").forward(request, response);
			break;
		case "/viewProfile":
			ed.viewProfile(request, response);
			break;
			
		case"/updateInfo":
			request.getRequestDispatcher("static/menu/updateProfile.html").forward(request, response);
			break;
			
		case"/viewPendList":
			request.getRequestDispatcher("static/menu/viewPendList.html").forward(request, response);
			break;
			
		case "/viewAllPend":
			md.viewAllPend(request, response);
			break;
			
		case"/viewResList":
			request.getRequestDispatcher("static/menu/viewResList.html").forward(request, response);
			break;

		case "/viewAllRes":
			md.viewAllRes(request, response);
			break;
			
		case"/viewEmpList":
			request.getRequestDispatcher("static/menu/viewEmpList.html").forward(request, response);
			break;
			
		case "/viewAllEmp":
			md.viewAllEmp(request, response);
			break;
			
		case"/viewReqEmp":
			request.getRequestDispatcher("static/menu/viewReqEmp.html").forward(request, response);
			break;
			
		case "/viewAllReqByEmp":
			md.viewAllReqEmp(request, response);
			break;
			
			
		default:
			response.sendError(405);
			break;
		}

	}

	public void processPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String path = request.getServletPath();
		ManagerDelegate md = new ManagerDelegate(request);
		EmployeeDelegate ed = new EmployeeDelegate(request);

		switch (path) {
		case "/login":
			// System.out.println("login is called");
			ud.logins(request, response);
			break;

		case "/submitReim":
			ed.submitReim(request, response);
			break;

		case "/updateProfile":
			ed.updateProfile(request, response);
			break;
			
		case "/updateReim":
			md.updateReim(request, response);
			break;

		default:
			response.sendError(404);
			break;

		}
	}

}
