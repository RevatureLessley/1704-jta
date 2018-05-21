package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	private static final Logger logger = Logger.getLogger(EmployeeDaoImpl.class);
	private static EmployeeDaoImpl instance;

	public EmployeeDaoImpl() {
	}

	public static EmployeeDaoImpl getInstance() {
		if (instance == null) {
			instance = new EmployeeDaoImpl();
		}
		return instance;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT e.employeeId, position, username, password, firstName, lastName, DOB, salary  FROM employee e JOIN info i ON e.employeeId = i.employeeId");
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(rs.getInt("employeeId"), rs.getString("position"), rs.getString("username"),
						rs.getString("password"), rs.getString("firstName"), rs.getString("lastname"), rs.getString("DOB"), rs.getInt("salary"));
				employees.add(employee);
			}
			return employees;
		} catch (SQLException sqle) {
			logger.warn(sqle.getMessage());
			logger.warn("SQL State: " + sqle.getSQLState());
			logger.warn("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public Employee getEmployee(String username) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT e.employeeId, position, username, password, firstName, lastName, DOB, salary  FROM employee e JOIN info i ON e.employeeId = i.employeeId WHERE e.username = ?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Employee(rs.getInt("employeeId"), rs.getString("position"), rs.getString("username"),
						rs.getString("password"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("DOB"), rs.getInt("salary"));
			}
		} catch (SQLException sqle) {
			logger.warn(sqle.getMessage());
			logger.warn("SQL State: " + sqle.getSQLState());
			logger.warn("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}


	@Override
	public boolean updateEmployee(Employee employee) {
		int index = 0, result;

		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL update_employee(?, ?, ?, ?)}");
			stmt.setInt(++index, employee.getEmployeeId());
			stmt.setString(++index, employee.getPosition());
			stmt.setString(++index, employee.getUsername());
			stmt.setString(++index, employee.getPassword());
			result = stmt.executeUpdate();
			stmt.close();
			return result > 0;
		} catch (SQLException sqle) {
			logger.warn(sqle.getMessage());
			logger.warn("SQL State: " + sqle.getSQLState());
			logger.warn("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public String getPasswordHash(Employee employee) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT get_user_hash(?, ?) AS HASH FROM dual");
			stmt.setString(++index, employee.getUsername());
			stmt.setString(++index, employee.getPassword());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getString("HASH");
			}
		} catch (SQLException sqle) {
			logger.warn(sqle.getMessage());
			logger.warn("SQL State: " + sqle.getSQLState());
			logger.warn("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	public boolean login(String username, String password) {
		Employee employee = new Employee(username, password);
		if (getEmployee(username).getPassword().equals(getPasswordHash(employee))) {
			return true;
		}
		return false;
	}

	@Override
	public Employee getEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
