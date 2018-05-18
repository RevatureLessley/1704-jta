package com.revature.services;

import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;

public class EmployeeService {

	
	private static EmployeeDao dao = EmployeeDaoImpl.getInstance();
	
	private EmployeeService() {}
	
	public static List<Employee> getAllEmployees(){
		return dao.getAllEmployees();
	}
	
	public static Employee getEmployee(String username) {
		return dao.getEmployee(username);
	}
}
