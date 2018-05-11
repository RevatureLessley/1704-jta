package com.revature.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.revature.dao.EmployeeService;
import com.revature.dao.ManagerService;
import com.revature.dao.ReimbursementService;
import com.revature.employee.FinanceManager;
import com.revature.employee.GenericEmployee;
import com.revature.exceptions.EmployeeNotFoundException;
import com.revature.reimbursement.Reimbursment;


public class LoginService {
	private static final Logger logger = Logger.getLogger(LoginService.class);

		private LoginService() {}
		
		public static String login(HttpServletRequest request, HttpServletResponse responce) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//Login logic
			try {
				FinanceManager man = ManagerService.getManager(username);
				if(man.getPassword().equals(ManagerService.getPasswordHash(new FinanceManager(username,password)))) {
					FinanceManager authorized = man;
					request.getSession().setAttribute("authorizedUser", authorized);
					String rebursementJson = new Gson().toJson(ReimbursementService.getReimbursmentForEmployee(authorized.getUsername()));
					System.out.println(rebursementJson);
					request.getSession().setAttribute("reimbursements", rebursementJson);
					return "/managerHome.do";
				}
			} catch (EmployeeNotFoundException enfe) {
				try {
					GenericEmployee emp = EmployeeService.getEmployee(username);
					if(emp.getPassword().equals(EmployeeService.getPasswordHash(new GenericEmployee(username,password)))) {
						GenericEmployee authorized = emp;
						request.getSession().setAttribute("authorizedUser", authorized);
						List<Reimbursment> list= ReimbursementService.getReimbursmentForEmployee(username);
						String rebursementJson = new Gson().toJson(ReimbursementService.getReimbursmentForEmployee(authorized.getUsername()));
						request.getSession().setAttribute("reimbursements", rebursementJson);
						return "/employeeHome.do";
					}
					}catch (EmployeeNotFoundException enfe2) {
				logger.error(enfe2.getMessage());
					}
			}
			
			return "index.jsp";
		}
		public static String logout(HttpServletRequest request, HttpServletResponse responce) {
			request.getSession().removeAttribute("authorizedUser");
			return "index.jsp";
		}
	}
