package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDao {
		
	public boolean updateEmployee(Employee employee);
	public Employee getEmployee(int eid);
	List<Employee> getAllEmployee();
}
