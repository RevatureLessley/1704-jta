package com.revature.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementImpl implements ReimbursementDAO {
	
	private static ReimbursementImpl re_instance;
	
	private ReimbursementImpl() {
		
	}
	
	public static ReimbursementImpl getInstance() {
		
		System.out.println("inside the getInstance Method in ReimbursementImpl Implementation");
		if (re_instance == null) {
			System.out.println("the instance was NUll");
			re_instance = new ReimbursementImpl();
			System.out.println("new instance " + re_instance);
		}
		return re_instance;
	}


	@Override
	public boolean submitReimbursement(Reimbursement reimbursement) {
			
			System.out.println("inside submit Reimb");
			
			int index = 0; 
			try(Connection conn = ConnectionUtil.getConnection()){
				
				CallableStatement stmt = conn.prepareCall("{CALL SUBMIT_REIMB(?,?,?)}");
				stmt.setInt(++index, reimbursement.getEid_fk());
				stmt.setDouble(++index, reimbursement.getAmount());
				stmt.setString(++index, reimbursement.getCategory());
				
				System.out.println("inside callable reimb");
				return stmt.executeUpdate() > 0;
				
			} catch(SQLException sqle) {
				System.out.println("not updated reimbursement");
				System.err.println(sqle.getMessage());
				System.err.println("SQL state " + sqle.getSQLState());
				System.err.println("Error Code: " + sqle.getErrorCode());
			}
			
			return false;
		}
	
	
		
public Reimbursement getReimbursement(int eid) {		
		
		System.out.println("inside get reimbursement");
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Reimbursement WHERE eid_fk = ?");
			stmt.setInt(++index, eid);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("has next");
				return new Reimbursement(rs.getInt("rid"),rs.getString("status"), rs.getDouble("reimbamount"), rs.getTimestamp("date_submitted"));
			}
			else {
				
				System.out.println("inside else");
				return null;
			}
			
		} catch(SQLException sqle) {
			System.out.println("returning null from getReimb");

			System.err.println(sqle.getMessage());
			System.err.println("SQL state " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		
		return null;
	}

public List<Reimbursement> viewAllReimbursment() {		
	
	System.out.println("inside get all reimbursement");
	int index = 0;
	List<Reimbursement> r = new ArrayList<>();
	try(Connection conn = ConnectionUtil.getConnection()){
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Reimbursement ");
		ResultSet rs = stmt.executeQuery();
		
		
		while(rs.next()) {
			System.out.println("has next inside viewAllReimbursement / ReimbursementImpl");
			r.add(new Reimbursement(rs.getInt("rid"),rs.getString("status"), rs.getDouble("reimbamount"), rs.getTimestamp("date_submitted")));
		}
		return r;
		
		
	} catch(SQLException sqle) {
		System.out.println("returning null from getReimb");

		System.err.println(sqle.getMessage());
		System.err.println("SQL state " + sqle.getSQLState());
		System.err.println("Error Code: " + sqle.getErrorCode());
	}
	
	return null;
}



}
