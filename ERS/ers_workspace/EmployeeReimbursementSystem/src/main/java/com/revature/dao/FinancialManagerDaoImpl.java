package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.logging.LogThis;
import com.revature.model.Employee;
import com.revature.model.FinancialManager;
import com.revature.model.Reimbursement;
import com.revature.util.ConnectionUtil;

public class FinancialManagerDaoImpl implements FinancialManagerDao {

	private static FinancialManagerDaoImpl instance;

	private FinancialManagerDaoImpl() {
	}

	public static FinancialManagerDaoImpl getInstance() {
		if (instance == null) {
			instance = new FinancialManagerDaoImpl();
		}
		return instance;
	}

	@Override
	public String getPasswordHash(FinancialManager financialManager) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT get_user_hash(?, ?) AS HASH FROM dual");
			stmt.setString(++index, financialManager.getUsername());
			stmt.setString(++index, financialManager.getPassword());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getString("HASH");
			}
		} catch (SQLException sqle) {
			LogThis.warn(sqle.getMessage());
			LogThis.warn("SQL state: " + sqle.getSQLState());
			LogThis.warn("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public FinancialManager getFinancialManager(String username) {
		FinancialManager financialManager = new FinancialManager();
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employee e"
					+ "JOIN employee_info ei ON e.employee_id = ei.employee_id " + "WHERE e.employee_id = ?");
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				financialManager.setFmid(rs.getInt("f_manager_id"));
				financialManager.setId(rs.getInt("employee_id"));
				financialManager.setUsername(rs.getString("username"));
				financialManager.setPassword(rs.getString("password"));
				financialManager.setFinancialManager(true);
				financialManager.setFirstname(rs.getString("f_name"));
				financialManager.setMiddleInitial(rs.getString("m_initial"));
				financialManager.setLastname(rs.getString("l_name"));
				financialManager.setPhone(rs.getInt("phone"));
				financialManager.setEmail(rs.getString("email"));
				return financialManager;
			}
		} catch (SQLException sqle) {
			LogThis.warn(sqle.getMessage());
			LogThis.warn("SQL state: " + sqle.getSQLState());
			LogThis.warn("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Employee> viewAllEmployees() {
		List<Employee> list = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT f_name, m_initial, l_name FROM employee_info");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(new Employee(rs.getString("f_name"), rs.getString("m_initial"), rs.getString("l_name")));
			}
			return list;
		} catch (SQLException sqle) {
			LogThis.warn(sqle.getMessage());
			LogThis.warn("SQL state: " + sqle.getSQLState());
			LogThis.warn("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Reimbursement> viewAllReimbursements() {
		List<Reimbursement> list = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(
					"SELECT r.reimbursement_id, (ei.f_name || ' ' || ei.l_name) AS requestor_name, s.r_status, c.r_category, r.amount, r.submitted, r.resolved, "
							+ "ai.approver_name FROM reimbursement r "
							+ "JOIN employee_info ei ON r.requestor_id = ei.employee_id "
							+ "JOIN r_status s ON s.status_id = r.status_id "
							+ "JOIN r_category c ON c.category_id = r.category_id "
							+ "JOIN (SELECT (ei2.f_name || ' ' || ei2.l_name) AS approver_name, fm.f_manager_id AS fmid FROM employee_info ei2 "
							+ "JOIN f_manager fm ON ei2.employee_id = fm.employee_id) ai ON ai.fmid = r.approver_id");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(new Reimbursement(rs.getInt("r.reimbursement_id"), rs.getString("requestor_name"),
						rs.getString("ai.approver_name"), rs.getString("c.r_category"), rs.getString("s.r_status"),
						rs.getInt("r.amount"), rs.getString("r.submitted"), rs.getString("r.resolved")));
			}
			return list;
		} catch (SQLException sqle) {
			LogThis.warn(sqle.getMessage());
			LogThis.warn("SQL state: " + sqle.getSQLState());
			LogThis.warn("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Reimbursement> viewReimbursementsByEmployee(Employee employee) {
		List<Reimbursement> list = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(
					"SELECT r.reimbursement_id, (ei.f_name || ' ' || ei.l_name) AS requestor_name, s.r_status, "
							+ "c.r_category, r.amount, r.submitted, r.resolved, ai.approver_name FROM reimbursement r "
							+ "JOIN employee_info ei ON r.requestor_id = ei.employee_id "
							+ "JOIN r_status s ON s.status_id = r.status_id "
							+ "JOIN r_category c ON c.category_id = r.category_id "
							+ "JOIN (SELECT (ei2.f_name || ' ' || ei2.l_name) AS approver_name, fm.f_manager_id AS fmid FROM employee_info ei2 "
							+ "JOIN f_manager fm ON ei2.employee_id = fm.employee_id) ai ON ai.fmid = r.approver_id "
							+ "WHERE r.requestor_id = ?");
			stmt.setInt(1, employee.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(new Reimbursement(rs.getInt("r.reimbursement_id"), rs.getString("requestor_name"),
						rs.getString("ai.approver_name"), rs.getString("c.r_category"), rs.getString("s.r_status"),
						rs.getInt("r.amount"), rs.getString("r.submitted"), rs.getString("r.resolved")));
			}
			return list;
		} catch (SQLException sqle) {
			LogThis.warn(sqle.getMessage());
			LogThis.warn("SQL state: " + sqle.getSQLState());
			LogThis.warn("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public boolean resolveReimbursement(FinancialManager financialmanager, Reimbursement reimbursement, int status) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL resolve_reimbursement (?, ?, ?)}");
			stmt.setInt(++index, financialmanager.getId());
			stmt.setInt(++index, reimbursement.getId());
			stmt.setInt(++index, status);
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			LogThis.warn(sqle.getMessage());
			LogThis.warn("SQL state: " + sqle.getSQLState());
			LogThis.warn("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean insertFinancialManager(FinancialManager financialManager) {
		return false;
	}

}