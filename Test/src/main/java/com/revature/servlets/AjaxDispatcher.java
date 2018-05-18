package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Employee;
import com.revature.services.EmployeeService;
import com.revature.services.ReimbursementService;

public class AjaxDispatcher {

	private AjaxDispatcher() {
	}

	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		
		Employee employee = (Employee) request.getSession().getAttribute("authorizedUser");
		int employeeId = employee.getEmployeeId();
		
		switch (request.getRequestURI()) {
		case "/Test/getReimbursements.ajax":
			return ReimbursementService.getReimbursements(employeeId);
		case "/Test/getEmployees.ajax":
			return EmployeeService.getAllEmployees();
		default:
			return new String("Not implemented");
		}
	}
}
