package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;


public class FrontController extends DefaultServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 RequestHelper rh = new RequestHelper();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get is called");
		/*
		 * Initially the request URI might look something like: /FrontControllerDemo/planets/1
		 * the URI is cleaned by returning a substring removing "/FrontcontrollerDemo" (the context path)
		 */
		String path = request.getRequestURI().substring(request.getContextPath().length());
		
		/*
		 * We want to process the request based on the URI, however we still want to be able to return static webpages from the static folder
		 */
		if(path.startsWith("/static/") || path.equals("/") || path.equals("/index.html") ) {
			super.doGet(request, response);
		}else {
			rh.processRequest(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post is called");
		rh.processPost(request, response);
	}




}
