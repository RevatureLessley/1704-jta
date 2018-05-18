package com.revature.services;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.InfoDao;
import com.revature.dao.InfoDaoImpl;
import com.revature.model.Employee;
import com.revature.model.Info;

public class InfoService {

	private static InfoDao dao = InfoDaoImpl.getInstance();
	
	private InfoService() {}
	
	public static boolean updateInfo(Info info) {
		return dao.updateInfo(info);
	}
	
	public static String update(HttpServletRequest request, HttpServletResponse response) {
	Employee employee = (Employee) request.getSession().getAttribute("authorizedUser");
	
	int employeeId = employee.getEmployeeId();
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	
	
	employee.setFirstName(firstName);
	employee.setLastName(lastName);
	
	Info info = new Info(employeeId, firstName, lastName);
	
	if(updateInfo(info)) {
		request.getSession().setAttribute("authorizedUser", employee);
	}
	return "/employee_page.jsp";
	
	}
	
	
}
