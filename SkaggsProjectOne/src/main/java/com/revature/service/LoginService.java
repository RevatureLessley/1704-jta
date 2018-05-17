package com.revature.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.Employee;
import com.revature.dao.EmployeeService;

public class LoginService {
	private LoginService() {}
	
	public static String login(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException {

		//logic to ensure users can't use the back button
		//into another users account
		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); 
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma","no-cache"); 
		response.setDateHeader ("Expires", 0); 
		
		//logic for logging in
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String hashedPassword;
		Employee e = null;
		
		Employee test = new Employee(username, password);
		hashedPassword = EmployeeService.getPasswordHash(test);
		e = EmployeeService.getEmployee(username);
		
		//in case username is empty
		if (e == null) return "/index.jsp";
		
		if (username.equals(e.getUserName()) & hashedPassword.equals(e.getPassword())) {
			
			if (e.isFinanceManager()) {
				Employee authorized = e;
				request.getSession().setAttribute("authorizedUser", authorized);
				return "/fm.do";
			} else {
				Employee authorized = e;
				request.getSession().setAttribute("authorizedUser", authorized);
				return "/home.do";
			}
		}	

		return "/index.jsp";
	}
}
