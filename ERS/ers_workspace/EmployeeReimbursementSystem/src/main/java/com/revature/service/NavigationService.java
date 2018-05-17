package com.revature.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.factories.LoginFactory;
import com.revature.logging.InvalidLoginException;
import com.revature.logging.LogThis;
import com.revature.model.Employee;

public class NavigationService {

	private NavigationService() {
	}

	public static String login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Employee temp = new Employee(username, password);
//		LogThis.info("temp in login in NavigationService " + temp.toString());

		try {
			Employee currentEmployee = LoginFactory.userLogin(temp);
//			LogThis.info("currentEmployee in login in NavigationService " + currentEmployee.toString());
			request.getSession().setAttribute("currentEmployee", currentEmployee);
			if (currentEmployee == null) {
				return "main.do";
			}
			if (currentEmployee.isFinancialManager()) {
				return "finManHome.do";
			} else {
				return "employeeHome.do";
			}
		} catch (InvalidLoginException e) {
			LogThis.warn(e.getMessage());
			return "404.do";
		}
	}


	public static String logout(HttpServletRequest request, HttpServletResponse response) {
		try { 
		HttpSession session = request.getSession(false);
		
		if (session.getAttribute("currentEmployee") == null) {
//			response.sendRedirect("/main.do");
			return "main.do";
		}
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		
		session.setAttribute("currentEmployee", null);
		session.invalidate();
//		response.sendRedirect("/main.do");
		} catch (Exception e) {
			return "main.do";
		}
		return "main.do";
	}

	public static String main(HttpServletRequest request) {
		return "login.jsp";
	}

	public static String userUpdate(HttpServletRequest request) {
		Employee temp = (Employee) request.getSession().getAttribute("currentEmployee");
		int id = temp.getId();
		String username = request.getParameter("username");
		boolean isFinancialManager = temp.isFinancialManager();
		String firstname = request.getParameter("firstname");
		String middleInitial = request.getParameter("middleInitial");
		String lastname = request.getParameter("lastname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		Employee new_current = new Employee(id, username, isFinancialManager, firstname, middleInitial, lastname, phone,
				email);
		EmployeeService.updateEmployee(new_current);
		request.getSession().setAttribute("currentEmployee", new_current);
		if (temp.isFinancialManager()) {
			return "fmUpdateAccount.jsp";
		} else {
			return "eUpdateAccount.jsp";
		}
	}

}
