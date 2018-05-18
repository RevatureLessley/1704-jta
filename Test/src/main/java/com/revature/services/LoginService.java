package com.revature.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;

public class LoginService {

private LoginService() {}
	
	public static String login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//Employee employee = new Employee(username, password);
		EmployeeDaoImpl empdao = new EmployeeDaoImpl();
		
		// Login logic
		if(empdao.login(username, password) && empdao.getEmployee(username).getPosition().equals("Financial Manager")) {
			Employee authorizedUser = empdao.getEmployee(username);
			request.getSession().setAttribute("authorizedUser", authorizedUser);
			return "/manager_page.jsp";
		}
		if(empdao.login(username, password) && empdao.getEmployee(username).getPosition().equals("Employee")) {
			Employee authorizedUser = empdao.getEmployee(username);
			request.getSession().setAttribute("authorizedUser", authorizedUser);
			return "/employee_page.jsp";
		}

		return "/index.jsp";
	}
}
