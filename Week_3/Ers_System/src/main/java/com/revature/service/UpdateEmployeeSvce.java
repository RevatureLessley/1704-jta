package com.revature.service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;

public class UpdateEmployeeSvce extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static EmployeeDao employeedao = EmployeeDaoImpl.getInstance(); 
	
	public static String updateEmployee(HttpServletRequest request, HttpServletResponse response) {
		
		Employee employee = (Employee) request.getSession().getAttribute("authorizedUser");
		//System.out.println(e);
		
		
		System.out.println("inside updateEmployeeSvce");
		String newFirstname = request.getParameter("firstname");
		String newLastname = request.getParameter("lastname");
		String eid= request.getParameter("eid");
		int newEid= Integer.parseInt(eid);
		
		
		employee = new Employee(newEid, newFirstname, newLastname);
		
		Employee temp = employeedao.getEmployee(newEid); //to get all the object values
		
		//System.out.println("temp id " + temp.getType());
				
		if(	employeedao.updateEmployee(employee) == true && temp.getType().equals("ge")) {
			System.out.println("successfully updated general employee");  //logger
			request.getSession().setAttribute("authorizedUser",employee);
		return "/generalEmployeeHome.jsp";	
		}
		
		if(	employeedao.updateEmployee(employee) == true && temp.getType().equals("fm")) {
			System.out.println("successfully updated finance manager");  //logger
			request.getSession().setAttribute("authorizedUser",employee);
		return "/financeManager.jsp";	
		}
		
		return "/index.jsp";
		
		
	}
}
