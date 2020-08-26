package com.learning.j10.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.jbbwebsolutions.utility.BasicUtility.*;
import com.learning.j10.utility.GLOBAL;


public abstract class _AbstractWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected String getURLPattern(HttpServletRequest request) {
		String url = request.getRequestURL().toString();
		String parts[] = url.split("/");
		String urlPattern = parts[parts.length-1];
		return urlPattern;
	}
	
	protected void redirect(String path, HttpServletRequest request, HttpServletResponse response) {
		try {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
			requestDispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		/* Starting Logic for security */
		
		boolean isLoggedIn = whatIfNull(request.getSession()::getAttribute
				, GLOBAL.IS_SECURED, false, Boolean.class);
		boolean isLoginPage = getURLPattern(request).toString().equals("login");
		
		if(isLoggedIn || isLoginPage) {
			this.get(request, response);
		}
		else {
			this.redirect("/login", request, response);
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		get(request, response);
	}

	protected abstract void get(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;

	
}
