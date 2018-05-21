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
import com.revature.model.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {

	private static final Logger logger = Logger.getLogger(ReimbursementDaoImpl.class);
	private static ReimbursementDaoImpl instance;
	
	private ReimbursementDaoImpl() {}
	
	public static ReimbursementDaoImpl getInstance() {
		if (instance == null) {
			instance = new ReimbursementDaoImpl();
		}
		return instance;
	}
	
	@Override
	public List<Reimbursement> getAllReimbursements(int employeeId) {
		
		List<Reimbursement> reimbursements = new ArrayList<>();
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimbursement WHERE requestorId != ? ORDER BY requestorId");
			stmt.setInt(++index, employeeId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Reimbursement reimbursement = new Reimbursement(rs.getInt("reimbursementId"), rs.getInt("requestorId"), rs.getInt("approverId"), rs.getString("category"), rs.getString("status"), rs.getString("submissionDate"), rs.getString("resolutionDate"), rs.getDouble("amount"));
				reimbursements.add(reimbursement);
			}
			return reimbursements;
		} catch (SQLException sqle) {
			logger.warn(sqle.getMessage());
			logger.warn("SQL State: " + sqle.getSQLState());
			logger.warn("Error Code: " + sqle.getErrorCode());
		}	
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursements(int employeeId) {
		List<Reimbursement> reimbursements = new ArrayList<>();
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimbursement WHERE requestorId = ?");
			stmt.setInt(++index, employeeId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Reimbursement reimbursement = new Reimbursement(rs.getInt("reimbursementId"), rs.getInt("requestorId"), rs.getInt("approverId"), rs.getString("category"), rs.getString("status"), rs.getString("submissionDate"), rs.getString("resolutionDate"), rs.getDouble("amount"));
				reimbursements.add(reimbursement);
			}
			return reimbursements;
		} catch (SQLException sqle) {
			logger.warn(sqle.getMessage());
			logger.warn("SQL State: " + sqle.getSQLState());
			logger.warn("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}
		

	@Override
	public boolean insertReimbursement(Reimbursement reimbursement) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL insert_reimbursement(?, ?, ?)}");
			stmt.setInt(++index, reimbursement.getRequestorId());
			stmt.setString(++index, reimbursement.getCategory());
			stmt.setDouble(++index, reimbursement.getAmount());
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			logger.warn(sqle.getMessage());
			logger.warn("SQL State: " + sqle.getSQLState());
			logger.warn("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean updateReimbursement(int reimbursementId, int approverId, String status) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL update_reimbursement(?,?,?)}");
			stmt.setInt(++index, reimbursementId);
			stmt.setInt(++index, approverId);
			stmt.setString(++index, status);
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			logger.warn(sqle.getMessage());
			logger.warn("SQL State: " + sqle.getSQLState());
			logger.warn("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	
}
