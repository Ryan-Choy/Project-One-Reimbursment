package com.revature.delegate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Delegatable {
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}
