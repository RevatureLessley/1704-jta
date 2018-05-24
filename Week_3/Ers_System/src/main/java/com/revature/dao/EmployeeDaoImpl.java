package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	
	
	private static EmployeeDaoImpl instance;
	
	private EmployeeDaoImpl() {};
	
	public static EmployeeDao getInstance() {
		
		System.out.println("inside the getInstance Method in LoginDao Implementation");
		if (instance == null) {
			System.out.println("the instance was NUll");
			instance = new EmployeeDaoImpl();
			System.out.println("new instance " + instance);
		}
		return instance;
	}

	
public Employee getEmployee(int eid) {		
		
		System.out.println("inside getUser in EmployeeDaoImpl");
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Employee WHERE eid = ?");
			stmt.setInt(++index, eid);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("has next");
				return new Employee(rs.getInt("eid"),rs.getString("efname"), rs.getString("elname"), rs.getString("eusername"),
						rs.getString("epassword"), rs.getString("etype"));
			}
			else {
				
				System.out.println("inside else");
				return null;
			}
			
		} catch(SQLException sqle) {
			System.out.println("returning null from getUser");

			System.err.println(sqle.getMessage());
			System.err.println("SQL state " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		
		return null;
	}


	@Override
	public boolean updateEmployee(Employee employee) {
		
		System.out.println("inside update Employee");
		
		int index = 0; 
		try(Connection conn = ConnectionUtil.getConnection()){
			
			CallableStatement stmt = conn.prepareCall("{CALL UPDATE_EMPLOYEE(?,?,?)}");
			stmt.setInt(++index, employee.getEid());
			stmt.setString(++index, employee.getFirstName());
			stmt.setString(++index, employee.getLastName());
			
			return stmt.executeUpdate() > 0;
			
		} catch(SQLException sqle) {
			System.out.println("not updated employee");
			System.err.println(sqle.getMessage());
			System.err.println("SQL state " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		
		return false;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employees = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT eid, efname, elname, eusername FROM employee ");
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(rs.getInt("eid"), rs.getString("efname"), rs.getString("elname"));
				employees.add(employee);
			}
			return employees;
		} catch (SQLException sqle) {
			sqle.getMessage();
			sqle.getSQLState();
			sqle.getErrorCode();
		}
		
		return null;
	} 
	

}
