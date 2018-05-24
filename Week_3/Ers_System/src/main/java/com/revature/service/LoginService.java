package com.revature.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.LoginDao;
import com.revature.dao.LoginDaoImpl;
import com.revature.model.Employee;



public class LoginService {
	
	private static LoginDao logindao = LoginDaoImpl.getInstance();

	public static String login(HttpServletRequest request, HttpServletResponse response) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Employee employee = new Employee(username,password);		//first create a new employee obj.
		
		Employee temp = logindao.getUser(username);
		
		if(temp.getPassword().equals(logindao.getPasswordHash(employee)) && temp.getType().equals("ge")) {
				System.out.println("valid Regular Employee"); //logger
				request.getSession().setAttribute("authorizedUser", temp);
				return "/generalEmployeeHome.jsp";
		}
		
		 if(temp.getPassword().equals(logindao.getPasswordHash(employee)) && temp.getType().equals("fm")) {
			System.out.println("valid Finance Manager"); //logger
			request.getSession().setAttribute("authorizedUser", temp);
			return "/financeManagerHome.jsp";
		}
		
		else {
		System.out.println("wrong password");		//logger
		return  "/index.jsp";
		}
	}
}